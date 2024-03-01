package com.distributor.warehouse.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductInWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Product product;

    private double stock;

    private Status status;

}