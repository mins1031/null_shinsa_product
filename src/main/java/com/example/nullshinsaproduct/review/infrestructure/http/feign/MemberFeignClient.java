package com.example.nullshinsaproduct.review.infrestructure.http.feign;

import com.example.nullshinsaproduct.common.config.DefaultFeignConfig;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.MemberQueryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "MemberFeignClient",
        url = "http://localhost:8082",
        configuration = {DefaultFeignConfig.class}
)
public interface MemberFeignClient {
    @GetMapping("/members/{id}")
    ResponseEntity<MemberQueryResponse> findMemberById(@PathVariable long id);
}
