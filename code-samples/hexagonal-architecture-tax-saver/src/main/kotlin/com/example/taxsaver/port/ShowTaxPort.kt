package com.example.taxsaver.port

import com.example.taxsaver.application.TaxInfo

interface ShowTaxPort {
    fun showSuccessfulTaxInfo(taxInfo: TaxInfo)
    fun showFailedTaxInfo(exception: Throwable)
}
