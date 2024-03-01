package com.distributor.warehouse.entity;

import jakarta.persistence.*;
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
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre del almacén no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El nombre del almacén debe tener entre 3 y 50 caracteres.")
    @Column(length = 50)
    private String name;

    @NotBlank(message = "La dirección no puede estar vacía.")
    @Size(min = 8, max = 100, message = "La dirección debe tener entre 8 y 100 caracteres.")
    @Column(length = 100)
    private String address;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY)
    private List<ProductInWarehouse> productsInWarehouse;

    private Status status;

}