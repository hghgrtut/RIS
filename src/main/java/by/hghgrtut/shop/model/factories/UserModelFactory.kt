package by.hghgrtut.shop.model.factories

import by.hghgrtut.shop.model.UserModel
import by.hghgrtut.shop.entities.UserEntity
import org.springframework.stereotype.Component

@Component
class UserModelFactory {

    fun toUserModel(userEntity: UserEntity): UserModel = UserModel.builder()
            .id(userEntity.getId())
            .login(userEntity.getLogin())
            .password(userEntity.getPassword())
            .firstName(userEntity.getFirstName())
            .lastName(userEntity.getLastName())
            .role(userEntity.getRole().toString())
            .basket(BasketModelFactory().toBasketModel(userEntity.getBasket()))
            .build()
}