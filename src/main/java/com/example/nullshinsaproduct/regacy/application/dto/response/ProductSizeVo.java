package com.example.nullshinsaproduct.regacy.application.dto.response;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductBottomSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductTopSizeEntity;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;

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

    public static ProductSizeVo createVoBySizeType(ProductSizeEntity productSizeEntity) {
        if (Objects.isNull(productSizeEntity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PARAMETER);
        }

        return switch (productSizeEntity.getProductSizeType()) {
            case TOP -> createTopSizeVo(productSizeEntity);
            case BOTTOM -> createBottomSizeVo(productSizeEntity);
            case UNDER_WEAR -> createUnderSizeVo(productSizeEntity);
        };
    }

    // Root Entity(Product)에서 생성하는 메서드
    private static ProductSizeVo createTopSizeVo(ProductSizeEntity productSizeEntity) {
        if (!(productSizeEntity instanceof ProductTopSizeEntity topSize)) {
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

    private static ProductSizeVo createBottomSizeVo(ProductSizeEntity productSizeEntity) {
        if (!(productSizeEntity instanceof ProductBottomSizeEntity bottomSize)) {
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

    private static ProductSizeVo createUnderSizeVo(ProductSizeEntity productSizeEntity) {
        return null;
    }

    public long getProductId() {
        if (Objects.isNull(this.product)) {
            return 0;
        }

        return this.product.getId();
    }
}
