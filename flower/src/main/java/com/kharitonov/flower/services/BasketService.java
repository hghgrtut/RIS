package com.kharitonov.flower.services;

import com.kharitonov.flower.dtos.BasketDTO;
import com.kharitonov.flower.dtos.factories.BasketDTOFactory;
import com.kharitonov.flower.entities.BasketEntity;
import com.kharitonov.flower.entities.FlowerEntity;
import com.kharitonov.flower.exceptions.BadRequestException;
import com.kharitonov.flower.exceptions.NotFoundException;
import com.kharitonov.flower.repositories.BasketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public List<BasketDTO> findAll() {
        return basketRepository.findAll()
                .stream()
                .map(basketEntity -> new BasketDTOFactory().toBasketDTO(basketEntity))
                .collect(Collectors.toList());
    }

    public BasketDTO findById(Long id) {
        return new BasketDTOFactory().toBasketDTO(basketRepository.findById(id).orElseThrow(NotFoundException::new));
    }

    public BasketDTO save(Optional<BasketEntity> basketEntity) {
        if (basketEntity.isEmpty()) {
            throw new BadRequestException("Object was not found");
        }

        return new BasketDTOFactory().toBasketDTO(basketRepository.save(basketEntity.get()));
    }

    public BasketDTO update(Optional<BasketEntity> basketEntityFromDB, Optional<BasketEntity> basketEntity) {
        if(basketEntityFromDB.isEmpty() || basketEntity.isEmpty()) {
            throw new BadRequestException("Object was not found");
        }

        BeanUtils.copyProperties(basketEntity.get(), basketEntityFromDB.get(), "id");
        return new BasketDTOFactory().toBasketDTO(basketRepository.save(basketEntity.get()));
    }

    public BasketDTO addFlower(Optional<BasketEntity> basketEntity, Optional<FlowerEntity> flowerEntity) {
        if(basketEntity.isEmpty() || flowerEntity.isEmpty()) {
            throw new BadRequestException("Object was not found");
        }

        BasketEntity basket = basketEntity.get();
        basket.getFlowers().add(flowerEntity.get());

        return new BasketDTOFactory().toBasketDTO(basketRepository.save(basket));
    }

    public void delete(Optional<BasketEntity> basketEntity) {
        if(basketEntity.isEmpty()) {
            throw new BadRequestException("Object was not found");
        }

        basketRepository.delete(basketEntity.get());
    }
}
