package com.example.taxsaver.adapter.`in`.telegram

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "telegram")
class TelegramProperties {
    lateinit var apiKey: String
}
