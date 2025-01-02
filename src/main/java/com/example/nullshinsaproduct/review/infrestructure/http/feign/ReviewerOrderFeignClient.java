package com.example.nullshinsaproduct.review.infrestructure.http.feign;

import com.example.nullshinsaproduct.common.config.DefaultFeignConfig;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.CheckOrdererInfraResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "ReviewerOrderFeignClient",
        url = "http://localhost:8081",
        configuration = {DefaultFeignConfig.class}
)
public interface ReviewerOrderFeignClient {
    @GetMapping("/orders/check-orderer")
    ResponseEntity<CheckOrdererInfraResponse> checkReviewerIsOrderer(
            @RequestParam(name = "customerId") long memberId,
            @RequestParam(name = "productId") long productId
    );
}
