package by.hghgrtut.shop.entities

import javax.persistence.*

@Entity
@Table(name = "item")
class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    val name: String? = null,
    val picture: String? = null,
    val price: Double? = null,
    val description: String? = null
}