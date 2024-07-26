package com.example.nullshinsaproduct.common.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseResult<T> {
    private HttpStatus statusCode;
    private String message;
    private T result;

    private ResponseResult(HttpStatus statusCode, String message, T result) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }

    public static <Void> ResponseResult<Void> empty(HttpStatus code) {
        return new ResponseResult<Void>(code, null, null);
    }


    public static <Void> ResponseResult<Void> error(HttpStatus code, String message) {
        return new ResponseResult<>(code, message, null);
    }

    public static <T> ResponseResult<T> success(HttpStatus statusCode, T result) {
        return new ResponseResult<T>(statusCode, null, result);
    }
}
