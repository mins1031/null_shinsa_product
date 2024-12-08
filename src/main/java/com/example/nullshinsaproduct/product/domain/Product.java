package com.example.nullshinsaproduct.product.domain;

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
    private List<SkuProduct> skuProductList;
    private List<ProductImage> productImageList;
    private CategoryVo categoryVo;
    private ProductDeliveryVo productDeliveryVo;
    private ProductBrandVo productBrandVo;
    private ProductSize productSize;
    private ProductStatus productStatus;
    private DiscountDetail discountDetail;

    public Product(
            Long id,
            String name,
            int price,
            List<SkuProduct> skuProductList,
            List<ProductImage> productImageList,
            CategoryVo categoryVo,
            ProductDeliveryVo productDeliveryVo,
            ProductBrandVo productBrandVo,
            ProductSize productSize,
            ProductStatus productStatus,
            DiscountDetail discountDetail
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.skuProductList = skuProductList;
        this.productImageList = productImageList;
        this.categoryVo = categoryVo;
        this.productDeliveryVo = productDeliveryVo;
        this.productBrandVo = productBrandVo;
        this.productSize = productSize;
        this.productStatus = productStatus;
        this.discountDetail = discountDetail;
    }

    public static Product createFrom(ProductSaveVo saveVo) {
        return new Product(
                null,
                saveVo.name(),
                saveVo.price(),
                new ArrayList<>(),
                new ArrayList<>(),
                CategoryVo.of(
                        saveVo.firstLayerCategory(),
                        saveVo.secondLayerCategory(),
                        saveVo.thirdLayerCategory()
                ),
                ProductDeliveryVo.createAs(saveVo.isDeliveryFree()),
                null/*productBrandVo*/,
                null,
                ProductStatus.TEMP,
                DiscountDetail.of(
                        saveVo.discountApplyPossible(),
                        saveVo.discountMinRate(),
                        saveVo.discountMaxRate()
                )
        );
    }


    public void updateRelatedSkus(final List<SkuProduct> skuProductList) {
        this.skuProductList = skuProductList;
    }

    public void updateRelatedImages(final List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public void updateSize(final ProductSize productSize) {
        this.productSize = productSize;
    }

}
