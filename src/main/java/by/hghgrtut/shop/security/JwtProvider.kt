package by.hghgrtut.shop.security

import by.hghgrtut.shop.entities.UserEntity
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SignatureException
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import javax.crypto.SecretKey
import java.security.Key
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date

@Slf4j
@Component
class JwtProvider(
        @Value("\${jwt.secret.access}") jwtAccessSecret: String?,
        @Value("\${jwt.secret.refresh}") jwtRefreshSecret: String?
) {
    private val jwtAccessSecret: SecretKey
    private val jwtRefreshSecret: SecretKey

    init {
        this.jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret))
        this.jwtRefreshSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtRefreshSecret))
    }

    fun generateAccessToken(user: UserEntity): String = Jwts.builder()
            .setSubject(user.getLogin())
            .setExpiration(Date.from(LocalDateTime.now().plusMinutes(5).atZone(ZoneId.systemDefault()).toInstant()))
            .signWith(jwtAccessSecret)
            .claim("roles", user.getRole())
            .claim("firstName", user.getFirstName())
            .compact()

    fun generateRefreshToken(user: UserEntity): String = Jwts.builder()
            .setSubject(user.getLogin())
            .setExpiration(Date.from(LocalDateTime.now().plusDays(30).atZone(ZoneId.systemDefault()).toInstant()))
            .signWith(jwtRefreshSecret)
            .compact()

    fun validateAccessToken(accessToken: String): Boolean = validateToken(accessToken, jwtAccessSecret)

    fun validateRefreshToken(refreshToken: String): Boolean = validateToken(refreshToken, jwtRefreshSecret)

    private fun validateToken(token: String, secret: Key): Boolean {
        try {
            Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token)
            return true
        } catch (expEx: ExpiredJwtException) {
            log.error("Token expired", expEx)
        } catch (unsEx: UnsupportedJwtException) {
            log.error("Unsupported jwt", unsEx)
        } catch (mjEx: MalformedJwtException) {
            log.error("Malformed jwt", mjEx)
        } catch (sEx: SignatureException) {
            log.error("Invalid signature", sEx)
        } catch (e: Exception) {
            log.error("invalid token", e)
        }
        return false
    }

    fun getAccessClaims(token: String): Claims = getClaims(token, jwtAccessSecret)

    fun getRefreshClaims(token: String): Claims = getClaims(token, jwtRefreshSecret)

    private fun getClaims(token: String, secret: Key): Claims = Jwts.parserBuilder()
            .setSigningKey(secret)
            .build()
            .parseClaimsJws(token)
            .getBody()
}