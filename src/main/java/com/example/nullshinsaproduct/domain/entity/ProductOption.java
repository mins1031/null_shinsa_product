package com.example.nullshinsaproduct.domain.entity;

import com.example.nullshinsaproduct.common.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOption extends BaseEntity {

    private String color;
    private String size;
    private String length;
    private String shoulder;
    private String chest;
    private String sleeve;
    private String waist;
    private String crotch;
    private String hip;
    private String thigh;
    private String hem;
    private int stock;

    @Column(nullable = false)
    private Long productId;

    public ProductOption(String size,
                         String color,
                         String length,
                         String shoulder,
                         String chest,
                         String sleeve,
                         String waist,
                         String crotch,
                         String hip,
                         String thigh,
                         String hem,
                         int stock,
                         Long productId
    ) {
        this.color = color;
        this.size = size;
        this.length = length;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
        this.stock = stock;
        this.productId = productId;
    }

    public boolean isSoldOut() {
        return this.stock == 0;
    }
}
