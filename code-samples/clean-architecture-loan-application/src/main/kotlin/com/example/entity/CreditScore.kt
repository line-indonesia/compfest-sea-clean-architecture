package com.example.entity

import java.time.Period

data class CreditScore(
    val score: Score,
    val maxAmount: Int,
    val maxPeriod: Period
)
