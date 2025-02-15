package tech.vasconcelos.trackercoin.domain.extensions

fun <T> T?.orThrow(exceptionProvider: () -> Throwable): T {
    return this ?: throw exceptionProvider()
}