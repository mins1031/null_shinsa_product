package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.common.helper.CommonTestHelper;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FakeProductDslRepository implements ProductDslRepository{
    private long idCountIncrement = 0;
    private Map<Long, ProductEntity> fakeProductContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void updateStatusById(Long id, ProductStatus productStatus) {
        ProductEntity productEntity = fakeProductContext.get(id);
        injectStatusInEntity(productEntity, productStatus);
    }

    @Override
    public void updateStatusByIds(List<Long> ids, ProductStatus productStatus) {
        for (Long id : ids) {
            ProductEntity productEntity = fakeProductContext.get(id);
            injectStatusInEntity(productEntity, productStatus);
        }
    }


    public void injectStatusInEntity(ProductEntity entity, ProductStatus productStatus) {
        try {
            Field status = entity.getClass().getDeclaredField("productStatus");
            status.setAccessible(true);
            status.set(entity, productStatus);

            Field isCanView = entity.getClass().getDeclaredField("isCanView");
            isCanView.setAccessible(true);
            isCanView.set(entity, true);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }

    public ProductEntity save(ProductEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[상품저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeProductContext.put(idCountIncrement, entity);
        CommonTestHelper.injectIdInEntity(entity, "id", idCountIncrement);

        return fakeProductContext.get(idCountIncrement);
    }

    public ProductEntity findById(Long id) {
        return fakeProductContext.get(id);
    }
}
