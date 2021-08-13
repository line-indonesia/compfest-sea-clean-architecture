package com.example.article

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.text.DateFormat
import java.util.Date
import java.util.Locale

class DateFormatTest {

    @Test
    fun testIndonesiaLocale() {
        // Given
        val date = Date(1628230611010L) // 2021 Aug 06
        val idLocale = Locale("id", "ID")
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, idLocale)

        // When
        val readableDate = df.format(date)

        // Then
        assertEquals("6 Agt 2021", readableDate)
    }
}
