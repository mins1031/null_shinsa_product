package com.example.nullshinsaproduct.review.application.output.port;

import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewImageEntity;

import java.util.List;

public interface ReviewImageRepository {
    void saveAll(List<ReviewImageEntity> entityList);
}
