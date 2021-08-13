package com.example.usecase

import com.example.entity.Loan

interface LoanRepository {
    fun saveLoan(loan: Loan)
}
