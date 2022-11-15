package com.kharitonov.flower.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlowerDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String picture;
    @NonNull
    private Double price;
    @NonNull
    private String description;
}
