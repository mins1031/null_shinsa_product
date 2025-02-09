package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.application.input.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProductOutputStructMapperTest {

    @Test
    public void 상품_도메인객체를_엔티티로_변환할_수_있다() {
        //given
        ProductSaveVo productSaveVo = makeOuterProductSaveVo();
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

    private ProductSaveVo makeOuterProductSaveVo() {
        return new ProductSaveVo(
                "test 상품",
                100000,
                1L,
                "brandName",
                "corporateNum",
                "sellingNum",
                "represetative",
                "location",
                FirstLayerCategory.MEN,
                SecondLayerCategory.OUTER,
                ThirdLayerCategory.CARDIGAN,
                CouponApplyPossible.POSSIBLE,
                DiscountApplyPossible.POSSIBLE,
                8,
                3,
                20,
                3,
                true,
                ProductType.CLOTHES
        );
    }
}