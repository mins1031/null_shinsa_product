package com.example.nullshinsaproduct.application.combine;

import com.example.nullshinsaproduct.domain.product.entity.ProductImage;
import com.example.nullshinsaproduct.domain.product.entity.ProductSize;
import com.example.nullshinsaproduct.domain.product.entity.SkuProduct;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.infrastructure.repository.ProductDetailRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductImageRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductSizeRepository;
import com.example.nullshinsaproduct.infrastructure.repository.SkuProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductDataCombine {
    private final ProductDetailRepository productDetailRepository;
    private final SkuProductRepository skuProductRepository;
    private final ProductSizeRepository productSizeRepository;
    private final ProductImageRepository productImageRepository;

    @Transactional
    public void saveProductSubEntities(
            ProductDetail productDetail,
            List<ProductSize> productSizes,
            List<SkuProduct> skus,
            List<ProductImage> images
    ) {
        productDetailRepository.save(productDetail);
        productSizeRepository.saveAll(productSizes);
        skuProductRepository.saveAll(skus);
        productImageRepository.saveAll(images);
    }
}
