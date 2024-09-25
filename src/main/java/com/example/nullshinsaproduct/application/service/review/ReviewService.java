package com.example.nullshinsaproduct.application.service.review;

import com.example.nullshinsaproduct.application.dto.request.ReviewSaveRequest;
import com.example.nullshinsaproduct.domain.review.enttiy.Review;
import com.example.nullshinsaproduct.infrastructure.repository.review.ReviewImageRepository;
import com.example.nullshinsaproduct.infrastructure.repository.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Transactional
    public void saveReview(ReviewSaveRequest req) {

//        new Review(
//                req.writerId(),
//                req.writerId(),
//                req.writerId(),
//                req.writerId(),
//                req.writerId(),
//        )
    }
}
