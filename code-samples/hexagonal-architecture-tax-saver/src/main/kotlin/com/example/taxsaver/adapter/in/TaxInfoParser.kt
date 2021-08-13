package com.example.taxsaver.adapter.`in`

import com.example.taxsaver.adapter.`in`.web.ReadableTaxInfo
import com.example.taxsaver.application.TaxInfo
import java.text.NumberFormat
import java.util.Locale

fun Double.toMoney(): String {
    val idLocale = Locale("id", "ID")
    val nf = NumberFormat.getNumberInstance(idLocale)
    val formatted = nf.format(this)
    return "Rp$formatted"
}

fun Int.toMoney(): String {
    val idLocale = Locale("id", "ID")
    val nf = NumberFormat.getNumberInstance(idLocale)
    val formatted = nf.format(this)
    return "Rp$formatted"
}

fun TaxInfo.toReadableString(): String {
    val capitalizedName = name.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
    return """
        name: $capitalizedName
        taxable income: ${taxableIncome.toMoney()}
        annual tax: ${annualTax.toMoney()}
        monthly tax: ${monthlyTax.toMoney()}
    """.trimIndent()
}

fun TaxInfo.toReadableTaxInfo(): ReadableTaxInfo {
    val capitalizedName = name.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
    return ReadableTaxInfo(
        capitalizedName,
        taxableIncome.toMoney(),
        annualTax.toMoney(),
        monthlyTax.toMoney()
    )
}
