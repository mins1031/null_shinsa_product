package com.example.nullshinsaproduct.exception.product;

import com.example.nullshinsaproduct.exception.seller.SellerExceptionCode;
import lombok.Getter;

@Getter
public class ProductException extends RuntimeException {
    private final ProductExceptionCode productExceptionCode;

    public ProductException(ProductExceptionCode productExceptionCode) {
        this.productExceptionCode = productExceptionCode;
    }
}
