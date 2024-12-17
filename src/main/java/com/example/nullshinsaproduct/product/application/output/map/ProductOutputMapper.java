package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductOutputMapper {
    ProductOutputMapper INSTANCE = Mappers.getMapper(ProductOutputMapper.class);

    @Mapping(source = "categoryInfoRequest.firstLayerCategory", target = "firstLayerCategory")
    @Mapping(source = "categoryInfoRequest.secondLayerCategory", target = "secondLayerCategory")
    @Mapping(source = "categoryInfoRequest.thirdLayerCategory", target = "thirdLayerCategory")
    ProductSaveVo toProductSaveVo(ProductSaveRequest requestDto);


    @Mapping(source = "categoryVo.firstLayerCategory", target = "firstLayerCategory")
    @Mapping(source = "categoryVo.secondLayerCategory", target = "secondLayerCategory")
    @Mapping(source = "categoryVo.thirdLayerCategory", target = "thirdLayerCategory")
    @Mapping(source = "discountDetail.discountApplyPossible", target = "discountApplyPossible")
    @Mapping(source = "discountDetail.discountMinRate", target = "discountMinRate")
    @Mapping(source = "discountDetail.discountMaxRate", target = "discountMaxRate")
    @Mapping(source = "productDeliveryVo.outboundPossibleDay", target = "outboundPossibleDay")
    @Mapping(source = "productDeliveryVo.deliveryFee", target = "deliveryFee")
    ProductEntity toProductEntity(Product domain);

}
