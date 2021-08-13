package com.example.usecase

import com.example.entity.CreditScore
import com.example.entity.Profile

interface CreditScoreRepository {

    fun getCreditScore(profile: Profile): CreditScore
}
