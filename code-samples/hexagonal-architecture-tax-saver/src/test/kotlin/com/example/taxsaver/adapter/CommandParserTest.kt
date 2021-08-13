package com.example.taxsaver.adapter

import com.example.taxsaver.adapter.`in`.parseChat
import com.example.taxsaver.adapter.`in`.parseForm
import com.example.taxsaver.adapter.`in`.web.TaxForm
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CommandParserTest {

    @Test
    fun parseChat_successCases1() {
        // Given
        val input = listOf(
            "brown 1.000.000" to Pair("brown", 1_000_000.00),
            "cony 10.000.000" to Pair("cony", 10_000_000.00),
            "sally 900.000" to Pair("sally", 900_000.00),
            "james 1_000_000" to Pair("james", 1_000_000.00),
        )
        // When
        input.forEach {
            val (parsedName, parsedAmount) = it.first.parseChat()
            val (name, amount) = it.second
            // Then
            assertEquals(name, parsedName)
            assertEquals(amount, parsedAmount)
        }
    }

    @Test
    fun parseChat_successCases2() {
        // Given
        val input = listOf(
            "brown" to Pair("brown", null),
            "cony" to Pair("cony", null),
            "sally" to Pair("sally", null),
            "james" to Pair("james", null),
        )
        // When
        input.forEach {
            val (parsedName, parsedAmount) = it.first.parseChat()
            val (name, amount) = it.second
            // Then
            assertEquals(name, parsedName)
            assertEquals(amount, parsedAmount)
        }
    }

    @Test
    fun parseChat_failCases() {
        // Given
        val input = listOf(
            " " to Pair("", null),
            "cony brown" to Pair("cony", null),
            "." to Pair(".", null),
            "1_000_000" to Pair("1_000_000", null),
        )
        // When
        input.forEach {
            val (parsedName, parsedAmount) = it.first.parseChat()
            val (name, amount) = it.second
            // Then
            assertEquals(name, parsedName)
            assertEquals(amount, parsedAmount)
        }
    }


    @Test
    fun parseForm_successCases1() {
        // Given
        val input = listOf(
            TaxForm("brown", "1.000.000") to Pair("brown", 1_000_000.00),
            TaxForm("cony", "10.000.000") to Pair("cony", 10_000_000.00),
            TaxForm("sally", "900.000") to Pair("sally", 900_000.00),
            TaxForm("james", "1_000_000") to Pair("james", 1_000_000.00),
        )
        // When
        input.forEach {
            val (parsedName, parsedAmount) = it.first.parseForm()
            val (name, amount) = it.second
            // Then
            assertEquals(name, parsedName)
            assertEquals(amount, parsedAmount)
        }
    }

    @Test
    fun parseForm_successCases2() {
        // Given
        val input = listOf(
            TaxForm("brown", null) to Pair("brown", null),
            TaxForm("cony", null) to Pair("cony", null),
            TaxForm("sally", null) to Pair("sally", null),
            TaxForm("james", null) to Pair("james", null),
        )
        // When
        input.forEach {
            val (parsedName, parsedAmount) = it.first.parseForm()
            val (name, amount) = it.second
            // Then
            assertEquals(name, parsedName)
            assertEquals(amount, parsedAmount)
        }
    }

    @Test
    fun parseForm_failCases() {
        // Given
        val input = listOf(
            TaxForm(" ", " ") to Pair(" ", null),
            TaxForm("cony", "brown") to Pair("cony", null),
            TaxForm(".", null) to Pair(".", null),
            TaxForm("1_000_000", "") to Pair("1_000_000", null),
        )
        // When
        input.forEach {
            val (parsedName, parsedAmount) = it.first.parseForm()
            val (name, amount) = it.second
            // Then
            assertEquals(name, parsedName)
            assertEquals(amount, parsedAmount)
        }
    }
}
