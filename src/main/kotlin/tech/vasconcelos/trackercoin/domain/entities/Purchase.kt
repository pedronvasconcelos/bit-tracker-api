package tech.vasconcelos.trackercoin.domain.entities

import tech.vasconcelos.trackercoin.domain.enums.CoinName
import tech.vasconcelos.trackercoin.domain.enums.FiatCurrency
import tech.vasconcelos.trackercoin.domain.exceptions.BusinessException
import tech.vasconcelos.trackercoin.domain.strategy.CalculatePrice
import java.math.BigDecimal
import java.math.BigInteger
import java.util.UUID
import java.time.Instant


data class Purchase(
    val id: UUID,
    val userId: UUID,
    val purchaseTimeStamp: Instant,
    val price: BigDecimal,
    val quantity: Long,
    val usdAmount: BigDecimal,
    val localCurrencyAmount: BigDecimal,
    val coin: CoinName,
    val fiatCurrency: FiatCurrency
) {
    init {
        if (quantity <= 0L) {
            throw BusinessException("Quantity must be greater than zero.")
        }
        if (price <= BigDecimal.ZERO) {
            throw BusinessException("Price must be greater than zero.")
        }
        if (usdAmount < BigDecimal.ZERO) {
            throw BusinessException("USD amount must be non-negative.")
        }
        if (localCurrencyAmount < BigDecimal.ZERO) {
            throw BusinessException("Local currency amount must be non-negative.")
        }
    }

    companion object {
        fun create(
            userId: UUID,
            fiatAmount: BigDecimal,
            quantity: Long,
            coin: CoinName,
            fiatCurrency: FiatCurrency,
            localCurrencyConversionRate: BigDecimal
        ): Purchase {
            val usdAmount = fiatAmount.divide(localCurrencyConversionRate)
            val price = CalculatePrice(coin, usdAmount, quantity ).calculatePrice()
            return Purchase(
                id = UUID.randomUUID(),
                userId = userId,
                purchaseTimeStamp = Instant.now(),
                price = price,
                quantity = quantity,
                usdAmount = usdAmount,
                localCurrencyAmount = fiatAmount,
                coin = coin,
                fiatCurrency = fiatCurrency
            )

        }
    }
}

