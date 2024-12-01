package com.example.nullshinsaproduct.regacy.application.service.product.service;

import com.example.nullshinsaproduct.regacy.application.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ElectronicProduct;
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
