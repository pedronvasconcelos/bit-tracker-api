package tech.vasconcelos.trackercoin.infra.data.repositories

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.vasconcelos.trackercoin.domain.entities.User
import tech.vasconcelos.trackercoin.domain.repositories.UserRepository
import tech.vasconcelos.trackercoin.infra.data.models.UserEntity

@Repository
class UserRepositoryImpl(
    @PersistenceContext
    private val entityManager: EntityManager
) : UserRepository {

    override fun add(user: User): User {
        val entity = UserEntity.fromDomain(user)
        entityManager.persist(entity)
        return entity.toDomain()
    }
}