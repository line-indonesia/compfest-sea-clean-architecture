package com.example.usecase

import com.example.entity.CreditScore
import com.example.entity.Loan
import com.example.entity.LoanRequest
import com.example.entity.Profile
import com.example.entity.Score
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Period

class ApplyLoanTest {

    @Test
    fun `valid loan application 1`() {
        // Given
        // Mock boundary
        val csRepo = object : CreditScoreRepository {
            override fun getCreditScore(profile: Profile): CreditScore {
                return CreditScore(
                    Score.A,
                    5_000_000,
                    Period.ofDays(90)
                )
            }
        }
        var isLoanCreated = false
        val loanRepo = object : LoanRepository {
            override fun saveLoan(loan: Loan) {
                isLoanCreated = true
            }
        }
        val profile = Profile(
            "Brown",
            LocalDate.of(1980, 8, 17)
        )
        val loanRequest = LoanRequest(profile, 3_000_000)

        // When
        val applyLoan = ApplyLoan(csRepo, loanRepo)
        val result = applyLoan(loanRequest)

        // Then
        assertTrue(isLoanCreated)
        assertTrue(result.isSuccess)
        assertEquals(profile, result.getOrThrow().profile)
    }

    @Test
    fun `valid loan application 2`() {
        // Given
        // Mock boundary
        val csRepo = object : CreditScoreRepository {
            override fun getCreditScore(profile: Profile): CreditScore {
                return CreditScore(
                    Score.A,
                    10_000_000,
                    Period.ofDays(90)
                )
            }
        }
        var isLoanCreated = false
        val loanRepo = object : LoanRepository {
            override fun saveLoan(loan: Loan) {
                isLoanCreated = true
            }
        }
        val profile = Profile(
            "Brown",
            LocalDate.of(2000, 8, 17)
        )
        val loanRequest = LoanRequest(profile, 10_000_000)

        // When
        val applyLoan = ApplyLoan(csRepo, loanRepo)
        val result = applyLoan(loanRequest)

        // Then
        assertTrue(isLoanCreated)
        assertTrue(result.isSuccess)
        assertEquals(profile, result.getOrThrow().profile)
    }

    @Test
    fun `invalid loan application 1 - invalid profile - too young`() {
        // Given
        val profile = Profile(
            "Cony",
            LocalDate.of(2010, 8, 17)
        )
        val loanRequest = LoanRequest(profile, 10_000_000)

        // When
        val applyLoan = ApplyLoan(stubCsRepository(), stubLoanRepository())
        val result = applyLoan(loanRequest)

        // Then
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApplyLoan.ApplyLoanError)
        assertEquals(result.exceptionOrNull()!!.message, ApplyLoan.Error.E1.description)
    }

    @Test
    fun `invalid loan application 2 - invalid loan amount - too large`() {
        // Given
        val profile = Profile(
            "Cony",
            LocalDate.of(2000, 8, 17)
        )
        val loanRequest = LoanRequest(profile, 100_000_000)

        // When
        val applyLoan = ApplyLoan(stubCsRepository(), stubLoanRepository())
        val result = applyLoan(loanRequest)

        // Then
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApplyLoan.ApplyLoanError)
        assertEquals(result.exceptionOrNull()!!.message, ApplyLoan.Error.E2.description)
    }

    @Test
    fun `invalid loan application 3 - invalid credit score - low credit score`() {
        // Given
        val profile = Profile(
            "Cony",
            LocalDate.of(2000, 8, 17)
        )
        val loanRequest = LoanRequest(profile, 1_000_000)

        // When
        val applyLoan = ApplyLoan(object : CreditScoreRepository {
            override fun getCreditScore(profile: Profile): CreditScore {
                return CreditScore(Score.D, 600_000, Period.ofDays(10))
            }
        }, stubLoanRepository())
        val result = applyLoan(loanRequest)

        // Then
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApplyLoan.ApplyLoanError)
        assertEquals(result.exceptionOrNull()!!.message, ApplyLoan.Error.E3.description)
    }

    @Test
    fun `invalid loan application 4 - invalid credit score - loan too large`() {
        // Given
        val profile = Profile(
            "Cony",
            LocalDate.of(2000, 8, 17)
        )
        val loanRequest = LoanRequest(profile, 1_000_000)

        // When
        val applyLoan = ApplyLoan(object : CreditScoreRepository {
            override fun getCreditScore(profile: Profile): CreditScore {
                return CreditScore(Score.C, 600_000, Period.ofDays(10))
            }
        }, stubLoanRepository())
        val result = applyLoan(loanRequest)

        // Then
        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApplyLoan.ApplyLoanError)
        assertEquals(result.exceptionOrNull()!!.message, ApplyLoan.Error.E3.description)
    }

    private fun stubLoanRepository() = object : LoanRepository {
        override fun saveLoan(loan: Loan) {
        }
    }

    private fun stubCsRepository() = object : CreditScoreRepository {
        override fun getCreditScore(profile: Profile): CreditScore {
            // Unused value
            return CreditScore(
                Score.A,
                10_000_000,
                Period.ofDays(90)
            )
        }
    }

}
