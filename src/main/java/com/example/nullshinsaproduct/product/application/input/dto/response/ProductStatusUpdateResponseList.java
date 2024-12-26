package com.example.nullshinsaproduct.product.application.input.dto.response;

import java.util.List;

public record ProductStatusUpdateResponseList(
        List<ProductStatusUpdateResponse> responses
) {

    public static ProductStatusUpdateResponseList of(List<ProductStatusUpdateResponse> responses) {
        return new ProductStatusUpdateResponseList(responses);
    }
}
