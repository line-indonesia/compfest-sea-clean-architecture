package com.example.taxsaver

import com.example.taxsaver.adapter.out.local.HashMapTaxInfoPort
import com.example.taxsaver.port.TaxInfoPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("local")
class TaxSaverLocalConfig {

    @Bean
    fun taxInfoPort(): TaxInfoPort {
        return HashMapTaxInfoPort()
    }
}
