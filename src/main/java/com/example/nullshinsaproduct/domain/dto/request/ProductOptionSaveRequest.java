package com.example.nullshinsaproduct.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOptionSaveRequest {
    private String color;
    @NotBlank(message = "상품옵션중 사이즈는 필수값 입니다.")
    private String size;
    private String length;
    private String shoulder;
    private String chest;
    private String sleeve;
    private String waist;
    private String crotch;
    private String hip;
    private String thigh;
    private String hem;
    @NotBlank(message = "상품옵션중 재고정보는 필수값 입니다.")
    private int stock;

    public ProductOptionSaveRequest(
            String color,
            String size,
            String length,
            String shoulder,
            String chest,
            String sleeve,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem,
            int stock
    ) {
        this.color = color;
        this.size = size;
        this.length = length;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
        this.stock = stock;
    }
}
