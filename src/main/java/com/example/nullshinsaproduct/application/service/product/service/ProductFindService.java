package com.example.nullshinsaproduct.application.service.product.service;

import com.example.nullshinsaproduct.application.combine.ProductDataCombine;
import com.example.nullshinsaproduct.domain.dto.response.BrandResponse;
import com.example.nullshinsaproduct.domain.dto.response.ProductResponse;
import com.example.nullshinsaproduct.domain.product.entity.Brand;
import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.ProductSize;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.factory.ProductSizeFactory;
import com.example.nullshinsaproduct.exception.product.ProductException;
import com.example.nullshinsaproduct.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.infrastructure.repository.BrandRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.domain.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaproduct.infrastructure.repository.ProductSizeRepository;
import com.example.nullshinsaproduct.presentation.mapper.ProductMapper;
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
    private final BrandRepository brandRepository;
    private final ProductSizeRepository productSizeRepository;
    private final ProductSizeFactory productSizeFactory;
    private final ProductDataCombine productDataCombine;
//
//    //주문 저장시에 상품정보가 필요. 재사용성 위해 필요한 모든 데이터 응답 api 구현
//    @Transactional(readOnly = true)
//    public ProductResponse findIntegrationProductById(Long productId) {
//        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT));
//        ProductBrandInfo productBrandInfo = product.getProductBrandInfo();
//        Brand brand = brandRepository.findById(productBrandInfo.getBrandId()).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_BRAND));
//
//        BrandResponse brandResponse = new BrandResponse(
//                brand.getId(),
//                brand.getBrandName(),
//                brand.getOneLineIntroduce(),
//                brand.getCorporateNumber(),
//                brand.getCommunicationSellingNumber(),
//                brand.getRepresentative(),
//                brand.getLocation(),
//                brand.getTitleImageUrl(),
//                brand.getIntroImageUrl()
//        );
//
//        List<ProductSize> sizesByProduct = productSizeRepository.findAllByProduct(product);
//
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
