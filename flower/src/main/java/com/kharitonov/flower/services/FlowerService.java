package com.kharitonov.flower.services;

import com.kharitonov.flower.dtos.FlowerDTO;
import com.kharitonov.flower.dtos.factories.FlowerDTOFactory;
import com.kharitonov.flower.entities.FlowerEntity;
import com.kharitonov.flower.exceptions.BadRequestException;
import com.kharitonov.flower.exceptions.NotFoundException;
import com.kharitonov.flower.repositories.FlowerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlowerService {

    private final FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    public List<FlowerDTO> findAll() {
        return flowerRepository.findAll()
                .stream()
                .map(flowerEntity -> new FlowerDTOFactory().toFlowerDTO(flowerEntity))
                .collect(Collectors.toList());
    }

    public FlowerDTO findById(Long id) {
        return new FlowerDTOFactory().toFlowerDTO(flowerRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public FlowerDTO save(Optional<FlowerEntity> flowerEntity) {
        if(flowerEntity.isEmpty()) {
            throw new BadRequestException("Object was not found");
        }

        return new FlowerDTOFactory().toFlowerDTO(flowerRepository.save(flowerEntity.get()));
    }

    public FlowerDTO update(Optional<FlowerEntity> flowerEntityFromDB, Optional<FlowerEntity> flowerEntity) {
        if(flowerEntityFromDB.isEmpty() || flowerEntity.isEmpty()) {
            throw new BadRequestException("Object was not found.");
        }

        BeanUtils.copyProperties(flowerEntity.get(), flowerEntityFromDB.get(), "id");
        return new FlowerDTOFactory().toFlowerDTO(flowerRepository.save(flowerEntityFromDB.get()));
    }

    public void delete(Optional<FlowerEntity> flowerEntity) {
        if(flowerEntity.isEmpty()) {
            throw new BadRequestException("Object was not found");
        }
        flowerRepository.delete(flowerEntity.get());
    }


}
