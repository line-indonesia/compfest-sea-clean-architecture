package com.example.adapter

import com.example.entity.Loan
import com.example.usecase.LoanRepository

class InMemoryLoanRepository : LoanRepository {
    private val list = mutableListOf<Loan>()

    override fun saveLoan(loan: Loan) {
        list.add(loan)
    }
}
