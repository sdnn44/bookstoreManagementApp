package com.example.bookstore.controller;

import com.example.bookstore.model.Review;
import com.example.bookstore.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewRestController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewsById(@PathVariable int reviewId) {
        return reviewService.getReviewById(reviewId).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/book-details/reviews/{bookId}")
    public ResponseEntity<List<Review>> getAllReviewsByBookName(@PathVariable int bookId) {
        return new ResponseEntity<>(reviewService.getAllReviewsByBookId((long) bookId), HttpStatus.OK);
    }

    @PostMapping("/add-reviews/{bookId}")
    public String saveReview(Review review, @PathVariable int bookId) {
        return reviewService.addReview(review, bookId) ? "redirect:/book-details/" + bookId + "#review" : "main-page.html";
    }

}
