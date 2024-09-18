package com.example.nullshinsaproduct.infrastructure.repository;

import com.example.nullshinsaproduct.domain.product.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {
}
