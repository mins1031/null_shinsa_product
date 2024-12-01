package com.example.nullshinsaproduct.regacy.application.service.product.service;

import com.example.nullshinsaproduct.regacy.application.combine.ProductDataCombine;
import com.example.nullshinsaproduct.regacy.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Brand;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ClothesProduct;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.CategoryInfoEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.regacy.product.domain.factory.ProductSizeFactory;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.regacy.brand.BrandRepository;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository.ProductRepository;
import com.example.nullshinsaproduct.regacy.application.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final ProductSizeFactory productSizeFactory;
    private final ProductDataCombine productDataCombine;

    @Transactional
    public void saveClothesProduct(ProductSaveRequest req) {
        // TODO 시큐리티 설정을 통해 요청자의 데이터를 조회하는 과정이 필요하긴 하지만.. 일단 이렇게 해놓고 추후 개선 필요
        Brand brand = brandRepository.findById(req.brandId()).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT_OPTION));
        ProductBrandInfo productBrandInfo = new ProductBrandInfo(
                brand.getId(),
                brand.getBrandName(),
                brand.getCommunicationSellingNumber(),
                brand.getCommunicationSellingNumber(),
                brand.getRepresentative(),
                brand.getLocation()
        );

        CategoryInfoEntity categoryInfoEntity = new CategoryInfoEntity(
                req.categoryInfoRequest().firstLayerCategory(),
                req.categoryInfoRequest().secondLayerCategory(),
                req.categoryInfoRequest().thirdLayerCategory(),
                req.categoryInfoRequest().inferiorLayerCategory()
        );

        ClothesProduct clothesProduct = ClothesProduct.createBasicClothesProduct(
                req.name(),
                req.price(),
                productBrandInfo,
                categoryInfoEntity,
                new DiscountDetail(req.discountApplyPossible(), req.discountMinRate(), req.discountMaxRate()),
                req.couponApplyPossible(),
                ProductDeliveryInfo.createFreeDelivery(),
                ProductType.CLOTHES
        );

        ClothesProduct savedProduct = productRepository.save(clothesProduct);

        ProductDetail productDetail = ProductMapper.mapFromReqToProductDetail(req.productDetailRequest(), savedProduct);
        savedProduct.initDetail(productDetail);
        List<ProductSizeEntity> productSizeEntities = productSizeFactory.createProductSizeDetailByCategory(savedProduct, req.categoryInfoRequest(), req.productSizeRequests());
        savedProduct.initSizes(productSizeEntities);
        List<SkuProductEntity> skus = ProductMapper.mapFromReqsToSkuProducts(req.skuProductRequests(), savedProduct);
        savedProduct.initSkus(skus);
        List<ProductImageEntity> images = ProductMapper.mapFromReqsToProductImages(req.thumbnailLink(), req.profileImagesLink(), req.detailImageLink(), savedProduct);
        savedProduct.initImages(images);

        productDataCombine.saveProductSubEntities(productDetail, productSizeEntities, skus, images);

        //이벤트 처리

    }
}
