package com.example.nullshinsaproduct.common.exception.product;

import lombok.Getter;

@Getter
public class ProductException extends RuntimeException {
    private final ProductExceptionCode productExceptionCode;

    public ProductException(ProductExceptionCode productExceptionCode) {
        this.productExceptionCode = productExceptionCode;
    }
}
