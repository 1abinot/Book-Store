package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(Long id);

    Book save(Book book);

    void deleteById(Long id);

}
