package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.model.Book;
import com.bookstore.bookstore.model.MyBookList;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.MyBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class BookController {

    private final BookService bookService;
    private final MyBookService myBookService;

    public BookController(BookService bookService, MyBookService myBookService) {
        this.bookService = bookService;
        this.myBookService = myBookService;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/books")
    public String getBooksPage(Model model) {
        List<Book> books = this.bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book-register")
    public String getBookRegisterPage(Model model) {
        model.addAttribute("book", new Book());
        return "book-register";
    }

    @GetMapping("/available-books")
    public String getAvailableBooksPage(Model model) {
        return "available-books";
    }

    @PostMapping("/save")
    public String addBook(@RequestParam String title, @RequestParam String author, @RequestParam Double price) {
        Book book = new Book(title, author, price);
        this.bookService.save(book);
        return "redirect:/books";
    }

    @GetMapping("myBookList")
    public String getMyBookListPage(Model model) {
        List<MyBookList> myBooks = this.myBookService.findAll();
        model.addAttribute("myBooks", myBooks);
        return "my-books";
    }

    @GetMapping("/{id}/my-books")
    public String addBookPage(@PathVariable Long id, Model model) {
        Book book = this.bookService.findById(id);
        myBookService.saveBook(book);
        return "redirect:/myBookList";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable Long id) {
        this.bookService.deleteById(id);
         return "redirect:/books";
    }

    @GetMapping("{id}/edit")
    public String editBookPage(@PathVariable Long id, Model model) {
        Book book = this.bookService.findById(id);
        model.addAttribute("book", book);
        return "book-register";
    }

    @DeleteMapping("/{id}/deleteMyBook")
    public String deleteMyBook(@PathVariable Long id) {
        this.myBookService.deleteById(id);
        return "redirect:/myBookList";
    }

}
