package com.example.nullshinsaproduct.infrastructure.repository.product;

import com.example.nullshinsaproduct.domain.product.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
