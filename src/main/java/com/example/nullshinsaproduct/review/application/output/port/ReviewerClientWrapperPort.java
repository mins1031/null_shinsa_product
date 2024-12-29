package com.example.nullshinsaproduct.review.application.output.port;

import com.example.nullshinsaproduct.review.application.output.dto.ReviewerQueryResponse;

public interface ReviewerClientWrapperPort {
    ReviewerQueryResponse findMemberById(long memberId);
}
