package tech.vasconcelos.trackercoin.application.services

import org.springframework.stereotype.Service
import tech.vasconcelos.trackercoin.domain.enums.FiatCurrency
import java.math.BigDecimal

interface CurrencyConverter {

    fun getUsdRate (localCurrency : FiatCurrency) : BigDecimal
}