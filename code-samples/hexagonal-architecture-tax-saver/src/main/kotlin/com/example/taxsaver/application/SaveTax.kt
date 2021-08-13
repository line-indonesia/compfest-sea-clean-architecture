package com.example.taxsaver.application

import com.example.taxsaver.port.TaxInfoPort
import kotlin.math.roundToInt

class SaveTax(
    private val taxInfoPort: TaxInfoPort
) {

    operator fun invoke(name: String, taxableIncome: Double) {
        val taxInfo = TaxInfo(
            name = name,
            taxableIncome = taxableIncome,
            annualTax = getAnnualTax(taxableIncome),
            monthlyTax = getMonthlyTax(taxableIncome)
        )
        taxInfoPort.saveTaxInfo(taxInfo)
    }

    /**
     * Inaccurate calculation of progressive tax.
     * For demo purpose only.
     * The conditions are:
     * 1. No need to handle NPWP ownership case
     * 2. Individual tax, not org tax
     * 3. For citizen of Indonesia, not foreigner
     * 4. We use double instead of BigDecimal or Java Money API
     */
    companion object {
        private const val MAX_PERCENTAGE = 0.3
        private val LIMIT_PERCENT_PAIRS = listOf(
            Pair(50_000_000.00, 0.05),
            Pair(200_000_000.00, 0.15),
            Pair(250_000_000.00, 0.25)
        )

        fun getAnnualTax(taxableIncome: Double): Double {
            var tax = 0.0
            var income = taxableIncome

            for ((limit, percent) in LIMIT_PERCENT_PAIRS) {
                val remainder = income - limit
                if (remainder <= 0) {
                    tax += income * percent
                    income = remainder
                    break
                }
                tax += limit * percent
                income -= limit
            }
            if (income > 0) {
                tax += income * MAX_PERCENTAGE
            }

            return tax
        }

        fun getMonthlyTax(taxableIncome: Double): Int {
            return (getAnnualTax(taxableIncome) / 12).roundToInt()
        }
    }
}
