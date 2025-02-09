package com.example.nullshinsaproduct.sale.infrastructure.repository;

import com.example.nullshinsaproduct.sale.domain.SaleStatus;
import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleJpaRepository extends JpaRepository<SaleEntity, Long> {

    List<SaleEntity> findAllBySaleStatus(SaleStatus saleStatus);
}
