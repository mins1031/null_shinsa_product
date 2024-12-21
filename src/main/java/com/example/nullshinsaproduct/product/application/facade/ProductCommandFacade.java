package com.example.nullshinsaproduct.product.application.facade;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.service.ProductCommandService;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductCommandFacade {
    private final ProductCommandService productCommandService;

    @Transactional
    public void saveProduct(final ProductSaveRequest request) {
        final ProductEntity productEntity = productCommandService.saveProduct(request);

        productCommandService.saveSkuProducts(productEntity, request.skuProductRequests());
        productCommandService.saveProductSize(productEntity, request.productSizeRequests());
        productCommandService.saveProductImages(productEntity, request);


        // 이후 작업 필요. 우선 위 작업 테스트 부터 하고 ㄱㄱ
        
    }
}
