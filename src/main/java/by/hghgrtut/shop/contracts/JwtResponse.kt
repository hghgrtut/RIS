package by.hghgrtut.shop.contracts

import lombok.AllArgsConstructor
import lombok.Getter

class JwtResponse(val type = "MyType", val accessToken: String? = null, val refreshToken: String? = null)