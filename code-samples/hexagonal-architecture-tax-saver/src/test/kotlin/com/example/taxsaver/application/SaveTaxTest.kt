package com.example.taxsaver.application

import com.example.taxsaver.port.TaxInfoPort
import com.example.taxsaver.port.TaxInfoPort.Error.E1
import com.example.taxsaver.port.TaxInfoPort.TaxInfoException
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SaveTaxTest {

    @Test
    fun successBehavior() {
        // Given
        val mockTaxInfoPort = spyk<TaxInfoPort>()

        // When
        val saveTax = SaveTax(mockTaxInfoPort)
        saveTax("brown", 10.0)

        // Then
        verify(exactly = 1) {
            mockTaxInfoPort.saveTaxInfo(any())
        }
        verify(exactly = 0) {
            mockTaxInfoPort.getTaxInfo(any())
        }
    }

    @Test
    fun failBehavior() {
        // Given
        val exception = TaxInfoException(E1.message)
        val mockTaxInfoPort = spyk<TaxInfoPort>()
        every {
            mockTaxInfoPort.saveTaxInfo(any())
        } throws exception

        // When
        val saveTax = SaveTax(mockTaxInfoPort)

        // Then
        assertThrows<TaxInfoException> {
            saveTax("brown", 10.0)
        }
        verify(exactly = 1) {
            mockTaxInfoPort.saveTaxInfo(any())
        }
    }
}
