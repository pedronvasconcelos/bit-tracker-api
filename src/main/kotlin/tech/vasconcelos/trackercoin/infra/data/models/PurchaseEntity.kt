package tech.vasconcelos.trackercoin.infra.data.models

import jakarta.persistence.*
import tech.vasconcelos.trackercoin.domain.entities.Purchase
import tech.vasconcelos.trackercoin.domain.enums.CoinName
import tech.vasconcelos.trackercoin.domain.enums.FiatCurrency
import java.math.BigDecimal
import java.time.Instant
import java.util.*

@Entity
@Table(name = "purchases")
data class PurchaseEntity(
    @Id
    @Column(name = "purchase_id", nullable = false)
    val id: UUID,

    @Column(name = "user_id", nullable = false)
    val userId: UUID,




    @Column(name = "purchase_timestamp", nullable = false)
    val purchaseTimeStamp: Instant,

    @Column(name = "price", precision = 19, scale = 8)
    val price: BigDecimal,

    @Column(name = "quantity", precision = 30, scale = 0)
    val quantity: Long,

    @Column(name = "usd_amount", precision = 19, scale = 2)
    val usdAmount: BigDecimal,

    @Column(name = "local_currency_amount", precision = 19, scale = 2)
    val localCurrencyAmount: BigDecimal,

    @Column(name = "coin", length = 16)
    @Enumerated(EnumType.STRING)
    val coin: CoinName,

    @Column(name = "fiat_currency", length = 3)
    @Enumerated(EnumType.STRING)
    val fiatCurrency: FiatCurrency,

    @Column(
        name = "internal_id",
        nullable = false,
        updatable = false,
        columnDefinition = "bigserial"
    )
    val internalId: Long = 0,


    ) {
    companion object {
        fun fromDomain(purchase: Purchase): PurchaseEntity =
            PurchaseEntity(
                purchase.id,
                purchase.userId,
                purchase.purchaseTimeStamp,
                purchase.price,
                purchase.quantity,
                purchase.usdAmount,
                purchase.localCurrencyAmount,
                purchase.coin,
                purchase.fiatCurrency
            )


    }
}
