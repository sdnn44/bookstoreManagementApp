package com.example.bookstore.model;

import com.example.bookstore.entity.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

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
                bookEntity.getBookDescription()
        );
    }
}
