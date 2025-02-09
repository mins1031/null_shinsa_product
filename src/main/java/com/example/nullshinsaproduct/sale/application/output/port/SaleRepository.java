package com.example.nullshinsaproduct.sale.application.output.port;


import com.example.nullshinsaproduct.sale.infrastructure.entity.SaleEntity;

public interface SaleRepository {

    SaleEntity save(SaleEntity entity);

    SaleEntity findById(long id);

    void deleteById(long id);
}
