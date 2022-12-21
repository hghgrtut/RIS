package by.hghgrtut.shop.model.factories

import by.hghgrtut.shop.model.BasketModel
import by.hghgrtut.shop.entities.BasketEntity
import org.springframework.stereotype.Component

@Component
class BasketModelFactory {

    fun toBasketModel(basketEntity: BasketEntity): BasketModel = BasketModel.builder()
            .id(basketEntity.getId())
            .items(basketEntity.getItems()
                    .stream()
                    .map { itemEntity -> ItemModelFactory().toItemModel(itemEntity) }
                    .collect(Collectors.toList()))
            .build()
}