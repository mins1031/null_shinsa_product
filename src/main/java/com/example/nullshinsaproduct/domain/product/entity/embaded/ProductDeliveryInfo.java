package com.example.nullshinsaproduct.domain.product.entity.embaded;

import com.example.nullshinsaproduct.domain.product.enumeration.DeliveryFee;
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

    public ProductDeliveryInfo(int outboundPossibleDay, DeliveryFee deliveryFee) {
        this.outboundPossibleDay = outboundPossibleDay;
        this.deliveryFee = deliveryFee;
    }
}
