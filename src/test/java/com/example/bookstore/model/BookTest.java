package com.example.bookstore.model;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.entity.PublisherEntity;
import com.example.bookstore.entity.ReviewEntity;
import com.example.bookstore.entity.StockEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookTest {
    @Test
    void shouldCreateBookByGivenBookEntity() {
        BookEntity bookEntity = new BookEntity(
                new StockEntity(10, true),
                new PublisherEntity("John Murray Publishers", "January 01, 2018", 345, "Paperback", "English"),
                "London Rules",
                "Mick Herron",
                new BigDecimal("20.0"),
                "Thriller",
                "9781399803083",
                "London Rules might not be written",
                List.of(new ReviewEntity(1L, 3, "Not a big fan", "jonas@gmail.com", "jonte"))
        );
        //when
        Book book = Book.fromEntity(bookEntity);
        //then
        Assertions.assertThat(book.getId()).isEqualTo(bookEntity.getId());
        Assertions.assertThat(book.getBookTitle()).isEqualTo(bookEntity.getBookTitle());
        Assertions.assertThat(book.getBookAuthor()).isEqualTo(bookEntity.getBookAuthor());
        Assertions.assertThat(book.getStock().getId()).isEqualTo(bookEntity.getStock().getId());
        Assertions.assertThat(book.getStock().getQuantity()).isEqualTo(bookEntity.getStock().getQuantity());
        Assertions.assertThat(book.getReviews().size()).isEqualTo(1);
        Assertions.assertThat(book.getReviews().get(0).getContent()).isEqualTo(bookEntity.getReviews().get(0).getContent());
        Assertions.assertThat(book.getReviews().get(0).getBookId()).isEqualTo(bookEntity.getReviews().get(0).getBookId());


    }
}
