package com.example.nullshinsaproduct.application.combine;

import com.example.nullshinsaproduct.infrastructure.feign.MemberFeignClient;
import com.example.nullshinsaproduct.infrastructure.feign.OrderFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewDataCombine {
    private final MemberFeignClient memberFeignClient;
    private final OrderFeignClient orderFeignClient;

    public
}
