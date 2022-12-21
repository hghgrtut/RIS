package by.hghgrtut.shop.exceptions

import lombok.extern.slf4j.Slf4j

@Slf4j
@RestControllerAdvice
class CustomExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    @Throws(Exception::class)
    fun handler(exception: Exception?, request: WebRequest?): ResponseEntity<Object> {
        log.error("Exception during execution of application", exception)
        return handleException(exception, request)
    }
}