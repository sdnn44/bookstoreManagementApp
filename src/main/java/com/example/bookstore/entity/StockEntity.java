package com.example.bookstore.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "stocks", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

public class StockEntity {
    @Id
    @Column(name = "stock_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "is_available")
    private boolean isAvailable;

    public StockEntity(Integer quantity, boolean isAvailable) {
        this.quantity = quantity;
        this.isAvailable = isAvailable;
    }
}
