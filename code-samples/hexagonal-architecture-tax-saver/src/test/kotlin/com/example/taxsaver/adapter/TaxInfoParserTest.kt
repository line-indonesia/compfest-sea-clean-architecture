package com.example.taxsaver.adapter

import com.example.taxsaver.adapter.`in`.toReadableString
import com.example.taxsaver.adapter.`in`.toReadableTaxInfo
import com.example.taxsaver.adapter.`in`.web.ReadableTaxInfo
import com.example.taxsaver.application.TaxInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TaxInfoParserTest {

    @Test
    fun radableString_sampleCase() {
        // Given
        val input = listOf(
            TaxInfo("brown", 1000000.0, 50000.0, 4167),
            TaxInfo("cony", 2.1E8, 2.65E7, 2208333),
            TaxInfo("james", 3000000.0, 150000.0, 12500),
            TaxInfo("sally", 3.0E8, 4.5E7, 3750000),
            TaxInfo("boss", 7.0E8, 1.55E8, 12916667)
        )
        // When
        val actualList = input.map {
            it.toReadableString()
        }
        val expectedList = listOf(
            """
                name: Brown
                taxable income: Rp1.000.000
                annual tax: Rp50.000
                monthly tax: Rp4.167
            """.trimIndent(),
            """
                name: Cony
                taxable income: Rp210.000.000
                annual tax: Rp26.500.000
                monthly tax: Rp2.208.333
            """.trimIndent(),
            """
                name: James
                taxable income: Rp3.000.000
                annual tax: Rp150.000
                monthly tax: Rp12.500
            """.trimIndent(),
            """
                name: Sally
                taxable income: Rp300.000.000
                annual tax: Rp45.000.000
                monthly tax: Rp3.750.000
            """.trimIndent(),
            """
                name: Boss
                taxable income: Rp700.000.000
                annual tax: Rp155.000.000
                monthly tax: Rp12.916.667
            """.trimIndent()
        )
        // Then
        actualList.forEachIndexed { index, actual ->
            println(actual)
            assertEquals(expectedList[index], actual)
        }
    }

    @Test
    fun toReadableTaxInfo_sampleCase() {
        // Given
        val input = listOf(
            TaxInfo("brown", 1000000.0, 50000.0, 4167),
            TaxInfo("cony", 2.1E8, 2.65E7, 2208333),
            TaxInfo("james", 3000000.0, 150000.0, 12500),
            TaxInfo("sally", 3.0E8, 4.5E7, 3750000),
            TaxInfo("boss", 7.0E8, 1.55E8, 12916667)
        )
        // When
        val actualList = input.map {
            it.toReadableTaxInfo()
        }
        val expectedList = listOf(
            ReadableTaxInfo(
                "Brown",
                "Rp1.000.000",
                "Rp50.000",
                "Rp4.167"
            ),
            ReadableTaxInfo(
                "Cony",
                "Rp210.000.000",
                "Rp26.500.000",
                "Rp2.208.333"
            ),
            ReadableTaxInfo(
                "James",
                "Rp3.000.000",
                "Rp150.000",
                "Rp12.500"
            ),
            ReadableTaxInfo(
                "Sally",
                "Rp300.000.000",
                "Rp45.000.000",
                "Rp3.750.000"
            ),
            ReadableTaxInfo(
                "Boss",
                "Rp700.000.000",
                "Rp155.000.000",
                "Rp12.916.667"
            )
        )
        // Then
        actualList.forEachIndexed { index, actual ->
            println(actual)
            assertEquals(expectedList[index], actual)
        }
    }
}
