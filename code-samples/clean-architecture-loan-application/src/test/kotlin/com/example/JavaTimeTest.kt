package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Period

class JavaTimeTest {

    @Test
    fun `year difference test`() {
        val date1 = LocalDate.of(1945, 8, 17)
        val date2 = LocalDate.of(2021, 8, 17)
        val diff = Period.between(date1, date2).years
        assertEquals(diff, 76)
    }
}
