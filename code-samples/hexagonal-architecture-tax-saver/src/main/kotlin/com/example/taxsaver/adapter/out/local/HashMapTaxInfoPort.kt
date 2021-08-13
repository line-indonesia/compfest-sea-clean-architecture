package com.example.taxsaver.adapter.out.local

import com.example.taxsaver.application.TaxInfo
import com.example.taxsaver.port.TaxInfoPort
import com.example.taxsaver.port.TaxInfoPort.Error.E1
import com.example.taxsaver.port.TaxInfoPort.TaxInfoException

class HashMapTaxInfoPort : TaxInfoPort {

    private val hashMap = hashMapOf<String, TaxInfo>()

    override fun saveTaxInfo(taxInfo: TaxInfo) {
        hashMap[taxInfo.name] = taxInfo
    }

    override fun getTaxInfo(name: String): Result<TaxInfo> {
        return if (hashMap.containsKey(name)) {
            Result.success(hashMap[name]!!)
        } else {
            Result.failure(TaxInfoException(E1.message))
        }
    }
}
