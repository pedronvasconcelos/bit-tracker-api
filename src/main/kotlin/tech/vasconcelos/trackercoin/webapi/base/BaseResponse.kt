package tech.vasconcelos.trackercoin.webapi.base

import java.time.LocalDateTime

open class BaseResponse<T>(
    val data: T? = null,
    val success: Boolean = true,
    val message: String? = null,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun <T> success(data: T, message: String? = null): BaseResponse<T> {
            return BaseResponse(data = data, message = message)
        }

        fun <T> error(message: String, data: T? = null): BaseResponse<T> {
            return BaseResponse(data = data, success = false, message = message)
        }
    }
}

