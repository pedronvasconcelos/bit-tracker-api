package tech.vasconcelos.trackercoin.domain.strategy

import tech.vasconcelos.trackercoin.domain.enums.CoinName
import java.math.BigDecimal
import java.math.RoundingMode

class CalculatePrice(
    private val coin: CoinName,
    private val totalAmount: BigDecimal,
    private val quantity: Long
) {
    fun calculatePrice(): BigDecimal {
        val strategy = CalculateStrategyFactory.getStrategy(coin)
        return strategy.calculate(totalAmount, quantity)
    }
}

object CalculateStrategyFactory {
    fun getStrategy(coin: CoinName): CalculatePriceStrategy {
        return when (coin) {
            CoinName.BTC -> BitcoinCalculateStrategy()
        }
    }
}

interface CalculatePriceStrategy {
    fun calculate(totalAmountUSD: BigDecimal, quantity: Long): BigDecimal

}

class BitcoinCalculateStrategy : CalculatePriceStrategy {
    override fun calculate(totalAmountUSD: BigDecimal, quantity: Long): BigDecimal {
        val satoshisPerBitcoin = BigDecimal("100000000")
        val quantityBitcoin = BigDecimal(quantity).divide(satoshisPerBitcoin, 8, RoundingMode.HALF_UP)
        return totalAmountUSD.divide(quantityBitcoin, 2, RoundingMode.HALF_UP)
    }

}