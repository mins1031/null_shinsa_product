package com.example.nullshinsaproduct.review.application;

import com.example.nullshinsaproduct.review.application.dto.request.ReviewSaveRequest;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.Review;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewImage;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.CheckOrdererResponse;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.MemberQueryResponse;
import com.example.nullshinsaproduct.review.infrestructure.http.feign.wrapper.MemberClientWrapper;
import com.example.nullshinsaproduct.review.infrestructure.http.feign.wrapper.OrderClientWrapper;
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
    private final MemberClientWrapper memberClientWrapper;
    private final OrderClientWrapper orderClientWrapper;

    @Transactional
    public void saveReview(ReviewSaveRequest req) {
        MemberQueryResponse findMemberRes = memberClientWrapper.findMemberById(req.reviewerId());
        CheckOrdererResponse checkOrdererResponseRes = orderClientWrapper.checkReviewerIsOrderer(findMemberRes.memberId(), req.productId());
        if (checkOrdererResponseRes.isNotOrderer()) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REVIEWER_ORDER);
        }

        Review review = Review.of(
                req.reviewerId(),
                checkOrdererResponseRes.orderId(),
                req.productId(),
                req.content(),
                req.startPoint(),
                checkOrdererResponseRes.orderSkuName()
        );
        Review savedReview = reviewRepository.save(review);

        List<ReviewImage> reviewImages = req.imgUrls().stream()
                .map(imgUrl -> ReviewImage.of(imgUrl, savedReview))
                .toList();
        savedReview.initImages(reviewImages);
        reviewImageRepository.saveAll(reviewImages);
    }
}
