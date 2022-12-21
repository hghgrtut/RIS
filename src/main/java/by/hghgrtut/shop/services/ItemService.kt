package by.hghgrtut.shop.services

import by.hghgrtut.shop.model.ItemModel
import by.hghgrtut.shop.model.factories.ItemModelFactory
import by.hghgrtut.shop.entities.ItemEntity
import by.hghgrtut.shop.exceptions.BadRequestException
import by.hghgrtut.shop.exceptions.NotFoundException
import by.hghgrtut.shop.repositories.ItemRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.List
import java.util.Optional
import java.util.stream.Collectors

@Service
class ItemService @Autowired constructor(private val itemRepository: ItemRepository) {

    fun findAll(): List<ItemModel> =
            itemRepository.findAll().stream().map { ItemModelFactory().toItemModel(it) }.collect(Collectors.toList())

    fun findById(id: Long?): ItemModel =
            ItemModelFactory().toItemModel(itemRepository.findById(id).orElseThrow { NotFoundException() })

    fun save(itemEntity: ItemEntity?): ItemModel = ItemModelFactory().toItemModel(itemRepository.save(itemEntity!!))

    fun update(itemEntityFromDB: ItemEntity?, itemEntity: ItemEntity?): ItemModel {
        BeanUtils.copyProperties(itemEntity!!, itemEntityFromDB!!, "id")
        return ItemModelFactory().toItemModel(itemRepository.save(itemEntityFromDB!!))
    }

    fun delete(itemEntity: ItemEntity?) = itemRepository.delete(itemEntity!!)
}