package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.domain.product.entity.embaded.CategoryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetailInfo;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ElectronicProduct extends Product {
    @Embedded
    private CategoryInfo category;
    @Embedded
    private ProductDeliveryInfo productDeliveryInfo;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProduct> skuProductList;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private ProductDetailInfo productDetailInfo;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductSizeDetail> productSizeDetailList;

    public ElectronicProduct(
            String name,
            int price,
            ProductBrandInfo productBrandInfo,
            CategoryInfo category,
            DiscountDetail discountDetail,
            CouponApplyPossible couponApplyPossible,
            List<ProductImage> productImageList,
            ProductDeliveryInfo productDeliveryInfo,
            List<SkuProduct> skuProductList,
            ProductDetailInfo productDetailInfo,
            List<ProductSizeDetail> productSizeDetailList
    ) {
        super(name, price, productBrandInfo, discountDetail, couponApplyPossible, productImageList);
        this.category = category;
        this.productDeliveryInfo = productDeliveryInfo;
        this.skuProductList = skuProductList;
        this.productDetailInfo = productDetailInfo;
        this.productSizeDetailList = productSizeDetailList;
    }
}
