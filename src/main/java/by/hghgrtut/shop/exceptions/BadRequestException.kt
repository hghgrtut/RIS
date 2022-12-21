package by.hghgrtut.shop.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.function.Supplier

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
class BadRequestException : RuntimeException {
    constructor(message: String?) : super(message) {}
    constructor() {}
}