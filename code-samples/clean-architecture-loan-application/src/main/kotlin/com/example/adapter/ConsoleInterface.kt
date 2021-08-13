package com.example.adapter

import com.example.entity.LoanRequest
import com.example.entity.Profile
import com.example.usecase.ApplyLoan
import java.time.LocalDate

class ConsoleInterface {

    private val applyLoan = ApplyLoan(PromotionalCreditScoreRepository(), InMemoryLoanRepository())

    fun submit(name: String, dob: String, loanAmount: String): String {
        val loanRequest = parseToLoanRequest(name, dob, loanAmount)
        val result = applyLoan(loanRequest)
        if (result.isFailure) {
            return result.exceptionOrNull()!!.message!!
        }
        return result.getOrNull()!!.toString()
    }

    companion object {
        fun parseToLoanRequest(name: String, dob: String, loanAmount: String): LoanRequest {
            val localDate = LocalDate.parse(dob)
            return LoanRequest(
                Profile(name, localDate),
                loanAmount.toInt()
            )
        }
    }
}
