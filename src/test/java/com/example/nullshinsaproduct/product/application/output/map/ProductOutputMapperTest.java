package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.application.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProductOutputMapperTest {

    @Test
    public void 상품저장_DTO를_VO로_변환할_수_있다() {
        //given
        ProductSaveRequest productSaveRequest = makeOuterProductSaveReq();

        //when
        ProductOutputMapper productOutputMapper = ProductOutputMapper.INSTANCE;
        ProductSaveVo productSaveVo = productOutputMapper.toProductSaveVo(productSaveRequest);

        //then
        Assertions.assertEquals(productSaveRequest.name(), productSaveVo.name());
        Assertions.assertEquals(productSaveRequest.price(), productSaveVo.price());
        Assertions.assertEquals(productSaveRequest.categoryInfoRequest().firstLayerCategory(), productSaveVo.firstLayerCategory());
        Assertions.assertEquals(productSaveRequest.categoryInfoRequest().secondLayerCategory(), productSaveVo.secondLayerCategory());
        Assertions.assertEquals(productSaveRequest.categoryInfoRequest().thirdLayerCategory(), productSaveVo.thirdLayerCategory());
        Assertions.assertEquals(productSaveRequest.couponApplyPossible(), productSaveVo.couponApplyPossible());
        Assertions.assertEquals(productSaveRequest.discountApplyPossible(), productSaveVo.discountApplyPossible());
        Assertions.assertEquals(productSaveRequest.discountMinRate(), productSaveVo.discountMinRate());
        Assertions.assertEquals(productSaveRequest.discountMaxRate(), productSaveVo.discountMaxRate());
        Assertions.assertEquals(productSaveRequest.outboundPossibleDay(), productSaveVo.outboundPossibleDay());
        Assertions.assertEquals(productSaveRequest.isDeliveryFree(), productSaveVo.isDeliveryFree());
        Assertions.assertEquals(productSaveRequest.productType(), productSaveVo.productType());
    }

    private ProductSaveRequest makeOuterProductSaveReq() {
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
                List.of(
                        new SkuProductRequest(
                                "상품1 - 사이즈1",
                                0,
                                5000,
                                SkuProductStatus.TEMP
                        )
                ),
                ProductType.CLOTHES
        );
    }
}