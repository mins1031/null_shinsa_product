package com.example.nullshinsaproduct.review.application.output.port;

import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewHeartEntity;

public interface ReviewHeartRepository {
    ReviewHeartEntity save(ReviewHeartEntity entity);
}
