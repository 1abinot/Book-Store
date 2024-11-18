package com.bookstore.bookstore.repository;

import com.bookstore.bookstore.model.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Long> {
}
