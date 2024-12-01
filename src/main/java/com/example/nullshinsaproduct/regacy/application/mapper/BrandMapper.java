package com.example.nullshinsaproduct.regacy.application.mapper;

import com.example.nullshinsaproduct.regacy.application.dto.response.BrandResponse;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Brand;

import java.util.Objects;

public class BrandMapper {
    public static BrandResponse mapEntityToRes(final Brand brand) {
        if (Objects.isNull(brand)) {
            return null;
        }

        return new BrandResponse(
                brand.getId(),
                brand.getBrandName(),
                brand.getOneLineIntroduce(),
                brand.getCorporateNumber(),
                brand.getCommunicationSellingNumber(),
                brand.getRepresentative(),
                brand.getLocation(),
                brand.getTitleImageUrl(),
                brand.getIntroImageUrl()
        );
    }
}
