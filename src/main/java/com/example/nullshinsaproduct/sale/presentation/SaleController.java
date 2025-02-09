package com.example.nullshinsaproduct.sale.presentation;

import com.example.nullshinsaproduct.common.dto.ResponseResult;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.sale.application.SaleService;
import com.example.nullshinsaproduct.sale.application.input.dto.request.SaleCommandRequest;
import com.example.nullshinsaproduct.sale.domain.SaleStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sales")
    public ResponseResult<Boolean> saveSale(@Valid @RequestBody SaleCommandRequest request) {
        log.info("할인 생성 req : {}", request);
        saleService.saveSale(request);
        return ResponseResult.success(HttpStatus.CREATED, true);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/sales/{id}")
    public ResponseResult<Boolean> updateSale(
            @NotNull @PathVariable(name = "id") Long id,
            @Valid @RequestBody SaleCommandRequest request
    ) {
        log.info("할인 수정 req : {}", request);
        saleService.updateSale(id, request);
        return ResponseResult.success(HttpStatus.OK, true);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/sales/{id}")
    public ResponseResult<Boolean> changeSaleStatus(
            @NotNull @PathVariable(name = "id") Long id,
            @Valid @RequestBody SaleStatus saleStatus
    ) {
        log.info("할인 상태 수정 req : {}", saleStatus);
        saleService.changeSaleStatus(id, saleStatus);
        return ResponseResult.success(HttpStatus.OK, true);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/sales/{id}")
    public ResponseResult<Boolean> removeSale(
            @NotNull @PathVariable(name = "id") Long id
    ) {
        log.info("할인 삭제 id : {}", id);
        saleService.removeSale(id);
        return ResponseResult.success(HttpStatus.OK, true);
    }
}
