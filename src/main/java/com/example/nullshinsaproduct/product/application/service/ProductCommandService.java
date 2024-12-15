package com.example.nullshinsaproduct.product.application.service;

import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.application.output.map.ProductEntityMapper;
import com.example.nullshinsaproduct.product.application.output.map.ProductOutputMapper;
import com.example.nullshinsaproduct.product.application.output.port.ProductImageRepository;
import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.application.output.port.ProductSizeRepository;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductRepository;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.domain.service.ProductImageDomainService;
import com.example.nullshinsaproduct.product.domain.vo.ProductDeliveryVo;
import com.example.nullshinsaproduct.product.domain.vo.ProductSaveVo;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
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
    private final SkuProductRepository skuProductRepository;
    private final ProductSizeRepository productSizeRepository;
    private final ProductImageRepository productImageRepository;

    private final ProductOutputMapper productOutputMapper;


    @Transactional
    public ProductEntity saveProduct(ProductSaveRequest req) {
        // 상품생성 시작
        ProductSaveVo productSaveVo = productOutputMapper.toProductSaveVo(req);

        Product product = Product.createFrom(productSaveVo);
        return productRepository.save(productOutputMapper.toProductEntity(product));
    }

    @Transactional
    public void saveSkuProducts(ProductEntity productEntity, List<SkuProductRequest> requests) {
        List<SkuProduct> skuProducts = productOutputMapper.toSkuProducts(productEntity.getId(), requests);
        List<SkuProductEntity> entities = ProductEntityMapper.toSkuProductEntities(skuProducts, productEntity);

        skuProductRepository.saveAll(entities);
    }

    @Transactional
    public void saveProductSize(ProductEntity productEntity, List<ProductSizeRequest> requests) {
        List<ProductSize> productSizes = requests.stream()
                .map(size -> size.productSizeType().createProductSizeByType(size, productEntity.getId()))
                .toList();
        List<ProductSizeEntity> productSizeEntities = ProductEntityMapper.toProductSizeEntities(productSizes, productEntity);

        productSizeRepository.saveAll(productSizeEntities);
    }

    @Transactional
    public void saveProductImages(ProductEntity productEntity, ProductSaveRequest request) {
        ProductImageDomainService domainService = new ProductImageDomainService();
        List<ProductImage> productImages = domainService.generateProductImages(
                request.thumbnailLink(),
                request.profileImagesLink(),
                request.detailImageLink(),
                productEntity.getId()
        );

        List<ProductImageEntity> imageEntities = ProductEntityMapper.toProductImageEntities(productImages, productEntity);
        productImageRepository.saveAll(imageEntities);
    }

}
