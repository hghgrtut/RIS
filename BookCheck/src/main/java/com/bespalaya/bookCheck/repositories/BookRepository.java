package com.bespalaya.bookCheck.repositories;

import com.bespalaya.bookCheck.entities.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private int COUNT;
    private List<BookEntity> bookEntities = new ArrayList<>();

    public List<BookEntity> findAll() {
        return bookEntities;
    }

    public BookEntity findById(int id) {
        return bookEntities.stream()
                .filter(bookEntity -> bookEntity.getId() == id)
                .findFirst()
                .get();
    }

    public BookEntity save(BookEntity bookEntity) {
        if(bookEntity != null) {
            bookEntity.setId(++COUNT);
            bookEntities.add(bookEntity);
            return bookEntity;
        } else {
            throw  new NullPointerException();
        }
    }

    public BookEntity update(int id, BookEntity bookEntity) {
        BookEntity bookEntityFormDB = findById(id);
        bookEntity.setId(bookEntityFormDB.getId());
        bookEntities.remove(bookEntityFormDB);
        bookEntities.add(bookEntity);
        return bookEntity;
    }

    public void delete(BookEntity bookEntity) {
        bookEntities.remove(bookEntity);
    }
}
