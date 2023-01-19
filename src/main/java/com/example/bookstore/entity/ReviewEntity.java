package com.example.bookstore.entity;

import com.example.bookstore.model.Review;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reviews", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class ReviewEntity {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "review_book_id")
    private int bookReviewId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review_content")
    private String content;

    @Column(name = "review_email")
    private String email;

    @Column(name = "review_login")
    private String login;

    public ReviewEntity(int bookReviewId, Integer rating, String content, String email, String login) {
        this.bookReviewId = bookReviewId;
        this.rating = rating;
        this.content = content;
        this.email = email;
        this.login = login;
    }

    public static ReviewEntity fromReview(Review review) {
        return new ReviewEntity(review.getBookReviewId(), review.getRating(), review.getContent(), review.getEmail(), review.getLogin());
    }
}