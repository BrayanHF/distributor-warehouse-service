package com.distributor.warehouse.entity.DTO;

import com.distributor.warehouse.entity.Measurement;
import com.distributor.warehouse.entity.ProductImage;

import java.util.List;

public record ProductDTO(long id, String name, double price, Measurement measurement, List<ProductImage> images) {}