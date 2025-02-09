package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.product.common.helper.ProductTestHelper;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        this.product = Product.createFrom(
                ProductTestHelper.makeOuterProductSaveVo()
        );
        SkuProduct sku = SkuProduct.createDefault(
                null,
                "Sku",
                0,
                0,
                SkuProductStatus.TEMP
        );
        product.updateRelatedSkus(
                List.of(sku)
        );
    }

    @Test
    void 상품을_승인완료_상태로_변경할_시_상태와_조회가능여부가_변경된다() {
        //given
        //when
        product.updateApproveStatus();

        //then
        Assertions.assertEquals(ProductStatus.APPROVE, product.getProductStatus());
        Assertions.assertTrue(product.isCanView());
        Assertions.assertEquals(SkuProductStatus.APPROVE, product.getSkuProductList().get(0).getSkuProductStatus());

    }

    @Test
    void 예외_상품이_승인전_상태가_아니면_승인완료로_변경할_수_없다() {
        //given
        //when
        product.updateApproveStatus();

        //then
        Assertions.assertThrows(ProductException.class, () -> product.updateApproveStatus());
    }

    @Test
    void 상품이_승인전_상태면_조회할_수_없다() {
        //given
        //when
        //then
        Assertions.assertTrue(product.isNotFindStatus());
    }

    @Test
    void 상품이_승인전_상태가_아니라면_조회할_수_있다() {
        //given
        //when
        product.updateApproveStatus();

        //then
        Assertions.assertFalse(product.isNotFindStatus());
    }

}