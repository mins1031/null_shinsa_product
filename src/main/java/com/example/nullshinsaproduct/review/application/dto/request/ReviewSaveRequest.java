package com.example.nullshinsaproduct.review.application.dto.request;

import java.util.List;

public record ReviewSaveRequest (
        long reviewerId,
        long orderId,
        long productId,
        String content,
        double startPoint,
        List<String> imgUrls
) {
}
