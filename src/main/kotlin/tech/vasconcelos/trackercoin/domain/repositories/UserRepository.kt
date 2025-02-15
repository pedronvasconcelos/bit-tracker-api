package tech.vasconcelos.trackercoin.domain.repositories

import tech.vasconcelos.trackercoin.domain.entities.User

interface UserRepository {
    fun add(user: User) : User
}