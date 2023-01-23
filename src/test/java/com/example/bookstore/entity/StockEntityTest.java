package com.example.bookstore.entity;

import com.example.bookstore.model.Stock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StockEntityTest {
    @Test
    void shouldReturnStockEntityByGivenStock() {
        //given
        Stock stock = new Stock(1L, 12, true);
        //when
        StockEntity stockEntity = StockEntity.fromStock(stock);
        //then
//        Assertions.assertThat(stockEntity.getId()).isEqualTo(stock.getId());
        Assertions.assertThat(stockEntity.getQuantity()).isEqualTo(stock.getQuantity());
        Assertions.assertThat(stockEntity.isAvailable()).isEqualTo(stock.isAvailable());
    }
}
