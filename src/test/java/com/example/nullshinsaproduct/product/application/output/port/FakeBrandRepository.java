package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.brand.apllication.output.port.BrandRepository;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FakeBrandRepository implements BrandRepository {
    private long idCountIncrement = 0;
    private Map<Long, BrandEntity> fakeBrandContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public BrandEntity save(BrandEntity brandEntity) {
        if (Objects.isNull(brandEntity)) {
            throw new IllegalArgumentException("[SkuProduct 저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        injectIdInEntity(brandEntity);
        fakeBrandContext.put(idCountIncrement, brandEntity);
        return fakeBrandContext.get(idCountIncrement);
    }

    @Override
    public BrandEntity findById(long id) {
        return fakeBrandContext.get(id);
    }

    private void injectIdInEntity(BrandEntity entity) {
        try {
            Field id = entity.getClass().getDeclaredField("id");
            id.setAccessible(true);
            id.set(entity, idCountIncrement);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }
}
