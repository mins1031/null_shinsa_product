package com.example.nullshinsaproduct.brand.apllication.output.port;

import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;

public interface BrandRepository {

    BrandEntity save(BrandEntity brandEntity);

    BrandEntity findById(long id);
}
