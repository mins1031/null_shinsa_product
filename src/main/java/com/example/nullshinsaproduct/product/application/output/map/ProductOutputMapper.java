package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.mapstruct.IterableMapping;
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

    ProductEntity toProductEntity(Product domain);
    Product toProductDomain(ProductEntity entity);

    @Named("toSkuProduct")
    @Mapping(target = "parentProductId", source = "parentProductId")
    SkuProduct toSkuProduct(SkuProductRequest request, long parentProductId);

    default List<SkuProduct> toSkuProducts(List<SkuProductRequest> requests, long parentProductId) {
        return requests.stream()
                .map(req -> toSkuProduct(req, parentProductId))
                .toList();
    }

//    @Named("toSkuProductEntity")
//    SkuProductEntity toSkuProductEntity(SkuProduct domain);
//    @IterableMapping(qualifiedByName = "toSkuProductEntity")
//    List<SkuProductEntity> toSkuProductEntities(List<SkuProduct> domains);
//
//    @Named("toProductSize")
//    ProductSize toProductSize(ProductSizeRequest request, long parentProductId);
//    @IterableMapping(qualifiedByName = "toProductSize")
//    List<ProductSize> toProductSizes(List<ProductSizeRequest> requests, long parentProductId);
//
//    @IterableMapping(qualifiedByName = "toProductSizeEntity")
//    List<ProductSizeEntity> toProductSizeEntities(List<ProductSize> domains);
//    @Named("toProductSizeEntity")
//    ProductSizeEntity toProductSizeEntity(ProductSize domain);
//
//    @IterableMapping(qualifiedByName = "toProductImageEntity")
//    List<ProductImageEntity> toProductImageEntities(List<ProductImage> domains);
//    @Named("toProductImageEntity")
//    ProductImageEntity toProductImageEntity(ProductImage domain);




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
