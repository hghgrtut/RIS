package by.hghgrtut.shop.controllers

import by.hghgrtut.shop.contracts.ApiRouter
import by.hghgrtut.shop.contracts.JwtRequest
import by.hghgrtut.shop.contracts.JwtResponse
import by.hghgrtut.shop.contracts.RefreshJwtRequest
import by.hghgrtut.shop.services.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(ApiRouter.AuthRouter.BASE_URL)
class AuthController @Autowired constructor(private val authService: AuthService) {

    @PostMapping(ApiRouter.AuthRouter.LOGIN)
    fun login(@RequestBody authRequest: JwtRequest?): ResponseEntity<JwtResponse> =
            getEntity(authService.login(authRequest))

    @PostMapping(ApiRouter.AuthRouter.TOKEN)
    fun getNewAccessToken(@RequestBody request: RefreshJwtRequest): ResponseEntity<JwtResponse> =
            getEntity(authService.getAccessToken(request.getRefreshToken()))

    @PostMapping(ApiRouter.AuthRouter.REFRESH)
    fun getNewRefreshToken(@RequestBody request: RefreshJwtRequest): ResponseEntity<JwtResponse> =
            getEntity(authService.refresh(request.getRefreshToken()))

    private fun getEntity(token: JwtResponse) = ResponseEntity.ok(token)
}