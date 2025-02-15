package tech.vasconcelos.trackercoin.domain.repositories

import tech.vasconcelos.trackercoin.domain.entities.User
import java.util.UUID

interface UserRepository {
    fun add(user: User) : User

    fun getById(userId: UUID) : User?
}