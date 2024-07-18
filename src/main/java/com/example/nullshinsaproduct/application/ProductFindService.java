package com.example.nullshinsaproduct.application;

import com.example.nullshinsaproduct.domain.dto.response.ProductOptionResponse;
import com.example.nullshinsaproduct.domain.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaproduct.domain.dto.response.ProductResponse;
import com.example.nullshinsaproduct.domain.entity.Product;
import com.example.nullshinsaproduct.domain.entity.ProductOption;
import com.example.nullshinsaproduct.exception.product.ProductException;
import com.example.nullshinsaproduct.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.infrastructure.repository.ProductOptionRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductFindService {
    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;


    //주문 저장시에 상품정보가 필요. 재사용성 위해 필요한 모든 데이터 응답 api 구현
    @Transactional(readOnly = true)
    public ProductResponse findIntegrationProductById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT));
        List<ProductOption> productOptions = productOptionRepository.findByProductId(productId);

        return ProductMapper.INSTANCE.toResponseDto(product, productOptions);
    }

    @Transactional(readOnly = true)
    public List<ProductOptionStockResponse> findProductOptionStocks(final List<Long> productOptionIdList) {
        if (CollectionUtils.isEmpty(productOptionIdList)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        final List<ProductOption> productOptions = productOptionRepository.findAllById(productOptionIdList);
        if (productOptionIdList.size() != productOptions.size()) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT_OPTION);
        }

        return productOptions.stream()
                .map(productOption -> new ProductOptionStockResponse(productOption.getProductId(), productOption.getStock(), productOption.isSoldOut()))
                .collect(Collectors.toList());
    }
}
