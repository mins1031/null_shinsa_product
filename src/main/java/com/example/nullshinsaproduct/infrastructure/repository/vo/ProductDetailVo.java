package com.example.nullshinsaproduct.infrastructure.repository.vo;

import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;

public record ProductDetailVo (
        long id,
        long productId,
        String manufacturingCountry,
        String manufacturingCompany,
        String manufacturingDate,
        String qualityGuarantee,
        String fabric,
        String measurement,
        String washCaution,
        String productInnerItems,
        String asOfficerAndTel,
        String detailContent,
        String brandDetailContent,
        String adminDetailContent
) {

    public static ProductDetailVo from(ProductDetail productDetail) {
        return new ProductDetailVo(
                productDetail.getId(),
                productDetail.getProductId(),
                productDetail.getManufacturingCountry(),
                productDetail.getManufacturingCompany(),
                productDetail.getManufacturingDate(),
                productDetail.getQualityGuarantee(),
                productDetail.getFabric(),
                productDetail.getMeasurement(),
                productDetail.getWashCaution(),
                productDetail.getProductInnerItems(),
                productDetail.getAsOfficerAndTel(),
                productDetail.getDetailContent(),
                productDetail.getBrandDetailContent(),
                productDetail.getAdminDetailContent()
        );
    }
}
