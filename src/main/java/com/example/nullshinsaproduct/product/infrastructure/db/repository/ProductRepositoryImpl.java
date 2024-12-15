package com.example.nullshinsaproduct.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return productJpaRepository.save(productEntity);
    }
}
