package tech.vasconcelos.trackercoin.infra.data.repositories

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.vasconcelos.trackercoin.domain.entities.Purchase
import tech.vasconcelos.trackercoin.domain.repositories.PurchaseRepository
import tech.vasconcelos.trackercoin.infra.data.models.PurchaseEntity

@Repository
class PurchaseRepositoryImpl  : PurchaseRepository {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

   override fun add(purchase: Purchase): Purchase =
       run {
           entityManager.persist(PurchaseEntity.fromDomain(purchase))
           entityManager.flush()
           purchase
       }

}