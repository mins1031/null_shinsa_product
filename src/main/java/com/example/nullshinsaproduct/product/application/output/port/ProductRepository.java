package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

public interface ProductRepository {
    ProductEntity save(ProductEntity entity);
}
