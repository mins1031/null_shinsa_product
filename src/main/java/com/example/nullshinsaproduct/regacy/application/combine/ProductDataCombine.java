package com.example.nullshinsaproduct.regacy.application.combine;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductImage;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductSize;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.SkuProduct;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.ProductDetailRepository;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.ProductImageRepository;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.ProductSizeRepository;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.SkuProductRepository;
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
