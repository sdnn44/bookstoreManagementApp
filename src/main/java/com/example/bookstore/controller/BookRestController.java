package com.example.bookstore.controller;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    public String addToFavourites(@PathVariable int bookId, Principal principal) {
        Optional<UserEntity> user = userService.getUserByUsername(principal.getName());
        Optional<BookEntity> book = bookService.getBookEntityById((long) bookId);
        user.ifPresent(userEntity -> userService.ee(userEntity.getId(), bookId));
//        if (user.isPresent() && book.isPresent()) {
//            userService.addToFavourites(user.get(), book.get());
//        }
        return "main-page.html";
    }
}
