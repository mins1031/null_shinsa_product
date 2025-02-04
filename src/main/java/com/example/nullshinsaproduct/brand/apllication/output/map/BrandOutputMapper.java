package com.example.nullshinsaproduct.brand.apllication.output.map;

import com.example.nullshinsaproduct.brand.domain.Brand;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.brand.apllication.dto.BrandResponse;

import java.util.Objects;

public class BrandOutputMapper {
//    public static BrandResponse mapEntityToRes(final BrandEntity brandEntity) {
//        if (Objects.isNull(brandEntity)) {
//            return null;
//        }
//
//        return new BrandResponse(
//                brandEntity.getId(),
//                brandEntity.getBrandName(),
//                brandEntity.getOneLineIntroduce(),
//                brandEntity.getCorporateNumber(),
//                brandEntity.getCommunicationSellingNumber(),
//                brandEntity.getRepresentative(),
//                brandEntity.getLocation(),
//                brandEntity.getTitleImageUrl(),
//                brandEntity.getIntroImageUrl()
//        );
//    }

    public static Brand toDomainFromEntity(final BrandEntity brandEntity) {
        return Brand.of(
                brandEntity.getId(),
                brandEntity.getBrandName(),
                brandEntity.getOneLineIntroduce(),
                brandEntity.getCorporateNumber(),
                brandEntity.getCommunicationSellingNumber(),
                brandEntity.getRepresentative(),
                brandEntity.getLocation(),
                brandEntity.getTitleImageUrl(),
                brandEntity.getIntroImageUrl()
        );
    }
}
