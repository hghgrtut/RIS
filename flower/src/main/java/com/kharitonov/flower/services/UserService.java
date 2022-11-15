package com.kharitonov.flower.services;

import com.kharitonov.flower.dtos.UserDTO;
import com.kharitonov.flower.dtos.factories.UserDTOFactory;
import com.kharitonov.flower.entities.UserEntity;
import com.kharitonov.flower.exceptions.BadRequestException;
import com.kharitonov.flower.exceptions.NotFoundException;
import com.kharitonov.flower.repositories.UserRepository;
import lombok.NonNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserEntity> getByLogin(@NonNull String login) {
        return userRepository.findByLogin(login);
    }

    public UserDTO findById(Long id) {
        return new UserDTOFactory().toUserDTO(userRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public UserDTO save(Optional<UserEntity> userEntity) {
        if(userEntity.isEmpty()) {
            throw new BadRequestException("Object was not found.");
        }

        return new UserDTOFactory().toUserDTO(userRepository.save(userEntity.get()));
    }

    public UserDTO update(Optional<UserEntity> userEntityFromDB, Optional<UserEntity> userEntity) {
        if(userEntityFromDB.isEmpty() || userEntity.isEmpty()) {
            throw new BadRequestException("Object was not found.");
        }
        BeanUtils.copyProperties(userEntity.get(), userEntityFromDB.get(), "id");

        return new UserDTOFactory().toUserDTO(userRepository.save(userEntityFromDB.get()));
    }

    public void delete(Optional<UserEntity> userEntity) {
        if(userEntity.isEmpty()) {
            throw new BadRequestException(("Object was not found."));
        }
        userRepository.delete(userEntity.get());
    }
}