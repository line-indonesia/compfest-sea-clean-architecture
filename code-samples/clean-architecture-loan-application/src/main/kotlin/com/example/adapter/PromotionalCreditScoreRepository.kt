package com.example.adapter

import com.example.entity.CreditScore
import com.example.entity.Profile
import com.example.entity.Score
import com.example.usecase.CreditScoreRepository
import java.time.Period

class PromotionalCreditScoreRepository : CreditScoreRepository {
    override fun getCreditScore(profile: Profile): CreditScore {
        return CreditScore(Score.A, 10_000_000, Period.ofDays(100))
    }
}
