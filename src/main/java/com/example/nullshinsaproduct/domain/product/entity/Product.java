package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetailInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductSizeDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;

    @Embedded
    private ProductDetailInfo productDetailInfo;
    @Embedded
    private ProductBrandInfo productBrandInfo;
    @Embedded
    private ProductDeliveryInfo productDeliveryInfo;

    // === 이넘 ===
    @Enumerated(EnumType.STRING)
    private DiscountApplyPossible discountApplyPossible;
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;

    // === 연관관계 ===
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProduct> skuProductList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductImage> productImageList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductSizeDetail> productSizeDetailList;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    public Product(
            String name,
            int price,
            ProductDetailInfo productDetailInfo,
            ProductBrandInfo productBrandInfo,
            ProductDeliveryInfo productDeliveryInfo,
            DiscountApplyPossible discountApplyPossible,
            CouponApplyPossible couponApplyPossible,
            Category category,
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
        this.category = category;
        this.skuProductList = skuProductList;
        this.productImageList = productImageList;
        this.productSizeDetailList = productSizeDetailList;
    }
}
