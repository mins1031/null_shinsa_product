package com.example.nullshinsaproduct.review.infrestructure.db.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.application.output.port.ReviewImageRepository;
import com.example.nullshinsaproduct.review.application.output.port.ReviewRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewImageEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa.ReviewImageJpaRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa.ReviewJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ReviewImageRepositoryImpl implements ReviewImageRepository {
    private final ReviewImageJpaRepository reviewImageJpaRepository;

    @Override
    public void saveAll(List<ReviewImageEntity> entityList) {
        if (CollectionUtils.isEmpty(entityList)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PARAMETER);
        }

        reviewImageJpaRepository.saveAll(entityList);
    }
}
