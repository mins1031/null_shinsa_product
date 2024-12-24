package com.example.nullshinsaproduct.product.application.service;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.product.application.input.map.ProductInputMapper;
import com.example.nullshinsaproduct.product.application.output.map.ProductOutputMapper;
import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductFindService {
    private final ProductRepository productRepository;

    // 이제 여기에 연관 전시 상품들도 같이 노출되는 로직도 필요
    // 별점 관련 작업도 필요
    @Transactional(readOnly = true)
    public ProductQueryResponse findProductById(long id) {
        ProductEntity productEntity = productRepository.findById(id);
        Product product = ProductOutputMapper.toProductDomain(productEntity);
        if (product.isNotFindStatus()) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT);
        }

        return ProductInputMapper.toProductQueryResponse(product);
    }
}
