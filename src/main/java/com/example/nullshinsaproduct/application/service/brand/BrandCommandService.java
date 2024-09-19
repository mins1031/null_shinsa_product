package com.example.nullshinsaproduct.application.service.brand;

import com.example.nullshinsaproduct.domain.dto.request.BrandSaveRequest;
import com.example.nullshinsaproduct.domain.product.entity.Brand;
import com.example.nullshinsaproduct.infrastructure.repository.BrandRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BrandCommandService {
    private final BrandRepository brandRepository;

    @Transactional
    public void saveBrand(BrandSaveRequest req) {
        // 원래는 사업자번호 검증하는 작업도 필요하지만 일단 스킵(중요한거 아님)
        Brand brand = Brand.builder()
                .brandName(req.brandName())
                .corporateNumber(req.corporateNumber())
                .communicationSellingNumber(req.communicationSellingNumber())
                .representative(req.representative())
                .location(req.location())
                .build();

        brandRepository.save(brand);
    }
}
