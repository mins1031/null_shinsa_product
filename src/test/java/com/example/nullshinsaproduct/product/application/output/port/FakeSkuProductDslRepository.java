package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.common.CommonTestHelper;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FakeSkuProductDslRepository implements SkuProductDslRepository{
    private long idCountIncrement = 0;
    private Map<Long, SkuProductEntity> fakeSkuProductContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void updateStatusById(Long id, SkuProductStatus skuProductStatus) {
        SkuProductEntity skuProductEntity = fakeSkuProductContext.get(id);
        injectStatusInEntity(skuProductEntity, skuProductStatus);
    }

    @Override
    public void updateStatusByIds(List<Long> ids, SkuProductStatus skuProductStatus) {
        for (Map.Entry<Long, SkuProductEntity> entry : fakeSkuProductContext.entrySet()) {
            SkuProductEntity skuProductEntity = entry.getValue();
            if (!ids.contains(skuProductEntity.getProduct().getId())) {
                continue;
            }

            injectStatusInEntity(skuProductEntity, skuProductStatus);
        }
    }


    public void injectStatusInEntity(SkuProductEntity entity, SkuProductStatus productStatus) {
        try {
            Field id = entity.getClass().getDeclaredField("skuProductStatus");
            id.setAccessible(true);
            id.set(entity, productStatus);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }

    public SkuProductEntity save(SkuProductEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[상품저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeSkuProductContext.put(idCountIncrement, entity);
        CommonTestHelper.injectIdInEntity(entity, "id", idCountIncrement);

        return fakeSkuProductContext.get(idCountIncrement);
    }

    public SkuProductEntity findById(Long id) {
        return fakeSkuProductContext.get(id);
    }
}
