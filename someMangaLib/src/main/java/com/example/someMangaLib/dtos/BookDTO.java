package com.example.someMangaLib.dtos;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {
    @NonNull
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String author;
    @NonNull
    private int countPages;
    @NonNull
    private TitleStatusDTO titleStatusDTO;
    @NonNull
    private TranslateStatusDTO translateStatusDTO;

}
