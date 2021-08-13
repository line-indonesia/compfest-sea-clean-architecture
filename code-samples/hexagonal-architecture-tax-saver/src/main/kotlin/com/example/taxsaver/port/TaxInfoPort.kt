package com.example.taxsaver.port

import com.example.taxsaver.application.TaxInfo

interface TaxInfoPort {

    fun saveTaxInfo(taxInfo: TaxInfo)

    fun getTaxInfo(name: String): Result<TaxInfo>

    class TaxInfoException(message: String) : Exception(message)

    enum class Error(val message: String) {
        E1("Tax info not found")
    }
}
