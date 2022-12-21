package by.hghgrtut.shop.security

class JwtAuthentication(
        override var isAuthenticated = false
        var username: String? = null
        var name: String? = null
        var roles: Set<Role>? = null
) : Authentication {

    val authorities: Collection<Role>? get() = roles
    val principal: String? get() = username
}