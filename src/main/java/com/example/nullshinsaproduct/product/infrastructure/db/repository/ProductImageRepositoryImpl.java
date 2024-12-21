package com.example.nullshinsaproduct.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.output.port.ProductImageRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductImageJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ProductImageRepositoryImpl implements ProductImageRepository {
    private final ProductImageJpaRepository productImageJpaRepository;


    @Override
    public ProductImageEntity save(ProductImageEntity entity) {
        if (Objects.isNull(entity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        return productImageJpaRepository.save(entity);
    }

    @Override
    public void saveAll(List<ProductImageEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        productImageJpaRepository.saveAll(entities);
    }
}
