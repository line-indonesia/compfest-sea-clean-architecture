package com.example.taxsaver.application

import com.example.taxsaver.port.ShowTaxPort
import com.example.taxsaver.port.TaxInfoPort
import com.example.taxsaver.port.TaxInfoPort.Error.E1
import com.example.taxsaver.port.TaxInfoPort.TaxInfoException
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class GetTaxTest {

    @Test
    fun successBehavior() {
        // Given
        val stubTax = TaxInfo("brown", 10.0, 10.0, 10)
        val stubTaxInfoPort = object : TaxInfoPort {
            override fun saveTaxInfo(taxInfo: TaxInfo) {
            }

            override fun getTaxInfo(name: String): Result<TaxInfo> {
                return Result.success(stubTax)
            }
        }
        val mockShowTaxInfoPort = spyk<ShowTaxPort>()

        // When
        val getTax = GetTax(stubTaxInfoPort)
        val result = getTax("brown", mockShowTaxInfoPort)

        // Then
        verify(exactly = 1) {
            mockShowTaxInfoPort.showSuccessfulTaxInfo(any())
        }
        verify(exactly = 0) {
            mockShowTaxInfoPort.showFailedTaxInfo(any())
        }

        assertTrue(result.isSuccess)
        assertEquals(stubTax, result.getOrNull()!!)
    }

    @Test
    fun failBehavior() {
        // Given
        val exception = TaxInfoException(E1.message)
        val stubTaxInfoPort = object : TaxInfoPort {
            override fun saveTaxInfo(taxInfo: TaxInfo) {
            }

            override fun getTaxInfo(name: String): Result<TaxInfo> {
                return Result.failure(exception)
            }
        }
        val mockShowTaxInfoPort = spyk<ShowTaxPort>()

        // When
        val getTax = GetTax(stubTaxInfoPort)
        val result = getTax("brown", mockShowTaxInfoPort)

        // Then
        verify(exactly = 0) {
            mockShowTaxInfoPort.showSuccessfulTaxInfo(any())
        }
        verify(exactly = 1) {
            mockShowTaxInfoPort.showFailedTaxInfo(any())
        }

        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull()!!)
    }
}
