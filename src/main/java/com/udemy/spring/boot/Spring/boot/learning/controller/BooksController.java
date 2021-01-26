package com.udemy.spring.boot.Spring.boot.learning.controller;

import com.udemy.spring.boot.Spring.boot.learning.model.Book;
import com.udemy.spring.boot.Spring.boot.learning.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        //Return 201 with URL including id.
        URI bookPath = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{book_id}")
                .buildAndExpand(savedBook.getId()).toUri();
        return ResponseEntity.created(bookPath).build();
    }

}
