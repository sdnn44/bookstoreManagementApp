package com.example.bookstore.repository;


import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "select distinct book_id from FAVOURITE_BOOKS where user_id = :userId", nativeQuery = true)
    List<Long> findFavouritesFor(@Param("userId") Long id);
}
