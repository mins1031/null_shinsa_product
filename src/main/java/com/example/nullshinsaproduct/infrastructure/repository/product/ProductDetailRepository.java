package com.example.nullshinsaproduct.infrastructure.repository.product;

import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
