package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;
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
public class SkuProduct {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private String color;
    private String size;
    private int stock;
    private double startPoint;
    private int discountRate;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;

    private SkuProduct(String color, String size, int stock, double startPoint, int discountRate, ProductStatus productStatus, Product product) {
        this.color = color;
        this.size = size;
        this.stock = stock;
        this.startPoint = startPoint;
        this.discountRate = discountRate;
        this.productStatus = productStatus;
        this.product = product;
    }

    public static SkuProduct createSkuProduct(
            String color,
            String size,
            int stock,
            int discountRate,
            ProductStatus productStatus,
            Product product
    ) {
        return new SkuProduct(
                color,
                size,
                stock,
                0,
                discountRate,
                productStatus,
                product
        );
    }

    public boolean isSoldOut() {
        return this.stock <= 0;
    }


    @Override
    public String toString() {
        return "SkuProduct{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", stock=" + stock +
                ", startPoint=" + startPoint +
                ", discountRate=" + discountRate +
                ", productStatus=" + productStatus +
                '}';
    }
}
