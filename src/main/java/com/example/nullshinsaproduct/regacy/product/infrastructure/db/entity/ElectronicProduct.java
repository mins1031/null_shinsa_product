package com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.CategoryInfoEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.DiscountDetailInEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductBrandInfoEmbeddable;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDeliveryInfoInEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
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
    private CategoryInfoEntity category;
    @Embedded
    private ProductDeliveryInfoInEntity productDeliveryInfoInEntity;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProductEntity> skuProductEntityList;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductDetail productDetail;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductSizeEntity> productSizeEntityList;

    public ElectronicProduct(
            String name,
            int price,
            ProductBrandInfoEmbeddable productBrandInfoEmbeddable,
            CategoryInfoEntity category,
            DiscountDetailInEntity discountDetailInEntity,
            CouponApplyPossible couponApplyPossible,
            ProductDeliveryInfoInEntity productDeliveryInfoInEntity,
            List<SkuProductEntity> skuProductEntityList,
            ProductDetail productDetail,
            List<ProductSizeEntity> productSizeEntityList,
            ProductType productType
    ) {
        super(name, price, productBrandInfoEmbeddable, discountDetailInEntity, couponApplyPossible, productType);
        this.category = category;
        this.productDeliveryInfoInEntity = productDeliveryInfoInEntity;
        this.skuProductEntityList = skuProductEntityList;
        this.productDetail = productDetail;
        this.productSizeEntityList = productSizeEntityList;
    }
}
