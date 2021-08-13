package com.example.adapter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate
import java.time.format.DateTimeParseException

class ConsoleInterfaceTest {

    @Test
    fun `parse success 1`() {
        // Given
        val name = "Brown"
        val dob = "2000-08-17"
        val amount = "1000000"

        // When
        val actual = ConsoleInterface.parseToLoanRequest(name, dob, amount)

        // Then
        assertEquals(name, actual.profile.name)
        assertEquals(LocalDate.of(2000, 8, 17), actual.profile.dob)
        assertEquals(amount.toInt(), actual.amount)
    }

    @Test
    fun `parse success 2`() {
        // Given
        val name = "Brown"
        val dob = "1800-08-17"
        val amount = "1000"

        // When
        val actual = ConsoleInterface.parseToLoanRequest(name, dob, amount)

        // Then
        assertEquals(name, actual.profile.name)
        assertEquals(LocalDate.of(1800, 8, 17), actual.profile.dob)
        assertEquals(amount.toInt(), actual.amount)
    }

    @Test
    fun `parse fail 1 - invalid date`() {
        // Given
        val name = "Brown"
        val dob = "1800/08/17"
        val amount = "1000"

        // Then
        assertThrows<DateTimeParseException> {
            // When
            ConsoleInterface.parseToLoanRequest(name, dob, amount)
        }
    }

    @Test
    fun `parse fail 2 - invalid amount`() {
        // Given
        val name = "Brown"
        val dob = "1800-08-17"
        val amount = "abc"

        // Then
        assertThrows<NumberFormatException> {
            // When
            ConsoleInterface.parseToLoanRequest(name, dob, amount)
        }
    }
}
