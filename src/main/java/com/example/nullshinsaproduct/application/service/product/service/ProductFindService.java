package com.example.nullshinsaproduct.application.service.product.service;

import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.domain.dto.response.ProductOptionStockResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductFindService {
    private final ProductRepository productRepository;


    //주문 저장시에 상품정보가 필요. 재사용성 위해 필요한 모든 데이터 응답 api 구현
//    @Transactional(readOnly = true)
//    public ProductResponse findIntegrationProductById(Long productId) {
//        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT));
//        List<ProductClothesOption> productClothesOptions = productOptionRepository.findByProductId(productId);
//
//        return ProductMapper.INSTANCE.toResponseDto(product, productClothesOptions);
//    }

    @Transactional(readOnly = true)
    public List<ProductOptionStockResponse> findProductOptionStocks(final List<Long> productOptionIdList) {
//        if (CollectionUtils.isEmpty(productOptionIdList)) {
//            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
//        }
//
//        final List<ProductClothesOption> productClothesOptions = productOptionRepository.findAllById(productOptionIdList);
//        if (productOptionIdList.size() != productClothesOptions.size()) {
//            throw new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT_OPTION);
//        }
//
//        return productClothesOptions.stream()
//                .map(productOption -> new ProductOptionStockResponse(productOption.getProductId(), productOption.getStock(), productOption.isSoldOut()))
//                .collect(Collectors.toList());
        return null;
    }
}
