package by.hghgrtut.shop.repositories

import by.hghgrtut.shop.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<UserEntity?, Long?> {

    fun findByLogin(login: String?): UserEntity?
}