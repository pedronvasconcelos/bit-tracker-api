package tech.vasconcelos.trackercoin.application.usecases.users

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import tech.vasconcelos.trackercoin.domain.entities.User
import tech.vasconcelos.trackercoin.domain.valueobjects.Email
import tech.vasconcelos.trackercoin.domain.repositories.UserRepository
import java.util.*

@Service
@Transactional
class CreateUserUseCase(private val userRepository: UserRepository) {

    fun execute(request : CreateUserRequest): CreateUserResponse =
        User.create(request.name, request.email)
            .let { user -> userRepository.add(user) }
            .let { savedUser ->  CreateUserResponse(savedUser.id) }
}

data class CreateUserResponse(
    val id: UUID,
)

data class CreateUserRequest(
    val name: String,
    val email: String
)