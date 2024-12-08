package com.example.nullshinsaproduct.product.domain.vo;

import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import lombok.Getter;

@Getter
public class ProductDeliveryVo {
    private final int outboundPossibleDay;
    private final DeliveryFee deliveryFee;

    public ProductDeliveryVo(int outboundPossibleDay, DeliveryFee deliveryFee) {
        this.outboundPossibleDay = outboundPossibleDay;
        this.deliveryFee = deliveryFee;
    }

    public static ProductDeliveryVo createAs(boolean isDeliveryFree) {
        if (isDeliveryFree) {
            return createFreeDelivery();
        }

        return createSpecialDelivery();
    }

    public static ProductDeliveryVo createFreeDelivery() {
        return new ProductDeliveryVo(3, DeliveryFee.FREE);
    }

    public static ProductDeliveryVo createSpecialDelivery() {
        return new ProductDeliveryVo(4, DeliveryFee.NOT_FREE);
    }
}
