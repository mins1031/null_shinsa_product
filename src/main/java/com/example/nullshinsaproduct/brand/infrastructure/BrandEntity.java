package com.example.nullshinsaproduct.brand.infrastructure;

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
public class BrandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String brandName;
    private String oneLineIntroduce;
    private String corporateNumber;
    private String communicationSellingNumber;
    private String representative;
    private String location;
    private String titleImageUrl;
    private String introImageUrl;

    @CreatedDate
    protected LocalDateTime createdDate;

    @LastModifiedDate
    protected LocalDateTime updatedDate;

    public BrandEntity(Long id, String brandName, String oneLineIntroduce, String corporateNumber, String communicationSellingNumber, String representative, String location, String titleImageUrl, String introImageUrl) {
        this.id = id;
        this.brandName = brandName;
        this.oneLineIntroduce = oneLineIntroduce;
        this.corporateNumber = corporateNumber;
        this.communicationSellingNumber = communicationSellingNumber;
        this.representative = representative;
        this.location = location;
        this.titleImageUrl = titleImageUrl;
        this.introImageUrl = introImageUrl;
    }

    public static BrandEntity of(
            Long id,
            String brandName,
            String oneLineIntroduce,
            String corporateNumber,
            String communicationSellingNumber,
            String representative,
            String location,
            String titleImageUrl,
            String introImageUrl
    ) {
        return new BrandEntity(
                id,
                brandName,
                oneLineIntroduce,
                corporateNumber,
                communicationSellingNumber,
                representative,
                location,
                titleImageUrl,
                introImageUrl
        );
    }


}
