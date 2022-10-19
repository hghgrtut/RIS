package com.example.someMangaLib.dtos.factories;

import com.example.someMangaLib.dtos.BookDTO;
import com.example.someMangaLib.entities.BookEntity;


public class BookDTOFactory {
    public BookDTO toBookDTO(BookEntity bookEntity) {
        return BookDTO.builder()
                .id(bookEntity.getId())
                .name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .countPages(bookEntity.getCountPages())
                .translateStatusDTO(new TranslateStatusDTOFactory().toTranslateStatusDTO(bookEntity.getTranslateStatusEntity()))
                .titleStatusDTO(new TitleStatusDTOFactory().toTitleStatusDTO(bookEntity.getTitleStatusEntity()))
                .build();
    }
}
