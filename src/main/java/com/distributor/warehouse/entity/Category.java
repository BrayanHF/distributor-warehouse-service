package com.distributor.warehouse.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El nombre de la categoría no puede estar vacío.")
    @Size(min = 3, max = 50, message = "El nombre de la catagoría debe tener entre 3 y 50 caracteres.")
    @Column(length = 50)
    private String name;

}