package com.example.nullshinsaproduct.sale.infrastructure.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.sale.application.output.port.SaleRepository;
import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class SaleRepositoryImpl implements SaleRepository {
    private final SaleJpaRepository saleJpaRepository;

    @Override
    public SaleEntity save(SaleEntity entity) {
        if (Objects.isNull(entity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PARAMETER);
        }

        return saleJpaRepository.save(entity);
    }

    @Override
    public SaleEntity findById(long id) {
        return saleJpaRepository.findById(id).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_SALE));
    }

    @Override
    public void deleteById(long id) {
        saleJpaRepository.deleteById(id);
    }
}
