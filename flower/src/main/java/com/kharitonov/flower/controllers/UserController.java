package com.kharitonov.flower.controllers;

import com.kharitonov.flower.contracts.ApiRouter;
import com.kharitonov.flower.dtos.UserDTO;
import com.kharitonov.flower.entities.UserEntity;
import com.kharitonov.flower.security.Role;
import com.kharitonov.flower.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(ApiRouter.UserRouter.BASE_URL)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(ApiRouter.UserRouter.FIND_BY_ID)
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO userDTO = userService.findById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody Optional<UserEntity> userEntity) {
        userEntity.get().setRole(Role.USER);
        UserDTO userDTO = userService.save(userEntity);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping(ApiRouter.UserRouter.UPDATE)
    public ResponseEntity<UserDTO> update(@PathVariable("id") Optional<UserEntity> userEntityFromDb,
                           @RequestBody Optional<UserEntity> userEntity) {
        UserDTO userDTO = userService.update(userEntityFromDb, userEntity);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping(ApiRouter.UserRouter.DELETE_BY_ID)
    public void delete(@PathVariable("id") Optional<UserEntity> userEntity) {
        userService.delete(userEntity);
    }
}
