package com.example.bookstore.service;

import com.example.bookstore.entity.StockEntity;
import com.example.bookstore.model.Stock;
import com.example.bookstore.repository.StockRepository;
import com.example.bookstore.service.StockService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {
    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockService stockService;

    private final List<StockEntity> mockStocks = List.of(
            new StockEntity(31, true),
            new StockEntity(23, true),
            new StockEntity(1, true)
    );

    @Test
    void shouldReturnAllStocks() {
        Mockito.when(stockRepository.findAll()).thenReturn(mockStocks);

        //when
        List<Stock> result = stockService.getAllStocks();

        //then
        Assertions.assertThat(result.size()).isEqualTo(3);
        Assertions.assertThat(result.get(0).getQuantity()).isEqualTo(31);
    }

    @Test
    void shouldReturnStockByGivenStockId() {
        Mockito.when(stockRepository.findById(1L)).thenReturn(Optional.ofNullable(mockStocks.get(1)));

        //when
        Stock result = stockService.getStockById(1L).orElse(null);

        //then
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getQuantity()).isEqualTo(23);
        Assertions.assertThat(result.isAvailable()).isTrue();
    }
}
