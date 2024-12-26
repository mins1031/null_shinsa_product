package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkuProductTest {
    private SkuProduct skuProduct;

    @BeforeEach
    void setUp() {
        this.skuProduct = SkuProduct.createDefault(
                null,
                "Sku",
                0,
                0,
                SkuProductStatus.TEMP
        );
    }

    @Test
    void 스큐상품의_상태를_승인완료로_변경할_수_있다() {
        //given
        //when
        skuProduct.updateApproveStatus();

        //then
        Assertions.assertEquals(SkuProductStatus.APPROVE, skuProduct.getSkuProductStatus());
    }

    @Test
    void 예외_스큐상품의_상태가_승인전이_아니라면_승인완료로_변경할_수_없다() {
        //given
        //when
        skuProduct.updateApproveStatus();

        //then
        Assertions.assertThrows(ProductException.class, () -> skuProduct.updateApproveStatus());
    }
}