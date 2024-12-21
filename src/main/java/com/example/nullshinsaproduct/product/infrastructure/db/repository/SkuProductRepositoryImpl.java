package com.example.nullshinsaproduct.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.SkuProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class SkuProductRepositoryImpl implements SkuProductRepository {
    private final SkuProductJpaRepository skuProductJpaRepository;

    @Override
    public SkuProductEntity save(SkuProductEntity entity) {
        if (Objects.isNull(entity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        return skuProductJpaRepository.save(entity);
    }

    @Override
    public void saveAll(List<SkuProductEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        skuProductJpaRepository.saveAll(entities);
    }
}
