package com.example.nullshinsaproduct.common.exception.product;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ProductExceptionCode {
    NOT_EXIST_PARAMETER(HttpStatus.INTERNAL_SERVER_ERROR, 0001, "메서드의 파라미터가 잘못되었습니다"),
    FAIL_MEMBER_REQUEST(HttpStatus.INTERNAL_SERVER_ERROR, 0002, "회원서버 API 호출이 실패했습니다"),
    FAIl_ORDER_REQUEST(HttpStatus.INTERNAL_SERVER_ERROR, 0003, "주문서버 API 호출이 실패했습니다"),

    NOT_EXIST_REQUEST_PARAMS(HttpStatus.BAD_REQUEST, 1000, "요청 파라미터가 없습니다. 요청데이터를 다시 확인해주세요."),
    NOT_EXIST_PRODUCT(HttpStatus.NOT_FOUND, 1001, "요청한 상품데이터가 없습니다. 상품데이터를 다시 확인해주세요."),
    NOT_EXIST_PRODUCT_OPTION(HttpStatus.NOT_FOUND, 1002, "요청한 상품옵션 데이터가 없습니다. 상품데이터를 다시 확인해주세요."),
    WRONG_MATCHED_PRODUCT_SIZE_TYPE(HttpStatus.INTERNAL_SERVER_ERROR, 1003, "상품사이즈 데이터의 정합성이 맞지 않습니다. 확인이 필요합니다."),
    NOT_YET_APPROVE(HttpStatus.INTERNAL_SERVER_ERROR, 1004, "상품이 아직 승인전 상태입니다."),


    NOT_EXIST_REVIEWER_ORDER(HttpStatus.INTERNAL_SERVER_ERROR, 1005, "리뷰어는 해당 상품을 주문하지 않았습니다. 확인이 필요합니다."),


    NOT_EXIST_REQUEST_BRAND(HttpStatus.INTERNAL_SERVER_ERROR, 2001, "존재하지 않는 브랜드 입니다. 요청 값을 다시 확인해 주세요"),
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
