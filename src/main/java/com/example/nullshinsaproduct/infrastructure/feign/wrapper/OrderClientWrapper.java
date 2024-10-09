package com.example.nullshinsaproduct.infrastructure.feign.wrapper;

import com.example.nullshinsaproduct.exception.product.ProductException;
import com.example.nullshinsaproduct.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.infrastructure.dto.response.CheckOrdererResponse;
import com.example.nullshinsaproduct.infrastructure.feign.OrderFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderClientWrapper {
    private final OrderFeignClient orderFeignClient;

    public CheckOrdererResponse checkReviewerIsOrderer(
            final long memberId,
            final long productId
    ) {
        ResponseEntity<CheckOrdererResponse> result = orderFeignClient.checkReviewerIsOrderer(memberId, productId);
        if (result.getStatusCode().isError()) {
            throw new ProductException(ProductExceptionCode.FAIl_ORDER_REQUEST);
        }

        if (Objects.isNull(result.getBody())) {
            throw new ProductException(ProductExceptionCode.FAIl_ORDER_REQUEST);
        }

        return result.getBody();
    }
}
