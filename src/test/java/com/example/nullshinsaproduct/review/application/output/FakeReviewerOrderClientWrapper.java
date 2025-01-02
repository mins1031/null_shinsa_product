package com.example.nullshinsaproduct.review.application.output;

import com.example.nullshinsaproduct.review.application.output.dto.CheckOrdererResponse;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerOrderClientWrapperPort;

public class FakeReviewerOrderClientWrapper implements ReviewerOrderClientWrapperPort {
    @Override
    public CheckOrdererResponse checkReviewerIsOrderer(long memberId, long productId) {
        if (memberId == -1L) {
            return new CheckOrdererResponse(
                    false,
                    0L,
                    memberId,
                    "주문되지 않은 상품 이름"
            );
        }

        return new CheckOrdererResponse(
                true,
                1L,
                memberId,
                "주문된 상품 이름"
        );
    }
}
