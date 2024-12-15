package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

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
        return fakeProductContext.get(idCountIncrement);
    }
}