package com.example.nullshinsaproduct.product.domain.enumeration;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import lombok.Getter;

import java.util.function.BiFunction;

@Getter
public enum ProductSizeType {
    TOP("상의 사이즈", ProductSize::createTop),
    BOTTOM("하의 사이즈", ProductSize::createBottom),
    OUTER("아우터 사이즈", ProductSize::createOuter),
    DRESS("원피스 사이즈", ProductSize::createDress),
    SKIRT("스커트 사이즈", ProductSize::createSkirt),
    SHOES("신발 사이즈", ProductSize::createShoe),
    BAG("가방 사이즈", ProductSize::createBag),
//    UNDER_WEAR("언더웨어 사이즈"),
    ;

    private final String desc;
    private final BiFunction<ProductSizeRequest, Long, ProductSize> productSizeBiFunction;

    ProductSizeType(String desc, BiFunction<ProductSizeRequest, Long, ProductSize> productSizeBiFunction) {
        this.desc = desc;
        this.productSizeBiFunction = productSizeBiFunction;
    }

    public ProductSize createProductSizeByType(ProductSizeRequest req, Long productId) {
        return this.productSizeBiFunction.apply(req, productId);
    }
}
