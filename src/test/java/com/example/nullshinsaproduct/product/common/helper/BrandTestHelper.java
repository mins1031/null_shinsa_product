package com.example.nullshinsaproduct.product.common.helper;

import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;

public class BrandTestHelper {
    public static BrandEntity makeBrandEntity() {
        return BrandEntity.of(
                1L,
                "brand1",
                "한줄 소개",
                "1234",
                "031-111-2222",
                "representative",
                "성동구",
                "대표이미지",
                "인트로이미지"
        );
    }
}
