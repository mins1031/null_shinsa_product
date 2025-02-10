package com.example.nullshinsaproduct.sale.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode
public class SaleCacheKey implements Comparable {
    private final int salePercent;
    private final LocalDateTime saleStartTime;
    private final long saleId;

    public SaleCacheKey(int salePercent, LocalDateTime saleStartTime, long saleId) {
        this.salePercent = salePercent;
        this.saleStartTime = saleStartTime;
        this.saleId = saleId;
    }

    public static SaleCacheKey of(
            int salePercent,
            LocalDateTime regDateTime,
            long saleId
    ) {
        return new SaleCacheKey(
                salePercent,
                regDateTime,
                saleId
        );
    }

    @Override
    public int compareTo(Object o) {
        SaleCacheKey req = (SaleCacheKey) o;

        if (this.salePercent > req.getSalePercent()) {
            return 1;
        } else if (this.salePercent < req.getSalePercent()) {
            return -1;
        } else {
            int compareResult = this.saleStartTime.compareTo(req.getSaleStartTime());
            if (compareResult != 0) {
                return compareResult;
            } else {
                if (this.saleId > req.saleId) {
                    return 1;
                } else if (this.saleId < req.saleId) {
                    return -1;
                }
            }
        }

        return 0;
    }
}
