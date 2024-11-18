package com.bookstore.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "myBooks")
public class MyBookList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    public MyBookList() {
    }

    public MyBookList(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
