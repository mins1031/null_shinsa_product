package com.example.nullshinsaproduct.sale.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@EqualsAndHashCode
public class Sale {
    private Long id;
    private String name;
    private int salePercent;
    private SaleStatus saleStatus;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    private Sale(Long id, String name, int salePercent, SaleStatus saleStatus, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.id = id;
        this.name = name;
        this.salePercent = salePercent;
        this.saleStatus = saleStatus;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public static Sale of(
            Long id,
            String  name,
            int salePercent,
            SaleStatus saleStatus,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime
    ) {
        return new Sale(
                id,
                name,
                salePercent,
                saleStatus,
                startDateTime,
                endDateTime
        );
    }

    public static Sale ofWhenSave(
            String name,
            int salePercent,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime
    ) {
        return new Sale(
                null,
                name,
                salePercent,
                SaleStatus.WAIT,
                startDateTime,
                endDateTime
        );
    }

    public void updateSale(
            String name,
            int salePercent,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime
    ) {
        if (salePercent < 0) {
            return;
        }

        this.name = name;
        this.salePercent = salePercent;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public void changeStatus(final SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public void startSale(LocalDateTime nowTime) {
        if (SaleStatus.FINISH.equals(this.saleStatus)
                || SaleStatus.ON_SALE.equals(this.saleStatus)
        ) {
            return;
        }

        if (Objects.isNull(nowTime)) {
            return;
        }

        if (this.startDateTime.isAfter(nowTime)) {
            return;
        }

        this.saleStatus = SaleStatus.ON_SALE;
    }
}
