package com.example.taxsaver.adapter.`in`

import com.example.taxsaver.adapter.`in`.web.TaxForm

fun String.parseChat(): Pair<String, Double?> {
    val token = split("\\s+".toRegex())
    val name = token[0].lowercase()
    val amount = token.getOrNull(1)
        ?.filter { it.isDigit() }
        ?.toDoubleOrNull()
    return Pair(name, amount)
}

fun TaxForm.parseForm(): Pair<String, Double?> {
    val lowercase = name.lowercase()
    val amount = taxableIncome
        ?.filter { it.isDigit() }
        ?.toDoubleOrNull()
    return Pair(lowercase, amount)
}
