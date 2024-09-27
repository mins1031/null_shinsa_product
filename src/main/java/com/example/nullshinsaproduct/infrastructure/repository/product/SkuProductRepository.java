package com.example.nullshinsaproduct.infrastructure.repository.product;

import com.example.nullshinsaproduct.domain.product.entity.SkuProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuProductRepository extends JpaRepository<SkuProduct, Long> {
}