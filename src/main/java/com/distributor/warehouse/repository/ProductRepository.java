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

    @Query(value = "SELECT new com.distributor.warehouse.entity.projection.ProductSummary(p.id, p.name, p.price, MIN(pi.imagePath), p.status) FROM ProductImage pi INNER JOIN Product p ON p.id = pi.product.id GROUP BY p.id")
    List<ProductSummary> findAllProductsProjectedBy();

    @Query(value = "SELECT new com.distributor.warehouse.entity.projection.ProductDetails(p.id, p.name, p.description, p.price, p.measurement, pw.stock, p.status) FROM ProductInWarehouse pw INNER JOIN Product p ON p.id = pw.product.id WHERE p.id = :id")
    Optional<ProductDetails> findByIdProjectedBy(@Param("id") long id);

}