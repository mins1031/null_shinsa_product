package com.example.nullshinsaproduct.review.application.output.dto;

public record ReviewerQueryResponse(
        Long memberId,
        String name,
        String height,
        String weight
) {
}
