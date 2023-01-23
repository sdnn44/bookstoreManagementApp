package com.example.bookstore.entity;

import com.example.bookstore.model.Book;
import com.example.bookstore.model.Publisher;
import com.example.bookstore.model.Review;
import com.example.bookstore.model.Stock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class BookEntityTest {
    @Test
    void shouldReturnBookEntityByGivenBook() {
        Book book = new Book(1L, new Stock(1L, 12, true), new Publisher(1L, "publisherName", "publishDate", 111, "bookType", "bookLanguage"), "title", "author", new BigDecimal("15.00"), "category", "ISBN", "descr", List.of(new Review(1L, 1L, 3, "Not a big fan", "jonas@gmail.com", "jonte")));
        //when
        BookEntity bookEntity = BookEntity.fromBook(book);
        //then
//        Assertions.assertThat(bookEntity.getId()).isEqualTo(book.getId());
        Assertions.assertThat(bookEntity.getBookAuthor()).isEqualTo(book.getBookAuthor());
        Assertions.assertThat(bookEntity.getBookTitle()).isEqualTo(book.getBookTitle());
        Assertions.assertThat(bookEntity.getPrice()).isEqualTo(book.getPrice());
        Assertions.assertThat(bookEntity.getBookCategory()).isEqualTo(book.getBookCategory());
        Assertions.assertThat(bookEntity.getBookIsbn()).isEqualTo(book.getISBN());
        Assertions.assertThat(bookEntity.getBookDescription()).isEqualTo(book.getDescription());
        Assertions.assertThat(bookEntity.getReviews().size()).isEqualTo(book.getReviews().size());
    }
}
