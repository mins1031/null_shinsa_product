//
//package com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity;
//
//import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
//import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
//import jakarta.persistence.Entity;
//import lombok.AccessLevel;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Getter
//@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
//public class ProductBottomSizeEntity extends ProductSizeEntity {
//    private String length;
//    private String waist;
//    private String crotch;
//    private String hip;
//    private String thigh;
//    private String hem;
//
//    public ProductBottomSizeEntity(
//            String sizeName,
//            Product product,
//            ProductSizeType productSizeType,
//            String length,
//            String waist,
//            String crotch,
//            String hip,
//            String thigh,
//            String hem
//    ) {
//        super(sizeName, product, productSizeType);
//        this.length = length;
//        this.waist = waist;
//        this.crotch = crotch;
//        this.hip = hip;
//        this.thigh = thigh;
//        this.hem = hem;
//    }
//}
