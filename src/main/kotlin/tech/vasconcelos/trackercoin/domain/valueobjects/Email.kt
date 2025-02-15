package tech.vasconcelos.trackercoin.domain.valueobjects

import tech.vasconcelos.trackercoin.domain.exceptions.EmailInvalidException

data class Email private constructor(
    val address: String
) {
    companion object {
        private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")

        fun create(address: String): Email {
            if (!isValid(address)) {
                throw EmailInvalidException(address)
            }
            return Email(address)
        }

        fun isValid(address: String): Boolean {
            return address.matches(EMAIL_REGEX)
        }
    }
}