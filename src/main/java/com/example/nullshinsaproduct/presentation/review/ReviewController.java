package com.example.nullshinsaproduct.presentation.review;

import com.example.nullshinsaproduct.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.application.dto.request.ReviewSaveRequest;
import com.example.nullshinsaproduct.application.service.review.ReviewService;
import com.example.nullshinsaproduct.common.dto.ResponseResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reviews")
    public ResponseResult<Boolean> saveReview(@Valid @RequestBody ReviewSaveRequest request) {
        log.info("리뷰등록 req : {}", request);
        reviewService.saveReview(request);
        return ResponseResult.success(HttpStatus.CREATED, true);
    }
}
