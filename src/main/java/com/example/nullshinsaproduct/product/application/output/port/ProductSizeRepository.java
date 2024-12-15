package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;

import java.util.List;

public interface ProductSizeRepository {
    ProductSizeEntity save(ProductSizeEntity entity);

    void saveAll(List<ProductSizeEntity> entities);
}
