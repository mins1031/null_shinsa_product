package com.example.nullshinsaproduct.review.application.output;

import com.example.nullshinsaproduct.common.CommonTestHelper;
import com.example.nullshinsaproduct.review.application.output.port.ReviewHeartRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewHeartEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FakeReviewHeartRepository implements ReviewHeartRepository {
    private long idCountIncrement = 0;
    private Map<Long, ReviewHeartEntity> fakeReviewHeartContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public ReviewHeartEntity save(ReviewHeartEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[SkuProduct 저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        CommonTestHelper.injectIdInEntity(entity, "id", idCountIncrement);
        fakeReviewHeartContext.put(idCountIncrement, entity);
        return fakeReviewHeartContext.get(idCountIncrement);
    }
}
