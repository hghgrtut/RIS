package com.example.someMangaLib.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TitleStatusDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
}
