package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.domain.product.entity.embaded.CategoryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetailInfo;
import com.example.nullshinsaproduct.domain.product.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
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

    @Embedded
    private ProductDetailInfo productDetailInfo; // 내려갈거
    @Embedded
    private ProductBrandInfo productBrandInfo;
    @Embedded
    private ProductDeliveryInfo productDeliveryInfo; // 내려갈거
    @Embedded
    private CategoryInfo category;

    // === 이넘 ===
    @Enumerated(EnumType.STRING)
    private DiscountApplyPossible discountApplyPossible;
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProduct> skuProductList; // 내려갈거
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductImage> productImageList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductSizeDetail> productSizeDetailList; // 내려갈거

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private Product(
            String name,
            int price,
            ProductDetailInfo productDetailInfo,
            ProductBrandInfo productBrandInfo,
            ProductDeliveryInfo productDeliveryInfo,
            DiscountApplyPossible discountApplyPossible,
            CouponApplyPossible couponApplyPossible,
            FirstLayerCategory firstLayerCategory,
            List<SkuProduct> skuProductList,
            List<ProductImage> productImageList,
            List<ProductSizeDetail> productSizeDetailList
    ) {
        this.name = name;
        this.price = price;
        this.productDetailInfo = productDetailInfo;
        this.productBrandInfo = productBrandInfo;
        this.productDeliveryInfo = productDeliveryInfo;
        this.discountApplyPossible = discountApplyPossible;
        this.couponApplyPossible = couponApplyPossible;
        this.category = firstLayerCategory;
        this.skuProductList = skuProductList;
        this.productImageList = productImageList;
        this.productSizeDetailList = productSizeDetailList;
    }

}
