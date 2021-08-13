package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class DependencyInversion {

    @Test
    fun `dependency inversion - hard to test`() {
        // Given
        fun formatDate(): String {
            val idLocale = Locale("id", "ID")
            val date = LocalDate.now()
            val df = DateTimeFormatter.ofPattern("d MMM yyyy", idLocale).format(date)
            return df.format(date)
        }

        // When
        val output = formatDate()

        // Then
        assertEquals("12 Agt 2021", output)
    }

    @Test
    fun `dependency inversion - easy to test`() {
        fun formatDate(date: LocalDate, locale: Locale): String {
            return DateTimeFormatter.ofPattern("d MMM yyyy", locale).format(date)
        }

        fun test1() {
            // Given
            val today = LocalDate.of(2021, 8, 17)
            val local = Locale("id", "ID")

            // When
            val output = formatDate(today, local)

            // Then
            assertEquals("17 Agt 2021", output)
        }
        test1()

        fun test2() {
            // Given
            val today = LocalDate.of(2022, 1, 1)
            val local = Locale.JAPAN

            // When
            val output = formatDate(today, local)

            // Then
            assertEquals("1 1月 2022", output)
        }
        test2()
    }
}
