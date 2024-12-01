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
//public class ProductTopSizeEntity extends ProductSizeEntity {
//    private String length;
//    private String shoulder;
//    private String chest;
//    private String sleeve;
//
//    public ProductTopSizeEntity(
//            String sizeName,
//            Product product,
//            ProductSizeType productSizeType,
//            String length,
//            String shoulder,
//            String chest,
//            String sleeve
//    ) {
//        super(sizeName, product, productSizeType);
//        this.length = length;
//        this.shoulder = shoulder;
//        this.chest = chest;
//        this.sleeve = sleeve;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductTopSize{" +
//                "length='" + length + '\'' +
//                ", shoulder='" + shoulder + '\'' +
//                ", chest='" + chest + '\'' +
//                ", sleeve='" + sleeve + '\'' +
//                '}';
//    }
//}
