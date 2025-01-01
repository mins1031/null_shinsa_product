package com.example.nullshinsaproduct.review.application.dto.request;

import jakarta.validation.constraints.NotNull;

public record ReviewHeartSaveRequest(
        @NotNull(message = "하트를 누른 리뷰Id는 필수 입니다") long reviewId,
        @NotNull(message = "하트를 누른 회워Id는 필수 입니다") long heartPickerId
) {
}
