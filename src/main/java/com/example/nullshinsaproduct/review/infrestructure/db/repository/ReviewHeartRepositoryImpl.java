package com.example.nullshinsaproduct.review.infrestructure.db.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.application.output.port.ReviewHeartRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewHeartEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa.ReviewHeartJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ReviewHeartRepositoryImpl implements ReviewHeartRepository {
    private final ReviewHeartJpaRepository reviewHeartJpaRepository;

    @Override
    public ReviewHeartEntity save(ReviewHeartEntity entity) {
        if (Objects.isNull(entity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PARAMETER);
        }

        return reviewHeartJpaRepository.save(entity);
    }
}
