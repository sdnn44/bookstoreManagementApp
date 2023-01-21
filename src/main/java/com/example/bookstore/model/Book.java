package com.example.bookstore.model;

import com.example.bookstore.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
