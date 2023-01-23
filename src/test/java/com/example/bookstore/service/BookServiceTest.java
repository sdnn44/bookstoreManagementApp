package com.example.bookstore.service;//package com.example.bookstore.service;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.entity.PublisherEntity;
import com.example.bookstore.entity.ReviewEntity;
import com.example.bookstore.entity.StockEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Publisher;
import com.example.bookstore.model.Review;
import com.example.bookstore.model.Stock;
import com.example.bookstore.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    private final List<BookEntity> mockBooks = List.of(
            new BookEntity(
                    new StockEntity(10, true),
                    new PublisherEntity("John Murray Publishers", "January 01, 2018", 345, "Paperback", "English"),
                    "London Rules",
                    "Mick Herron",
                    new BigDecimal("20.0"),
                    "Thriller",
                    "9781399803083",
                    "London Rules might not be written",
                    List.of(new ReviewEntity(1L, 3, "Not a big fan", "jonas@gmail.com", "jonte"))),
            new BookEntity(
                    new StockEntity(10, true),
                    new PublisherEntity("John Murray Publishers", "January 01, 2018", 345, "Paperback", "English"),
                    "Animal Farm",
                    "George Orwell",
                    new BigDecimal("15.00"),
                    "Science-Fiction",
                    "9781784876609", "George Orwell’s fable of revolutionary farm animals",
                    List.of(new ReviewEntity(2L, 3, "Wow", "mikkel@gmail.com", "whereisjessicahyde")))
    );

    @Test
    void shouldCallFindAllInRepository() {
        given(bookRepository.findAll().stream().map(Book::fromEntity).collect(Collectors.toList())).willReturn(new ArrayList<>());

        //when
        List<Book> result = bookService.getAllBooks();

        //then
        then(bookRepository).should().findAll();
        assertThat(result).isNotNull();
    }

    @Test
    void shouldReturnAllBooks() {
        Mockito.when(bookRepository.findAll()).thenReturn(mockBooks);

        //when
        List<Book> result = bookService.getAllBooks();

        //then
        Assertions.assertThat(result.size()).isEqualTo(2);
        Assertions.assertThat(result.get(1).getBookAuthor()).isEqualTo("George Orwell");
        Assertions.assertThat(result.get(0).getReviews().size()).isEqualTo(1);
        Assertions.assertThat(result.get(0).getBookTitle()).isEqualTo("London Rules");
        Assertions.assertThat(result.get(0).getBookAuthor()).isEqualTo("Mick Herron");
        Assertions.assertThat(result.get(1).getReviews().size()).isEqualTo(1);

    }

    @Test
    void shouldReturnSpecificBookByGivenId() {
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.ofNullable(mockBooks.get(1)));

        //when
        Book result = bookService.getBookById(1L).orElse(null);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getBookAuthor()).isEqualTo("George Orwell");
        Assertions.assertThat(result.getPrice()).isEqualTo(new BigDecimal("15.00"));
        Assertions.assertThat(result.getBookTitle()).isEqualTo("Animal Farm");
    }

    @Test
    void shouldReturnBookEntityByGivenId() {
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.ofNullable(mockBooks.get(1)));

        //when
        BookEntity result = bookService.getBookEntityById(1L).orElse(null);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getBookIsbn()).isEqualTo("9781784876609");

    }
}
