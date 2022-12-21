package by.hghgrtut.shop.entities

import java.util.ArrayList
import javax.persistence.*

@Entity
@Table(name = "basket")
class BasketEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long? = null,

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    private val items: List<ItemEntity> = ArrayList<ItemEntity>()
)