package com.example.bookstore.entity;

import com.example.bookstore.model.Review;
import com.example.bookstore.model.Stock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ReviewEntityTest {
    @Test
    void shouldReturnReviewEntityByGivenReview() {
        //given
        Review review = new Review(1L, 5, "Nice", "aaa@wp.pl", "aaa");
        //when
        ReviewEntity reviewEntity = ReviewEntity.fromReview(review);
        //then
//        Assertions.assertThat(stockEntity.getId()).isEqualTo(stock.getId());
        Assertions.assertThat(reviewEntity.getBookId()).isEqualTo(review.getBookId());
        Assertions.assertThat(reviewEntity.getContent()).isEqualTo(review.getContent());
        Assertions.assertThat(reviewEntity.getEmail()).isEqualTo(review.getEmail());
        Assertions.assertThat(reviewEntity.getLogin()).isEqualTo(review.getLogin());
        Assertions.assertThat(reviewEntity.getRating()).isEqualTo(review.getRating());
    }
}
