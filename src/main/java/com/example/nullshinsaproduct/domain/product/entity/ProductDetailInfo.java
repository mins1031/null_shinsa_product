package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.presentation.dto.request.ProductDetailRequest;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDetailInfo {
    private String fabric;
    private String manufacturingCountry;
    private String washCaution;
    private String manufacturingDate;
    private String qualityGuarantee;

    private ProductDetailInfo(String fabric, String manufacturingCountry, String washCaution, String manufacturingDate, String qualityGuarantee) {
        this.fabric = fabric;
        this.manufacturingCountry = manufacturingCountry;
        this.washCaution = washCaution;
        this.manufacturingDate = manufacturingDate;
        this.qualityGuarantee = qualityGuarantee;
    }

    public static ProductDetailInfo from(ProductDetailRequest productDetailRequest) {
        return new ProductDetailInfo(
                productDetailRequest.getFabric(),
                productDetailRequest.getManufacturingCountry(),
                productDetailRequest.getWashCaution(),
                productDetailRequest.getManufacturingDate(),
                productDetailRequest.getQualityGuarantee()
                );
    }
}
