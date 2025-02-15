package tech.vasconcelos.trackercoin.domain.entities

import tech.vasconcelos.trackercoin.domain.valueobjects.Email
import java.time.LocalDateTime
import java.util.UUID

data class User private constructor(
    val id: UUID,
    val name: String,
    val email: Email,
    val createdDate: LocalDateTime,
    val updatedDate: LocalDateTime,
) {
    companion object {
        fun create(name: String, email: String): User {
            val now = LocalDateTime.now()
            return User(UUID.randomUUID(), name, Email.create(email), now, now)
        }
    }
}