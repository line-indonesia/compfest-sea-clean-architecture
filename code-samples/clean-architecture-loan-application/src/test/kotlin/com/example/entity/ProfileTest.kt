package com.example.entity

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ProfileTest {

    @Test
    fun `valid profile 1`() {
        // Given
        val profile = Profile(
            "Brown",
            LocalDate.of(2000, 8, 17)
        )
        // When & Then
        assertTrue(profile.isValid())
    }

    @Test
    fun `valid profile 2`() {
        // Given
        val profile = Profile(
            "Cony",
            LocalDate.of(1970, 8, 17)
        )
        // When & Then
        assertTrue(profile.isValid())
    }

    @Test
    fun `invalid profile 1`() {
        // Given
        val profile = Profile(
            "Brown",
            LocalDate.of(1000, 8, 17)
        )
        // When & Then
        assertFalse(profile.isValid())
    }

    @Test
    fun `invalid profile 2`() {
        // Given
        val profile = Profile(
            "Brown",
            LocalDate.of(3000, 8, 17)
        )
        // When & Then
        assertFalse(profile.isValid())
    }
}
