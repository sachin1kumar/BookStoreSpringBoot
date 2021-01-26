package com.udemy.spring.boot.Spring.boot.learning.controller;

import com.udemy.spring.boot.Spring.boot.learning.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController {

   /* @GetMapping("/books")
    public List<Book> getBooksList() {
        return Arrays.asList(new Book(3, "My journey", "167"));
    }

    @GetMapping(path = "/books/{id}")
    public Book getBookDetail(@PathVariable int id) {
        return new Book(id, "My book", "123");
    }*/

}
