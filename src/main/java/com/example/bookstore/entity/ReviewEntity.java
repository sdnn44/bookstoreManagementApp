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
public class ReviewEntity {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review_content")
    private String content;

    @Column(name = "review_email")
    private String email;

    @Column(name = "review_login")
    private String login;

    public ReviewEntity(Long bookId, Integer rating, String content, String email, String login) {
        this.bookId = bookId;
        this.rating = rating;
        this.content = content;
        this.email = email;
        this.login = login;
    }

    public ReviewEntity (Review review) {
        this.bookId = review.getBookId();
        this.rating = review.getRating();
        this.content = review.getContent();
        this.email = review.getEmail();
        this.login = review.getLogin();
    }
}