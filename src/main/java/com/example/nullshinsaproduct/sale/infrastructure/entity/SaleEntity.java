package com.example.nullshinsaproduct.sale.infrastructure.entity;

import com.example.nullshinsaproduct.sale.domain.SaleStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(
        name = "sale"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String name;
    private int salePercent;
    private SaleStatus saleStatus;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    public SaleEntity(Long id, String name, int salePercent, SaleStatus saleStatus, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        this.id = id;
        this.name = name;
        this.salePercent = salePercent;
        this.saleStatus = saleStatus;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }
}
