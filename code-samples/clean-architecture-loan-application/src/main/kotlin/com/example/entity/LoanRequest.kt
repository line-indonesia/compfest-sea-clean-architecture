package com.example.entity

data class LoanRequest(
    val profile: Profile,
    val amount: Int
) {
    fun isValid(): Boolean {
        return amount in 500_000..10_000_000
    }
}
