package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    ProductEntity save(ProductEntity entity);

    ProductEntity findById(long id);

    List<ProductEntity> findByIds(List<Long> ids);
}
