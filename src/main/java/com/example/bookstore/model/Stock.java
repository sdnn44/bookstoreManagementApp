package com.example.bookstore.model;


import com.example.bookstore.entity.StockEntity;
import lombok.*;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class Stock {

    private final int id;
    private final Integer quantity;
    private final boolean isAvailable;

    public static Stock fromEntity(StockEntity stockEntity) {
        return new Stock(
                stockEntity.getId(),
                stockEntity.getQuantity(),
                stockEntity.isAvailable());
    }
}
