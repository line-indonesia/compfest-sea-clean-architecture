package com.example.entity

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate

class LoanRequestTest {

    @Test
    fun `valid loan 1`() {
        // Given
        val loan = LoanRequest(
            stubProfile(),
            500_000
        )
        // When & Then
        assertTrue(loan.isValid())
    }

    @Test
    fun `valid loan 2`() {
        // Given
        val loan = LoanRequest(
            stubProfile(),
            10_000_000
        )
        // When & Then
        assertTrue(loan.isValid())
    }

    @Test
    fun `invalid loan 1`() {
        // Given
        val loan = LoanRequest(
            stubProfile(),
            1
        )
        // When & Then
        assertFalse(loan.isValid())
    }

    @Test
    fun `invalid loan 2`() {
        // Given
        val loan = LoanRequest(
            stubProfile(),
            100_000_000
        )
        // When & Then
        assertFalse(loan.isValid())
    }

    private fun stubProfile() = Profile("Brown", LocalDate.of(2000, 8, 16))
}
