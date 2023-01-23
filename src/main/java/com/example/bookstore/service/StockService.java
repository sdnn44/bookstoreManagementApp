package com.example.bookstore.service;

import com.example.bookstore.model.Stock;
import com.example.bookstore.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll()
                .stream()
                .map(Stock::fromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id)
                .map(Stock::fromEntity);
    }
}
