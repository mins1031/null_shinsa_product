package com.example.nullshinsaproduct.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.output.port.ProductSizeRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductSizeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductSizeRepositoryImpl implements ProductSizeRepository {
    private final ProductSizeJpaRepository productSizeJpaRepository;

    @Override
    public ProductSizeEntity save(ProductSizeEntity entity) {
        if (Objects.isNull(entity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        return productSizeJpaRepository.save(entity);
    }

    @Override
    public void saveAll(List<ProductSizeEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        productSizeJpaRepository.saveAll(entities);
    }
}
