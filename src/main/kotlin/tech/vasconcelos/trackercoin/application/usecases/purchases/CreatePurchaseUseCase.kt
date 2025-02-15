package tech.vasconcelos.trackercoin.application.usecases.purchases

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.vasconcelos.trackercoin.application.services.CurrencyConverter
import tech.vasconcelos.trackercoin.domain.entities.Purchase
import tech.vasconcelos.trackercoin.domain.enums.CoinName
import tech.vasconcelos.trackercoin.domain.enums.FiatCurrency
import tech.vasconcelos.trackercoin.domain.exceptions.BusinessException
import tech.vasconcelos.trackercoin.domain.extensions.orThrow
import tech.vasconcelos.trackercoin.domain.repositories.PurchaseRepository
import tech.vasconcelos.trackercoin.domain.repositories.UserRepository
import java.math.BigDecimal
import java.time.Instant
import java.util.UUID

@Service
@Transactional
class CreatePurchaseUseCase(private val purchaseRepository: PurchaseRepository,
    private val userRepository: UserRepository,
    private val currencyConverter : CurrencyConverter) {

    fun execute(request: CreatePurchaseRequest): CreatePurchaseResponse =
    userRepository.getById(request.userId)
        .orThrow({ BusinessException("User not found") })
    .let { user ->
        Purchase.create(
            userId = user.id,
            fiatAmount = request.fiatAmount,
            quantity = request.quantity,
            coin = request.coin,
            fiatCurrency = request.fiatCurrency,
            localCurrencyConversionRate = currencyConverter.getUsdRate(request.fiatCurrency)
        ).also { purchase ->
            purchaseRepository.add(purchase)
        }
    }
    .let { purchase ->
        CreatePurchaseResponse(
            purchaseId = purchase.id,
            usdAmount = purchase.usdAmount,
            price = purchase.price,
            coinName = purchase.coin,
            purchaseTimeStamp = purchase.purchaseTimeStamp
        )
    }

}


data class CreatePurchaseRequest(val userId : UUID,
    val fiatAmount : BigDecimal,
    val quantity : Long,
    val coin : CoinName,
    val fiatCurrency : FiatCurrency
    )


data class CreatePurchaseResponse(val purchaseId : UUID,
    val  price : BigDecimal,
    val usdAmount : BigDecimal,
    val coinName : CoinName,
    val purchaseTimeStamp : Instant
    )