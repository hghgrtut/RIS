package by.hghgrtut.shop.model.factories

import by.hghgrtut.shop.model.ItemModel
import by.hghgrtut.shop.entities.ItemEntity
import org.springframework.stereotype.Component

@Component
class ItemModelFactory {

    fun toItemModel(itemEntity: ItemEntity): ItemModel = ItemModel.builder()
            .id(itemEntity.getId())
            .name(itemEntity.getName())
            .picture(itemEntity.getPicture())
            .description(itemEntity.getDescription())
            .price(itemEntity.getPrice())
            .build()
}