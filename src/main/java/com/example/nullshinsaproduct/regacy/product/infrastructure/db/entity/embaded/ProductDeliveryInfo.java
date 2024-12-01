package com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded;

import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDeliveryInfo {
    private int outboundPossibleDay;
    private DeliveryFee deliveryFee;

    private ProductDeliveryInfo(int outboundPossibleDay, DeliveryFee deliveryFee) {
        this.outboundPossibleDay = outboundPossibleDay;
        this.deliveryFee = deliveryFee;
    }

    public static ProductDeliveryInfo createFreeDelivery() {
        return new ProductDeliveryInfo(3, DeliveryFee.FREE);
    }

    public static ProductDeliveryInfo createSpecialDelivery() {
        return new ProductDeliveryInfo(4, DeliveryFee.NOT_FREE);
    }

}
