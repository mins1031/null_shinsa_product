package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.domain.product.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price; // 내려갈거

    // 브랜드는 상품 종류마다 뭔가 따로 로직이 있어야할 필요는 없을것 같아 상위필드에 정의
    @Embedded
    private ProductBrandInfo productBrandInfo;
    @Embedded
    private DiscountDetail discountDetail;

    // === 이넘 ===
    // 쿠폰가능여부 정도의 필드기에 참조정도로만 사용할것 같아 상위클래스에 정의
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductImage> productImageList;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    protected Product(
            String name,
            int price,
            ProductBrandInfo productBrandInfo,
            DiscountDetail discountDetail,
            CouponApplyPossible couponApplyPossible
    ) {
        this.name = name;
        this.price = price;
        this.productBrandInfo = productBrandInfo;
        this.discountDetail = discountDetail;
        this.couponApplyPossible = couponApplyPossible;
    }

    public void initImages(List<ProductImage> images) {
        this.productImageList = images;
    }
}
