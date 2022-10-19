package com.example.someMangaLib.repositories;

import com.example.someMangaLib.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
