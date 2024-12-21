package com.example.nullshinsaproduct.product.domain.enumeration;

import lombok.Getter;

@Getter
public enum ImageType {
    THUMBNAIL("섬네일 이미지"),
    PROFILE("프로필 이미지"),
    DETAIL("상세페이지 이미지"),

    ;

    private final String desc;

    ImageType(String desc) {
        this.desc = desc;
    }
}
