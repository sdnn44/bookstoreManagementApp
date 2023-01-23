package com.example.bookstore.service;

import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

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

    public List<Book> getFavouriteBooksFor(String name) {
        Optional<UserEntity> user = userRepository.findByUsername(name);
        if (user.isPresent()) {
            List<Long> favouriteIds = getFavouriteIds(user.get().getId());
            return bookRepository.findAllById(favouriteIds).stream().map(Book::fromEntity).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public List<Long> getFavouriteIds(Long userId) {
        return bookRepository.findFavouritesFor(userId);
    }
}
