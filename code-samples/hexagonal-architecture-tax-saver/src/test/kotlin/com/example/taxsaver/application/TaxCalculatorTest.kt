package com.example.taxsaver.application

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TaxCalculatorTest {

    @Test
    fun testAnnualTax() {
        val pairs = listOf(
            32_700_000.00 to 1_635_000.00,
            60_000_000.00 to 4_000_000.00,
            75_000_000.00 to 6_250_000.00,
            226_000_000.00 to 28_900_000.00,
            400_000_000.00 to 70_000_000.00,
            514_500_000.00 to 99_350_000.00,
        )
        pairs.forEach {
            val input = it.first
            val expected = it.second
            val actual = SaveTax.getAnnualTax(input)
            assertEquals(expected, actual)
        }
    }

    @Test
    fun testMonthlyTax() {
        val pairs = listOf(
            32_700_000.00 to 136_250,
            60_000_000.00 to 333_333,
            75_000_000.00 to 520_833,
            226_000_000.00 to 2_408_333,
            400_000_000.00 to 5_833_333,
            514_500_000.00 to 8_279_167,
        )
        pairs.forEach {
            val input = it.first
            val expected = it.second
            val actual = SaveTax.getMonthlyTax(input)
            assertEquals(expected, actual)
        }
    }
}
