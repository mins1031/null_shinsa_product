package com.example.nullshinsaproduct.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public record ProductSizeRequest (
    String length,
    String shoulder,
    String chest,
    String sleeve,
    String waist,
    String crotch,
    String hip,
    String thigh,
    String hem
) {
}
