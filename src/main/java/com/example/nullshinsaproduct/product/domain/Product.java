package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.vo.CategoryVo;
import com.example.nullshinsaproduct.product.domain.vo.ProductBrandVo;
import com.example.nullshinsaproduct.product.domain.vo.ProductDeliveryVo;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Product {

    private final Long id;
    private String name;
    private int price;
    private CategoryVo categoryVo;
    private ProductDeliveryVo productDeliveryVo;
    private ProductBrandVo productBrandVo;
    private ProductStatus productStatus;
    private DiscountDetail discountDetail;
    private CouponApplyPossible couponApplyPossible;
    private List<SkuProduct> skuProductList;
    private List<ProductSize> productSizes;
    private List<ProductImage> productImageList;


    public Product(
            Long id,
            String name,
            int price,
            CategoryVo categoryVo,
            ProductDeliveryVo productDeliveryVo,
            ProductBrandVo productBrandVo,
            ProductStatus productStatus,
            DiscountDetail discountDetail,
            CouponApplyPossible couponApplyPossible,
            List<SkuProduct> skuProductList,
            List<ProductSize> productSizes,
            List<ProductImage> productImageList
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryVo = categoryVo;
        this.productDeliveryVo = productDeliveryVo;
        this.productBrandVo = productBrandVo;
        this.productStatus = productStatus;
        this.discountDetail = discountDetail;
        this.couponApplyPossible = couponApplyPossible;
        this.skuProductList = skuProductList;
        this.productSizes = productSizes;
        this.productImageList = productImageList;
    }

    public static Product createFrom(final ProductSaveVo saveVo) {
        return new Product(
                null,
                saveVo.name(),
                saveVo.price(),
                CategoryVo.of(
                        saveVo.firstLayerCategory(),
                        saveVo.secondLayerCategory(),
                        saveVo.thirdLayerCategory()
                ),
                ProductDeliveryVo.createAs(saveVo.isDeliveryFree()),
                null/*productBrandVo*/,
                ProductStatus.TEMP,
                DiscountDetail.of(
                        saveVo.discountApplyPossible(),
                        saveVo.discountMinRate(),
                        saveVo.discountMaxRate()
                ),
                saveVo.couponApplyPossible(),
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>()
        );
    }


    public void updateRelatedSkus(final List<SkuProduct> skuProductList) {
        this.skuProductList = skuProductList;
    }

    public void updateRelatedImages(final List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public void updateSize(final List<ProductSize> productSizes) {
        this.productSizes = productSizes;
    }

}
