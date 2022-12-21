package by.hghgrtut.shop.repositories

import by.hghgrtut.shop.entities.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<ItemEntity?, Long?>