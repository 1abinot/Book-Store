package com.bookstore.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private Double price;

    public Book() {
    }

    public Book(String title, String author, Double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
