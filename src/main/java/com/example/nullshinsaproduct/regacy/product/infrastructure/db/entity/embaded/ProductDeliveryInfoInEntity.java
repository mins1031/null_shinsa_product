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
public class ProductDeliveryInfoInEntity {
    private int outboundPossibleDay;
    private DeliveryFee deliveryFee;

    private ProductDeliveryInfoInEntity(int outboundPossibleDay, DeliveryFee deliveryFee) {
        this.outboundPossibleDay = outboundPossibleDay;
        this.deliveryFee = deliveryFee;
    }

    public static ProductDeliveryInfoInEntity createFreeDelivery() {
        return new ProductDeliveryInfoInEntity(3, DeliveryFee.FREE);
    }

    public static ProductDeliveryInfoInEntity createSpecialDelivery() {
        return new ProductDeliveryInfoInEntity(4, DeliveryFee.NOT_FREE);
    }

}