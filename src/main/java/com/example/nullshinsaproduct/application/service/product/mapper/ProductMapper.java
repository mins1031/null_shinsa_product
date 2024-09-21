package com.example.nullshinsaproduct.application.service.product.mapper;

import com.example.nullshinsaproduct.domain.dto.request.ProductDetailRequest;
import com.example.nullshinsaproduct.domain.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.ProductImage;
import com.example.nullshinsaproduct.domain.product.entity.SkuProduct;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.ImageType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDetail mapFromReqToProductDetail(ProductDetailRequest req, Product product) {
        return new ProductDetail(
                req.manufacturingCountry(),
                req.manufacturingCompany(),
                req.manufacturingDate(),
                req.qualityGuarantee(),
                req.fabric(),
                req.measurement(),
                req.washCaution(),
                req.productInnerItems(),
                req.asOfficerAndTel(),
                req.detailContent(),
                req.brandDetailContent(),
                req.adminDetailContent(),
                product.getId()
        );
    }

    public static List<SkuProduct> mapFromReqsToSkuProducts(List<SkuProductRequest> req, Product product) {
        return req.stream()
                .map(sku -> SkuProduct.createSkuProduct(
                        sku.color(),
                        sku.size(),
                        sku.stock(),
                        sku.discountRate(),
                        sku.productStatus(),
                        product
                ))
                .collect(Collectors.toList());
    }

    public static List<ProductImage> mapFromReqsToProductImages(String thumbnail, List<String> titleImages, List<String> detailImages, Product product) {
        List<ProductImage> images = new ArrayList<>();
        images.add(new ProductImage(thumbnail, ImageType.THUMBNAIL, product));
        images.addAll(
                titleImages.stream()
                        .map(image -> new ProductImage(image, ImageType.TITLE, product))
                        .collect(Collectors.toList())
        );
        images.addAll(
                detailImages.stream()
                        .map(image -> new ProductImage(image, ImageType.DETAIL, product))
                        .collect(Collectors.toList())
        );

        return images;
    }
}
