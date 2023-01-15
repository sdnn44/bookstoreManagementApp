package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor

public class MainController {
    private final BookService bookService;

    @GetMapping
    public String getMainPage(Model model) {
        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("books", allBooks);

        return "main-page.html";
    }

    @GetMapping("/book-details")
    public String getBookDetailsPage(@RequestParam Integer bookId, Model model) {
        Book specificBook = bookService.getBookById(bookId).orElse(null);
        model.addAttribute("book", specificBook);

        return "book-details-page.html";
    }
}
