package com.example.bookstore.service;

import com.example.bookstore.model.Review;
import com.example.bookstore.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.getReviewById(id);
    }

    public List<Review> getAllReviewsByBookName(String bookName) {
        return reviewRepository.getAllReviewsByBookName(bookName);
    }

    public double calculateAverageBookRating(String bookName) {
        List<Review> reviewsForBookName = getAllReviewsByBookName(bookName);
        if (reviewsForBookName.isEmpty())
            return 0d;

        double rating = reviewsForBookName.stream().map(Review::getRating).reduce(0, Integer::sum);
        return rating / reviewsForBookName.size();
    }

    public boolean addReview(Review review) {
        // validation
        return reviewRepository.save(review);
    }
//    public boolean addReview(int id, int bookId, Integer rating, String content, String email, String login) {
//        // validation
//        return reviewRepository.addReview(new Review(id, bookId, rating, content, email, login));
//    }
}
