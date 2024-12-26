package com.example.nullshinsaproduct.product.application.input.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProductStatusUpdateRequest(
        @NotNull @Size(min = 1, max = 30) List<Long> updateTargetIds
) {
}
