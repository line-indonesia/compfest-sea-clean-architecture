package com.example.taxsaver

import com.example.taxsaver.application.GetTax
import com.example.taxsaver.application.SaveTax
import com.example.taxsaver.port.TaxInfoPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TaxSaverConfig {

    @Bean
    fun getTax(taxInfoPort: TaxInfoPort): GetTax {
        return GetTax(taxInfoPort)
    }

    @Bean
    fun saveTax(taxInfoPort: TaxInfoPort): SaveTax {
        return SaveTax(taxInfoPort)
    }
}
