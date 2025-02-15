package tech.vasconcelos.trackercoin.domain.repositories

import tech.vasconcelos.trackercoin.domain.entities.Purchase

interface PurchaseRepository {
    fun add(purchase : Purchase) : Purchase
}