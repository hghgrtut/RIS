package by.hghgrtut.shop.controllers

import by.hghgrtut.shop.contracts.ApiRouter
import by.hghgrtut.shop.model.BasketModel
import by.hghgrtut.shop.entities.BasketEntity
import by.hghgrtut.shop.entities.ItemEntity
import by.hghgrtut.shop.services.BasketService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ApiRouter.BasketItem.BASE_URL)
class BasketController @Autowired constructor(private val basketService: BasketService) {

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @GetMapping
    fun findAll(): ResponseEntity<List<BasketModel>> = getEntity(basketService.findAll())

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @GetMapping(ApiRouter.BasketItem.FIND_BY_ID)
    fun findById(@PathVariable("id") id: Long?): BasketModel = basketService.findById(id)

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @PostMapping
    fun create(@RequestBody basketEntity: BasketEntity?): ResponseEntity<BasketModel> =
            getEntity(basketService.save(basketEntity))

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @PutMapping(ApiRouter.BasketItem.UPDATE)
    fun update(@PathVariable("id") basketEntityFromDB: BasketEntity?, @RequestBody basketEntity: BasketEntity?) =
            getEntity(basketService.update(basketEntityFromDB, basketEntity))

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @PutMapping(ApiRouter.BasketItem.ADD_FLOWER)
    fun addItem(
            @PathVariable("toBasketId") basketEntity: BasketEntity?,
            @PathVariable("itemId") itemEntity: ItemEntity?
    ): ResponseEntity<BasketModel> = getEntity(basketService.addItem(basketEntity, itemEntity))

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @DeleteMapping(ApiRouter.BasketItem.DELETE_BY_ID)
    fun delete(@PathVariable("id") basketEntity: BasketEntity?) { basketService.delete(basketEntity) }
    
    private fun getEntity(basketModel: BasketModel) = ResponseEntity.ok(basketModel)
}