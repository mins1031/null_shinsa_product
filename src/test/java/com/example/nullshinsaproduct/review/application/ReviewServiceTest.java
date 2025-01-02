package com.example.nullshinsaproduct.review.application;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.review.application.dto.request.ReviewSaveRequest;
import com.example.nullshinsaproduct.review.application.output.FakeReviewHeartRepository;
import com.example.nullshinsaproduct.review.application.output.FakeReviewImageRepository;
import com.example.nullshinsaproduct.review.application.output.FakeReviewRepository;
import com.example.nullshinsaproduct.review.application.output.FakeReviewerClientWrapper;
import com.example.nullshinsaproduct.review.application.output.FakeReviewerOrderClientWrapper;
import com.example.nullshinsaproduct.review.application.output.port.ReviewHeartRepository;
import com.example.nullshinsaproduct.review.application.output.port.ReviewImageRepository;
import com.example.nullshinsaproduct.review.application.output.port.ReviewRepository;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerClientWrapperPort;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerOrderClientWrapperPort;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewImageEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ReviewServiceTest {
    private FakeReviewRepository reviewRepository = new FakeReviewRepository();
    private FakeReviewImageRepository reviewImageRepository = new FakeReviewImageRepository();
    private FakeReviewHeartRepository reviewHeartRepository = new FakeReviewHeartRepository();
    private FakeReviewerClientWrapper reviewerClientWrapperPort = new FakeReviewerClientWrapper();
    private FakeReviewerOrderClientWrapper reviewerOrderClientWrapperPort = new FakeReviewerOrderClientWrapper();

    private ReviewService reviewService;

    @BeforeEach
    void setUp() {

        this.reviewService = new ReviewService(
                this.reviewRepository,
                this.reviewImageRepository,
                this.reviewHeartRepository,
                this.reviewerClientWrapperPort,
                this.reviewerOrderClientWrapperPort
        );
    }

    @Test
    void 리뷰어의_회원가입여부와_주문여부가_정상이면_리뷰를_등록할_수_있다() {
        //given
        ReviewSaveRequest req = new ReviewSaveRequest(
                1L,
                1L,
                1L,
                "리뷰 내용",
                4.5,
                List.of(
                        "img url 1",
                        "img url 2",
                        "img url 3"
                )
        );

        //when
        reviewService.saveReview(req);

        //then
        ReviewEntity review = reviewRepository.findById(1L);
        Assertions.assertEquals(req.reviewerId(), review.getReviewerId());
        Assertions.assertEquals(req.orderId(), review.getOrderId());
        Assertions.assertEquals(req.productId(), review.getProductId());
        Assertions.assertEquals(req.content(), review.getContent());
        Assertions.assertEquals(req.startPoint(), review.getStartPoint());

        List<ReviewImageEntity> allImages = reviewImageRepository.findAll();
        Assertions.assertEquals(3, allImages.size());
        Assertions.assertEquals(req.imgUrls().get(0), allImages.get(0).getUrlPath());
        Assertions.assertEquals(req.imgUrls().get(1), allImages.get(1).getUrlPath());
        Assertions.assertEquals(req.imgUrls().get(2), allImages.get(2).getUrlPath());
    }

    @Test
    void 예외_리뷰어가_해당상품을_주문하지_않았다면_리뷰를_할_수_없다() {
        //given
        ReviewSaveRequest req = new ReviewSaveRequest(
                -1L,
                1L,
                1L,
                "리뷰 내용",
                4.5,
                List.of(
                        "img url 1",
                        "img url 2",
                        "img url 3"
                )
        );

        //when
        //then
        Assertions.assertThrows(ProductException.class, () -> reviewService.saveReview(req));
    }

}