package com.example.bookstore.repository;


import com.example.bookstore.entity.BookEntity;
import com.example.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
//    @Query(value = "SELECT * FROM Book")
//    List<Book> books();
//    Optional<Book> findBookById(Long id);
}