package com.example.nullshinsaproduct.product.application.service;

import com.example.nullshinsaproduct.brand.apllication.output.port.BrandRepository;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.SkuProductRequest;
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
    private final BrandRepository brandRepository;


    @Transactional
    public ProductEntity saveProduct(ProductSaveRequest req) {
        // 상품생성 시작
        BrandEntity brandEntity = brandRepository.findById(req.brandId());
        ProductSaveVo productSaveVo = ProductOutputMapper.toProductSaveVo(req, brandEntity);

        Product product = Product.createFrom(productSaveVo);

        return productRepository.save(ProductOutputMapper.toProductEntity(product));
    }

    @Transactional
    public void saveSkuProducts(ProductEntity product, List<SkuProductRequest> requests) {
        List<SkuProduct> skuProducts = ProductOutputMapper.toSkuProducts(product.getId(), requests);
        List<SkuProductEntity> entities = ProductOutputMapper.toSkuProductEntities(skuProducts, product);

        skuProductRepository.saveAll(entities);
    }

    @Transactional
    public void saveProductSize(ProductEntity product, List<ProductSizeRequest> requests) {
        List<ProductSize> productSizes = requests.stream()
                .map(size -> size.productSizeType().createProductSizeByType(size, product.getId()))
                .toList();
        List<ProductSizeEntity> productSizeEntities = ProductOutputMapper.toProductSizeEntities(productSizes, product);

        productSizeRepository.saveAll(productSizeEntities);
    }

    @Transactional
    public void saveProductImages(ProductEntity product, ProductSaveRequest request) {
        ProductImageDomainService domainService = new ProductImageDomainService();
        List<ProductImage> productImages = domainService.generateProductImages(
                request.thumbnailLink(),
                request.profileImagesLink(),
                request.detailImageLink(),
                product.getId()
        );

        List<ProductImageEntity> imageEntities = ProductOutputMapper.toProductImageEntities(productImages, product);
        productImageRepository.saveAll(imageEntities);
    }

}
