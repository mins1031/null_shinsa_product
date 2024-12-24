package com.example.nullshinsaproduct.product.infrastructure.db.entity;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(
        name = "product_size"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductSizeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sizeName;
    private String totalLength; // 총장
    private String shoulder; // 어깨너비
    private String chest; // 가슴단면
    private String sleeve; // 소매길이
    private String waist; // 허리
    private String crotch; // 밑위
    private String hip; // 엉덩이 단면
    private String thigh; // 허벅지 단면
    private String hem; // 밑단
    private String width; // 너비
    private String height; // 높이
    private String depth; // 폭(깊이)

    @Enumerated(EnumType.STRING)
    private ProductSizeType productSizeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ProductEntity product;


    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private ProductSizeEntity(
            String sizeName,
            String totalLength,
            String shoulder,
            String chest,
            String sleeve,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem,
            String width,
            String height,
            String depth,
            ProductSizeType productSizeType,
            ProductEntity product
    ) {
        this.sizeName = sizeName;
        this.totalLength = totalLength;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.productSizeType = productSizeType;
        this.product = product;
    }


    public static ProductSizeEntity of(
            String sizeName,
            String totalLength,
            String shoulder,
            String chest,
            String sleeve,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem,
            String width,
            String height,
            String depth,
            ProductSizeType productSizeType,
            ProductEntity product
    ) {
        return new ProductSizeEntity(
                sizeName,
                totalLength,
                shoulder,
                chest,
                sleeve,
                waist,
                crotch,
                hip,
                thigh,
                hem,
                width,
                height,
                depth,
                productSizeType,
                product
        );
    }

    public long getProductId() {
        return this.product.getId();
    }
}
