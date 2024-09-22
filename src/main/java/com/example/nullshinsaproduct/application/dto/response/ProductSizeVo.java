package com.example.nullshinsaproduct.application.dto.response;

import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.ProductBottomSize;
import com.example.nullshinsaproduct.domain.product.entity.ProductSize;
import com.example.nullshinsaproduct.domain.product.entity.ProductTopSize;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductSizeType;
import com.example.nullshinsaproduct.exception.product.ProductException;
import com.example.nullshinsaproduct.exception.product.ProductExceptionCode;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProductSizeVo(
        long sizeId,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        String sizeName,
        ProductSizeType productSizeType,
        String length,
        String shoulder,
        String chest,
        String sleeve,
        String waist,
        String crotch,
        String hip,
        String thigh,
        String hem,
        Product product
) {

    public static ProductSizeVo createVoBySizeType(ProductSize productSize) {
        if (Objects.isNull(productSize)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PARAMETER);
        }

        return switch (productSize.getProductSizeType()) {
            case TOP -> createTopSizeVo(productSize);
            case BOTTOM -> createBottomSizeVo(productSize);
            case UNDER_WEAR -> createUnderSizeVo(productSize);
        };
    }

    // Root Entity(Product)에서 생성하는 메서드
    private static ProductSizeVo createTopSizeVo(ProductSize productSize) {
        if (!(productSize instanceof ProductTopSize topSize)) {
            throw new ProductException(ProductExceptionCode.WRONG_MATCHED_PRODUCT_SIZE_TYPE);
        }

        return new ProductSizeVo(
                topSize.getId(),
                topSize.getCreatedDate(),
                topSize.getUpdatedDate(),
                topSize.getSizeName(),
                topSize.getProductSizeType(),
                topSize.getLength(),
                topSize.getShoulder(),
                topSize.getChest(),
                topSize.getSleeve(),
                null,
                null,
                null,
                null,
                null,
                topSize.getProduct()
        );
    }

    private static ProductSizeVo createBottomSizeVo(ProductSize productSize) {
        if (!(productSize instanceof ProductBottomSize bottomSize)) {
            throw new ProductException(ProductExceptionCode.WRONG_MATCHED_PRODUCT_SIZE_TYPE);
        }

        return new ProductSizeVo(
                bottomSize.getId(),
                bottomSize.getCreatedDate(),
                bottomSize.getUpdatedDate(),
                bottomSize.getSizeName(),
                bottomSize.getProductSizeType(),
                bottomSize.getLength(),
                null,
                null,
                null,
                bottomSize.getWaist(),
                bottomSize.getCrotch(),
                bottomSize.getHip(),
                bottomSize.getThigh(),
                bottomSize.getHem(),
                bottomSize.getProduct()
        );
    }

    private static ProductSizeVo createUnderSizeVo(ProductSize productSize) {
        return null;
    }

    public long getProductId() {
        return this.product.getId();
    }
}
