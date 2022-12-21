package by.hghgrtut.shop.security

import lombok.RequiredArgsConstructor
import org.springframework.security.core.GrantedAuthority

@RequiredArgsConstructor
enum class Role(authority: String) : GrantedAuthority(authority) {

    ADMIN("ADMIN"), USER("USER")
}