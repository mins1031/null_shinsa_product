package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;

import java.util.List;

public interface ProductDslRepository {

    void updateStatusById(Long id, ProductStatus productStatus);
    void updateStatusByIds(List<Long> ids, ProductStatus productStatus);
}
