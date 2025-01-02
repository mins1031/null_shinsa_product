package com.example.nullshinsaproduct.review.infrestructure.http.feign.wrapper;

import com.example.nullshinsaproduct.common.annotation.InfrastructureComponent;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.application.output.dto.ReviewerQueryResponse;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerClientWrapperPort;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.ReviewerQueryInfraResponse;
import com.example.nullshinsaproduct.review.infrestructure.http.feign.ReviewerFeignClient;
import com.example.nullshinsaproduct.review.infrestructure.http.feign.map.ReviewInfraMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@Slf4j
@InfrastructureComponent
@RequiredArgsConstructor
public class ReviewerClientWrapper implements ReviewerClientWrapperPort {
    private final ReviewerFeignClient reviewerFeignClient;

    public ReviewerQueryResponse findMemberById(long memberId) {
        ResponseEntity<ReviewerQueryInfraResponse> queryResult = reviewerFeignClient.findMemberById(memberId);
        if (queryResult.getStatusCode().isError()) {
            throw new ProductException(ProductExceptionCode.FAIL_MEMBER_REQUEST);
        }

        if (Objects.isNull(queryResult.getBody())) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_MEMBER);
        }

        return ReviewInfraMapper.mapReviewerQueryToApplicationDto(queryResult.getBody());
    }

}
