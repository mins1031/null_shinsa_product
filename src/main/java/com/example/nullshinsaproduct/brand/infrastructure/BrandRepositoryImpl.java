package com.example.nullshinsaproduct.brand.infrastructure;

import com.example.nullshinsaproduct.brand.apllication.output.port.BrandRepository;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryImpl implements BrandRepository {
    private final BrandJpaRepository brandJpaRepository;

    @Override
    public BrandEntity save(BrandEntity brandEntity) {
        if (Objects.isNull(brandEntity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        return brandJpaRepository.save(brandEntity);
    }

    @Override
    public BrandEntity findById(long id) {
        return brandJpaRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_BRAND));
    }
}
