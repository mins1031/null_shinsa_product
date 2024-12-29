package com.example.nullshinsaproduct.review.application.output.port;

import com.example.nullshinsaproduct.review.application.output.dto.CheckOrdererResponse;

public interface ReviewerOrderClientWrapperPort {

    CheckOrdererResponse checkReviewerIsOrderer(long memberId, long productId);
}
