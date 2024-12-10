package com.example.nullshinsaproduct.product.application;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.output.map.ProductOutputMapper;
import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;
import com.example.nullshinsaproduct.product.domain.service.ProductImageDomainService;
import com.example.nullshinsaproduct.product.domain.vo.ProductDeliveryVo;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCommandService {
    private final ProductRepository productRepository;
    private final ProductOutputMapper productOutputMapper;


    @Transactional
    public void saveProduct(ProductSaveRequest req) {
        // 상품생성 시작
        ProductSaveVo productSaveVo = productOutputMapper.toProductSaveVo(req);

        Product product = Product.createFrom(productSaveVo);
        ProductEntity productEntity = productRepository.save(productOutputMapper.toProductEntity(product));
        Product savedProduct = productOutputMapper.toProductDomain(productEntity);

//        List<SkuProduct> skuProducts = productOutputMapper.toSkuProducts(req.skuProductRequests(), savedProduct.getId());
//        productEntity.initSkus(
//                productOutputMapper.toSkuProductEntities(skuProducts)
//        );
//
//        List<ProductSize> productSizes = productOutputMapper.toProductSizes(req.productSizeRequests(), savedProduct.getId());
//        productEntity.initSizes(
//                productOutputMapper.toProductSizeEntities(productSizes)
//        );
//
//        List<ProductImage> productImages = new ProductImageDomainService().generateProductImages(
//                req.thumbnailLink(),
//                req.profileImagesLink(),
//                req.detailImageLink(),
//                savedProduct.getId()
//        );
//        productEntity.initImages(
//                productOutputMapper.toProductImageEntities(productImages)
//        );

        // 이후 작업 필요. 우선 위 작업 테스트 부터 하고 ㄱㄱ

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

//    private ProductSaveVo mapSaveReqToVo(ProductSaveRequest req) {
//        return new ProductSaveVo(
//                req.name(),
//                req.price(),
//                req.categoryInfoRequest().firstLayerCategory(),
//                req.categoryInfoRequest().secondLayerCategory(),
//                req.categoryInfoRequest().thirdLayerCategory(),
//                req.couponApplyPossible(),
//                req.discountApplyPossible(),
//                req.discountMinRate(),
//                req.discountMaxRate(),
//                req.outboundPossibleDay(),
//                req.isDeliveryFree(),
//                req.productType()
//        );
//    }


    private ProductDeliveryVo createProductDeliveryVoBy(boolean isDeliveryFree) {
        if (isDeliveryFree) {
            return ProductDeliveryVo.createFreeDelivery();
        }

        return ProductDeliveryVo.createSpecialDelivery();
    }
}