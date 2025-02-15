package tech.vasconcelos.trackercoin.infra.data.models

import jakarta.persistence.*
import tech.vasconcelos.trackercoin.domain.entities.User
import tech.vasconcelos.trackercoin.domain.valueobjects.Email
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @Column(name = "id", nullable = false)
    val id: UUID,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "email", nullable = false, unique = true)
    val email: String,

    @Column(name = "created_date", nullable = false)
    val createdDate: LocalDateTime,

    @Column(name = "updated_date", nullable = false)
    val updatedDate: LocalDateTime,
    @Column(
        name = "internal_id",
        nullable = false,
        updatable = false,
        columnDefinition = "bigserial"
    )
    val internalId: Long = 0,

) {
     fun toDomain(): User =
        User(id, name, Email.create(email), createdDate, updatedDate)

    companion object {
         fun fromDomain(user: User): UserEntity =
            UserEntity(
                id = user.id,
                name = user.name,
                email = user.email.address,
                createdDate = user.createdDate,
                updatedDate = user.updatedDate,
            )
    }
}