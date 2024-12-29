package com.example.nullshinsaproduct.review.infrestructure.http.feign.map;

import com.example.nullshinsaproduct.review.application.output.dto.CheckOrdererResponse;
import com.example.nullshinsaproduct.review.application.output.dto.ReviewerQueryResponse;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.CheckOrdererInfraResponse;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.ReviewerQueryInfraResponse;

public class ReviewInfraMapper {

    public static CheckOrdererResponse mapCheckOrdererToApplicationDto(CheckOrdererInfraResponse infraResponse) {
        return new CheckOrdererResponse(
                infraResponse.isOrderer(),
                infraResponse.orderId(),
                infraResponse.ordererId(),
                infraResponse.orderedProductName()
        );
    }

    public static ReviewerQueryResponse mapReviewerQueryToApplicationDto(ReviewerQueryInfraResponse infraResponse) {
        return new ReviewerQueryResponse(
                infraResponse.memberId(),
                infraResponse.name(),
                infraResponse.height(),
                infraResponse.weight()
        );
    }
}
