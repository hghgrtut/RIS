package com.bespalaya.bookCheck.controllers;

import com.bespalaya.bookCheck.entities.BookEntity;
import com.bespalaya.bookCheck.services.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final ObjectMapper objectMapper;

    @Autowired
    public BookController(BookService bookService, ObjectMapper objectMapper) {
        this.bookService = bookService;
        this.objectMapper = objectMapper;
    }


    @GetMapping
    public String getAllBooks() throws JsonProcessingException {
        return objectMapper.writeValueAsString(bookService.findAll());
    }

    @GetMapping("/{id}")
    public String findBookById(@PathVariable("id") int id) throws JsonProcessingException {
        return objectMapper.writeValueAsString(bookService.findById(id));
    }

    @PostMapping
    public String saveBook(@RequestBody Map<String, String> bodyParams) throws JsonProcessingException {
        BookEntity bookEntity = new BookEntity(bodyParams.get("name"),
                bodyParams.get("author"),
                Integer.parseInt(bodyParams.get("countPages")));
        return objectMapper.writeValueAsString(bookService.save(bookEntity));
    }

    @PostMapping("/{id}")
    public String updateBook(@PathVariable("id") int id, @RequestBody Map<String, String> bodyParams) throws JsonProcessingException {
        BookEntity bookEntity = new BookEntity(bodyParams.get("name"),
                bodyParams.get("author"),
                Integer.parseInt(bodyParams.get("countPages")));
        return objectMapper.writeValueAsString(bookService.update(id,bookEntity));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") int id) {
        bookService.delete(bookService.findById(id));
    }
}
