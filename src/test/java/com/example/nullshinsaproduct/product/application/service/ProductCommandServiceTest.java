package com.example.nullshinsaproduct.product.application.service;

import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.product.application.input.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.product.application.output.map.ProductOutputMapper;
import com.example.nullshinsaproduct.product.application.output.port.FakeBrandRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductImageRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductSizeRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeSkuProductRepository;
import com.example.nullshinsaproduct.product.common.helper.BrandTestHelper;
import com.example.nullshinsaproduct.product.common.helper.ProductTestHelper;
import com.example.nullshinsaproduct.product.domain.Product;
import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductCommandServiceTest {
    private FakeProductRepository productRepository;
    private FakeSkuProductRepository skuProductRepository;
    private FakeProductSizeRepository fakeProductSizeRepository;
    private FakeProductImageRepository fakeProductImageRepository;
    private FakeBrandRepository fakeBrandRepository;

    private ProductCommandService productCommandService;


    @BeforeEach
    void setUp() {
        this.productRepository = new FakeProductRepository();
        this.skuProductRepository = new FakeSkuProductRepository();
        this.fakeProductSizeRepository = new FakeProductSizeRepository();
        this.fakeProductImageRepository = new FakeProductImageRepository();
        this.fakeBrandRepository = new FakeBrandRepository();

        this.productCommandService = new ProductCommandService(
                this.productRepository,
                this.skuProductRepository,
                this.fakeProductSizeRepository,
                this.fakeProductImageRepository,
                this.fakeBrandRepository
        );

        productRepository.save(ProductTestHelper.makeProductEntityInTemp());
        fakeBrandRepository.save(BrandTestHelper.makeBrandEntity());
    }

    @Test
    void 상품_등록요청객체로_상품객체를_저장할_수_있다() {
        //given
        ProductSaveRequest productSaveRequest = ProductTestHelper.makeOuterProductSaveReq();

        //when
        ProductEntity productEntity = productCommandService.saveProduct(productSaveRequest);
        Product product = ProductOutputMapper.toProductDomain(productEntity);

        //then
        assertEquals(productSaveRequest.name(), product.getName());
        assertEquals(productSaveRequest.price(), product.getPrice());
        assertEquals(productSaveRequest.categoryInfoRequest().firstLayerCategory(), product.getCategoryVo().getFirstLayerCategory());
        assertEquals(productSaveRequest.categoryInfoRequest().secondLayerCategory(), product.getCategoryVo().getSecondLayerCategory());
        assertEquals(productSaveRequest.categoryInfoRequest().thirdLayerCategory(), product.getCategoryVo().getThirdLayerCategory());
        assertEquals(productSaveRequest.couponApplyPossible(), product.getCouponApplyPossible());
        assertEquals(productSaveRequest.discountApplyPossible(), product.getDiscountDetail().getDiscountApplyPossible());
        assertEquals(productSaveRequest.discountMinRate(), product.getDiscountDetail().getDiscountMinRate());
        assertEquals(productSaveRequest.discountMaxRate(), product.getDiscountDetail().getDiscountMaxRate());
        assertEquals(productSaveRequest.outboundPossibleDay(), product.getProductDeliveryVo().getOutboundPossibleDay());
        assertEquals(DeliveryFee.findByIsFree(productSaveRequest.isDeliveryFree()), product.getProductDeliveryVo().getDeliveryFee());
        assertEquals(product.getProductStatus(), ProductStatus.TEMP);
        assertEquals(0, product.getSkuProductList().size());
        assertEquals(0, product.getProductSizes().size());
        assertEquals(0, product.getProductImageList().size());
    }


    @Test
    void SKU상품_등록요청DTO_리스트로_SKU상품_엔티티를_저장할_수_있다() {
        //given
        long productId = 1L;
        ProductEntity productEntity = productRepository.findById(productId);
        List<SkuProductRequest> skuProductRequests = ProductTestHelper.makeSkuProductSaveReq();

        //when
        productCommandService.saveSkuProducts(productEntity, skuProductRequests);

        //then
        List<SkuProductEntity> all = skuProductRepository.findAll();
        assertEquals(3, all.size());
        assertEquals(skuProductRequests.get(0).name(), all.get(0).getName());
        assertEquals(skuProductRequests.get(0).stock(), all.get(0).getStock());
        assertEquals(skuProductRequests.get(0).plusPrice(), all.get(0).getPlusPrice());
        assertEquals(skuProductRequests.get(0).skuProductStatus(), all.get(0).getSkuProductStatus());
        assertEquals(productId, all.get(0).getProductId());

        assertEquals(skuProductRequests.get(1).name(), all.get(1).getName());
        assertEquals(skuProductRequests.get(1).stock(), all.get(1).getStock());
        assertEquals(skuProductRequests.get(1).plusPrice(), all.get(1).getPlusPrice());
        assertEquals(skuProductRequests.get(1).skuProductStatus(), all.get(1).getSkuProductStatus());
        assertEquals(productId, all.get(1).getProductId());

        assertEquals(skuProductRequests.get(2).name(), all.get(2).getName());
        assertEquals(skuProductRequests.get(2).stock(), all.get(2).getStock());
        assertEquals(skuProductRequests.get(2).plusPrice(), all.get(2).getPlusPrice());
        assertEquals(skuProductRequests.get(2).skuProductStatus(), all.get(2).getSkuProductStatus());
        assertEquals(productId, all.get(2).getProductId());
    }

    @Test
    void 상품사이즈_등록요청DTO_리스트로_상품사이즈_엔티티를_저장할_수_있다() {
        //given
        long productId = 1L;
        ProductEntity productEntity = productRepository.findById(productId);
        List<ProductSizeRequest> productSizeRequests = ProductTestHelper.makeProductSizeReqs();

        //when
        productCommandService.saveProductSize(productEntity, productSizeRequests);

        //then
        List<ProductSizeEntity> all = fakeProductSizeRepository.findAll();
        assertEquals(2, all.size());
        assertEquals(productSizeRequests.get(0).totalLength(), all.get(0).getTotalLength());
        assertEquals(productSizeRequests.get(0).shoulder(), all.get(0).getShoulder());
        assertEquals(productSizeRequests.get(0).chest(), all.get(0).getChest());
        assertEquals(productSizeRequests.get(0).sleeve(), all.get(0).getSleeve());
        assertEquals(productId, all.get(0).getProductId());

        assertEquals(productSizeRequests.get(1).totalLength(), all.get(1).getTotalLength());
        assertEquals(productSizeRequests.get(1).shoulder(), all.get(1).getShoulder());
        assertEquals(productSizeRequests.get(1).chest(), all.get(1).getChest());
        assertEquals(productSizeRequests.get(1).sleeve(), all.get(1).getSleeve());
        assertEquals(productId, all.get(1).getProductId());
    }

    @Test
    void 상품이미지_등록요청DTO_리스트로_상품이미지_엔티티를_저장할_수_있다() {
        //given
        long productId = 1L;
        ProductEntity productEntity = productRepository.findById(productId);
        ProductSaveRequest productSaveRequest = ProductTestHelper.makeOuterProductSaveReq();

        //when
        productCommandService.saveProductImages(productEntity, productSaveRequest);

        //then
        List<ProductImageEntity> all = fakeProductImageRepository.findAll();
        assertEquals(5, all.size());
        assertEquals(productSaveRequest.thumbnailLink(), all.get(0).getImageUrl());
        assertEquals(ImageType.THUMBNAIL, all.get(0).getImageType());
        assertEquals(productId, all.get(0).getProductId());

        assertEquals(productSaveRequest.profileImagesLink().get(0), all.get(1).getImageUrl());
        assertEquals(ImageType.PROFILE, all.get(1).getImageType());
        assertEquals(productId, all.get(1).getProductId());

        assertEquals(productSaveRequest.profileImagesLink().get(1), all.get(2).getImageUrl());
        assertEquals(ImageType.PROFILE, all.get(2).getImageType());
        assertEquals(productId, all.get(2).getProductId());

        assertEquals(productSaveRequest.detailImageLink().get(0), all.get(3).getImageUrl());
        assertEquals(ImageType.DETAIL, all.get(3).getImageType());
        assertEquals(productId, all.get(3).getProductId());

        assertEquals(productSaveRequest.detailImageLink().get(1), all.get(4).getImageUrl());
        assertEquals(ImageType.DETAIL, all.get(4).getImageType());
        assertEquals(productId, all.get(4).getProductId());
    }

}