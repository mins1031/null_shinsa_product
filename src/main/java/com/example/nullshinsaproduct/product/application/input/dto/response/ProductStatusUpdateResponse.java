package com.example.nullshinsaproduct.product.application.input.dto.response;

import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;

public record ProductStatusUpdateResponse(
        Long id,
        String name,
        ProductStatus toStatus,
        boolean isSuccess,
        String failReason
) {

    public static ProductStatusUpdateResponse of(
            Long id,
            String name,
            ProductStatus toStatus,
            boolean isSuccess,
            String failReason
    ) {
        return new ProductStatusUpdateResponse(
                 id,
                 name,
                 toStatus,
                isSuccess,
                failReason
        );
    }
}
