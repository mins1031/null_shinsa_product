package com.example.nullshinsaproduct.domain.product.entity;


import com.example.nullshinsaproduct.domain.product.entity.embaded.CategoryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;
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
public class ClothesProduct extends Product {
    // 카테고리, 배송정보 모두 상품별로 따로 정의가 들어가야할 가능성이 조금이라 있을듯하여 하위 클래스에 정의
    @Embedded
    private CategoryInfo category;
    @Embedded
    private ProductDeliveryInfo productDeliveryInfo;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProduct> skuProductList;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private ProductDetail productDetail;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductSize> productSizeList;


    private ClothesProduct(
            String name,
            int price,
            ProductBrandInfo productBrandInfo,
            CategoryInfo category,
            DiscountDetail discountDetail,
            CouponApplyPossible couponApplyPossible,
            ProductDeliveryInfo productDeliveryInfo,
            ProductType productType
    ) {
        super(name, price, productBrandInfo, discountDetail, couponApplyPossible, productType);
        this.category = category;
        this.productDeliveryInfo = productDeliveryInfo;
    }


    public static ClothesProduct createBasicClothesProduct(
            String name,
            int price,
            ProductBrandInfo productBrandInfo,
            CategoryInfo category,
            DiscountDetail discountDetail,
            CouponApplyPossible couponApplyPossible,
            ProductDeliveryInfo productDeliveryInfo,
            ProductType productType
    ) {
        return new ClothesProduct(
                name,
                price,
                productBrandInfo,
                category,
                discountDetail,
                couponApplyPossible,
                productDeliveryInfo,
                productType
        );
    }


    public void initSkus(List<SkuProduct> skus) {
        this.skuProductList = skus;
    }
    public void initDetail(ProductDetail detail) {
        this.productDetail = detail;
    }
    public void initSizes(List<ProductSize> sizes) {
        this.productSizeList = sizes;
    }


}
