package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
