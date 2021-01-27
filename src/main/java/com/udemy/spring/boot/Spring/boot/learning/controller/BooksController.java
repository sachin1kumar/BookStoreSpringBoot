package com.udemy.spring.boot.Spring.boot.learning.controller;

import com.udemy.spring.boot.Spring.boot.learning.model.Book;
import com.udemy.spring.boot.Spring.boot.learning.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;

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

    @GetMapping("/books/{id}")
    public Book getBookDetail(@PathVariable BigInteger id) {
        Book book = bookRepository.getOne(id);
        try {
            book.getId();
        } catch (EntityNotFoundException e) {
            throw new BookNotFoundException("Book not found");
        }
        return book;
    }

    @GetMapping("/allBooks")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @DeleteMapping("/delete/books/{id}")
    public void deleteBook(@PathVariable BigInteger id) {
        try{
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new BookNotFoundException("Book not found");
        }
    }
}
