package com.example.nullshinsaproduct.infrastructure.feign;

import com.example.nullshinsaproduct.common.config.DefaultFeignConfig;
import com.example.nullshinsaproduct.infrastructure.dto.response.CheckCustomerResponse;
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
    @GetMapping("/orders/check-customer")
    ResponseEntity<CheckCustomerResponse> checkCustomer(
            @RequestParam(name = "customerId") long memberId,
            @RequestParam(name = "productId") long productId
    );
}