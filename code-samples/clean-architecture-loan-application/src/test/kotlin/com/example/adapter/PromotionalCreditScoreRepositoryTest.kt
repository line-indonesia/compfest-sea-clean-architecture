package com.example.adapter

import com.example.entity.CreditScore
import com.example.entity.Profile
import com.example.entity.Score
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Period

class PromotionalCreditScoreRepositoryTest {

    private val repository = PromotionalCreditScoreRepository()

    @Test
    fun `behavior test`() {
        // Given
        val expected = CreditScore(Score.A, 10_000_000, Period.ofDays(100))

        // When
        repeat(100) {
            // Then
            val actual = repository.getCreditScore(stubProfile())
            assertEquals(expected, actual)
        }
    }

    private fun stubProfile() = Profile("Brown", LocalDate.of(2000, 8, 17))
}
