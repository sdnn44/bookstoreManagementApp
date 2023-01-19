package com.example.bookstore.model;

import com.example.bookstore.entity.ReviewEntity;
import lombok.*;

import java.util.List;

//@RequiredArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Setter

public class Review {

    private int id;
    private int bookReviewId;
    private Integer rating;
    private String content;
    private String email;
    private String login;

    public Review(int bookReviewId) {
//        this.id = id;
        this.bookReviewId = bookReviewId;
    }

    public Review(int bookReviewId, Integer rating, String content, String email, String login) {
        this.bookReviewId = bookReviewId;
        this.rating = rating;
        this.content = content;
        this.email = email;
        this.login = login;
    }

    public static Review fromEntity(ReviewEntity reviewEntity) {
        return new Review(
//                reviewEntity.getId(),
                reviewEntity.getBookReviewId(),
                reviewEntity.getRating(),
                reviewEntity.getContent(),
                reviewEntity.getEmail(),
                reviewEntity.getLogin()
        );

    }
}
