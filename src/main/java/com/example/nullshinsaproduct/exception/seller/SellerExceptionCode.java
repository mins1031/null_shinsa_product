package com.example.nullshinsaproduct.exception.seller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SellerExceptionCode {
    NOT_EXIST_SELLER(HttpStatus.NOT_FOUND, 1001, "요청한 셀러는 가입되지 않은 셀러입니다. 다시 확인해주세요."),
    ;

    private final HttpStatus httpStatus;
    private final int errorCode;
    private final String errorMessage;

    SellerExceptionCode(HttpStatus httpStatus, int errorCode, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
