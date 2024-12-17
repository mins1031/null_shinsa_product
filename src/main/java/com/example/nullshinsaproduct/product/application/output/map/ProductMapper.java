package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product toProductDomain(ProductEntity entity) {
        return Product.of(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getBrandId(),
                entity.getBrandName(),
                entity.getCorporateNumber(),
                entity.getCommunicationSellingNumber(),
                entity.getRepresentative(),
                entity.getLocation(),
                entity.getDiscountMinRate(),
                entity.getDiscountMaxRate(),
                entity.getOutboundPossibleDay(),
                entity.getDeliveryFee(),
                entity.getDiscountApplyPossible(),
                entity.getCouponApplyPossible(),
                entity.getProductStatus(),
                entity.getFirstLayerCategory(),
                entity.getSecondLayerCategory(),
                entity.getThirdLayerCategory(),
                toSkuProductDomains(entity.getSkuProductEntityList()),
                toProductSizeDomains(entity.getProductSizeEntityList()),
                toProductImageDomains(entity.getProductImageEntityList())
        );
    }


    // ======  SkuProduct Mappers START ======
    public static SkuProduct toSkuProduct(long parentProductId, SkuProductRequest request) {
        return SkuProduct.createDefault(
                parentProductId,
                request.name(),
                request.stock(),
                request.plusPrice(),
                request.skuProductStatus()
        );
    }

    public static List<SkuProduct> toSkuProducts(long parentProductId, List<SkuProductRequest> requests) {
        return requests.stream()
                .map(request -> toSkuProduct(parentProductId, request))
                .toList();
    }

    public static SkuProduct toSkuProductDomain(SkuProductEntity skuProduct) {
        return SkuProduct.of(
                skuProduct.getId(),
                skuProduct.getProduct().getId(),
                skuProduct.getName(),
                skuProduct.getStock(),
                skuProduct.getPlusPrice(),
                skuProduct.getSkuProductStatus()
        );
    }

    public static List<SkuProduct> toSkuProductDomains(List<SkuProductEntity> skuProducts) {
        if (CollectionUtils.isEmpty(skuProducts)) {
            return new ArrayList<>();
        }

        return skuProducts.stream()
                .map(ProductMapper::toSkuProductDomain)
                .toList();
    }

    public static SkuProductEntity toSkuProductEntity(SkuProduct skuProduct, ProductEntity product) {
        return SkuProductEntity.createSkuProduct(
                product,
                skuProduct.getName(),
                skuProduct.getStock(),
                skuProduct.getPlusPrice(),
                skuProduct.getSkuProductStatus()
        );
    }

    public static List<SkuProductEntity> toSkuProductEntities(List<SkuProduct> skuProducts, ProductEntity product) {
        if (CollectionUtils.isEmpty(skuProducts)) {
            return new ArrayList<>();
        }

        return skuProducts.stream()
                .map(domain -> toSkuProductEntity(domain, product))
                .toList();
    }

    // ======  SkuProduct Mappers END ======


    // ======  ProductSize Mappers START ======

    public static ProductSize toProductSizeDomain(ProductSizeEntity productSize) {
        return ProductSize.of(
                productSize.getId(),
                productSize.getProduct().getId(),
                productSize.getSizeName(),
                productSize.getProductSizeType(),
                productSize.getTotalLength(),
                productSize.getShoulder(),
                productSize.getChest(),
                productSize.getSleeve(),
                productSize.getWaist(),
                productSize.getCrotch(),
                productSize.getHip(),
                productSize.getThigh(),
                productSize.getHem(),
                productSize.getWidth(),
                productSize.getHeight(),
                productSize.getDepth()
        );
    }

    public static List<ProductSize> toProductSizeDomains(List<ProductSizeEntity> sizeEntities) {
        if (CollectionUtils.isEmpty(sizeEntities)) {
            return new ArrayList<>();
        }

        return sizeEntities.stream()
                .map(ProductMapper::toProductSizeDomain)
                .toList();
    }

    public static ProductSizeEntity toProductSizeEntity(ProductSize productSize, ProductEntity product) {
        return ProductSizeEntity.of(
                productSize.getSizeName(),
                productSize.getTotalLength(),
                productSize.getShoulder(),
                productSize.getChest(),
                productSize.getSleeve(),
                productSize.getWaist(),
                productSize.getCrotch(),
                productSize.getHip(),
                productSize.getThigh(),
                productSize.getHem(),
                productSize.getWidth(),
                productSize.getHeight(),
                productSize.getDepth(),
                productSize.getProductSizeType(),
                product
        );
    }

    public static List<ProductSizeEntity> toProductSizeEntities(List<ProductSize> productSizes, ProductEntity product) {
        if (CollectionUtils.isEmpty(productSizes)) {
            return new ArrayList<>();
        }

        return productSizes.stream()
                .map(domain -> toProductSizeEntity(domain, product))
                .toList();
    }

    // ======  ProductSize Mappers END ======


    // ======  ProductImage Mappers START ======


    public static ProductImageEntity toProductImageEntity(ProductImage productImage, ProductEntity product) {
        return ProductImageEntity.of(
                productImage.getImageUrl(),
                productImage.getImageType(),
                product
        );
    }

    public static List<ProductImageEntity> toProductImageEntities(List<ProductImage> productImages, ProductEntity product) {
        if (CollectionUtils.isEmpty(productImages)) {
            return new ArrayList<>();
        }

        return productImages.stream()
                .map(domain -> toProductImageEntity(domain, product))
                .toList();
    }


    public static ProductImage toProductImageDomain(ProductImageEntity imageEntity) {
        return ProductImage.of(
                imageEntity.getId(),
                imageEntity.getProduct().getId(),
                imageEntity.getImageUrl(),
                imageEntity.getImageType()
        );
    }

    public static List<ProductImage> toProductImageDomains(List<ProductImageEntity> imageEntities) {
        if (CollectionUtils.isEmpty(imageEntities)) {
            return new ArrayList<>();
        }

        return imageEntities.stream()
                .map(ProductMapper::toProductImageDomain)
                .toList();
    }


    // ======  ProductImage Mappers END ======
}
