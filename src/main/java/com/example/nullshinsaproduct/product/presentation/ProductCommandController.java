package com.example.nullshinsaproduct.product.presentation;

import com.example.nullshinsaproduct.common.dto.ResponseResult;
import com.example.nullshinsaproduct.product.application.facade.ProductCommandFacade;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductStatusUpdateRequest;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductStatusUpdateResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductStatusUpdateResponseList;
import com.example.nullshinsaproduct.product.application.service.ProductCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductCommandController {
    private final ProductCommandFacade productCommandFacade;
    private final ProductCommandService productCommandService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products")
    public ResponseResult<Boolean> saveProduct(@Valid @RequestBody ProductSaveRequest request) {
        log.info("상품 생성 req : {}", request);
        productCommandFacade.saveProduct(request);
        return ResponseResult.success(HttpStatus.CREATED, true);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/products")
    public ResponseResult<ProductStatusUpdateResponseList> updateApproveStatus(@Valid @RequestBody ProductStatusUpdateRequest request) {
        log.info("승인처리 상품 ids : {}", request.updateTargetIds());
        ProductStatusUpdateResponseList res = productCommandService.updateApproveStatus(request.updateTargetIds());
        return ResponseResult.success(HttpStatus.OK, res);
    }

}
