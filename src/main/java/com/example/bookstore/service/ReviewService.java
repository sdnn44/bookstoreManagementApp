package com.example.bookstore.service;

import com.example.bookstore.entity.ReviewEntity;
import com.example.bookstore.model.Review;
import com.example.bookstore.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(Review::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById((long) id)
                .map(Review::fromEntity);
    }

    public List<Review> getAllReviewsByBookId(Long bookId) {
        return reviewRepository.findAllByBookId(bookId)
                .stream()
                .map(Review::fromEntity)
                .collect(Collectors.toList());
    }

    public double calculateAverageBookRating(Long bookId) {
        List<Review> reviewsForBook = getAllReviewsByBookId(bookId);
        if (reviewsForBook.isEmpty())
            return 0d;

        double rating = reviewsForBook.stream().map(Review::getRating).reduce(0, Integer::sum);
        return rating / reviewsForBook.size();
    }

    public boolean addReview(Review review, int bookId) {
        review.setBookId((long) bookId);
        ReviewEntity reviewEntity = new ReviewEntity(review);
        reviewRepository.save(reviewEntity);
        return true;
    }
}
