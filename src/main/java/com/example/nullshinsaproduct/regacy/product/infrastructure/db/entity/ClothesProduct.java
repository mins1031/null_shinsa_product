package com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity;


import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.regacy.application.dto.response.ProductSizeVo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.CategoryInfoEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.CategoryVo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.ProductDetailVo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.ProductImageVo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.ProductOverviewVo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.SkuProductVo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClothesProduct extends Product {
    // 카테고리, 배송정보 모두 상품별로 따로 정의가 들어가야할 가능성이 조금이라 있을듯하여 하위 클래스에 정의
    @Embedded
    private CategoryInfoEntity category;
    @Embedded
    private ProductDeliveryInfo productDeliveryInfo;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProductEntity> skuProductEntityList;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private ProductDetail productDetail;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductSizeEntity> productSizeEntityList;

    @Enumerated(EnumType.STRING)
    private FirstLayerCategory firstLayerCategory;
    @Enumerated(EnumType.STRING)
    private SecondLayerCategory secondLayerCategory;
    @Enumerated(EnumType.STRING)
    private ThirdLayerCategory thirdLayerCategory;
    @Enumerated(EnumType.STRING)
    private InferiorLayerCategory inferiorLayerCategory;


    private ClothesProduct(
            String name,
            int price,
            ProductBrandInfo productBrandInfo,
            CategoryInfoEntity category,
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
            CategoryInfoEntity category,
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

    public void initSkus(List<SkuProductEntity> skus) {
        this.skuProductEntityList = skus;
    }
    public void initDetail(ProductDetail detail) {
        this.productDetail = detail;
    }
    public void initSizes(List<ProductSizeEntity> sizes) {
        this.productSizeEntityList = sizes;
    }

    public long getBrandId() {
        return this.getProductBrandInfo().getBrandId();
    }



    public ProductOverviewVo getProductOverview() {
        // 도메인 객체내의 null 체크는 없다고 가정.
        List<SkuProductVo> skuProductVos = this.skuProductEntityList.stream()
                .map(SkuProductVo::from)
                .collect(Collectors.toList());
        List<ProductSizeVo> productSizeVos = this.productSizeEntityList.stream()
                .map(ProductSizeVo::createVoBySizeType)
                .collect(Collectors.toList());
        List<ProductImageVo> productImageVos = super.getProductImageVos();
        ProductDetailVo productDetailVo = ProductDetailVo.from(this.productDetail);

        return new ProductOverviewVo(
                this.getId(),
                this.getName(),
                this.getPrice(),
                this.getProductDeliveryInfo().getOutboundPossibleDay(),
                this.getProductDeliveryInfo().getDeliveryFee(),
                this.getCouponApplyPossible(),
                this.getDiscountDetail().getDiscountApplyPossible(),
                this.getDiscountDetail().getDiscountMinRate(),
                this.getDiscountDetail().getDiscountMaxRate(),
                this.getProductType(),
                this.getCreatedDate(),
                this.getUpdatedDate(),
                productDetailVo,
                CategoryVo.from(this.category),
                skuProductVos,
                productSizeVos,
                productImageVos
        );
    }



    @Override
    public String toString() {
        return "ClothesProduct{" +
                "product=" + super.toString() +
                "category=" + category +
                ", productDeliveryInfo=" + productDeliveryInfo +
                ", skuProductList is null ? =" + Objects.isNull(skuProductEntityList) +
                ", productDetail is null ? =" + Objects.isNull(productDetail) +
                ", productSizeList is null ? =" + Objects.isNull(productSizeEntityList) +
                '}';
    }
}
