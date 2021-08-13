package com.example.taxsaver.adapter.out.local

import com.example.taxsaver.application.TaxInfo
import com.example.taxsaver.port.ShowTaxPort

class NoOpShowTaxPort : ShowTaxPort{
    override fun showSuccessfulTaxInfo(taxInfo: TaxInfo) {
        // Do nothing
    }

    override fun showFailedTaxInfo(exception: Throwable) {
        // Do nothing
    }
}
