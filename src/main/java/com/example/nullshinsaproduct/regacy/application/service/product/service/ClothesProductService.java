package com.example.nullshinsaproduct.regacy.application.service.product.service;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductJpaRepository;
import com.example.nullshinsaproduct.regacy.application.combine.ProductDataCombine;
import com.example.nullshinsaproduct.brand.infrastructure.BrandJpaRepository;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.CategoryInfoEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.embaded.ProductBrandInfoEmbeddable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClothesProductService {
    private final ProductJpaRepository productJpaRepository;
    private final BrandJpaRepository brandJpaRepository;
//    private final ProductSizeFactory productSizeFactory;
    private final ProductDataCombine productDataCombine;

    @Transactional
    public void saveClothesProduct(ProductSaveRequest req) {
        // TODO 시큐리티 설정을 통해 요청자의 데이터를 조회하는 과정이 필요하긴 하지만.. 일단 이렇게 해놓고 추후 개선 필요
        BrandEntity brandEntity = brandJpaRepository.findById(req.brandId()).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT_OPTION));
        ProductBrandInfoEmbeddable productBrandInfoEmbeddable = new ProductBrandInfoEmbeddable(
                brandEntity.getId(),
                brandEntity.getBrandName(),
                brandEntity.getCommunicationSellingNumber(),
                brandEntity.getCommunicationSellingNumber(),
                brandEntity.getRepresentative(),
                brandEntity.getLocation()
        );

        CategoryInfoEntity categoryInfoEntity = new CategoryInfoEntity(
                req.categoryInfoRequest().firstLayerCategory(),
                req.categoryInfoRequest().secondLayerCategory(),
                req.categoryInfoRequest().thirdLayerCategory(),
                req.categoryInfoRequest().inferiorLayerCategory()
        );

//        ProductEntity productEntity = ProductEntity.createDefault(
//                req.name(),
//                req.price(),
//                productBrandInfoEmbeddable,
//                categoryInfoEntity,
//                new DiscountDetailInEntity(req.discountApplyPossible(), req.discountMinRate(), req.discountMaxRate()),
//                req.couponApplyPossible(),
//                ProductDeliveryInfoInEntity.createFreeDelivery(),
//                ProductType.CLOTHES
//        );
//
//        ProductEntity savedProduct = productJpaRepository.save(productEntity);

//        ProductDetail productDetail = ProductMapper.mapFromReqToProductDetail(req.productDetailRequest(), savedProduct);
//        savedProduct.initDetail(productDetail);
//        List<ProductSizeEntity> productSizeEntities = productSizeFactory.createProductSizeDetailByCategory(savedProduct, req.categoryInfoRequest(), req.productSizeRequests());
//        savedProduct.initSizes(productSizeEntities);
//        List<SkuProductEntity> skus = ProductMapper.mapFromReqsToSkuProducts(req.skuProductRequests(), savedProduct);
//        savedProduct.initSkus(skus);
//        List<ProductImageEntity> images = ProductMapper.mapFromReqsToProductImages(req.thumbnailLink(), req.profileImagesLink(), req.detailImageLink(), savedProduct);
//        savedProduct.initImages(images);

//        productDataCombine.saveProductSubEntities(productDetail, productSizeEntities, skus, images);

        //이벤트 처리

    }
}
