package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    Optional<Product> findByIdAndProductType(long productId, ProductType productType);
}
