package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductSize {
    private final long id;
    private final long productId;
    private final String sizeName;
    private final ProductSizeType productSizeType;
    private final String totalLength;
    private final String shoulder; // 어깨너비
    private final String chest; // 가슴단면
    private final String sleeve; // 소매길이
    private final String waist; // 허리
    private final String crotch; // 밑위
    private final String hip; // 엉덩이 단면
    private final String thigh; // 허벅지 단면
    private final String hem; // 밑단
    private final String width; // 너비
    private final String height; // 높이
    private final String depth; // 폭(깊이)


    private ProductSize(
            long id,
            long productId,
            String sizeName,
            ProductSizeType productSizeType,
            String totalLength,
            String shoulder,
            String chest,
            String sleeve,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem,
            String width,
            String height,
            String depth
    ) {
        this.id = id;
        this.productId = productId;
        this.sizeName = sizeName;
        this.productSizeType = productSizeType;
        this.totalLength = totalLength;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // 정적 팩토리 메서드 여러개 craete
}
