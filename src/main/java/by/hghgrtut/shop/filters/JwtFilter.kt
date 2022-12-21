package by.hghgrtut.shop.filters

import by.hghgrtut.shop.security.JwtAuthentication

@Slf4j
@Component
class JwtFilter(private val jwtProvider: JwtProvider?) : GenericFilterBean() {

    @Override
    @Throws(IOException::class, ServletException::class)
    fun doFilter(request: ServletRequest, response: ServletResponse?, filterChain: FilterChain) {
        getTokenFromRequest(request as? HttpServletRequest)?.let {
            if (jwtProvider.validateAccessToken(it)) {
                val jwtInfoToken: JwtAuthentication = JwtUtils.generate(jwtProvider.getAccessClaims(token))
                jwtInfoToken.setAuthenticated(true)
                SecurityContextHolder.getContext().setAuthentication(jwtInfoToken)
            }
        }
        filterChain.doFilter(request, response)
    }

    private fun getTokenFromRequest(request: HttpServletRequest): String? {
        val bearer: String = request.getHeader(AUTHORIZATION)
        return if (StringUtils.hasText(bearer) && bearer.startsWith("Bearer ")) {
            bearer.substring(7)
        } else null
    }

    companion object {
        private const val AUTHORIZATION = "Authorization"
    }
}