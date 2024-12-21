package com.example.nullshinsaproduct.brand.apllication;

import com.example.nullshinsaproduct.brand.infrastructure.BrandJpaRepository;
import com.example.nullshinsaproduct.product.application.dto.request.BrandSaveRequest;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandCommandService {
    private final BrandJpaRepository brandJpaRepository;

    @Transactional
    public void saveBrand(BrandSaveRequest req) {
        // 원래는 사업자번호 검증하는 작업도 필요하지만 일단 스킵(중요한거 아님)
        BrandEntity brandEntity = BrandEntity.of(
                null,
                req.brandName(),
                req.oneLineIntroduce(),
                req.corporateNumber(),
                req.communicationSellingNumber(),
                req.representative(),
                req.location(),
                req.titleImageUrl(),
                req.introImageUrl()
        );

        brandJpaRepository.save(brandEntity);
    }
}
