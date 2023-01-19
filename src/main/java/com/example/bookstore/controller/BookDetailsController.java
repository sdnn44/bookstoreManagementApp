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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor

@RequestMapping()
public class BookDetailsController {

    private final BookService bookService;
    private final ReviewService reviewService;

    @GetMapping("/book-details")
    public String getBookDetailsPage(@RequestParam int bookId, Model model) {
        Book specificBook = bookService.getBookById(bookId).orElse(null);
        List<Review> allReviewsForSpecificBook = reviewService.getAllReviewsByBookName(specificBook.getBookTitle());
        int reviewId = allReviewsForSpecificBook.size()+1;
        double averageRating = reviewService.calculateAverageBookRating(specificBook.getBookTitle());
//        allReviewsForSpecificBook.add(new Review(reviewId));
        model.addAttribute("book", specificBook);
        model.addAttribute("reviews", allReviewsForSpecificBook);
        model.addAttribute("rating", averageRating);
        model.addAttribute("review", new Review());

        return "book-details-page.html";
    }

    @PostMapping("/add-reviews")
    public String saveReview(Review review) {
        int bookindex = review.getBookReviewId();
        return reviewService.addReview(review)?"redirect:/book-details?bookId="+bookindex+"#review":"main-page.html";
    }
}
