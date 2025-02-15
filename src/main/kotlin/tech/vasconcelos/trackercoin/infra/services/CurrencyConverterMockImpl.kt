package tech.vasconcelos.trackercoin.infra.services

import org.springframework.stereotype.Service
import tech.vasconcelos.trackercoin.application.services.CurrencyConverter
import tech.vasconcelos.trackercoin.domain.enums.FiatCurrency
import java.math.BigDecimal
@Service

class CurrencyConverterMockImpl : CurrencyConverter {
    override fun getUsdRate(localCurrency: FiatCurrency): BigDecimal {
        return BigDecimal("6.0")
    }
}