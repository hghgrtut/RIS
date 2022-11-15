package com.kharitonov.flower.dtos.factories;

import com.kharitonov.flower.dtos.BasketDTO;
import com.kharitonov.flower.entities.BasketEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BasketDTOFactory {

    public BasketDTO toBasketDTO(BasketEntity basketEntity) {
        return BasketDTO.builder()
                .id(basketEntity.getId())
                .flowers(basketEntity.getFlowers()
                        .stream()
                        .map(flowerEntity -> new FlowerDTOFactory().toFlowerDTO(flowerEntity))
                        .collect(Collectors.toList()))
                .build();
    }
}
