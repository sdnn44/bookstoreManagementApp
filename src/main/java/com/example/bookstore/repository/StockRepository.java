package com.example.bookstore.repository;

import com.example.bookstore.entity.StockEntity;
import com.example.bookstore.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor

public class StockRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    public List<Stock> getAllStocks() {
        return entityManager.createQuery("SELECT stockEntity FROM StockEntity stockEntity", StockEntity.class)
                .getResultList()
                .stream()
                .map(Stock::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Stock> getStockById(int id) {
        StockEntity stockEntity = entityManager.find(StockEntity.class, id);
        if(stockEntity == null)
            return Optional.empty();
        return Optional.of(Stock.fromEntity(stockEntity));
    }
}
