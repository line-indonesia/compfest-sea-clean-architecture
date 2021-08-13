package com.example.taxsaver.adapter.`in`.line

import com.example.taxsaver.adapter.`in`.parseChat
import com.example.taxsaver.adapter.`in`.toReadableString
import com.example.taxsaver.application.GetTax
import com.example.taxsaver.application.SaveTax
import com.example.taxsaver.application.TaxInfo
import com.linecorp.bot.model.event.MessageEvent
import com.linecorp.bot.model.event.message.TextMessageContent
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.spring.boot.annotation.EventMapping
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler

@LineMessageHandler
class LineMessageAdapter(
    private val getTax: GetTax,
    private val saveTax: SaveTax
) {

    @EventMapping
    fun textMessage(event: MessageEvent<TextMessageContent>): TextMessage {
        val message = event.message.text
        val result = handleMessage(message)
        val reply = if (result.isSuccess) {
            result.getOrNull()!!.toReadableString()
        } else {
            result.exceptionOrNull()!!.message
        }
        return TextMessage(reply)
    }

    private fun handleMessage(message: String): Result<TaxInfo> {
        val (name, amount) = message.parseChat()
        if (amount != null) {
            saveTax(name, amount)
        }
        return getTax(name)
    }
}
