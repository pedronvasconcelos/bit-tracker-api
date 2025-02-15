package tech.vasconcelos.trackercoin.domain.entities

import tech.vasconcelos.trackercoin.domain.enums.CoinName
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class CoinPrice(
    val id : UUID,
    val coinName : CoinName,
    val datePrice : LocalDateTime,
    val price : BigDecimal,
    val source : String
    )


