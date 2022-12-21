package by.hghgrtut.shop.entities

import by.hghgrtut.shop.security.Role
import javax.persistence.*

@Entity
@Table(name = "usr")
class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val login: String? = null,
    val password: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    @Enumerated(EnumType.STRING)
    val role: Role? = null,
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    val basket: BasketEntity? = null
}