package com.example.bookstore.entity;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Stock;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "books", schema = "public")
@NoArgsConstructor
@Getter
public class BookEntity {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private BigDecimal price;

    @Column(name = "book_category")
    private String bookCategory;

    @Column(name = "book_isbn")
    private String bookIsbn;

    @Column(name = "book_description")
    private String bookDescription;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private List<ReviewEntity> reviews;

    public BookEntity(StockEntity stock, PublisherEntity publisher, String bookTitle, String bookAuthor, BigDecimal price, String bookCategory, String bookIsbn, String bookDescription, List<ReviewEntity> reviews) {
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

    public static BookEntity fromBook(Book book) {
        return new BookEntity(StockEntity.fromStock(book.getStock()), PublisherEntity.fromPublisher(book.getPublisher()), book.getBookTitle(), book.getBookAuthor(), book.getPrice(), book.getBookCategory(), book.getISBN(), book.getDescription(), book.getReviews().stream().map(ReviewEntity::fromReview).collect(Collectors.toList()));
    }
}
