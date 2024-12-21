package com.example.nullshinsaproduct.review.infrestructure.http.feign;

import com.example.nullshinsaproduct.common.config.DefaultFeignConfig;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.CheckOrdererResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "OrderFeignClient",
        url = "http://localhost:8081",
        configuration = {DefaultFeignConfig.class}
)
public interface OrderFeignClient {
    @GetMapping("/orders/check-orderer")
    ResponseEntity<CheckOrdererResponse> checkReviewerIsOrderer(
            @RequestParam(name = "customerId") long memberId,
            @RequestParam(name = "productId") long productId
    );
}
