package com.example.nullshinsaproduct.product.application.facade;

import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.event.ProductSaveEvent;
import com.example.nullshinsaproduct.product.application.service.ProductCommandService;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCommandFacade {
    private final ProductCommandService productCommandService;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void saveProduct(final ProductSaveRequest request) {
        final ProductEntity productEntity = productCommandService.saveProduct(request);
        productCommandService.saveSkuProducts(productEntity, request.skuProductRequests());
        productCommandService.saveProductSize(productEntity, request.productSizeRequests());
        productCommandService.saveProductImages(productEntity, request);

        publishEvent(productEntity);
    }

    // 연관 이벤트가 추가될경우 해당 메서드에 작성 필요
    private void publishEvent(ProductEntity productEntity) {
        eventPublisher.publishEvent(ProductSaveEvent.of(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getBrandName(),
                List.of("receiver1@naverrr.com")
        ));
    }
}
