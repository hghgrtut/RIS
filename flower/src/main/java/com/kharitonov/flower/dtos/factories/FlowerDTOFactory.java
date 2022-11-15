package com.kharitonov.flower.dtos.factories;

import com.kharitonov.flower.dtos.FlowerDTO;
import com.kharitonov.flower.entities.FlowerEntity;
import org.springframework.stereotype.Component;

@Component
public class FlowerDTOFactory {

    public FlowerDTO toFlowerDTO(FlowerEntity flowerEntity) {
        return FlowerDTO.builder()
                .id(flowerEntity.getId())
                .name(flowerEntity.getName())
                .picture(flowerEntity.getPicture())
                .description(flowerEntity.getDescription())
                .price(flowerEntity.getPrice())
                .build();
    }
}
