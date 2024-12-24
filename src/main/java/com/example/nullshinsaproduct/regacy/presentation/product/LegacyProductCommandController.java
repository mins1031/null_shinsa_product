package com.example.nullshinsaproduct.regacy.presentation.product;

import com.example.nullshinsaproduct.regacy.application.facade.ProductFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LegacyProductCommandController {
    private final ProductFacade productFacade;

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/products")
//    public ResponseResult<Boolean> saveProduct(@Valid @RequestBody ProductSaveRequest request) {
//        log.info("상품 생성 req : {}", request);
//        productFacade.applySaveProductByType(request);
//        return ResponseResult.success(HttpStatus.CREATED, true);
//    }
}
