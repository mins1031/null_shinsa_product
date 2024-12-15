package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;

import java.util.List;

public interface ProductImageRepository {
    ProductImageEntity save(ProductImageEntity entity);

    void saveAll(List<ProductImageEntity> entities);
}
