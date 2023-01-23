package com.example.bookstore.service;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(Book::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id).map(Book::fromEntity);
    }

    public Optional<BookEntity> getBookEntityById(Long id) {
        return bookRepository.findById(id);
    }
}
