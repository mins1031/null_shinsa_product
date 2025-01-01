package com.example.nullshinsaproduct.review.infrestructure.db.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.application.output.port.ReviewRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
    private final ReviewJpaRepository reviewJpaRepository;


    @Override
    public ReviewEntity save(ReviewEntity entity) {
        if (Objects.isNull(entity)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        return reviewJpaRepository.save(entity);
    }

    @Override
    public ReviewEntity findById(long id) {
        return reviewJpaRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS));
    }
}
