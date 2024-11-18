package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.MyBookList;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.repository.MyBookRepository;
import com.bookstore.bookstore.service.MyBookService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MyBookServiceImpl implements MyBookService {
    private final BookRepository bookRepository;
    private final MyBookRepository myBookRepository;

    public MyBookServiceImpl(BookRepository bookRepository, MyBookRepository myBookRepository) {
        this.bookRepository = bookRepository;
        this.myBookRepository = myBookRepository;
    }

    @Override
    public MyBookList saveBook(Book book) {
        MyBookList myBookList = new MyBookList();
        myBookList.setTitle(book.getTitle());
        myBookList.setAuthor(book.getAuthor());
        return this.myBookRepository.save(myBookList);
    }

    @Override
    public List<MyBookList> findAll() {
        return this.myBookRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        this.myBookRepository.deleteById(id);
    }

    @DeleteMapping("{id}/myBookDelete")
    public void deleteMyBook(@PathVariable Long id) {
        this.myBookRepository.deleteById(id);
    }
}
