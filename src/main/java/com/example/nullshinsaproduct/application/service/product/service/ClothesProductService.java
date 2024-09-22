package com.example.nullshinsaproduct.application.service.product.service;

import com.example.nullshinsaproduct.application.combine.ProductDataCombine;
import com.example.nullshinsaproduct.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.domain.product.entity.Brand;
import com.example.nullshinsaproduct.domain.product.entity.ClothesProduct;
import com.example.nullshinsaproduct.domain.product.entity.ProductImage;
import com.example.nullshinsaproduct.domain.product.entity.ProductSize;
import com.example.nullshinsaproduct.domain.product.entity.SkuProduct;
import com.example.nullshinsaproduct.domain.product.entity.embaded.CategoryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;
import com.example.nullshinsaproduct.domain.product.factory.ProductSizeFactory;
import com.example.nullshinsaproduct.exception.product.ProductException;
import com.example.nullshinsaproduct.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.infrastructure.repository.BrandRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.application.mapper.ProductMapper;
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

        CategoryInfo categoryInfo = new CategoryInfo(
                req.categoryInfoRequest().firstLayerCategory(),
                req.categoryInfoRequest().secondLayerCategory(),
                req.categoryInfoRequest().thirdLayerCategory(),
                req.categoryInfoRequest().inferiorLayerCategory()
        );

        ClothesProduct clothesProduct = ClothesProduct.createBasicClothesProduct(
                req.name(),
                req.price(),
                productBrandInfo,
                categoryInfo,
                new DiscountDetail(req.discountApplyPossible(), req.discountMinRate(), req.discountMaxRate()),
                req.couponApplyPossible(),
                ProductDeliveryInfo.createFreeDelivery(),
                ProductType.CLOTHES
        );

        ClothesProduct savedProduct = productRepository.save(clothesProduct);

        ProductDetail productDetail = ProductMapper.mapFromReqToProductDetail(req.productDetailRequest(), savedProduct);
        savedProduct.initDetail(productDetail);
        List<ProductSize> productSizes = productSizeFactory.createProductSizeDetailByCategory(savedProduct, req.categoryInfoRequest(), req.productSizeRequests());
        savedProduct.initSizes(productSizes);
        List<SkuProduct> skus = ProductMapper.mapFromReqsToSkuProducts(req.skuProductRequests(), savedProduct);
        savedProduct.initSkus(skus);
        List<ProductImage> images = ProductMapper.mapFromReqsToProductImages(req.thumbnailLink(), req.profileImagesLink(), req.detailImageLink(), savedProduct);
        savedProduct.initImages(images);

        productDataCombine.saveProductSubEntities(productDetail, productSizes, skus, images);

        //이벤트 처리

    }
}
