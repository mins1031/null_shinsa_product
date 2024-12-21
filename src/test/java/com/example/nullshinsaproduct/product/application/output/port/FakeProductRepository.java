package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FakeProductRepository implements ProductRepository {
    private long idCountIncrement = 0;
    private Map<Long, ProductEntity> fakeProductContext =
            Collections.synchronizedMap(new HashMap<>());


    @Override
    public ProductEntity save(ProductEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[상품저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeProductContext.put(idCountIncrement, entity);
        injectIdInEntity(entity);

        return fakeProductContext.get(idCountIncrement);
    }

    public ProductEntity findById(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("[상품조회] - 엔티티 파리미터 NULL");
        }

        return this.fakeProductContext.get(id);
    }


    private void injectIdInEntity(ProductEntity entity) {
        try {
            Field id = entity.getClass().getDeclaredField("id");
            id.setAccessible(true);
            id.set(entity, idCountIncrement);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }
}