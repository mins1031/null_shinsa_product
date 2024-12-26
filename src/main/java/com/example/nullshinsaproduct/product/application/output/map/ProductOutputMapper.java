package com.example.nullshinsaproduct.product.application.output.map;

import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductOutputMapper {

    public static ProductSaveVo toProductSaveVo(ProductSaveRequest req, BrandEntity entity) {
        return new ProductSaveVo(
                req.name(),
                req.price(),
                entity.getId(),
                entity.getBrandName(),
                entity.getCorporateNumber(),
                entity.getCommunicationSellingNumber(),
                entity.getRepresentative(),
                entity.getLocation(),
                req.categoryInfoRequest().firstLayerCategory(),
                req.categoryInfoRequest().secondLayerCategory(),
                req.categoryInfoRequest().thirdLayerCategory(),
                req.couponApplyPossible(),
                req.discountApplyPossible(),
                req.discountMinRate(),
                req.discountMaxRate(),
                req.outboundPossibleDay(),
                req.isDeliveryFree(),
                req.productType()
        );
    }

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
                entity.isCanView(),
                entity.getFirstLayerCategory(),
                entity.getSecondLayerCategory(),
                entity.getThirdLayerCategory(),
                entity.getCreatedDate(),
                entity.getUpdatedDate(),
                toSkuProductDomains(entity.getSkuProductEntityList()),
                toProductSizeDomains(entity.getProductSizeEntityList()),
                toProductImageDomains(entity.getProductImageEntityList())
        );
    }

    public static List<Product> toProductDomains(List<ProductEntity> entities) {
        return entities.stream()
                .map(ProductOutputMapper::toProductDomain)
                .toList();
    }

    public static ProductEntity toProductEntity(Product domain) {
        return ProductEntity.createDefault(
                domain.getName(),
                domain.getPrice(),
                domain.getProductBrandVo().getBrandId(),
                domain.getProductBrandVo().getBrandName(),
                domain.getProductBrandVo().getCorporateNumber(),
                domain.getProductBrandVo().getCommunicationSellingNumber(),
                domain.getProductBrandVo().getRepresentative(),
                domain.getProductBrandVo().getLocation(),
                domain.getDiscountDetail().getDiscountMinRate(),
                domain.getDiscountDetail().getDiscountMaxRate(),
                domain.getProductDeliveryVo().getOutboundPossibleDay(),
                domain.getProductDeliveryVo().getDeliveryFee(),
                domain.getDiscountDetail().getDiscountApplyPossible(),
                domain.getCouponApplyPossible(),
                domain.getProductStatus(),
                domain.isCanView(),
                domain.getCategoryVo().getFirstLayerCategory(),
                domain.getCategoryVo().getSecondLayerCategory(),
                domain.getCategoryVo().getThirdLayerCategory(),
                null
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
                .map(ProductOutputMapper::toSkuProductDomain)
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
                .map(ProductOutputMapper::toProductSizeDomain)
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
                .map(ProductOutputMapper::toProductImageDomain)
                .toList();
    }


    // ======  ProductImage Mappers END ======
}
