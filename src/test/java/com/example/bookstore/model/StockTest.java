package com.example.bookstore.model;

import com.example.bookstore.entity.StockEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class StockTest {
    @Test
    void shouldCreateStockByGivenStockEntity() {
        //given
        StockEntity stockEntity = new StockEntity(12, true);
        //when
        Stock stock = Stock.fromEntity(stockEntity);
        //then
        Assertions.assertThat(stock.getId()).isEqualTo(stockEntity.getId());
        Assertions.assertThat(stock.getQuantity()).isEqualTo(12);
        Assertions.assertThat(stock.isAvailable()).isEqualTo(true);
    }
}
