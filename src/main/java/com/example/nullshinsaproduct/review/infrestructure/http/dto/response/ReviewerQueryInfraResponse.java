package com.example.nullshinsaproduct.review.infrestructure.http.dto.response;

public record ReviewerQueryInfraResponse(
        Long memberId,
        String name,
        String height,
        String weight
) {
}

