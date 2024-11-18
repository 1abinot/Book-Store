package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.MyBookList;

import java.util.List;

public interface MyBookService {
    MyBookList saveBook(Book book);
    List<MyBookList> findAll();

    void deleteById(Long id);
}
