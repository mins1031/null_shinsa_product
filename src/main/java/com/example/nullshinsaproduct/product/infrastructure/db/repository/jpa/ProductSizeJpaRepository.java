package com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSizeJpaRepository extends JpaRepository<ProductSizeEntity, Long> {

    List<ProductSizeEntity> findAllByProduct(Product product);
}
