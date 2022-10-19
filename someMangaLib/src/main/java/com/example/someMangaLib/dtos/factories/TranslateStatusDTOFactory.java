package com.example.someMangaLib.dtos.factories;

import com.example.someMangaLib.dtos.TranslateStatusDTO;
import com.example.someMangaLib.entities.TranslateStatusEntity;

public class TranslateStatusDTOFactory {
    public TranslateStatusDTO toTranslateStatusDTO(TranslateStatusEntity translateStatus) {
        return TranslateStatusDTO.builder()
                .id(translateStatus.getId())
                .name(translateStatus.getName())
                .build();
    }
}
