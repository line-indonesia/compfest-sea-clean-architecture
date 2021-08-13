package com.example.taxsaver.adapter.`in`.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class TaxWebAdapter(
    private val service: TaxWebService
) {

    @GetMapping("/tax-form")
    fun taxForm(model: Model): String {
        model.addAttribute("taxform", TaxForm())
        return "tax-form"
    }

    @PostMapping("/tax-info")
    fun taxInfo(@ModelAttribute taxForm: TaxForm, model: Model): String {
        return service.processTaxForm(taxForm, model)
    }
}
