package com.example.nullshinsaproduct.product.domain.service;


import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;

import java.util.List;
import java.util.stream.Stream;

public class ProductImageDomainService {

    public List<ProductImage> generateProductImages(
            String thumbnailLink,
            List<String> profileLinks,
            List<String> detailLinks,
            long productId
    ) {
        ProductImage thumbnail = ProductImage.of(productId, thumbnailLink, ImageType.THUMBNAIL);
        List<ProductImage> profileImages = profileLinks.stream()
                .map(link -> ProductImage.of(productId, link, ImageType.PROFILE))
                .toList();
        List<ProductImage> detailPageImages = detailLinks.stream()
                .map(link -> ProductImage.of(productId, link, ImageType.DETAIL))
                .toList();

        return Stream.concat(
                Stream.concat(
                        Stream.of(thumbnail),
                        profileImages.stream()
                ),
                detailPageImages.stream()
        ).toList();
    }
}
