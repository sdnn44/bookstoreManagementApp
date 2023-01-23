package com.example.bookstore.controller;

import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookService bookService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
        return bookService.getBookById((long) bookId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{bookId}/addToFav")
    public RedirectView addToFavourites(@PathVariable int bookId, Principal principal) {
        Optional<UserEntity> user = userService.getUserByUsername(principal.getName());
        user.ifPresent(userEntity -> userService.addToFavourites(userEntity.getId(), bookId));
        return new RedirectView("/");
    }

    @GetMapping("/{bookId}/removeFromFav")
    public RedirectView removeFromFav(@PathVariable int bookId, Principal principal) {
        Optional<UserEntity> user = userService.getUserByUsername(principal.getName());
        user.ifPresent(userEntity -> userService.removeFromFavourites(userEntity.getId(), bookId));
        return new RedirectView("/");
    }

    @GetMapping("/favourites")
    public String getFavouriteBooks(Model model, Principal principal) {
        List<Book> favouriteBooks = new ArrayList<>();
        if (principal != null) {
            favouriteBooks = bookService.getFavouriteBooksFor(principal.getName());
        }
        model.addAttribute("favourites", favouriteBooks);
        model.addAttribute("emptyBooks", favouriteBooks.isEmpty());

        return "favourites.html";
    }
}
