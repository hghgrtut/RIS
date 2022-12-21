package by.hghgrtut.shop.services

import by.hghgrtut.shop.model.UserModel
import by.hghgrtut.shop.model.factories.UserModelFactory
import by.hghgrtut.shop.entities.UserEntity
import by.hghgrtut.shop.exceptions.BadRequestException
import by.hghgrtut.shop.exceptions.NotFoundException
import by.hghgrtut.shop.repositories.UserRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService @Autowired constructor(private val userRepository: UserRepository) {
    
    fun getByLogin(login: String): UserEntity? = userRepository.findByLogin(login)

    fun findById(id: Long?): UserModel =
            UserModelFactory().toUserModel(userRepository.findById(id).orElseThrow { NotFoundException() })

    fun save(userEntity: UserEntity?): UserModel = UserModelFactory().toUserModel(userRepository.save(userEntity!!))

    fun update(userEntityFromDB: UserEntity?, userEntity: UserEntity?): UserModel {
        BeanUtils.copyProperties(userEntity!!, userEntityFromDB!!, "id")
        return UserModelFactory().toUserModel(userRepository.save(userEntityFromDB!!))
    }

    fun delete(userEntity: UserEntity?) = userRepository.delete(userEntity!!)
}