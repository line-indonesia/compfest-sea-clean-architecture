package com.example

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Instant

class ResultTest {

    @Test
    fun `functional style`() {
        val result: Result<Instant> = kotlin.runCatching {
            Instant.parse("2021-08-17T10:15:30.00Z")
        }
        assertTrue(result.isSuccess)
    }

    @Test
    fun `imperative style`() {
        val result: Result<Instant> = try {
            val date = Instant.parse("2021-08-17T10:15:30.00Z")
            Result.success(date)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
        assertTrue(result.isSuccess)
    }
}
