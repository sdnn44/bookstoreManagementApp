package com.example.bookstore.controller;

import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final BookService bookService;
    private final UserService userService;

    @GetMapping
    public String getMainPage(Model model, Principal principal) {
        List<Book> allBooks = bookService.getAllBooks();
        markFavourites(principal, allBooks);
        model.addAttribute("books", allBooks);

        return "main-page.html";
    }

    private void markFavourites(Principal principal, List<Book> books) {
        List<Long> favouriteIds = new ArrayList<>();

        if (principal != null) {
            Optional<UserEntity> user = userService.getUserByUsername(principal.getName());
            if (user.isPresent()) {
                favouriteIds = bookService.getFavouriteIds(user.get().getId());
            }
        }
        List<Long> finalFavouriteIds = favouriteIds;

        books.stream().filter(it -> finalFavouriteIds.contains(it.getId())).forEach(book -> book.setFavourite(true));
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
