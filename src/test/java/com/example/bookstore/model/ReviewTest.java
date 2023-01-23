package com.example.bookstore.model;

import com.example.bookstore.entity.ReviewEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReviewTest {
    @Test
    void shouldCreateReviewByGivenReviewEntity() {
        //given
        ReviewEntity reviewEntity = new ReviewEntity(1L, 4, "Nice", "johny@gmail.com", "john13");
        //when
        Review review = Review.fromEntity(reviewEntity);
        //then
        Assertions.assertThat(review.getId()).isEqualTo(reviewEntity.getId());
        Assertions.assertThat(review.getRating()).isEqualTo(4);
        Assertions.assertThat(review.getContent()).isEqualTo("Nice");
        Assertions.assertThat(review.getEmail()).isEqualTo("johny@gmail.com");
        Assertions.assertThat(review.getLogin()).isEqualTo("john13");
    }
}
