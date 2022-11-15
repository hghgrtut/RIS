package com.kharitonov.flower.dtos.factories;

import com.kharitonov.flower.dtos.UserDTO;
import com.kharitonov.flower.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDTOFactory {

    public UserDTO toUserDTO(UserEntity userEntity) {
        return UserDTO.builder()
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .password(userEntity.getPassword())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .role(userEntity.getRole().toString())
                .basket(new BasketDTOFactory().toBasketDTO(userEntity.getBasket()))
                .build();
    }
}
