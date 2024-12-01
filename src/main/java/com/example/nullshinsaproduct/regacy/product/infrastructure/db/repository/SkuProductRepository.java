package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.SkuProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuProductRepository extends JpaRepository<SkuProduct, Long> {
}
