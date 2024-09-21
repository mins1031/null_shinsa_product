package com.example.nullshinsaproduct.application.service.product.service;

import com.example.nullshinsaproduct.domain.dto.response.ProductResponse;
import com.example.nullshinsaproduct.domain.product.entity.ElectronicProduct;
import com.example.nullshinsaproduct.domain.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ElectronicProductFindService {

    @Transactional(readOnly = true)
    public ProductResponse findOneProduct(ElectronicProduct productId) {
        return null;
    }
}
