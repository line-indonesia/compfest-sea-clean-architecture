package com.example.taxsaver.adapter.`in`.web

import com.example.taxsaver.adapter.`in`.parseForm
import com.example.taxsaver.adapter.`in`.toReadableTaxInfo
import com.example.taxsaver.application.GetTax
import com.example.taxsaver.application.SaveTax
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute

@Service
class TaxWebService(
    private val getTax: GetTax,
    private val saveTax: SaveTax
) {

    fun processTaxForm(@ModelAttribute taxForm: TaxForm, model: Model): String {
        val (name, amount) = taxForm.parseForm()
        if (amount != null) {
            saveTax(name, amount)
        }
        val result = getTax(name)

        if (result.isFailure) {
            return "tax-info-not-found"
        }

        val taxInfo = result.getOrNull()!!.toReadableTaxInfo()
        model.addAttribute("taxinfo", taxInfo)
        return "tax-info"
    }
}
