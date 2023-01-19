package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Review;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/login-page")
    public String getLoginPage(Model model) {

        return "login-page.html";
    }
}
