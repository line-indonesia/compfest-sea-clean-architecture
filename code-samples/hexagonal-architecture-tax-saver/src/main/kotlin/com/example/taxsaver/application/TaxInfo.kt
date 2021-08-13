package com.example.taxsaver.application

data class TaxInfo(
    val name: String,
    val taxableIncome: Double,
    val annualTax: Double,
    val monthlyTax: Int
)
