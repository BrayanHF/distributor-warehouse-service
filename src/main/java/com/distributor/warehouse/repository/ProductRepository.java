package com.distributor.warehouse.repository;

import com.distributor.warehouse.entity.Product;
import com.distributor.warehouse.entity.projection.ProductDetails;
import com.distributor.warehouse.entity.projection.ProductSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}