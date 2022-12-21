package by.hghgrtut.shop.services

import by.hghgrtut.shop.contracts.JwtRequest
import by.hghgrtut.shop.contracts.JwtResponse
import by.hghgrtut.shop.entities.UserEntity
import by.hghgrtut.shop.exceptions.AuthException
import by.hghgrtut.shop.security.JwtAuthentication
import by.hghgrtut.shop.security.JwtProvider
import io.jsonwebtoken.Claims
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import java.util.HashMap
import java.util.Map

@Service
class AuthService @Autowired constructor(private val userService: UserService, private val jwtProvider: JwtProvider) {

    val authInfo: JwtAuthentication get() = SecurityContextHolder.getContext().getAuthentication() as JwtAuthentication

    private val refreshStorage: Map<String, String> = HashMap()

    fun login(authRequest: JwtRequest): JwtResponse {
        val user: UserEntity = userService.getByLogin(authRequest.getLogin()).orThrowUserNotFoundException()
        return if (user.getPassword().equals(authRequest.getPassword())) {
            val refreshToken: String = jwtProvider.generateRefreshToken(user)
            refreshStorage.put(user.getLogin(), refreshToken)
            JwtResponse(jwtProvider.generateAccessToken(user), refreshToken)
        } else { throw AuthException("Wrong password") }
    }

    fun getAccessToken(refreshToken: String): JwtResponse {
        var accessToken: String? = null
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            val login: String = jwtProvider.getRefreshClaims(refreshToken).getSubject()
            refreshStorage.get(login)?.let {
                if (it.equals(refreshToken))
                    accessToken =
                        jwtProvider.generateAccessToken(userService.getByLogin(login).orThrowUserNotFoundException())
            }
        }
        return JwtResponse(accessToken, null)
    }

    fun refresh(refreshToken: String): JwtResponse {
        if (jwtProvider.validateRefreshToken(refreshToken)) {
            val login: String = jwtProvider.getRefreshClaims(refreshToken).getSubject()
            refreshStorage.get(login)?.let {
                if (it.equals(refreshToken)) {
                    val user: UserEntity = userService.getByLogin(login).orThrowUserNotFoundException()
                    val newRefreshToken: String = jwtProvider.generateRefreshToken(user)
                    refreshStorage.put(user.getLogin(), newRefreshToken)
                    return JwtResponse(jwtProvider.generateAccessToken(user), newRefreshToken)
                }
            }
        }
        throw AuthException("Invalid JWT token")
    }

    private fun String.orThrowUserNotFoundException() = orElseThrow { AuthException("User not found") }
}