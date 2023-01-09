package com.example.bookstore.model;

import com.example.bookstore.entity.BookEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigInteger;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class Book {
    private final int id;
    private final Stock stock;
    private final Publisher publisher;
    private final String bookTitle;
    private final String bookAuthor;
    private final float price;
    private final String bookCategory;
    private final BigInteger ISBN;
    private final String description;


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
