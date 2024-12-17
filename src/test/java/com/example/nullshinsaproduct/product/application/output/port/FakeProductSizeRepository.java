package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FakeProductSizeRepository implements ProductSizeRepository {
    private long idCountIncrement = 0;
    private Map<Long, ProductSizeEntity> fakeProductSizeContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public ProductSizeEntity save(ProductSizeEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[SkuProduct 저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeProductSizeContext.put(idCountIncrement, entity);
        return fakeProductSizeContext.get(idCountIncrement);
    }

    @Override
    public void saveAll(List<ProductSizeEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            throw new IllegalArgumentException("[SkuProduct 다건저장] - 엔티티 파리미터 NULL");
        }

        entities.forEach(this::save);
    }

    public List<ProductSizeEntity> findAll() {
        return this.fakeProductSizeContext.values().stream().toList();
    }
}
