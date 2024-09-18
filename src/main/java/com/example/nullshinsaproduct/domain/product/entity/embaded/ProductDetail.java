package com.example.nullshinsaproduct.domain.product.entity.embaded;

import com.example.nullshinsaproduct.domain.product.entity.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ==== 필수 정보 ====
    private String manufacturingCountry; // 제조국
    private String manufacturingCompany; // 제조국
    private String manufacturingDate; // 제조일자
    private String qualityGuarantee; // 품질보증기준

    // ==== 선택 정보 ====
    private String fabric; // 원단
    private String measurement; // 치수
    private String washCaution; // 세탁시 주의사항
    private String productInnerItems; // 상품구성 내용
    private String asOfficerAndTel; // as 담당자 및 번호
    private String detailContent; // 상품상세 알림메모
    private String brandDetailContent; // 브랜드 알림메모
    private String adminDetailContent; // 관리자 알림메모

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    public ProductDetail(
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
            String adminDetailContent,
            Product product
    ) {
        this.manufacturingCountry = manufacturingCountry;
        this.manufacturingCompany = manufacturingCompany;
        this.manufacturingDate = manufacturingDate;
        this.qualityGuarantee = qualityGuarantee;
        this.fabric = fabric;
        this.measurement = measurement;
        this.washCaution = washCaution;
        this.productInnerItems = productInnerItems;
        this.asOfficerAndTel = asOfficerAndTel;
        this.detailContent = detailContent;
        this.brandDetailContent = brandDetailContent;
        this.adminDetailContent = adminDetailContent;
        this.product = product;
    }
}
