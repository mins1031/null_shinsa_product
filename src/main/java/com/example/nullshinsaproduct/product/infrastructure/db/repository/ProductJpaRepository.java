package com.example.nullshinsaproduct.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
//    Optional<Product> findByIdAndProductType(long productId, ProductType productType);
}
