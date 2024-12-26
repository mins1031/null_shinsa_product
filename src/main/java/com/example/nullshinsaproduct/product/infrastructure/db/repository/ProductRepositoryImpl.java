package com.example.nullshinsaproduct.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductJpaRepository productJpaRepository;

    @Override
    public ProductEntity save(ProductEntity entity) {
        return productJpaRepository.save(entity);
    }

    @Override
    public ProductEntity findById(long id) {
        Optional<ProductEntity> product = productJpaRepository.findById(id);

        return product.orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT));
    }

    @Override
    public List<ProductEntity> findByIds(List<Long> ids) {
        return productJpaRepository.findAllById(ids);
    }
}
