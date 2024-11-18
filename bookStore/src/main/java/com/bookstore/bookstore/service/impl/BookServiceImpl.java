package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.exceptions.BookNotFound;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(()->new BookNotFound(id));
    }

    @Override
    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }


}
