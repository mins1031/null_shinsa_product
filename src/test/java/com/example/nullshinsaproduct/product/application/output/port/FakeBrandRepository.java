package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.brand.apllication.output.port.BrandRepository;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.common.CommonTestHelper;

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
        CommonTestHelper.injectIdInEntity(brandEntity, "id", idCountIncrement);
        fakeBrandContext.put(idCountIncrement, brandEntity);
        return fakeBrandContext.get(idCountIncrement);
    }

    @Override
    public BrandEntity findById(long id) {
        return fakeBrandContext.get(id);
    }

}
