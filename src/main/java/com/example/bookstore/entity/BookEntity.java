package com.example.bookstore.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "books", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class BookEntity {

    @PersistenceContext
    private static EntityManager entityManager;

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id")
    private StockEntity stock;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_price")
    private float price;

    @Column(name = "book_category")
    private String bookCategory;

    @Column(name = "book_isbn")
    private BigInteger bookIsbn;

    @Column(name = "book_description")
    private String bookDescription;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "review_book_id")
    private List<ReviewEntity> reviews;

    public BookEntity(StockEntity stock, PublisherEntity publisher, String bookTitle, String bookAuthor, float price, String bookCategory, BigInteger bookIsbn, String bookDescription, List<ReviewEntity> reviews) {
        this.stock = stock;
        this.publisher = publisher;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.price = price;
        this.bookCategory = bookCategory;
        this.bookIsbn = bookIsbn;
        this.bookDescription = bookDescription;
        this.reviews = reviews;
    }
}
