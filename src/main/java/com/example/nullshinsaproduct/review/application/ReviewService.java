package com.example.nullshinsaproduct.review.application;

import com.example.nullshinsaproduct.review.application.dto.request.ReviewSaveRequest;
import com.example.nullshinsaproduct.review.application.output.dto.CheckOrdererResponse;
import com.example.nullshinsaproduct.review.application.output.dto.ReviewerQueryResponse;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerClientWrapperPort;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerOrderClientWrapperPort;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewImageEntity;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.ReviewerQueryInfraResponse;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.ReviewImageRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.ReviewRepository;
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
    private final ReviewImageRepository reviewImageRepository;
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
        savedReviewEntity.initImages(reviewImageEntities);
        reviewImageRepository.saveAll(reviewImageEntities);
    }
}
