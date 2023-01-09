package com.example.bookstore.service;

import com.example.bookstore.model.Stock;
import com.example.bookstore.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.getAllStocks();
    }

    public Optional<Stock> getStockById(int id) {
        return stockRepository.getStockById(id);
    }
}
