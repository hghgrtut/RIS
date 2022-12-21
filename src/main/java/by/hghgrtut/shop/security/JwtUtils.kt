package by.hghgrtut.shop.security

import by.hghgrtut.shop.security.JwtAuthentication
import by.hghgrtut.shop.security.Role
import io.jsonwebtoken.Claims
import lombok.AccessLevel
import lombok.NoArgsConstructor
import java.util.List
import java.util.Set
import java.util.stream.Collectors

object JwtUtils {

    fun generate(claims: Claims): JwtAuthentication = JwtAuthentication().apply {
        setRoles(getRoles(claims))
        setFirstName(claims.get("firstName", String::class.java))
        setUsername(claims.getSubject())
    }

    private fun getRoles(claims: Claims): Set<Role> =
            claims.get("roles", List::class.java).stream().map(Role::valueOf).collect(Collectors.toSet())
}