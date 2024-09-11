package com.example.nullshinsaproduct.exception.product;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ProductExceptionCode {
    NOT_EXIST_REQUEST_PARAMS(HttpStatus.BAD_REQUEST, 1000, "요청 파라미터가 없습니다. 요청데이터를 다시 확인해주세요."),
    NOT_EXIST_PRODUCT(HttpStatus.NOT_FOUND, 1001, "요청한 상품데이터가 없습니다. 상품데이터를 다시 확인해주세요."),
    NOT_EXIST_PRODUCT_OPTION(HttpStatus.NOT_FOUND, 1002, "요청한 상품옵션 데이터가 없습니다. 상품데이터를 다시 확인해주세요."),
    NOT_EXIST_BRAND(HttpStatus.NOT_FOUND, 1003, "잘못된 브랜드정보 입니다. 다시 확인해주세요."),
    ;

    private final HttpStatus httpStatus;
    private final int errorCode;
    private final String errorMessage;

    ProductExceptionCode(HttpStatus httpStatus, int errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
