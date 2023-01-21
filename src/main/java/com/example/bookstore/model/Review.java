package com.example.bookstore.model;

import com.example.bookstore.entity.ReviewEntity;
import lombok.*;

//@RequiredArgsConstructor
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Setter

public class Review {

    private Long id;
    private Long bookId;
    private Integer rating;
    private String content;
    private String email;
    private String login;

    public Review(Long bookId, Integer rating, String content, String email, String login) {
        this.bookId = bookId;
        this.rating = rating;
        this.content = content;
        this.email = email;
        this.login = login;
    }

    public static Review fromEntity(ReviewEntity reviewEntity) {
        return new Review(
//                reviewEntity.getId(),
                reviewEntity.getBookId(),
                reviewEntity.getRating(),
                reviewEntity.getContent(),
                reviewEntity.getEmail(),
                reviewEntity.getLogin()
        );
    }

    public ReviewEntity toEntity(Review review) {
        return new ReviewEntity(review);
    }
}
