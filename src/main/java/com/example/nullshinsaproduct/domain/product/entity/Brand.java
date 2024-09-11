package com.example.nullshinsaproduct.domain.product.entity;

import com.example.nullshinsaproduct.common.domain.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    private String brandName;
    private String corporateNumber;
    private String communicationSellingNumber;
    private String representative;
    private String location;

    @CreatedDate
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @Builder
    public Brand(String brandName, String corporateNumber, String communicationSellingNumber, String representative, String location) {
        this.brandName = brandName;
        this.corporateNumber = corporateNumber;
        this.communicationSellingNumber = communicationSellingNumber;
        this.representative = representative;
        this.location = location;
    }
}
