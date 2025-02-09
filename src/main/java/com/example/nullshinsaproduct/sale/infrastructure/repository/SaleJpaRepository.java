package com.example.nullshinsaproduct.sale.infrastructure.repository;

import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleJpaRepository extends JpaRepository<SaleEntity, Long> {
}
