package com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageJpaRepository extends JpaRepository<ProductImageEntity, Long> {
}
