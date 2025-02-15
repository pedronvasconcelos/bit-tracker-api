package tech.vasconcelos.trackercoin.webapi.controllers.impl

import UserController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.vasconcelos.trackercoin.application.usecases.users.CreateUserRequest
import tech.vasconcelos.trackercoin.application.usecases.users.CreateUserResponse
import tech.vasconcelos.trackercoin.application.usecases.users.CreateUserUseCase
import tech.vasconcelos.trackercoin.webapi.base.BaseResponse

@RestController
class UserControllerImpl @Autowired constructor(
    private val createUserUseCase: CreateUserUseCase
) : UserController {


    override fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<BaseResponse<CreateUserResponse>> =
        ResponseEntity(BaseResponse.success(createUserUseCase.execute(request), "User created successfully"), HttpStatus.CREATED)

}
