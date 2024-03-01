package com.distributor.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El nombre del producto debe tener entre 3 y 50 caracteres.")
    @Column(length = 50)
    private String name;

    @NotBlank(message = "La descripción del producto no puede estar vacía.")
    @Size(min = 10, message = "La descripción del producto debe tener más de 10 caracteres.")
    @Column(columnDefinition = "TEXT")
    private String description;

    @Min(value = 50, message = "El precio del producto no puede ser menor a $50 pesos.")
    private double price;

    private Measurement measurement;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Category> category;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductInWarehouse> productInWarehouses;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductImage> images;

    private Status status;

}