package com.example.bookstore.service;

import com.example.bookstore.entity.ReviewEntity;
import com.example.bookstore.model.Review;
import com.example.bookstore.repository.ReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    @Mock
    ReviewRepository reviewRepository;

    @InjectMocks
    ReviewService reviewService;

    private final List<ReviewEntity> mockReviews = List.of(
            new ReviewEntity(1L, 5, "Wow", "mikkel@gmail.com", "whereisjessicahyde"),
            new ReviewEntity(2L, 4, "Nice", "tom@gmail.com", "tom"),
            new ReviewEntity(3L, 3, "Could be better", "thomas@gmail.com", "thomas"),
            new ReviewEntity(3L, 3, "OK", "kyle@gmail.com", "kyle")
    );

    @Test
    void shouldReturnAllReviews() {
        Mockito.when(reviewRepository.findAll()).thenReturn(mockReviews);

        //when
        List<Review> result = reviewService.getAllReviews();

        //then
        Assertions.assertThat(result.size()).isEqualTo(4);
        Assertions.assertThat(result.get(0).getBookId()).isEqualTo(1);
        Assertions.assertThat(result.get(1).getLogin()).isEqualTo("tom");
        Assertions.assertThat(result.get(2).getRating()).isEqualTo(3);
        Assertions.assertThat(result.get(3).getContent()).isEqualTo("OK");
    }

    @Test
    void shouldReturnReviewByGivenBookId() {
        Mockito.when(reviewRepository.findAllByBookId(3L)).thenReturn(mockReviews);

        //when
        List<Review> result = reviewService.getAllReviewsByBookId(3L);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.get(0).getRating()).isEqualTo(5);
        Assertions.assertThat(result.get(3).getLogin()).isEqualTo("kyle");
    }

    @Test
    void shouldReturnReviewByGivenId() {
        Mockito.when(reviewRepository.findById(1L)).thenReturn(Optional.ofNullable(mockReviews.get(1)));

        //when
        Review result = reviewService.getReviewById(1).orElse(null);

        //then
        Assertions.assertThat(result).isNotNull();
//        Assertions.assertThat(result.get().getRating()).isEqualTo(5);
//        Assertions.assertThat(result.get().getLogin()).isEqualTo("kyle");
    }
}
