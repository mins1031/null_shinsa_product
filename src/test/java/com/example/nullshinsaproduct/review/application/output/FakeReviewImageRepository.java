package com.example.nullshinsaproduct.review.application.output;

import com.example.nullshinsaproduct.common.CommonTestHelper;
import com.example.nullshinsaproduct.review.application.output.port.ReviewImageRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewImageEntity;
import org.hibernate.result.UpdateCountOutput;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FakeReviewImageRepository implements ReviewImageRepository {
    private long idCountIncrement = 0;
    private Map<Long, ReviewImageEntity> fakeReviewImageContext = Collections.synchronizedMap(new HashMap<>());

    public ReviewImageEntity save(ReviewImageEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[SkuProduct 저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        CommonTestHelper.injectIdInEntity(entity, "id", idCountIncrement);
        fakeReviewImageContext.put(idCountIncrement, entity);
        return fakeReviewImageContext.get(idCountIncrement);
    }

    @Override
    public void saveAll(List<ReviewImageEntity> entityList) {
        entityList.forEach(this::save);
    }

    public List<ReviewImageEntity> findAll() {
        return this.fakeReviewImageContext.values().stream().toList();
    }
}
