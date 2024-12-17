package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FakeProductImageRepository implements ProductImageRepository{
    private long idCountIncrement = 0;
    private Map<Long, ProductImageEntity> fakeProductImageContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public ProductImageEntity save(ProductImageEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[SkuProduct 저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeProductImageContext.put(idCountIncrement, entity);
        return fakeProductImageContext.get(idCountIncrement);
    }

    @Override
    public void saveAll(List<ProductImageEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            throw new IllegalArgumentException("[SkuProduct 다건저장] - 엔티티 파리미터 NULL");
        }

        entities.forEach(this::save);
    }

    public List<ProductImageEntity> findAll() {
        return this.fakeProductImageContext.values().stream().toList();
    }
}
