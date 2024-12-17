package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FakeSkuProductRepository implements SkuProductRepository{
    private long idCountIncrement = 0;
    private Map<Long, SkuProductEntity> fakeSkuProductContext = Collections.synchronizedMap(new HashMap<>());


    @Override
    public SkuProductEntity save(SkuProductEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[SkuProduct 저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeSkuProductContext.put(idCountIncrement, entity);
        return fakeSkuProductContext.get(idCountIncrement);
    }

    @Override
    public void saveAll(List<SkuProductEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            throw new IllegalArgumentException("[SkuProduct 다건저장] - 엔티티 파리미터 NULL");
        }

        entities.forEach(this::save);
    }

    public List<SkuProductEntity> findAll() {
        return fakeSkuProductContext.values().stream().toList();
    }
}
