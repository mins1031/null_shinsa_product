package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.common.helper.ProductTestHelper;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ProductOutputMapperTest {

    @Test
    public void 상품_도메인객체를_엔티티로_변환할_수_있다() {
        //given
        ProductSaveVo productSaveVo = ProductTestHelper.makeOuterProductSaveVo();
        Product product = Product.createFrom(productSaveVo);

        //when
        ProductEntity productEntity = ProductOutputMapper.toProductEntity(product);

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
        Assertions.assertEquals(product.getDiscountDetail().getDiscountRate(), productEntity.getDiscountRate());
        Assertions.assertEquals(product.getProductDeliveryVo().getOutboundPossibleDay(), productEntity.getOutboundPossibleDay());
        Assertions.assertEquals(product.getProductDeliveryVo().getDeliveryFee(), productEntity.getDeliveryFee());
        Assertions.assertEquals(product.getProductStatus(), ProductStatus.TEMP);
        Assertions.assertNull(productEntity.getSkuProductEntityList());
        Assertions.assertNull(productEntity.getProductSizeEntityList());
        Assertions.assertNull(productEntity.getProductImageEntityList());
    }
}