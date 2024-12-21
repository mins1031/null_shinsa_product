package com.example.nullshinsaproduct.product.domain.service;

import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class ProductImageDomainServiceTest {

    @Test
    void 상품이미지_도메인객체를_생성할_수_있다() {
        //given
        ProductImageDomainService productImageDomainService = new ProductImageDomainService();
        String thumbnail = "http://thumbnail.co.kr";
        List<String> profileList = List.of(
                "http://profile1.co.kr",
                "http://profile2.co.kr"
        );
        List<String> detailList = List.of(
                "http://detail1.co.kr",
                "http://detail2.co.kr"
        );
        long productId = 1L;

        //when
        List<ProductImage> productImages = productImageDomainService.generateProductImages(thumbnail, profileList, detailList, productId);

        //then
        Assertions.assertEquals(productImages.get(0).getImageUrl(), thumbnail);
        Assertions.assertEquals(productImages.get(0).getProductId(), productId);
        Assertions.assertEquals(productImages.get(0).getImageType(), ImageType.THUMBNAIL);

        Assertions.assertEquals(productImages.get(1).getImageUrl(), profileList.get(0));
        Assertions.assertEquals(productImages.get(1).getProductId(), productId);
        Assertions.assertEquals(productImages.get(1).getImageType(), ImageType.PROFILE);
        Assertions.assertEquals(productImages.get(2).getImageUrl(), profileList.get(1));
        Assertions.assertEquals(productImages.get(2).getProductId(), productId);
        Assertions.assertEquals(productImages.get(2).getImageType(), ImageType.PROFILE);

        Assertions.assertEquals(productImages.get(3).getImageUrl(), detailList.get(0));
        Assertions.assertEquals(productImages.get(3).getProductId(), productId);
        Assertions.assertEquals(productImages.get(3).getImageType(), ImageType.DETAIL);
        Assertions.assertEquals(productImages.get(4).getImageUrl(), detailList.get(1));
        Assertions.assertEquals(productImages.get(4).getProductId(), productId);
        Assertions.assertEquals(productImages.get(4).getImageType(), ImageType.DETAIL);
    }
}