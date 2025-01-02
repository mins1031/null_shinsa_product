package com.example.nullshinsaproduct.review.domain;

import lombok.Getter;

@Getter
public class Reviewer {
    private Long memberId;
    private String name;
    private String height;
    private String weight;

    private Reviewer(Long memberId, String name, String height, String weight) {
        this.memberId = memberId;
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public static Reviewer of(Long memberId, String name, String height, String weight) {
        return new Reviewer(
                memberId,
                name,
                height,
                weight
        );
    }
}
