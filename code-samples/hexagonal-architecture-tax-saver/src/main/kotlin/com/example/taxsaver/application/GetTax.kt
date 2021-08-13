package com.example.taxsaver.application

import com.example.taxsaver.adapter.out.local.NoOpShowTaxPort
import com.example.taxsaver.port.ShowTaxPort
import com.example.taxsaver.port.TaxInfoPort

class GetTax(
    private val taxInfoPort: TaxInfoPort
) {

    operator fun invoke(name: String, showTaxPort: ShowTaxPort = NoOpShowTaxPort()): Result<TaxInfo> {
        val taxInfo = taxInfoPort.getTaxInfo(name)
        taxInfo.fold(showTaxPort::showSuccessfulTaxInfo, showTaxPort::showFailedTaxInfo)
        return taxInfo
    }

}
