package com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuProductJpaRepository extends JpaRepository<SkuProductEntity, Long> {
}
