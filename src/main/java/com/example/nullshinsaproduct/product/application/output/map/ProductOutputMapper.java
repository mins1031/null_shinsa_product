package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductOutputMapper {
    ProductOutputMapper INSTANCE = Mappers.getMapper(ProductOutputMapper.class);

    ProductSaveVo toProductSaveVo(ProductSaveRequest requestDto);

    ProductEntity toProductEntity(Product product);

    Product toProductDomain(ProductEntity entity);

    List<SkuProduct> toSkuProducts(List<SkuProductRequest> requests, long parentProductId);

    SkuProduct toSkuProduct(SkuProductRequest requests, long parentProductId);

    //    default ProductEntity toProductEntity(Product product) {
//        ProductEntity.createDefault(
//                product.getName(),
//                product.getPrice(),
//                product.getProductBrandVo().getBrandId(),
//                product.getProductBrandVo().getBrandName(),
//                product.getProductBrandVo().getCorporateNumber(),
//                product.getProductBrandVo().getCommunicationSellingNumber(),
//                product.getProductBrandVo().getRepresentative(),
//                product.getProductBrandVo().getLocation(),
//                product.getDiscountDetail().getDiscountMinRate(),
//                product.getDiscountDetail().getDiscountMaxRate(),
//                product.(),
//                product.(),
//                product.getDiscountDetail().getDiscountApplyPossible(),
//                product.(),
//                product.(),
//                product.(),
//                product.(),
//                product.(),
//                product.()
//        );
//    }
}
