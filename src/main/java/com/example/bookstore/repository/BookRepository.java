package com.example.bookstore.repository;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor

public class BookRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public List<Book> getAllBooks() {
        return entityManager.createQuery("SELECT bookEntity FROM BookEntity bookEntity", BookEntity.class)
                .getResultList()
                .stream()
                .map(Book::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Book> getBookById(int id) {
        BookEntity bookEntity = entityManager.find(BookEntity.class, id);
        if (bookEntity == null)
            return Optional.empty();
        return Optional.of(Book.fromEntity(bookEntity));
    }
}
