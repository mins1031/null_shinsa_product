package com.example.nullshinsaproduct.domain.product.entity.embaded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class ProductDetailInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabric; // 원단
    private String manufacturingCountry; // 제조사
    private String washCaution; // 세탁시 주의사항
    private String manufacturingDate; // 제조일자
    private String qualityGuarantee; //
    private String detailContent; // 상품상세 알림메모
    private String brandDetailContent; // 브랜드 알림메모
    private String adminDetailContent; // 관리자 알림메모

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

}
