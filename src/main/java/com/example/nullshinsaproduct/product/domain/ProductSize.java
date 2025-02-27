package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ProductSize {
    private final Long id;
    private Long productId;
    private String sizeName;
    private ProductSizeType productSizeType;
    private String totalLength;
    private String shoulder; // 어깨너비
    private String chest; // 가슴단면
    private String sleeve; // 소매길이
    private String waist; // 허리
    private String crotch; // 밑위
    private String hip; // 엉덩이 단면
    private String thigh; // 허벅지 단면
    private String hem; // 밑단
    private String width; // 너비
    private String height; // 높이
    private String depth; // 폭(깊이)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Builder
    private ProductSize(
            Long id,
            Long productId,
            String sizeName,
            ProductSizeType productSizeType,
            String totalLength,
            String shoulder,
            String chest,
            String sleeve,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem,
            String width,
            String height,
            String depth,
            LocalDateTime createdDate,
            LocalDateTime updatedDate
    ) {
        this.id = id;
        this.productId = productId;
        this.sizeName = sizeName;
        this.productSizeType = productSizeType;
        this.totalLength = totalLength;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public static ProductSize of(
            Long id,
            Long productId,
            String sizeName,
            ProductSizeType productSizeType,
            String totalLength,
            String shoulder,
            String chest,
            String sleeve,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem,
            String width,
            String height,
            String depth
    ) {
        return new ProductSize(
                id,
                productId,
                sizeName,
                productSizeType,
                totalLength,
                shoulder,
                chest,
                sleeve,
                waist,
                crotch,
                hip,
                thigh,
                hem,
                width,
                height,
                depth,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public static ProductSize createOuter(ProductSizeRequest req, Long productId) {
        return ProductSize.builder()
                .totalLength(req.totalLength())
                .shoulder(req.shoulder())
                .chest(req.chest())
                .sleeve(req.sleeve())
                .productId(productId)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static ProductSize createTop(ProductSizeRequest req, Long productId) {
        return ProductSize.builder()
                .totalLength(req.totalLength())
                .shoulder(req.shoulder())
                .chest(req.chest())
                .sleeve(req.sleeve())
                .productId(productId)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static ProductSize createBottom(ProductSizeRequest req, Long productId) {
        return ProductSize.builder()
                .totalLength(req.totalLength())
                .waist(req.waist())
                .crotch(req.crotch())
                .hip(req.hip())
                .thigh(req.thigh())
                .hem(req.hem())
                .productId(productId)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static ProductSize createDress(ProductSizeRequest req, Long productId) {
        return ProductSize.builder()
                .totalLength(req.totalLength())
                .shoulder(req.shoulder())
                .chest(req.chest())
                .sleeve(req.sleeve())
                .hip(req.hip())
                .productId(productId)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static ProductSize createSkirt(ProductSizeRequest req, Long productId) {
        return ProductSize.builder()
                .totalLength(req.totalLength())
                .waist(req.waist())
                .hip(req.hip())
                .hem(req.hem())
                .productId(productId)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static ProductSize createShoe(ProductSizeRequest req, Long productId) {
        return ProductSize.builder()
                .totalLength(req.totalLength())
                .productId(productId)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }

    public static ProductSize createBag(ProductSizeRequest req, Long productId) {
        return ProductSize.builder()
                .width(req.width())
                .height(req.height())
                .depth(req.depth())
                .productId(productId)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
