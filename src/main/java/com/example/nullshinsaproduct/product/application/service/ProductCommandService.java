package com.example.nullshinsaproduct.product.application.service;

import com.example.nullshinsaproduct.brand.apllication.output.port.BrandRepository;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductStatusUpdateResponse;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.application.input.dto.response.ProductStatusUpdateResponseList;
import com.example.nullshinsaproduct.product.application.output.map.ProductOutputMapper;
import com.example.nullshinsaproduct.product.application.output.port.ProductDslRepository;
import com.example.nullshinsaproduct.product.application.output.port.ProductImageRepository;
import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.application.output.port.ProductSizeRepository;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductDslRepository;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductRepository;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.ProductImage;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.SkuProduct;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
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
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCommandService {
    private final ProductRepository productRepository;
    private final SkuProductRepository skuProductRepository;
    private final ProductSizeRepository productSizeRepository;
    private final ProductImageRepository productImageRepository;
    private final BrandRepository brandRepository;
    private final ProductDslRepository productDslRepository;
    private final SkuProductDslRepository skuProductDslRepository;


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


    // 변경 해야함. 음.... 일단 연관관계 sku 조회부터 내부 도메인 로직에서 실패시 false응답도 받아서 처리해야함.
    @Transactional
    public ProductStatusUpdateResponseList updateApproveStatus(final List<Long> productIds) {
        List<ProductEntity> productEntities = productRepository.findByIds(productIds);
        if (CollectionUtils.isEmpty(productEntities)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT);
        }

        // 여기가 N+1 포인트임.
        // QueryDsl 의 fetchJoin으로 개선할건지 다른방식으로 할건지 정해야함. --> N+1 공부 및 카타시안 곱 조인 공부해볼것.
        List<Product> products = ProductOutputMapper.toProductDomains(productEntities);

        List<ProductStatusUpdateResponse> responses = products.stream()
                .map(this::switchResponseByError)
                .toList();

        updateEntity(responses);

        return ProductStatusUpdateResponseList.of(responses);
    }

    private void updateEntity(List<ProductStatusUpdateResponse> responses) {
        List<Long> updateSuccessIds = responses.stream()
                .filter(ProductStatusUpdateResponse::isSuccess)
                .map(ProductStatusUpdateResponse::id)
                .collect(Collectors.toList());
        if (updateSuccessIds.isEmpty()) {
            return;
        }

        productDslRepository.updateStatusByIds(
                updateSuccessIds,
                ProductStatus.APPROVE
        );
        skuProductDslRepository.updateStatusByIds(
                updateSuccessIds,
                SkuProductStatus.APPROVE
        );
    }

    private ProductStatusUpdateResponse switchResponseByError(Product product) {
        try {
            product.updateApproveStatus();
            return ProductStatusUpdateResponse.of(
                    product.getId(),
                    product.getName(),
                    ProductStatus.APPROVE,
                    true,
                    null
            );
        } catch (ProductException e) {
            return ProductStatusUpdateResponse.of(
                    product.getId(),
                    product.getName(),
                    ProductStatus.APPROVE,
                    false,
                    e.getMessage()
            );
        }
    }
}
