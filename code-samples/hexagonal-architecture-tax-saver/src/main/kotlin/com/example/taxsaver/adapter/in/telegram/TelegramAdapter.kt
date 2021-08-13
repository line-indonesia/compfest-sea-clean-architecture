package com.example.taxsaver.adapter.`in`.telegram

import com.example.taxsaver.adapter.`in`.parseChat
import com.example.taxsaver.adapter.`in`.toReadableString
import com.example.taxsaver.application.GetTax
import com.example.taxsaver.application.SaveTax
import com.example.taxsaver.application.TaxInfo
import com.example.taxsaver.port.ShowTaxPort
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.handlers.TextHandlerEnvironment
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId
import org.springframework.stereotype.Component

@Component
class TelegramAdapter(
    private val properties: TelegramProperties,
    private val getTax: GetTax,
    private val saveTax: SaveTax
) {

    private val bot = bot {
        token = properties.apiKey
        dispatch {
            text {
                handleTextEnvironment(this)
            }
        }
    }.apply {
        startPolling()
    }

    private fun handleTextEnvironment(handler: TextHandlerEnvironment) {
        val (name, amount) = handler.text.parseChat()
        val id = handler.message.chat.id
        if (amount != null) {
            saveTax(name, amount)
        }
        getTax(name, handleShowTaxPort(id))
    }

    private fun handleShowTaxPort(id: Long): ShowTaxPort {
        return object : ShowTaxPort {
            override fun showSuccessfulTaxInfo(taxInfo: TaxInfo) {
                bot.sendMessage(
                    ChatId.fromId(id),
                    text = taxInfo.toReadableString()
                )
            }

            override fun showFailedTaxInfo(exception: Throwable) {
                bot.sendMessage(
                    ChatId.fromId(id),
                    text = exception.message!!
                )
            }
        }
    }
}
