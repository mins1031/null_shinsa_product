package com.example.nullshinsaproduct.product.application.service;

import com.example.nullshinsaproduct.product.application.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.application.output.map.ProductEntityMapper;
import com.example.nullshinsaproduct.product.application.output.map.ProductOutputMapper;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductRepository;
import com.example.nullshinsaproduct.product.domain.Product;
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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductCommandServiceTest {
    private ProductCommandService productCommandService;

    private FakeProductRepository fakeProductRepository;

    @BeforeEach
    void setUp() {
        this.productCommandService = new ProductCommandService(
                new FakeProductRepository(),
                null,
                null,
                null,
                ProductOutputMapper.INSTANCE
        );
    }


    @Test
    void 상품_등록요청객체로_상품객체를_저장할_수_있다() {
        //given
        ProductSaveRequest productSaveRequest = makeOuterProductSaveReq();

        //when
        ProductEntity productEntity = productCommandService.saveProduct(productSaveRequest);
        Product product = ProductEntityMapper.toProductDomain(productEntity);

        //then
        assertEquals(productSaveRequest.name(), product.getName());
        assertEquals(productSaveRequest.price(), product.getPrice());
        assertEquals(productSaveRequest.categoryInfoRequest().firstLayerCategory(), product.getCategoryVo().getFirstLayerCategory());
        assertEquals(productSaveRequest.categoryInfoRequest().secondLayerCategory(), product.getCategoryVo().getSecondLayerCategory());
        assertEquals(productSaveRequest.categoryInfoRequest().thirdLayerCategory(), product.getCategoryVo().getThirdLayerCategory());
        assertEquals(productSaveRequest.couponApplyPossible(), product.getCouponApplyPossible());
        assertEquals(productSaveRequest.discountApplyPossible(), product.getDiscountDetail().getDiscountApplyPossible());
        assertEquals(productSaveRequest.discountMinRate(), product.getDiscountDetail().getDiscountMinRate());
        assertEquals(productSaveRequest.discountMaxRate(), product.getDiscountDetail().getDiscountMaxRate());
        assertEquals(productSaveRequest.outboundPossibleDay(), product.getProductDeliveryVo().getOutboundPossibleDay());
        assertEquals(DeliveryFee.findByIsFree(productSaveRequest.isDeliveryFree()), product.getProductDeliveryVo().getDeliveryFee());
        assertEquals(product.getProductStatus(), ProductStatus.TEMP);
        assertEquals(0, product.getSkuProductList().size());
        assertEquals(0, product.getProductSizes().size());
        assertEquals(0, product.getProductImageList().size());
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