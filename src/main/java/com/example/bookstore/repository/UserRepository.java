package com.example.bookstore.repository;

import com.example.bookstore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "insert into FAVOURITE_BOOKS (user_id, book_id) values (:userId, :bookId)", nativeQuery = true)
    void addToFavourites(@Param("userId") Long userId, @Param("bookId") Long bookId);

    @Transactional
    @Modifying
    @Query(value = "delete from FAVOURITE_BOOKS where user_id = :userId and book_id = :bookId", nativeQuery = true)
    void removeFromFav(@Param("userId") Long userId, @Param("bookId") Long bookId);
}
