package com.example.nullshinsaproduct.sale.application.output.map;

import com.example.nullshinsaproduct.sale.domain.Sale;
import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;

public class SaleOutputMapper {

    public static Sale toDomainFromEntity(final SaleEntity entity) {
        return Sale.of(
                entity.getId(),
                entity.getName(),
                entity.getSalePercent(),
                entity.getSaleStatus(),
                entity.getStartDateTime(),
                entity.getEndDateTime()
        );
    }

    public static SaleEntity toEntityFromDomain(final Sale domain) {
        return new SaleEntity(
                domain.getId(),
                domain.getName(),
                domain.getSalePercent(),
                domain.getSaleStatus(),
                domain.getStartDateTime(),
                domain.getEndDateTime()
        );
    }
}
