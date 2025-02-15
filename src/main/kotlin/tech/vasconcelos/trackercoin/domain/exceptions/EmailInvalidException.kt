package tech.vasconcelos.trackercoin.domain.exceptions

class EmailInvalidException(email: String) : BusinessException("The email '$email' is invalid")