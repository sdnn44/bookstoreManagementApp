package com.example.bookstore.model;

import com.example.bookstore.entity.BookEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;
    private Stock stock;
    private Publisher publisher;
    private String bookTitle;
    private String bookAuthor;
    private BigDecimal price;
    private String bookCategory;
    private String ISBN;
    private String description;
    private List<Review> reviews;
    @Setter
    private boolean favourite;

    public Book(Long id, Stock stock, Publisher publisher, String bookTitle, String bookAuthor, BigDecimal price, String bookCategory, String ISBN, String description, List<Review> reviews) {
        this.id = id;
        this.stock = stock;
        this.publisher = publisher;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.price = price;
        this.bookCategory = bookCategory;
        this.ISBN = ISBN;
        this.description = description;
        this.reviews = reviews;
    }

    public static Book fromEntity(BookEntity bookEntity) {
        return new Book(
                bookEntity.getId(),
                Stock.fromEntity(bookEntity.getStock()),
                Publisher.fromEntity(bookEntity.getPublisher()),
                bookEntity.getBookTitle(),
                bookEntity.getBookAuthor(),
                bookEntity.getPrice(),
                bookEntity.getBookCategory(),
                bookEntity.getBookIsbn(),
                bookEntity.getBookDescription(),
                bookEntity.getReviews().stream().map(Review::fromEntity).collect(Collectors.toList())
        );
    }
}
