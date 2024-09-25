package com.example.nullshinsaproduct.application.mapper;

import com.example.nullshinsaproduct.application.dto.response.BrandResponse;
import com.example.nullshinsaproduct.application.dto.response.CategoryResponse;
import com.example.nullshinsaproduct.application.dto.response.ProductImageResponse;
import com.example.nullshinsaproduct.application.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.application.dto.response.ProductResponse;
import com.example.nullshinsaproduct.application.dto.response.ProductSizeResponse;
import com.example.nullshinsaproduct.application.dto.request.ProductDetailRequest;
import com.example.nullshinsaproduct.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.application.dto.response.ProductDetailResponse;
import com.example.nullshinsaproduct.application.dto.response.ProductSizeVo;
import com.example.nullshinsaproduct.application.dto.response.SkuProductResponse;
import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.ProductImage;
import com.example.nullshinsaproduct.domain.product.entity.SkuProduct;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.ImageType;
import com.example.nullshinsaproduct.infrastructure.repository.vo.ProductDetailVo;
import com.example.nullshinsaproduct.infrastructure.repository.vo.ProductImageVo;
import com.example.nullshinsaproduct.infrastructure.repository.vo.ProductOverviewVo;
import com.example.nullshinsaproduct.infrastructure.repository.vo.SkuProductVo;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
                product
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

    public static ProductQueryResponse mapProductOverviewToRes(
            final ProductOverviewVo overviewVo,
            final BrandResponse brandResponse
    ) {
        if (Objects.isNull(overviewVo)) {
            return null;
        }

        return new ProductQueryResponse(
                mapProductVoToRes(overviewVo),
                mapProductDetailVoToRes(overviewVo.productDetailVo()),
                CategoryMapper.mapProductDetailVoToRes(overviewVo.categoryVo()),
                brandResponse,
                mapSkuVoToSkuRes(overviewVo.skuProductVoList()),
                mapProductSizeVosToSkuRes(overviewVo.sizeVoList()),
                mapProductImgVosToImgRes(overviewVo.productImageList())
        );
    }

    public static ProductResponse mapProductVoToRes(final ProductOverviewVo overviewVo) {
        if (Objects.isNull(overviewVo)) {
            return null;
        }

        return new ProductResponse(
                overviewVo.productId(),
                overviewVo.name(),
                overviewVo.price(),
                overviewVo.outboundPossibleDay(),
                overviewVo.deliveryFee(),
                overviewVo.couponApplyPossible(),
                overviewVo.discountApplyPossible(),
                overviewVo.discountMinRate(),
                overviewVo.discountMaxRate(),
                overviewVo.productType(),
                overviewVo.productCreatedDate(),
                overviewVo.productUpdatedDate()
        );
    }
    public static ProductDetailResponse mapProductDetailVoToRes(final ProductDetailVo detailVo) {
        if (Objects.isNull(detailVo)) {
            return null;
        }

        return new ProductDetailResponse(
                detailVo.id(),
                detailVo.productId(),
                detailVo.manufacturingCountry(),
                detailVo.manufacturingCompany(),
                detailVo.manufacturingDate(),
                detailVo.qualityGuarantee(),
                detailVo.fabric(),
                detailVo.measurement(),
                detailVo.washCaution(),
                detailVo.productInnerItems(),
                detailVo.asOfficerAndTel(),
                detailVo.detailContent(),
                detailVo.brandDetailContent(),
                detailVo.adminDetailContent()
        );
    }


    public static List<SkuProductResponse> mapSkuVoToSkuRes(final List<SkuProductVo> skuProductVos) {
        if (CollectionUtils.isEmpty(skuProductVos)) {
            return new ArrayList<>();
        }

        return skuProductVos.stream()
                .map(
                        vo -> new SkuProductResponse(
                                vo.id(),
                                vo.createdDate(),
                                vo.updatedDate(),
                                vo.color(),
                                vo.size(),
                                vo.stock(),
                                vo.startPoint(),
                                vo.discountRate(),
                                vo.productStatus(),
                                vo.getProductId()
                        )
                ).collect(Collectors.toList());
    }

    public static List<ProductSizeResponse> mapProductSizeVosToSkuRes(final List<ProductSizeVo> sizeVos) {
        if (CollectionUtils.isEmpty(sizeVos)) {
            return new ArrayList<>();
        }

        return sizeVos.stream()
                .map(
                        vo -> new ProductSizeResponse(
                                vo.sizeId(),
                                vo.createdDate(),
                                vo.updatedDate(),
                                vo.sizeName(),
                                vo.productSizeType(),
                                vo.length(),
                                vo.shoulder(),
                                vo.chest(),
                                vo.sleeve(),
                                vo.waist(),
                                vo.crotch(),
                                vo.hip(),
                                vo.thigh(),
                                vo.hem(),
                                vo.getProductId()
                        )
                ).collect(Collectors.toList());
    }

    public static List<ProductImageResponse> mapProductImgVosToImgRes(final List<ProductImageVo> imageVos) {
        if (CollectionUtils.isEmpty(imageVos)) {
            return new ArrayList<>();
        }

        return imageVos.stream()
                .map(
                        vo -> new ProductImageResponse(
                                vo.id(),
                                vo.createdDate(),
                                vo.updatedDate(),
                                vo.imageUrl(),
                                vo.imageType(),
                                vo.getProductId()
                        )
                ).collect(Collectors.toList());
    }
}
