package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.common.domain.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand extends BaseEntity {

    private String name;
    private String brandPhoneNumber;

    public Brand(String name, String brandPhoneNumber) {
        this.name = name;
        this.brandPhoneNumber = brandPhoneNumber;
    }
}
