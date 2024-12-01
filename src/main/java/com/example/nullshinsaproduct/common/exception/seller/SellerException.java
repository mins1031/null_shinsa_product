package com.example.nullshinsaproduct.common.exception.seller;

import lombok.Getter;

@Getter
public class SellerException extends RuntimeException {
    private final SellerExceptionCode sellerExceptionCode;

    public SellerException(SellerExceptionCode sellerExceptionCode) {
        this.sellerExceptionCode = sellerExceptionCode;
    }
}
