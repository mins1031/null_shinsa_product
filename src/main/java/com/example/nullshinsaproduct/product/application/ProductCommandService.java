package com.example.nullshinsaproduct.product.application;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.vo.ProductDeliveryVo;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCommandService {
    private final ProductRepository productRepository;

    @Transactional
    public void saveProduct(ProductSaveRequest req) {
        // 상품생성 시작
        ProductSaveVo productSaveVo = mapSaveReqToVo(req);

        Product product = Product.createFrom(productSaveVo);
        productRepository.save(product);

    }

    private ProductSaveVo mapSaveReqToVo(ProductSaveRequest req) {
        return new ProductSaveVo(
                req.name(),
                req.price(),
                req.categoryInfoRequest().firstLayerCategory(),
                req.categoryInfoRequest().secondLayerCategory(),
                req.categoryInfoRequest().thirdLayerCategory(),
                req.couponApplyPossible(),
                req.discountApplyPossible(),
                req.discountMinRate(),
                req.discountMaxRate(),
                req.outboundPossibleDay(),
                req.isDeliveryFree(),
                req.productType()
        );
    }

    private ProductSaveVo mapSaveReqToVo(ProductSaveRequest req) {
        return new ProductSaveVo(
                req.name(),
                req.price(),
                req.categoryInfoRequest().firstLayerCategory(),
                req.categoryInfoRequest().secondLayerCategory(),
                req.categoryInfoRequest().thirdLayerCategory(),
                req.couponApplyPossible(),
                req.discountApplyPossible(),
                req.discountMinRate(),
                req.discountMaxRate(),
                req.outboundPossibleDay(),
                req.isDeliveryFree(),
                req.productType()
        );
    }


    private ProductDeliveryVo createProductDeliveryVoBy(boolean isDeliveryFree) {
        if (isDeliveryFree) {
            return ProductDeliveryVo.createFreeDelivery();
        }

        return ProductDeliveryVo.createSpecialDelivery();
    }
}
