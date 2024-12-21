package com.example.nullshinsaproduct.product.common.helper;

import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.product.application.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

import java.util.List;

public class ProductTestHelper {
    public static ProductSaveRequest makeOuterProductSaveReq() {
        return new ProductSaveRequest(
                "test 상품",
                1L,
                100000,
                new CategoryInfoRequest(
                        FirstLayerCategory.MEN,
                        SecondLayerCategory.OUTER,
                        ThirdLayerCategory.CARDIGAN,
                        null
                ),
                CouponApplyPossible.POSSIBLE,
                DiscountApplyPossible.POSSIBLE,
                3,
                20,
                3,
                true,
                List.of(
                        new ProductSizeRequest(
                                "L",
                                "80",
                                "60",
                                "50",
                                "70",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                "",
                                ProductSizeType.OUTER
                        )
                ),
                "https://thumbnailLink",
                List.of("https://profileLink", "https://profileLink"),
                List.of("https://detailLink", "https://detailLink"),
                makeSkuProductSaveReq(),
                ProductType.CLOTHES
        );
    }

    public static List<SkuProductRequest> makeSkuProductSaveReq() {
        return List.of(
                new SkuProductRequest(
                        "상품1 - 사이즈1",
                        0,
                        5000,
                        SkuProductStatus.TEMP
                ),
                new SkuProductRequest(
                        "상품1 - 사이즈2",
                        0,
                        15000,
                        SkuProductStatus.TEMP
                ),
                new SkuProductRequest(
                        "상품1 - 사이즈3",
                        0,
                        0,
                        SkuProductStatus.TEMP
                )
        );
    }

    public static ProductEntity makeProductEntityInTemp() {
        ProductSaveRequest req = makeOuterProductSaveReq();
        return ProductEntity.createDefault(
                req.name(),
                req.price(),
                req.brandId(),
                null,
                null,
                null,
                null,
                null,
                req.discountMinRate(),
                req.discountMaxRate(),
                req.outboundPossibleDay(),
                DeliveryFee.findByIsFree(req.isDeliveryFree()),
                req.discountApplyPossible(),
                req.couponApplyPossible(),
                req.productType(),
                ProductStatus.TEMP,
                req.categoryInfoRequest().firstLayerCategory(),
                req.categoryInfoRequest().secondLayerCategory(),
                req.categoryInfoRequest().thirdLayerCategory(),
                null
        );
    }

    public static List<ProductSizeRequest> makeProductSizeReqs() {
        return List.of(
                new ProductSizeRequest(
                        "M",
                        "77",
                        "57",
                        "47",
                        "67",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ProductSizeType.OUTER
                ),
                new ProductSizeRequest(
                        "L",
                        "80",
                        "60",
                        "50",
                        "70",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        "",
                        ProductSizeType.OUTER
                )
        );
    }
}
