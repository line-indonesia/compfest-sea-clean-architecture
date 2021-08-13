package com.example.taxsaver.adapter.out.firebase

import com.example.taxsaver.application.TaxInfo
import com.example.taxsaver.port.TaxInfoPort
import com.example.taxsaver.port.TaxInfoPort.Error.E1
import com.example.taxsaver.port.TaxInfoPort.TaxInfoException
import com.google.cloud.firestore.Firestore
import org.slf4j.LoggerFactory

class FirebaseTaxInfoPort(
    private val firestore: Firestore
) : TaxInfoPort {

    private val log = LoggerFactory.getLogger(FirebaseTaxInfoPort::class.java)

    override fun saveTaxInfo(taxInfo: TaxInfo) {
        val result = firestore.collection(TAX_SAVER_COLLECTION)
            .document(taxInfo.name)
            .set(taxInfo.toHashMap())
            .get()
        log.info("TaxInfo $taxInfo saved at ${result.updateTime}")
    }

    override fun getTaxInfo(name: String): Result<TaxInfo> {
        val apiFuture = firestore.collection(TAX_SAVER_COLLECTION)
            .document(name)
            .get()

        val map = apiFuture.get().data

        return if (map != null) {
            val taxInfo = map.toTaxInfo()
            Result.success(taxInfo)
        } else {
            Result.failure(TaxInfoException(E1.message))
        }
    }

    private fun TaxInfo.toHashMap(): Map<String, Any> {
        return hashMapOf(
            FIELD_NAME to name,
            FIELD_TAXABLE_INCOME to taxableIncome.toString(),
            FIELD_ANNUAL_TAX to annualTax.toString(),
            FIELD_MONTHLY_TAX to monthlyTax.toString(),
        )
    }

    private fun MutableMap<String, Any>.toTaxInfo(): TaxInfo {
        return TaxInfo(
            name = get(FIELD_NAME) as String,
            taxableIncome = (get(FIELD_TAXABLE_INCOME) as String).toDouble(),
            annualTax = (get(FIELD_ANNUAL_TAX) as String).toDouble(),
            monthlyTax = (get(FIELD_MONTHLY_TAX) as String).toInt(),
        )
    }

    companion object {
        private const val TAX_SAVER_COLLECTION = "tax-saver-collection"
        private const val FIELD_NAME = "name"
        private const val FIELD_TAXABLE_INCOME = "taxableIncome"
        private const val FIELD_ANNUAL_TAX = "annualTax"
        private const val FIELD_MONTHLY_TAX = "monthlyTax"
    }
}
