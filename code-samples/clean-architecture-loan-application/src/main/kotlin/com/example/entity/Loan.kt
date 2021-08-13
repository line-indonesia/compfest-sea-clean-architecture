package com.example.entity

import java.time.Period

data class Loan(
    val profile: Profile,
    val amount: Int,
    val principle: Int,
    val period: Period
)
