package com.example.nullshinsaproduct.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


//    @Mapping(target = "productId", source = "product.id")
//    @Mapping(target = "fabric", source = "product.productDetailInfo.fabric")
//    @Mapping(target = "manufacturingCountry", source = "product.productDetailInfo.manufacturingCountry")
//    @Mapping(target = "washCaution", source = "product.productDetailInfo.washCaution")
//    @Mapping(target = "manufacturingDate", source = "product.productDetailInfo.manufacturingDate")
//    @Mapping(target = "qualityGuarantee", source = "product.productDetailInfo.qualityGuarantee")
//    @Mapping(target = "productOptionResponseList", source = "productOptions")
//    ProductResponse toResponseDto(Product product, List<ProductClothesOption> productClothesOptions);
//
//    @IterableMapping(qualifiedByName = "toProductOptionResponse")
//    ProductOptionResponse toProductOptionResponse(ProductClothesOption productClothesOption);
}
