package com.example.nullshinsaproduct.product.application.service;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductRepository;
import com.example.nullshinsaproduct.product.common.helper.ProductTestHelper;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProductFindServiceTest {

    private ProductFindService productFindService;

    @BeforeEach
    void setUp() {
        FakeProductRepository productRepository = new FakeProductRepository();

        ProductEntity entity = ProductTestHelper.makeProductEntityInApprove();
        productRepository.saveWithAssociations(
                entity,
                ProductTestHelper.makeSkuProductEntities(entity),
                ProductTestHelper.makeProductSizeEntities(entity),
                ProductTestHelper.makeProductImageEntities(entity)
        );
        productRepository.save(ProductTestHelper.makeProductEntityInTemp());

        this.productFindService = new ProductFindService(
                productRepository
        );
    }

    @Test
    void 상품번호로_상품을_조회할_수_있다() {
        //given
        ProductEntity productEntity = ProductTestHelper.makeProductEntityInApprove();
        List<SkuProductEntity> skuEntities = ProductTestHelper.makeSkuProductEntities(productEntity);
        List<ProductSizeEntity> sizeEntities = ProductTestHelper.makeProductSizeEntities(productEntity);
        List<ProductImageEntity> imageEntities = ProductTestHelper.makeProductImageEntities(productEntity);
        long id = 1L;

        //when
        ProductQueryResponse res = productFindService.findProductById(id);

        //then
        Assertions.assertEquals(1L, res.productResponse().productId());
        Assertions.assertEquals(productEntity.getName(), res.productResponse().name());
        Assertions.assertEquals(productEntity.getPrice(), res.productResponse().price());
        Assertions.assertEquals(productEntity.getOutboundPossibleDay(), res.productResponse().outboundPossibleDay());
        Assertions.assertEquals(productEntity.getDeliveryFee(), res.productResponse().deliveryFee());
        Assertions.assertEquals(productEntity.getCouponApplyPossible(), res.productResponse().couponApplyPossible());
        Assertions.assertEquals(productEntity.getDiscountApplyPossible(), res.productResponse().discountApplyPossible());
        Assertions.assertEquals(productEntity.getDiscountMinRate(), res.productResponse().discountMinRate());
        Assertions.assertEquals(productEntity.getDiscountMaxRate(), res.productResponse().discountMaxRate());
        Assertions.assertEquals(productEntity.getProductStatus(), res.productResponse().productStatus());

        Assertions.assertEquals(skuEntities.size(), res.skuProductResList().size());
        Assertions.assertEquals(skuEntities.get(0).getName(), res.skuProductResList().get(0).name());
        Assertions.assertEquals(skuEntities.get(0).getStock(), res.skuProductResList().get(0).stock());
        Assertions.assertEquals(skuEntities.get(0).getPlusPrice(), res.skuProductResList().get(0).plusPrice());
        Assertions.assertEquals(skuEntities.get(0).getSkuProductStatus(), res.skuProductResList().get(0).skuProductStatus());

        Assertions.assertEquals(sizeEntities.size(), res.sizeResList().size());

        Assertions.assertEquals(imageEntities.size(), res.productImageResList().size());
        Assertions.assertEquals(imageEntities.get(0).getImageUrl(), res.productImageResList().get(0).imageUrl());
        Assertions.assertEquals(imageEntities.get(0).getImageType(), res.productImageResList().get(0).imageType());
    }

    @Test
    void 승인전_상품은_조회할_수_없다() {
        //given
        long id = 2L;

        //when
        //then
        Assertions.assertThrows(ProductException.class, () -> productFindService.findProductById(id));
    }
}