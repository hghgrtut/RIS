package com.example.someMangaLib.servicies;

import com.example.someMangaLib.dtos.BookDTO;
import com.example.someMangaLib.dtos.factories.BookDTOFactory;
import com.example.someMangaLib.entities.BookEntity;
import com.example.someMangaLib.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookEntity -> new BookDTOFactory()
                        .toBookDTO(bookEntity))
                .collect(Collectors.toList());
    }

    public BookDTO findById(Long id) {
        return new BookDTOFactory().toBookDTO(bookRepository.findById(id).get());
    }

    public BookDTO save(BookEntity bookEntity) {
        return  new BookDTOFactory().toBookDTO(bookRepository.save(bookEntity));
    }

    public void delete (BookEntity bookEntity) {
        bookRepository.delete(bookEntity);
    }


}
