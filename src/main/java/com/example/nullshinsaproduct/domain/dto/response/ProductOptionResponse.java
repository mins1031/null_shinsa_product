package com.example.nullshinsaproduct.domain.dto.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProductOptionResponse {
    private String color;
    private String size;
    private String length;
    private String shoulder;
    private String chest;
    private String sleeve;
    private String waist;
    private String crotch;
    private String hip;
    private String thigh;
    private String hem;
    private int stock;

    public ProductOptionResponse(
            String color,
            String size,
            String length,
            String shoulder,
            String chest,
            String sleeve,
            String waist,
            String crotch,
            String hip,
            String thigh,
            String hem,
            int stock
    ) {
        this.color = color;
        this.size = size;
        this.length = length;
        this.shoulder = shoulder;
        this.chest = chest;
        this.sleeve = sleeve;
        this.waist = waist;
        this.crotch = crotch;
        this.hip = hip;
        this.thigh = thigh;
        this.hem = hem;
        this.stock = stock;
    }
}
