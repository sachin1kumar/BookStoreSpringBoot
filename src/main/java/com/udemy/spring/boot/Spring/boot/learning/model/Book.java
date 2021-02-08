package com.udemy.spring.boot.Spring.boot.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity(name = "book")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger book_id;
    @Size(min = 4)
    private String name;
    private String price;

    public Book() {

    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public BigInteger getId() {
        return book_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(BigInteger book_id) {
        this.book_id = book_id;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
