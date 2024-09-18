package com.example.nullshinsaproduct.application.service.brand;

import com.example.nullshinsaproduct.domain.dto.request.BrandSaveRequest;
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
    public void saveBrand(BrandSaveRequest request) {

    }
}
