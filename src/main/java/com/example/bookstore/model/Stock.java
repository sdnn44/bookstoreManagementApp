package com.example.bookstore.model;


import com.example.bookstore.entity.StockEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private Long id;
    private Integer quantity;
    private boolean isAvailable;

    public static Stock fromEntity(StockEntity stockEntity) {
        return new Stock(
                stockEntity.getId(),
                stockEntity.getQuantity(),
                stockEntity.isAvailable());
    }
}
