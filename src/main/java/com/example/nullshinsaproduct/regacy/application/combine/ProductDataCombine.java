package com.example.nullshinsaproduct.regacy.application.combine;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.ProductDetailRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductImageJpaRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductSizeJpaRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.SkuProductJpaRepository;
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
    private final SkuProductJpaRepository skuProductJpaRepository;
    private final ProductSizeJpaRepository productSizeJpaRepository;
    private final ProductImageJpaRepository productImageJpaRepository;

    @Transactional
    public void saveProductSubEntities(
            ProductDetail productDetail,
            List<ProductSizeEntity> productSizeEntities,
            List<SkuProductEntity> skus,
            List<ProductImageEntity> images
    ) {
        productDetailRepository.save(productDetail);
        productSizeJpaRepository.saveAll(productSizeEntities);
        skuProductJpaRepository.saveAll(skus);
        productImageJpaRepository.saveAll(images);
    }
}
