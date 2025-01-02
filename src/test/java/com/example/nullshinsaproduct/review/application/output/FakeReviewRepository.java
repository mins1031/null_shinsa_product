package com.example.nullshinsaproduct.review.application.output;

import com.example.nullshinsaproduct.common.CommonTestHelper;
import com.example.nullshinsaproduct.review.application.output.port.ReviewRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FakeReviewRepository implements ReviewRepository {
    private long idCountIncrement = 0;
    private Map<Long, ReviewEntity> fakeReviewContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public ReviewEntity save(ReviewEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[SkuProduct 저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        CommonTestHelper.injectIdInEntity(entity, "id", idCountIncrement);
        fakeReviewContext.put(idCountIncrement, entity);
        return fakeReviewContext.get(idCountIncrement);
    }

    @Override
    public ReviewEntity findById(long id) {
        return fakeReviewContext.get(id);
    }
}
