package com.example.nullshinsaproduct.application.service.product.service;

import com.example.nullshinsaproduct.application.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.domain.product.entity.ElectronicProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElectronicProductFindService {

    @Transactional(readOnly = true)
    public ProductQueryResponse findOneProduct(ElectronicProduct productId) {
        return null;
    }
}
