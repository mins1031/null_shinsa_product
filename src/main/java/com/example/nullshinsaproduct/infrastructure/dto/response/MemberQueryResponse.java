package com.example.nullshinsaproduct.infrastructure.dto.response;

public record MemberQueryResponse (
        Long memberId,
        String name,
        String height,
        String weight
) {
}

