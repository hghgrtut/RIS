package by.hghgrtut.shop.configs

import by.hghgrtut.shop.contracts.ApiRouter
import by.hghgrtut.shop.filters.JwtFilter
import lombok.RequiredArgsConstructor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig {

    private val jwtFilter: JwtFilter = JwtFilter()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain = http.httpBasic()
            .disable()
            .csrf()
            .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests {
                it.antMatchers(
                        ApiRouter.AuthRouter.BASE_URL + ApiRouter.AuthRouter.LOGIN,
                        ApiRouter.AuthRouter.BASE_URL + ApiRouter.AuthRouter.TOKEN,
                        ApiRouter.UserRouter.BASE_URL
                    )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter::class.java)
            }
            .build()
}