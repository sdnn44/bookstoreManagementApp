package com.example.bookstore.repository;

import com.example.bookstore.entity.PublisherEntity;
import com.example.bookstore.entity.ReviewEntity;
import com.example.bookstore.model.Publisher;
import com.example.bookstore.model.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class ReviewRepository {
    @PersistenceContext
    private final EntityManager entityManager;

    public List<Review> getAllReviews() {
        return entityManager.createQuery("SELECT reviewEntity FROM ReviewEntity reviewEntity", ReviewEntity.class)
                .getResultList()
                .stream()
                .map(Review::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Review> getReviewById(int id) {
        ReviewEntity reviewEntity = entityManager.find(ReviewEntity.class, id);
        if (reviewEntity == null)
            return Optional.empty();
        return Optional.of(Review.fromEntity(reviewEntity));
    }

    //    @SuppressWarnings("unchecked")
    public List<Review> getAllReviewsByBookName(String bookName) {
        return entityManager.createQuery("SELECT reviewEntity FROM ReviewEntity reviewEntity, BookEntity b WHERE b.id = reviewEntity.bookReviewId AND b.bookTitle IN :bookName", ReviewEntity.class)
                .setParameter("bookName", bookName).getResultList().stream().map(Review::fromEntity).collect(Collectors.toList());
    }

    @Transactional
    public void addReview(Review review) {
        entityManager.persist(ReviewEntity.fromReview(review));
    }

    @Transactional
    public boolean save(Review review) {
        ReviewEntity reviewEntity = new ReviewEntity(
                review.getBookReviewId(),
                review.getRating(),
                review.getContent(),
                review.getEmail(),
                review.getLogin()
        );
        try {
            entityManager.persist(reviewEntity);
            return true;
        } catch (PersistenceException e) {
            return false;
        }
    }
//    @Transactional
//    public boolean addReview(Review review) {
//        try{
//            entityManager.persist(ReviewEntity.fromReview(review));
//            return true;
//        } catch (PersistenceException e) {
//            System.out.println("blad");
//            return false;
//        }
//    }

}
