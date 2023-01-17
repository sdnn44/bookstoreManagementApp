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
}
