package com.example.nullshinsaproduct.product.application.input.map;

import com.example.nullshinsaproduct.brand.apllication.dto.BrandResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.CategoryResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductImageResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductSizeResponse;
import com.example.nullshinsaproduct.product.application.input.dto.response.SkuProductResponse;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;

import java.util.List;

public class ProductInputMapper {
    public static ProductQueryResponse toProductQueryResponse(Product domain) {
        return new ProductQueryResponse(
                toProductResponse(domain),
                new CategoryResponse(
                        domain.getCategoryVo().getFirstLayerCategory(),
                        domain.getCategoryVo().getSecondLayerCategory(),
                        domain.getCategoryVo().getThirdLayerCategory()
                ),
                new BrandResponse(
                        domain.getProductBrandVo().getBrandId(),
                        domain.getProductBrandVo().getBrandName(),
                        domain.getProductBrandVo().getCorporateNumber(),
                        domain.getProductBrandVo().getCommunicationSellingNumber(),
                        domain.getProductBrandVo().getRepresentative(),
                        domain.getProductBrandVo().getLocation()
                ),
                toSkuProductResponses(domain.getSkuProductList()),
                toProductSizeResponses(domain.getProductSizes()),
                toProductImageResponses(domain.getProductImageList())
        );
    }

    public static ProductResponse toProductResponse(Product domain) {
        return new ProductResponse(
                domain.getId(),
                domain.getName(),
                domain.getPrice(),
                domain.getProductDeliveryVo().getOutboundPossibleDay(),
                domain.getProductDeliveryVo().getDeliveryFee(),
                domain.getCouponApplyPossible(),
                domain.getDiscountDetail().getDiscountApplyPossible(),
                domain.getDiscountDetail().getDiscountMinRate(),
                domain.getDiscountDetail().getDiscountMaxRate(),
                domain.getProductStatus(),
                domain.getCreatedDate(),
                domain.getUpdatedDate()
        );
    }

    public static SkuProductResponse toSkuProductResponse(SkuProduct domain) {
        return new SkuProductResponse(
                domain.getId(),
                domain.getParentProductId(),
                domain.getName(),
                domain.getStock(),
                domain.getPlusPrice(),
                domain.getSkuProductStatus(),
                domain.getCreatedDate(),
                domain.getUpdatedDate()
        );
    }

    public static List<SkuProductResponse> toSkuProductResponses(List<SkuProduct> domains) {
        return domains.stream()
                .map(ProductInputMapper::toSkuProductResponse)
                .toList();
    }


    public static ProductSizeResponse toProductSizeResponse(ProductSize domain) {
        return new ProductSizeResponse(
                domain.getId(),
                domain.getProductId(),
                domain.getSizeName(),
                domain.getTotalLength(),
                domain.getShoulder(),
                domain.getChest(),
                domain.getSleeve(),
                domain.getWaist(),
                domain.getCrotch(),
                domain.getHip(),
                domain.getThigh(),
                domain.getHem(),
                domain.getWidth(),
                domain.getHeight(),
                domain.getDepth(),
                domain.getProductSizeType(),
                domain.getCreatedDate(),
                domain.getUpdatedDate()
        );
    }

    public static List<ProductSizeResponse> toProductSizeResponses(List<ProductSize> domains) {
        return domains.stream()
                .map(ProductInputMapper::toProductSizeResponse)
                .toList();
    }


    public static ProductImageResponse toProductImageResponse(ProductImage domain) {
        return new ProductImageResponse(
                domain.getId(),
                domain.getProductId(),
                domain.getImageUrl(),
                domain.getImageType(),
                domain.getCreatedDate(),
                domain.getUpdatedDate()
        );
    }

    public static List<ProductImageResponse> toProductImageResponses(List<ProductImage> domains) {
        return domains.stream()
                .map(ProductInputMapper::toProductImageResponse)
                .toList();
    }



}
