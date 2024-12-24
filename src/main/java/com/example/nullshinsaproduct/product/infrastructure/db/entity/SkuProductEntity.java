package com.example.nullshinsaproduct.product.infrastructure.db.entity;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.record.UnalignedMemoryRecords;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(
        name = "sku_product"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SkuProductEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int stock;
    private int plusPrice;

    @Enumerated(EnumType.STRING)
    private SkuProductStatus skuProductStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ProductEntity product;


    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    public SkuProductEntity(Long id, ProductEntity product, String name, int stock, int plusPrice, SkuProductStatus skuProductStatus) {
        this.id = id;
        this.product = product;
        this.name = name;
        this.stock = stock;
        this.plusPrice = plusPrice;
        this.skuProductStatus = skuProductStatus;
    }

    public static SkuProductEntity createSkuProduct(
            ProductEntity product,
            String name,
            int stock,
            int plusPrice,
            SkuProductStatus skuProductStatus
    ) {
        return new SkuProductEntity(
                null,
                product,
                name,
                stock,
                plusPrice,
                skuProductStatus
        );
    }

    public long getProductId() {
        return this.product.getId();
    }

    public boolean isSoldOut() {
        return this.stock <= 0;
    }

}
