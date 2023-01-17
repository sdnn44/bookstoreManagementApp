package com.example.bookstore.model;

import com.example.bookstore.entity.ReviewEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class Review {

    private final int id;
    private final int bookReviewId;
    private final Integer rating;
    private final String content;
    private final String email;
    private final String login;

    public static Review fromEntity(ReviewEntity reviewEntity) {
        return new Review(
                reviewEntity.getId(),
                reviewEntity.getBookReviewId(),
                reviewEntity.getRating(),
                reviewEntity.getContent(),
                reviewEntity.getEmail(),
                reviewEntity.getLogin()
        );

    }
}
