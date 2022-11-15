package com.kharitonov.flower.dtos;

import com.kharitonov.flower.entities.FlowerEntity;
import com.kharitonov.flower.entities.UserEntity;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDTO {

    @NonNull
    private Long id;
    @NonNull
    private List<FlowerDTO> flowers = new ArrayList<>();
}
