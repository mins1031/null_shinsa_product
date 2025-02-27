package com.example.nullshinsaproduct.brand.presentation;

import com.example.nullshinsaproduct.brand.apllication.BrandCommandService;
import com.example.nullshinsaproduct.common.dto.ResponseResult;
import com.example.nullshinsaproduct.product.application.input.dto.request.BrandSaveRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BrandController {
    private final BrandCommandService brandCommandService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/brands")
    public ResponseResult<Boolean> saveBrand(@Valid @RequestBody BrandSaveRequest request) {
        log.info("신규 브랜드 생성 req : {}", request);
        brandCommandService.saveBrand(request);
        return ResponseResult.success(HttpStatus.CREATED, true);
    }
}
