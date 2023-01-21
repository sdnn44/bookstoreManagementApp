package com.example.bookstore.service;

import com.example.bookstore.entity.UserEntity;
import com.example.bookstore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

//    public void addToFavourites(UserEntity user, BookEntity book) {
//        user.getFavouriteBooks().add(book);
//    }

    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void ee(Long userId, int bookId) {
        userRepository.addToFavourites(userId, (long) bookId);
    }
}
