package by.hghgrtut.shop.controllers

import by.hghgrtut.shop.contracts.ApiRouter
import by.hghgrtut.shop.model.ItemModel
import by.hghgrtut.shop.entities.ItemEntity
import by.hghgrtut.shop.services.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ApiRouter.ItemRouter.BASE_URL)
class ItemController @Autowired constructor(private val itemService: ItemService) {

    @GetMapping
    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    val all: ResponseEntity<List<ItemModel>> get() = getEntity(itemService.findAll())

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @GetMapping(ApiRouter.ItemRouter.FIND_BY_ID)
    fun findById(@PathVariable("id") id: Long?): ResponseEntity<ItemModel> =
            getEntity(itemService.findById(id))

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @PostMapping
    fun create(@RequestBody itemEntity: ItemEntity?): ResponseEntity<ItemModel> =
            getEntity(itemService.save(itemEntity))

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @PutMapping(ApiRouter.ItemRouter.UPDATE)
    fun update(@PathVariable("id") itemEntityFromDB: ItemEntity?, @RequestBody itemEntity: ItemEntity?) =
            getEntity(itemService.update(itemEntityFromDB, itemEntity))

    @PreAuthorize(PREAUTHORIZE_AUTHORITY)
    @DeleteMapping(ApiRouter.ItemRouter.DELETE_BY_ID)
    fun delete(@PathVariable("id") itemEntity: ItemEntity?) { itemService.delete(itemEntity) }

    private fun getEntity(itemModel: ItemModel) = ResponseEntity.ok(itemModel)
}