package by.hghgrtut.shop.services

import by.hghgrtut.shop.model.BasketModel
import by.hghgrtut.shop.model.factories.BasketModelFactory
import by.hghgrtut.shop.entities.BasketEntity
import by.hghgrtut.shop.entities.ItemEntity
import by.hghgrtut.shop.exceptions.BadRequestException
import by.hghgrtut.shop.exceptions.NotFoundException
import by.hghgrtut.shop.repositories.BasketRepository
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.List
import java.util.Optional
import java.util.stream.Collectors

@Service
class BasketService @Autowired constructor(private val basketRepository: BasketRepository) {

    fun findAll(): List<BasketModel> = basketRepository.findAll()
                .stream()
                .map { basketEntity -> BasketModelFactory().toBasketModel(basketEntity) }
                .collect(Collectors.toList())

    fun findById(id: Long?): BasketModel =
            BasketModelFactory().toBasketModel(basketRepository.findById(id).orElseThrow { NotFoundException() })

    fun save(basketEntity: BasketEntity?): BasketModel =
            BasketModelFactory().toBasketModel(basketRepository.save(basketEntity!!))

    fun update(basketEntityFromDB: BasketEntity?, basketEntity: BasketEntity?): BasketModel {
        BeanUtils.copyProperties(basketEntity!!, basketEntityFromDB!!, "id")
        return BasketModelFactory().toBasketModel(basketRepository.save(basketEntity!!))
    }

    fun addItem(basketEntity: BasketEntity?, itemEntity: ItemEntity?): BasketModel {
        basketEntity!!.getItems().add(itemEntity!!)
        return BasketModelFactory().toBasketModel(basketRepository.save(basketEntity!!))
    }

    fun delete(basketEntity: BasketEntity?) = basketRepository.delete(basketEntity!!)
}