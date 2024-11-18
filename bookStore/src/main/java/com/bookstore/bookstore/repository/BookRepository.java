package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface BookRepository extends JpaRepository<Book, Long> {
}
