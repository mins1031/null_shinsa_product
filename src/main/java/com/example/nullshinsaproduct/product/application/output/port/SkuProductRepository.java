package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;

import java.util.List;

public interface SkuProductRepository {
    SkuProductEntity save(SkuProductEntity entity);

    void saveAll(List<SkuProductEntity> entities);


}
