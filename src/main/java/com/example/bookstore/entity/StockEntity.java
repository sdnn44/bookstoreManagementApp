package com.example.bookstore.entity;


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
}
