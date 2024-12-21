package com.example.nullshinsaproduct.product.infrastructure.db.entity;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.DiscountDetailInEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductBrandInfoEmbeddable;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.ProductImageVo;
import jakarta.persistence.CascadeType;
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
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
//@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price; // 내려갈거

    // 브랜드는 상품 종류마다 뭔가 따로 로직이 있어야할 필요는 없을것 같아 상위필드에 정의
    // 과연 브랜드 관련 데이터가 상품에 있을필요가 있을까..? id 만 있어도 충분할거 같은데 cqrs 를 미리 고려해놔서 이렇게 한것 같다. -> 일단은.. 두자
    @Embedded
    private ProductBrandInfoEmbeddable productBrandInfoEmbeddable;
    @Embedded
    private DiscountDetailInEntity discountDetailInEntity;

    // === 이넘 ===
    // 쿠폰가능여부 정도의 필드기에 참조정도로만 사용할것 같아 상위클래스에 정의
    @Enumerated(EnumType.STRING)
    private CouponApplyPossible couponApplyPossible;
    @Enumerated(EnumType.STRING)
    private ProductType productType;

    // === 연관관계 ===
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product", orphanRemoval = true)
    private List<ProductImageEntity> productImageEntityList;

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    protected Product(
            String name,
            int price,
            ProductBrandInfoEmbeddable productBrandInfoEmbeddable,
            DiscountDetailInEntity discountDetailInEntity,
            CouponApplyPossible couponApplyPossible,
            ProductType productType
    ) {
        this.name = name;
        this.price = price;
        this.productBrandInfoEmbeddable = productBrandInfoEmbeddable;
        this.discountDetailInEntity = discountDetailInEntity;
        this.couponApplyPossible = couponApplyPossible;
        this.productType = productType;
    }

    public void initImages(List<ProductImageEntity> images) {
        this.productImageEntityList = images;
    }

    public List<ProductImageVo> getProductImageVos() {
        return this.productImageEntityList.stream()
                .map(ProductImageVo::from)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productBrandInfo=" + productBrandInfoEmbeddable +
                ", discountDetail=" + discountDetailInEntity +
                ", couponApplyPossible=" + couponApplyPossible +
                ", productType=" + productType +
                ", productImageList is null ? =" + Objects.isNull(productImageEntityList) +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }
}
