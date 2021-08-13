package com.example.usecase

import com.example.entity.Loan
import com.example.entity.LoanRequest
import com.example.entity.Score
import kotlin.math.roundToInt

class ApplyLoan(
    private val creditScoreRepository: CreditScoreRepository,
    private val loanRepository: LoanRepository
) {

    operator fun invoke(loanRequest: LoanRequest): Result<Loan> {
        // 1. Validate profile
        if (!loanRequest.profile.isValid()) {
            return Result.failure(ApplyLoanError(Error.E1.description))
        }
        // 2. Validate loan amount
        if (!loanRequest.isValid()) {
            return Result.failure(ApplyLoanError(Error.E2.description))
        }
        // 3. Get credit score
        val cs = creditScoreRepository.getCreditScore(loanRequest.profile)
        // 4. Validate from credit score
        if (cs.score == Score.D
            || cs.score == Score.E
            || loanRequest.amount > cs.maxAmount
        ) {
            return Result.failure(ApplyLoanError(Error.E3.description))
        }
        // 5. Calculate principle
        val principle = (loanRequest.amount * cs.score.interest).roundToInt()
        val loan = Loan(
            profile = loanRequest.profile,
            amount = loanRequest.amount,
            principle = principle,
            period = cs.maxPeriod
        )
        loanRepository.saveLoan(loan)
        return Result.success(loan)
    }

    class ApplyLoanError(description: String) : Throwable(description)

    enum class Error(val description: String) {
        E1("Invalid profile"),
        E2("Invalid loan amount"),
        E3("Invalid credit score"),
    }
}
