package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.application.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
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
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
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

    @Test
    public void 상품_도메인객체를_엔티티로_변환할_수_있다() {
        //given
        ProductSaveVo productSaveVo = makeOuterProductSaveVo();
        Product product = Product.createFrom(productSaveVo);

        //when
        ProductOutputMapper productOutputMapper = ProductOutputMapper.INSTANCE;
        ProductEntity productEntity = productOutputMapper.toProductEntity(product);

        //then
        Assertions.assertEquals(product.getName(), productEntity.getName());
        Assertions.assertEquals(product.getPrice(), productEntity.getPrice());
        Assertions.assertEquals(product.getCategoryVo().getFirstLayerCategory(), productEntity.getFirstLayerCategory());
        Assertions.assertEquals(product.getCategoryVo().getSecondLayerCategory(), productEntity.getSecondLayerCategory());
        Assertions.assertEquals(product.getCategoryVo().getThirdLayerCategory(), productEntity.getThirdLayerCategory());
        Assertions.assertEquals(product.getCouponApplyPossible(), productEntity.getCouponApplyPossible());
        Assertions.assertEquals(product.getDiscountDetail().getDiscountApplyPossible(), productEntity.getDiscountApplyPossible());
        Assertions.assertEquals(product.getDiscountDetail().getDiscountMinRate(), productEntity.getDiscountMinRate());
        Assertions.assertEquals(product.getDiscountDetail().getDiscountMaxRate(), productEntity.getDiscountMaxRate());
        Assertions.assertEquals(product.getProductDeliveryVo().getOutboundPossibleDay(), productEntity.getOutboundPossibleDay());
        Assertions.assertEquals(product.getProductDeliveryVo().getDeliveryFee(), productEntity.getDeliveryFee());
        Assertions.assertEquals(product.getProductStatus(), ProductStatus.TEMP);
        Assertions.assertNull(productEntity.getSkuProductEntityList());
        Assertions.assertNull(productEntity.getProductSizeEntityList());
        Assertions.assertNull(productEntity.getProductImageEntityList());
    }

    @Test
    public void 상품_엔티티를_도메인객체로_변환할_수_있다() {
//        //given
//        ProductEntity entity = ProductEntity.createDefault(
//                "test 상품",
//                100000,
//                1L,
//                "브랜드명",
//                "브랜드 넘버",
//                "브랜드 판매번호",
//                "??",
//                "사무실 위치",
//                3,
//                20,
//                3,
//                DeliveryFee.FREE,
//                DiscountApplyPossible.POSSIBLE,
//                CouponApplyPossible.POSSIBLE,
//                ProductType.CLOTHES,
//                ProductStatus.TEMP,
//                FirstLayerCategory.MEN,
//                SecondLayerCategory.OUTER,
//                ThirdLayerCategory.CARDIGAN,
//                null
//        );
//
//        //when
//        ProductOutputMapper productOutputMapper = ProductOutputMapper.INSTANCE;
//        Product product = productOutputMapper.toProductDomain(entity);
//
//        //then
//        Assertions.assertEquals(entity.getName(), product.getName());
//        Assertions.assertEquals(entity.getPrice(), product.getPrice());
//        Assertions.assertEquals(entity.getFirstLayerCategory(), product.getCategoryVo().getFirstLayerCategory());
//        Assertions.assertEquals(entity.getSecondLayerCategory(), product.getCategoryVo().getSecondLayerCategory());
//        Assertions.assertEquals(entity.getThirdLayerCategory(), product.getCategoryVo().getThirdLayerCategory());
//        Assertions.assertEquals(entity.getCouponApplyPossible(), product.getCouponApplyPossible());
//        Assertions.assertEquals(entity.getDiscountApplyPossible(), product.getDiscountDetail().getDiscountApplyPossible());
//        Assertions.assertEquals(entity.getDiscountMinRate(), product.getDiscountDetail().getDiscountMinRate());
//        Assertions.assertEquals(entity.getDiscountMaxRate(), product.getDiscountDetail().getDiscountMaxRate());
//        Assertions.assertEquals(entity.getOutboundPossibleDay(), product.getProductDeliveryVo().getOutboundPossibleDay());
//        Assertions.assertEquals(entity.getDeliveryFee(), product.getProductDeliveryVo().getDeliveryFee());
//        Assertions.assertEquals(entity.getProductStatus(), product.getProductStatus());
//        Assertions.assertNull(product.getProductSizes());
//        Assertions.assertNull(product.getSkuProductList());
//        Assertions.assertNull(product.getProductImageList());
    }

    @Test
    public void 상품SKU_요청DTO_리스트를_도메인객체_리스트로_변환할_수_있다() {
        //given
        List<SkuProductRequest> skuProductRequests = List.of(
                new SkuProductRequest(
                        "sku - 1 - (Green)",
                        0,
                        0,
                        SkuProductStatus.TEMP
                ),
                new SkuProductRequest(
                        "sku - 2 - (Blue)",
                        0,
                        0,
                        SkuProductStatus.TEMP
                )
        );

        //when
        ProductOutputMapper productOutputMapper = ProductOutputMapper.INSTANCE;
        List<SkuProduct> skuProducts = productOutputMapper.toSkuProducts(1L, skuProductRequests);

        //then
        Assertions.assertEquals(skuProducts.get(0).getName(), skuProductRequests.get(0).name());
        Assertions.assertEquals(skuProducts.get(0).getStock(), skuProductRequests.get(0).stock());
        Assertions.assertEquals(skuProducts.get(0).getPlusPrice(), skuProductRequests.get(0).plusPrice());
        Assertions.assertEquals(skuProducts.get(0).getSkuProductStatus(), skuProductRequests.get(0).skuProductStatus());
        Assertions.assertEquals(skuProducts.get(0).getParentProductId(), 1L);
        Assertions.assertEquals(skuProducts.get(1).getName(), skuProductRequests.get(1).name());
        Assertions.assertEquals(skuProducts.get(1).getStock(), skuProductRequests.get(1).stock());
        Assertions.assertEquals(skuProducts.get(1).getPlusPrice(), skuProductRequests.get(1).plusPrice());
        Assertions.assertEquals(skuProducts.get(1).getSkuProductStatus(), skuProductRequests.get(1).skuProductStatus());
        Assertions.assertEquals(skuProducts.get(1).getParentProductId(), 1L);
    }


    private ProductSaveVo makeOuterProductSaveVo() {
        return new ProductSaveVo(
                "test 상품",
                100000,
                FirstLayerCategory.MEN,
                SecondLayerCategory.OUTER,
                ThirdLayerCategory.CARDIGAN,
                CouponApplyPossible.POSSIBLE,
                DiscountApplyPossible.POSSIBLE,
                3,
                20,
                3,
                true,
                ProductType.CLOTHES
        );
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