package by.hghgrtut.shop.controllers

import by.hghgrtut.shop.contracts.ApiRouter
import by.hghgrtut.shop.model.UserModel
import by.hghgrtut.shop.entities.UserEntity
import by.hghgrtut.shop.security.Role
import by.hghgrtut.shop.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ApiRouter.UserRouter.BASE_URL)
class UserController @Autowired constructor(private val userService: UserService) {

    @GetMapping(ApiRouter.UserRouter.FIND_BY_ID)
    fun getById(@PathVariable id: Long?): ResponseEntity<UserModel> = getEntity(userService.findById(id))

    @PostMapping
    fun create(@RequestBody userEntity: UserEntity?): ResponseEntity<UserModel> = getEntity(userService.save(userEntity))

    @PutMapping(ApiRouter.UserRouter.UPDATE)
    fun update(@PathVariable("id") userEntityFromDb: UserEntity?, @RequestBody userEntity: UserEntity?) = getEntity(
            userService.update(userEntityFromDb, userEntity)
    )

    @DeleteMapping(ApiRouter.UserRouter.DELETE_BY_ID)
    fun delete(@PathVariable("id") userEntity: UserEntity?>?) { userService.delete(userEntity) }

    private fun getEntity(userModel: UserModel) = ResponseEntity.ok(userModel)
}