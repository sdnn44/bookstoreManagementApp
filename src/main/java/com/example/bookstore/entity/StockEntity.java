package com.example.bookstore.entity;


import com.example.bookstore.model.Book;
import com.example.bookstore.model.Stock;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "stocks", schema = "public")
@NoArgsConstructor
@Getter
public class StockEntity {
    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_available")
    private boolean isAvailable;

    public StockEntity(Integer quantity, boolean isAvailable) {
        this.quantity = quantity;
        this.isAvailable = isAvailable;
    }

    public static StockEntity fromStock(Stock stock) {
        return new StockEntity(stock.getQuantity(), stock.isAvailable());
    }
}
