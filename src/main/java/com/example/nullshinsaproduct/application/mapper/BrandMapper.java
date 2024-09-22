package com.example.nullshinsaproduct.application.mapper;

import com.example.nullshinsaproduct.application.dto.response.BrandResponse;
import com.example.nullshinsaproduct.application.dto.response.CategoryResponse;
import com.example.nullshinsaproduct.domain.product.entity.Brand;
import com.example.nullshinsaproduct.infrastructure.repository.vo.CategoryVo;

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
