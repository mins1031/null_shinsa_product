package com.example.nullshinsaproduct.review.infrestructure.http.dto.response;

public record MemberQueryResponse (
        Long memberId,
        String name,
        String height,
        String weight
) {
}

