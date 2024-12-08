package com.example.nullshinsaproduct.product.infrastructure.db.entity;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
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
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkuProductEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int stock;
    private int plusPrice;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;


    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    public SkuProductEntity(long id, Product product, String name, int stock, int plusPrice, ProductStatus productStatus) {
        this.id = id;
        this.product = product;
        this.name = name;
        this.stock = stock;
        this.plusPrice = plusPrice;
        this.productStatus = productStatus;
    }

    public static SkuProductEntity createSkuProduct(
            String color,
            String size,
            int stock,
            int discountRate,
            ProductStatus productStatus,
            Product product
    ) {
        return new SkuProductEntity(
        );
    }

    public boolean isSoldOut() {
        return this.stock <= 0;
    }

}
