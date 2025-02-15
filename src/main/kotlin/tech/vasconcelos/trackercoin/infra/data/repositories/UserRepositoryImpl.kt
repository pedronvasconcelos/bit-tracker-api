package tech.vasconcelos.trackercoin.infra.data.repositories

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Repository
import tech.vasconcelos.trackercoin.domain.entities.User
import tech.vasconcelos.trackercoin.domain.repositories.UserRepository
import tech.vasconcelos.trackercoin.infra.data.models.UserEntity
import java.util.*

@Repository
class UserRepositoryImpl : UserRepository {

    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun add(user: User): User {
        val entity = UserEntity.fromDomain(user)
        entityManager.persist(entity)
        entityManager.flush()
        return entity.toDomain()
    }

    override fun getById(userId: UUID): User? =
        runCatching { entityManager.find(UserEntity::class.java, userId) }
            .getOrNull()
            ?.toDomain()
}