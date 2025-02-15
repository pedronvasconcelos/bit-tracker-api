import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import tech.vasconcelos.trackercoin.application.usecases.users.CreateUserRequest
import tech.vasconcelos.trackercoin.application.usecases.users.CreateUserResponse
import tech.vasconcelos.trackercoin.webapi.base.BaseResponse

interface UserController {

    @Operation(summary = "Create a new user", description = "Creates a new user with the provided name and email")
    @PostMapping("/api/users")

    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<BaseResponse<CreateUserResponse>>
}
