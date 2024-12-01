package com.example.nullshinsaproduct.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuProductJpaRepository extends JpaRepository<SkuProductEntity, Long> {
}
