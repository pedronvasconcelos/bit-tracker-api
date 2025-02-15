package tech.vasconcelos.trackercoin.webapi.middlewares

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import tech.vasconcelos.trackercoin.domain.exceptions.BusinessException
import tech.vasconcelos.trackercoin.webapi.base.BaseResponse

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ResponseEntity<BaseResponse<Nothing>> {
        val statusCode = when (ex) {
            is BusinessException -> HttpStatus.BAD_REQUEST
            else -> HttpStatus.INTERNAL_SERVER_ERROR
        }

        val baseResponse = BaseResponse.error(ex.message ?: "Unknown Error", null)

        return ResponseEntity(
            baseResponse,
            statusCode
        )
    }
}