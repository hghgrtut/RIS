package com.bespalaya.bookCheck.services;

import com.bespalaya.bookCheck.entities.BookEntity;
import com.bespalaya.bookCheck.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    public BookEntity findById(int id) {
        return bookRepository.findById(id);
    }

    public BookEntity save(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public BookEntity update(int id, BookEntity bookEntity) {
        return bookRepository.update(id, bookEntity);
    }

    public void delete(BookEntity bookEntity) {
        bookRepository.delete(bookEntity);
    }
 }
