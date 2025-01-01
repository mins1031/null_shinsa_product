package com.example.nullshinsaproduct.review.application.output.port;

import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;

public interface ReviewRepository {
    ReviewEntity save(ReviewEntity entity);

    ReviewEntity findById(long id);
}
