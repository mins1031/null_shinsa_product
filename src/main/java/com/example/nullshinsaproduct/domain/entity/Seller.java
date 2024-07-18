package com.example.nullshinsaproduct.domain.entity;

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
public class Seller extends BaseEntity {

    private String name;
    private String sellerPhoneNumber;

    public Seller(String name, String sellerPhoneNumber) {
        this.name = name;
        this.sellerPhoneNumber = sellerPhoneNumber;
    }
}
