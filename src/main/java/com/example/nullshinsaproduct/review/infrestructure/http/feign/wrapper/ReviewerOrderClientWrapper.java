package com.example.nullshinsaproduct.review.infrestructure.http.feign.wrapper;

import com.example.nullshinsaproduct.common.annotation.InfrastructureComponent;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.application.output.dto.CheckOrdererResponse;
import com.example.nullshinsaproduct.review.application.output.port.ReviewerOrderClientWrapperPort;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.CheckOrdererInfraResponse;
import com.example.nullshinsaproduct.review.infrestructure.http.feign.ReviewerOrderFeignClient;
import com.example.nullshinsaproduct.review.infrestructure.http.feign.map.ReviewInfraMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@InfrastructureComponent
@RequiredArgsConstructor
public class ReviewerOrderClientWrapper implements ReviewerOrderClientWrapperPort {
    private final ReviewerOrderFeignClient reviewerOrderFeignClient;

    public CheckOrdererResponse checkReviewerIsOrderer(
            final long memberId,
            final long productId
    ) {
        ResponseEntity<CheckOrdererInfraResponse> result = reviewerOrderFeignClient.checkReviewerIsOrderer(memberId, productId);
        if (result.getStatusCode().isError()) {
            throw new ProductException(ProductExceptionCode.FAIl_ORDER_REQUEST);
        }

        if (Objects.isNull(result.getBody())) {
            throw new ProductException(ProductExceptionCode.FAIl_ORDER_REQUEST);
        }

        return ReviewInfraMapper.mapCheckOrdererToApplicationDto(result.getBody());
    }
}
