package com.udemy.spring.boot.Spring.boot.learning.controller;

import com.udemy.spring.boot.Spring.boot.learning.model.Book;
import com.udemy.spring.boot.Spring.boot.learning.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody @Valid Book book) {
        Book savedBook = bookRepository.save(book);
        //Return 201 with URL including id.
        URI bookPath = ServletUriComponentsBuilder.
                fromCurrentRequest()
                .path("/{book_id}")
                .buildAndExpand(savedBook.getId()).toUri();
        return ResponseEntity.created(bookPath).build();
    }

    @GetMapping("/books/{id}")
    public EntityModel<Book> getBookDetail(@PathVariable BigInteger id) {
        Book book = bookRepository.getOne(id);
        EntityModel<Book> resource = null;
        try {
            book.getId();

            //HATEOAS handling..
            resource = EntityModel.of(book);
            WebMvcLinkBuilder linkTo =
                    linkTo(methodOn(this.getClass()).getAllBooks());
            resource.add(linkTo.withRel("all-books"));
        } catch (EntityNotFoundException e) {
            throw new BookNotFoundException("Book not found");
        }
        return resource;
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

    @GetMapping("/hello-world/internationalised")
    public String getHelloMessage(@RequestHeader(name = "Accept-language"
            , required = false) Locale locale) {
        return messageSource.getMessage("greeting-message", null, locale);
    }
}
