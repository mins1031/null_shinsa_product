package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;

import java.util.List;

public class ProductEntityMapper {

    public static SkuProductEntity toSkuProductEntity(SkuProduct skuProduct, ProductEntity product) {
        return SkuProductEntity.createSkuProduct(
                product,
                skuProduct.getName(),
                skuProduct.getStock(),
                skuProduct.getPlusPrice(),
                skuProduct.getSkuProductStatus()
        );
    }

    public static List<SkuProductEntity> toSkuProductEntities(List<SkuProduct> skuProduct, ProductEntity product) {
        return skuProduct.stream()
                .map(domain -> toSkuProductEntity(domain, product))
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
        return productSizes.stream()
                .map(domain -> toProductSizeEntity(domain, product))
                .toList();
    }

    public static ProductImageEntity toProductImageEntity(ProductImage productImage, ProductEntity product) {
        return ProductImageEntity.of(
                productImage.getImageUrl(),
                productImage.getImageType(),
                product
        );
    }

    public static List<ProductImageEntity> toProductImageEntities(List<ProductImage> productImages, ProductEntity product) {
        return productImages.stream()
                .map(domain -> toProductImageEntity(domain, product))
                .toList();
    }
}
