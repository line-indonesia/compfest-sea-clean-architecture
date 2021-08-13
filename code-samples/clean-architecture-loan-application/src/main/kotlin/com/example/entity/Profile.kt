package com.example.entity

import java.time.LocalDate
import java.time.Period

data class Profile(
    val name: String,
    val dob: LocalDate
) {
    fun isValid(): Boolean {
        val now = LocalDate.of(2021, 8, 17)
        val diff = Period.between(dob, now).years
        if (diff <= 18 || diff >= 60) {
            return false
        }
        // Other validations
        return true
    }
}
