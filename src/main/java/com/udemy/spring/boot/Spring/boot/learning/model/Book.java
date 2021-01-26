package com.udemy.spring.boot.Spring.boot.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private final int id;
    private final String name;
    private final String price;

    public Book(int id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}
