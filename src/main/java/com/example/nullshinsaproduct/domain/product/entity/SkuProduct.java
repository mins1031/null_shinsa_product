package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductSizeDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkuProduct {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private String color;
    private String size;
    private int stock;
    private double startPoint;
    private int discountRate;

    @Embedded
    private ProductSizeDetail productSizeDetail;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


    public boolean isSoldOut() {
        return this.stock <= 0;
    }
}
