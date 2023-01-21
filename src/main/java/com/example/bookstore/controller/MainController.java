package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
