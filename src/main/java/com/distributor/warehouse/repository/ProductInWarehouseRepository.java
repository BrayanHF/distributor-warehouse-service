package com.distributor.warehouse.repository;

import com.distributor.warehouse.entity.ProductInWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInWarehouseRepository extends JpaRepository<ProductInWarehouse, Long> {
}