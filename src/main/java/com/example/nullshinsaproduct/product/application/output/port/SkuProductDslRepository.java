package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.dto.FindSkuWithProductDto;

import java.util.List;

public interface SkuProductDslRepository {

    void updateStatusById(Long id, SkuProductStatus skuProductStatus);
    void updateStatusByIds(List<Long> ids, SkuProductStatus skuProductStatus);

    FindSkuWithProductDto findProductAndSkuByIds(long productId, long skuId);
}
