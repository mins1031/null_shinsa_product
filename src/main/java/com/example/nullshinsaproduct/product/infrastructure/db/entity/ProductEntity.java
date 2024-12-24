package com.example.nullshinsaproduct.product.infrastructure.db.entity;


import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(
        name = "product"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price; // 내려갈거
    private Long brandId;
    private String brandName;
    private String corporateNumber;
    private String communicationSellingNumber;
    private String representative;
    private String location;

    private int discountMinRate;
    private int discountMaxRate;

    private int outboundPossibleDay;
    private DeliveryFee deliveryFee;

    private boolean isCanView;

    // === 이넘 ===
    // 쿠폰가능여부 정도의 필드기에 참조정도로만 사용할것 같아 상위클래스에 정의
    @Enumerated(EnumType.STRING)
    private DiscountApplyPossible discountApplyPossible;
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    // 카테고리, 배송정보 모두 상품별로 따로 정의가 들어가야할 가능성이 조금이라 있을듯하여 하위 클래스에 정의
    @Enumerated(EnumType.STRING)
    private FirstLayerCategory firstLayerCategory;
    @Enumerated(EnumType.STRING)
    private SecondLayerCategory secondLayerCategory;
    @Enumerated(EnumType.STRING)
    private ThirdLayerCategory thirdLayerCategory;
    @Enumerated(EnumType.STRING)
    private InferiorLayerCategory inferiorLayerCategory;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductImageEntity> productImageEntityList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProductEntity> skuProductEntityList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductSizeEntity> productSizeEntityList;


    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;


    @Builder
    private ProductEntity(
            String name,
            int price,
            Long brandId,
            String brandName,
            String corporateNumber,
            String communicationSellingNumber,
            String representative,
            String location,
            int discountMinRate,
            int discountMaxRate,
            int outboundPossibleDay,
            DeliveryFee deliveryFee,
            DiscountApplyPossible discountApplyPossible,
            CouponApplyPossible couponApplyPossible,
            ProductStatus productStatus,
            boolean isCanView,
            FirstLayerCategory firstLayerCategory,
            SecondLayerCategory secondLayerCategory,
            ThirdLayerCategory thirdLayerCategory,
            InferiorLayerCategory inferiorLayerCategory,
            List<ProductImageEntity> productImageEntityList,
            List<SkuProductEntity> skuProductEntityList,
            List<ProductSizeEntity> productSizeEntityList
    ) {
        this.name = name;
        this.price = price;
        this.brandId = brandId;
        this.brandName = brandName;
        this.corporateNumber = corporateNumber;
        this.communicationSellingNumber = communicationSellingNumber;
        this.representative = representative;
        this.location = location;
        this.discountMinRate = discountMinRate;
        this.discountMaxRate = discountMaxRate;
        this.outboundPossibleDay = outboundPossibleDay;
        this.deliveryFee = deliveryFee;
        this.discountApplyPossible = discountApplyPossible;
        this.couponApplyPossible = couponApplyPossible;
        this.productStatus = productStatus;
        this.isCanView = isCanView;
        this.firstLayerCategory = firstLayerCategory;
        this.secondLayerCategory = secondLayerCategory;
        this.thirdLayerCategory = thirdLayerCategory;
        this.inferiorLayerCategory = inferiorLayerCategory;
        this.productImageEntityList = productImageEntityList;
        this.skuProductEntityList = skuProductEntityList;
        this.productSizeEntityList = productSizeEntityList;
    }

    public static ProductEntity createDefault(
            String name,
            int price,
            Long brandId,
            String brandName,
            String corporateNumber,
            String communicationSellingNumber,
            String representative,
            String location,
            int discountMinRate,
            int discountMaxRate,
            int outboundPossibleDay,
            DeliveryFee deliveryFee,
            DiscountApplyPossible discountApplyPossible,
            CouponApplyPossible couponApplyPossible,
            ProductStatus productStatus,
            boolean isCanView,
            FirstLayerCategory firstLayerCategory,
            SecondLayerCategory secondLayerCategory,
            ThirdLayerCategory thirdLayerCategory,
            InferiorLayerCategory inferiorLayerCategory
    ) {
        return ProductEntity.builder()
                .name(name)
                .price(price)
                .brandId(brandId)
                .brandName(brandName)
                .corporateNumber(corporateNumber)
                .communicationSellingNumber(communicationSellingNumber)
                .representative(representative)
                .location(location)
                .discountMinRate(discountMinRate)
                .discountMaxRate(discountMaxRate)
                .outboundPossibleDay(outboundPossibleDay)
                .deliveryFee(deliveryFee)
                .discountApplyPossible(discountApplyPossible)
                .couponApplyPossible(couponApplyPossible)
                .productStatus(productStatus)
                .isCanView(isCanView)
                .firstLayerCategory(firstLayerCategory)
                .secondLayerCategory(secondLayerCategory)
                .thirdLayerCategory(thirdLayerCategory)
                .inferiorLayerCategory(inferiorLayerCategory)
                .build();
    }

    public void initSkus(List<SkuProductEntity> skus) {
        this.skuProductEntityList = skus;
    }
    public void initSizes(List<ProductSizeEntity> sizes) {
        this.productSizeEntityList = sizes;
    }
    public void initImages(List<ProductImageEntity> images) {
        this.productImageEntityList = images;
    }


}
