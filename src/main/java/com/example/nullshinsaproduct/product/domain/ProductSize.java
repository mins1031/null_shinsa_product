package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
import lombok.Getter;


@Getter
public class ProductSize {
    private final Long id;
    private final long productId;
    private String sizeName;
    private ProductSizeType productSizeType;
    private String totalLength;
    private String shoulder; // 어깨너비
    private String chest; // 가슴단면
    private String sleeve; // 소매길이
    private String waist; // 허리
    private String crotch; // 밑위
    private String hip; // 엉덩이 단면
    private String thigh; // 허벅지 단면
    private String hem; // 밑단
    private String width; // 너비
    private String height; // 높이
    private String depth; // 폭(깊이)


    private ProductSize(
            Long id,
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
