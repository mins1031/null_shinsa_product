package com.example.nullshinsaproduct.presentation.product;

import com.example.nullshinsaproduct.application.facade.ProductFacade;
import com.example.nullshinsaproduct.common.dto.ResponseResult;
import com.example.nullshinsaproduct.application.dto.request.ProductSaveRequest;
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
public class ProductCommandController {
    private final ProductFacade productFacade;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products")
    public ResponseResult<Boolean> saveProduct(@Valid @RequestBody ProductSaveRequest request) {
        log.info("상품 생성 req : {}", request);
        productFacade.applySaveProductByType(request);
        return ResponseResult.success(HttpStatus.CREATED, true);
    }
}
