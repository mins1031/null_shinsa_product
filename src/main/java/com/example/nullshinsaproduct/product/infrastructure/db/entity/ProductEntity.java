package com.example.nullshinsaproduct.product.infrastructure.db.entity;


import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.regacy.application.dto.response.ProductSizeVo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.CategoryInfoEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.DiscountDetailInEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductBrandInfoEmbeddable;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDeliveryInfoInEntity;
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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price; // 내려갈거

    // 브랜드는 상품 종류마다 뭔가 따로 로직이 있어야할 필요는 없을것 같아 상위필드에 정의
    // 과연 브랜드 관련 데이터가 상품에 있을필요가 있을까..? id 만 있어도 충분할거 같은데 cqrs 를 미리 고려해놔서 이렇게 한것 같다. -> 일단은.. 두자
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

    // === 이넘 ===
    // 쿠폰가능여부 정도의 필드기에 참조정도로만 사용할것 같아 상위클래스에 정의
    @Enumerated(EnumType.STRING)
    private DiscountApplyPossible discountApplyPossible;
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
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


    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<SkuProductEntity> skuProductEntityList;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private ProductDetail productDetail;
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
            ProductType productType,
            ProductStatus productStatus,
            FirstLayerCategory firstLayerCategory,
            SecondLayerCategory secondLayerCategory,
            ThirdLayerCategory thirdLayerCategory,
            InferiorLayerCategory inferiorLayerCategory,
            List<ProductImageEntity> productImageEntityList,
            List<SkuProductEntity> skuProductEntityList,
            ProductDetail productDetail,
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
        this.productType = productType;
        this.productStatus = productStatus;
        this.firstLayerCategory = firstLayerCategory;
        this.secondLayerCategory = secondLayerCategory;
        this.thirdLayerCategory = thirdLayerCategory;
        this.inferiorLayerCategory = inferiorLayerCategory;
        this.productImageEntityList = productImageEntityList;
        this.skuProductEntityList = skuProductEntityList;
        this.productDetail = productDetail;
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
            ProductType productType,
            ProductStatus productStatus,
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
                .productType(productType)
                .productStatus(productStatus)
                .firstLayerCategory(firstLayerCategory)
                .secondLayerCategory(secondLayerCategory)
                .thirdLayerCategory(thirdLayerCategory)
                .inferiorLayerCategory(inferiorLayerCategory)
                .build();
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

//    public long getBrandId() {
//        return this.getProductBrandInfoEmbeddable().getBrandId();
//    }
//
//
//
//    public ProductOverviewVo getProductOverview() {
//        // 도메인 객체내의 null 체크는 없다고 가정.
//        List<SkuProductVo> skuProductVos = this.skuProductEntityList.stream()
//                .map(SkuProductVo::from)
//                .collect(Collectors.toList());
//        List<ProductSizeVo> productSizeVos = this.productSizeEntityList.stream()
//                .map(ProductSizeVo::createVoBySizeType)
//                .collect(Collectors.toList());
//        List<ProductImageVo> productImageVos = this.getProductImageVos();
//        ProductDetailVo productDetailVo = ProductDetailVo.from(this.productDetail);
//
//        return new ProductOverviewVo(
//                this.getId(),
//                this.getName(),
//                this.getPrice(),
//                this.getProductDeliveryInfoInEntity().getOutboundPossibleDay(),
//                this.getProductDeliveryInfoInEntity().getDeliveryFee(),
//                this.getCouponApplyPossible(),
//                this.getDiscountDetailInEntity().getDiscountApplyPossible(),
//                this.getDiscountDetailInEntity().getDiscountMinRate(),
//                this.getDiscountDetailInEntity().getDiscountMaxRate(),
//                this.getProductType(),
//                this.getCreatedDate(),
//                this.getUpdatedDate(),
//                productDetailVo,
//                CategoryVo.from(this.category),
//                skuProductVos,
//                productSizeVos,
//                productImageVos
//        );
//    }

    public void initImages(List<ProductImageEntity> images) {
        this.productImageEntityList = images;
    }

//    public List<ProductImageVo> getProductImageVos() {
//        return this.productImageEntityList.stream()
//                .map(ProductImageVo::from)
//                .collect(Collectors.toList());
//    }
}
