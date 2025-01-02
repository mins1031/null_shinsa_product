package com.example.nullshinsaproduct.review.application.output;

import com.example.nullshinsaproduct.review.application.output.dto.ReviewerQueryResponse;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerClientWrapperPort;

public class FakeReviewerClientWrapper implements ReviewerClientWrapperPort {
    @Override
    public ReviewerQueryResponse findMemberById(long memberId) {
        return new ReviewerQueryResponse(
                memberId,
                "회원 이름" + memberId,
                "키" + memberId,
                "몸무게" + memberId
        );
    }
}
