package com.example.nullshinsaproduct.review.application;

import com.example.nullshinsaproduct.review.application.dto.request.ReviewHeartSaveRequest;
import com.example.nullshinsaproduct.review.application.dto.request.ReviewSaveRequest;
import com.example.nullshinsaproduct.review.application.output.dto.CheckOrdererResponse;
import com.example.nullshinsaproduct.review.application.output.dto.ReviewerQueryResponse;
import com.example.nullshinsaproduct.review.application.output.port.ReviewHeartRepository;
import com.example.nullshinsaproduct.review.application.output.port.ReviewRepository;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerClientWrapperPort;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerOrderClientWrapperPort;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewHeartEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewImageEntity;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa.ReviewImageJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewImageJpaRepository reviewImageJpaRepository;
    private final ReviewHeartRepository reviewHeartRepository;
    private final ReviewerClientWrapperPort reviewerClientWrapper;
    private final ReviewerOrderClientWrapperPort reviewerOrderClientWrapper;

    @Transactional
    public void saveReview(ReviewSaveRequest req) {
        ReviewerQueryResponse findReviewer = reviewerClientWrapper.findMemberById(req.reviewerId());
        CheckOrdererResponse checkIfReviewerOrdered = reviewerOrderClientWrapper.checkReviewerIsOrderer(findReviewer.memberId(), req.productId());
        if (checkIfReviewerOrdered.isNotOrderer()) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REVIEWER_ORDER);
        }

        ReviewEntity reviewEntity = ReviewEntity.of(
                req.reviewerId(),
                checkIfReviewerOrdered.orderId(),
                req.productId(),
                req.content(),
                req.startPoint(),
                checkIfReviewerOrdered.orderProductName()
        );
        ReviewEntity savedReviewEntity = reviewRepository.save(reviewEntity);

        List<ReviewImageEntity> reviewImageEntities = req.imgUrls().stream()
                .map(imgUrl -> ReviewImageEntity.of(imgUrl, savedReviewEntity))
                .toList();
        reviewImageJpaRepository.saveAll(reviewImageEntities);
    }

    @Transactional
    public void saveReviewHeart(ReviewHeartSaveRequest request) {
        ReviewEntity review = reviewRepository.findById(request.reviewId());

        ReviewHeartEntity reviewHeartEntity = new ReviewHeartEntity(request.heartPickerId(), review);
        reviewHeartRepository.save(reviewHeartEntity);
    }
}
