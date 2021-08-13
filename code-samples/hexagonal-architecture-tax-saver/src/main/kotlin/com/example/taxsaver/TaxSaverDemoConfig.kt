package com.example.taxsaver

import com.example.taxsaver.adapter.out.firebase.FirebaseTaxInfoPort
import com.example.taxsaver.port.TaxInfoPort
import com.google.cloud.firestore.Firestore
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("demo")
class TaxSaverDemoConfig {

    @Bean
    fun taxInfoPort(firestore: Firestore): TaxInfoPort {
        return FirebaseTaxInfoPort(firestore)
    }
}
