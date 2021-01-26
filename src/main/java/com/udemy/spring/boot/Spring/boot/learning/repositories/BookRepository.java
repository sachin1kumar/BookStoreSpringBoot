package com.udemy.spring.boot.Spring.boot.learning.repositories;

import com.udemy.spring.boot.Spring.boot.learning.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigInteger;

@Repository
public interface BookRepository extends JpaRepository<Book, BigInteger> {
}
