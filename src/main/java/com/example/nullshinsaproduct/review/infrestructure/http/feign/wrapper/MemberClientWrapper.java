package com.example.nullshinsaproduct.review.infrestructure.http.feign.wrapper;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.review.infrestructure.http.dto.response.MemberQueryResponse;
import com.example.nullshinsaproduct.review.infrestructure.http.feign.MemberFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberClientWrapper {
    private final MemberFeignClient memberFeignClient;

    public MemberQueryResponse findMemberById(long memberId) {
        ResponseEntity<MemberQueryResponse> queryResult = memberFeignClient.findMemberById(memberId);
        if (queryResult.getStatusCode().isError()) {
            throw new ProductException(ProductExceptionCode.FAIL_MEMBER_REQUEST);
        }

        return queryResult.getBody();
    }

}
