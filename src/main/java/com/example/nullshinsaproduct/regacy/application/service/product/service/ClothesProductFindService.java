package com.example.nullshinsaproduct.regacy.application.service.product.service;

import com.example.nullshinsaproduct.regacy.application.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.regacy.application.mapper.BrandMapper;
import com.example.nullshinsaproduct.regacy.application.mapper.ProductMapper;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Brand;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.regacy.brand.BrandRepository;
import com.example.nullshinsaproduct.regacy.application.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.vo.ProductOverviewVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClothesProductFindService {
    private final BrandRepository brandRepository;

    //주문 저장시에 상품정보가 필요. 재사용성 위해 필요한 모든 데이터 응답 api 구현
    @Transactional(readOnly = true)
    public ProductQueryResponse findOneProduct(ProductEntity product) {
//        ProductOverviewVo productOverview = product.getProductOverview();
//        Brand brand = brandRepository.findById(product.getBrandId()).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_BRAND));
//
//        return ProductMapper.mapProductOverviewToRes(
//                productOverview,
//                BrandMapper.mapEntityToRes(brand)
//        );
        return null;
    }

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
