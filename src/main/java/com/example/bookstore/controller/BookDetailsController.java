package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Review;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor

@RequestMapping()
public class BookDetailsController {

    private final BookService bookService;
    private final ReviewService reviewService;

    @GetMapping("/book-details/{bookId}")
    public String getBookDetailsPage(@PathVariable int bookId, Model model) {
        Book specificBook = bookService.getBookById((long) bookId).orElse(null);
        if (Objects.isNull(specificBook)) {
            return "error.html";
        }
        List<Review> allReviewsForSpecificBook = reviewService.getAllReviewsByBookId(specificBook.getId());
        double averageRating = reviewService.calculateAverageBookRating(specificBook.getId());
        model.addAttribute("book", specificBook);
        model.addAttribute("reviews", allReviewsForSpecificBook);
        model.addAttribute("rating", averageRating);
        model.addAttribute("review", new Review());

        return "book-details-page.html";
    }
}
