package com.example.bookstore.repository;

import com.example.bookstore.entity.PublisherEntity;
import com.example.bookstore.entity.StockEntity;
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

public class PublisherRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public List<Publisher> getAllPublishers() {
        return entityManager.createQuery("SELECT publisherEntity FROM PublisherEntity publisherEntity", PublisherEntity.class)
                .getResultList()
                .stream()
                .map(Publisher::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Publisher> getPublisherById(int id) {
        PublisherEntity publisherEntity = entityManager.find(PublisherEntity.class, id);
        if (publisherEntity == null)
            return Optional.empty();
        return Optional.of(Publisher.fromEntity(publisherEntity));
    }
}
