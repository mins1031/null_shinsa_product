package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

public class ProductOutputMapper {
//mapstruct 도입 해보기
    public static ProductEntity mapDomainToJpaEntity(Product product) {
        return ProductEntity.createBasicClothesProduct(
                product.getName(),
                product.getPrice(),

        )
    }
}
