package com.example.someMangaLib.dtos.factories;

import com.example.someMangaLib.dtos.TitleStatusDTO;
import com.example.someMangaLib.entities.TitleStatusEntity;

public class TitleStatusDTOFactory {
    public TitleStatusDTO toTitleStatusDTO(TitleStatusEntity titleStatus) {
        return TitleStatusDTO.builder()
                .id(titleStatus.getId())
                .name(titleStatus.getName())
                .build();
    }
}
