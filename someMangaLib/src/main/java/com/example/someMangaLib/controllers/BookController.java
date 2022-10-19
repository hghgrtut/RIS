package com.example.someMangaLib.controllers;

import com.example.someMangaLib.contracts.ApiRouter;
import com.example.someMangaLib.dtos.BookDTO;
import com.example.someMangaLib.entities.BookEntity;
import com.example.someMangaLib.servicies.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(ApiRouter.BookRouter.BASE_URL)
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getAll() {
        return bookService.findAll();
    }

    @GetMapping(ApiRouter.BookRouter.FIND_BY_ID)
    public BookDTO findById(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public BookDTO save(@RequestBody BookEntity bookEntity) {
        return bookService.save(bookEntity);
    }

    @PutMapping(ApiRouter.BookRouter.UPDATE)
    public BookDTO update(@PathVariable("id") BookEntity bookEntityFromDb,
                          @RequestBody BookEntity bookEntity) {
        BeanUtils.copyProperties(bookEntity, bookEntityFromDb, "id");
        return bookService.save(bookEntityFromDb);
    }

    @DeleteMapping(ApiRouter.BookRouter.DELETE)
    public void delete(@PathVariable("id") BookEntity bookEntity) {
        bookService.delete(bookEntity);
    }


}
