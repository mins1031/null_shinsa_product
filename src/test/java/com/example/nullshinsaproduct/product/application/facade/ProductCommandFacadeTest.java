package com.example.nullshinsaproduct.product.application.facade;

import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.application.output.map.ProductOutputMapper;
import com.example.nullshinsaproduct.product.application.output.port.FakeBrandRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductImageRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductSizeRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeSkuProductRepository;
import com.example.nullshinsaproduct.product.application.service.ProductCommandService;
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


class ProductCommandFacadeTest {
    private FakeProductRepository fakeProductRepository;
    private FakeSkuProductRepository fakeSkuProductRepository;
    private FakeProductSizeRepository fakeProductSizeRepository;
    private FakeProductImageRepository fakeProductImageRepository;
    private FakeBrandRepository fakeBrandRepository;

    private ProductCommandFacade productCommandFacade;

    @BeforeEach
    void setUp() {
        this.fakeProductRepository = new FakeProductRepository();
        this.fakeSkuProductRepository = new FakeSkuProductRepository();
        this.fakeProductSizeRepository = new FakeProductSizeRepository();
        this.fakeProductImageRepository = new FakeProductImageRepository();
        this.fakeBrandRepository = new FakeBrandRepository();

        ProductCommandService productCommandService = new ProductCommandService(
                this.fakeProductRepository,
                this.fakeSkuProductRepository,
                this.fakeProductSizeRepository,
                this.fakeProductImageRepository,
                this.fakeBrandRepository
        );

        fakeBrandRepository.save(BrandTestHelper.makeBrandEntity());
        this.productCommandFacade = new ProductCommandFacade(
                productCommandService,
                System.out::println
        );
    }

    @Test
    void 상품저장_전프로세스가_정상적으로_처리될_수_있다() {
        //gven
        ProductSaveRequest req = ProductTestHelper.makeOuterProductSaveReq();

        //when
        productCommandFacade.saveProduct(req);

        //then
        ProductEntity productEntity = fakeProductRepository.findById(1L);

        // ==== 상품 검증 로직 ====
        Product product = ProductOutputMapper.toProductDomain(productEntity);
        assertEquals(req.name(), product.getName());
        assertEquals(req.price(), product.getPrice());
        assertEquals(req.categoryInfoRequest().firstLayerCategory(), product.getCategoryVo().getFirstLayerCategory());
        assertEquals(req.categoryInfoRequest().secondLayerCategory(), product.getCategoryVo().getSecondLayerCategory());
        assertEquals(req.categoryInfoRequest().thirdLayerCategory(), product.getCategoryVo().getThirdLayerCategory());
        assertEquals(req.couponApplyPossible(), product.getCouponApplyPossible());
        assertEquals(req.discountApplyPossible(), product.getDiscountDetail().getDiscountApplyPossible());
        assertEquals(req.discountMinRate(), product.getDiscountDetail().getDiscountMinRate());
        assertEquals(req.discountMaxRate(), product.getDiscountDetail().getDiscountMaxRate());
        assertEquals(req.outboundPossibleDay(), product.getProductDeliveryVo().getOutboundPossibleDay());
        assertEquals(DeliveryFee.findByIsFree(req.isDeliveryFree()), product.getProductDeliveryVo().getDeliveryFee());
        assertEquals(product.getProductStatus(), ProductStatus.TEMP);

        // ==== SKU 검증 로직 ====
        List<SkuProductEntity> fakeSkuProducts = fakeSkuProductRepository.findAll();
        assertEquals(3, fakeSkuProducts.size());
        assertEquals(req.skuProductRequests().get(0).name(), fakeSkuProducts.get(0).getName());
        assertEquals(req.skuProductRequests().get(0).stock(), fakeSkuProducts.get(0).getStock());
        assertEquals(req.skuProductRequests().get(0).plusPrice(), fakeSkuProducts.get(0).getPlusPrice());
        assertEquals(req.skuProductRequests().get(0).skuProductStatus(), fakeSkuProducts.get(0).getSkuProductStatus());
        assertEquals(productEntity.getId(), fakeSkuProducts.get(0).getProductId());

        assertEquals(req.skuProductRequests().get(1).name(), fakeSkuProducts.get(1).getName());
        assertEquals(req.skuProductRequests().get(1).stock(), fakeSkuProducts.get(1).getStock());
        assertEquals(req.skuProductRequests().get(1).plusPrice(), fakeSkuProducts.get(1).getPlusPrice());
        assertEquals(req.skuProductRequests().get(1).skuProductStatus(), fakeSkuProducts.get(1).getSkuProductStatus());
        assertEquals(productEntity.getId(), fakeSkuProducts.get(1).getProductId());

        assertEquals(req.skuProductRequests().get(2).name(), fakeSkuProducts.get(2).getName());
        assertEquals(req.skuProductRequests().get(2).stock(), fakeSkuProducts.get(2).getStock());
        assertEquals(req.skuProductRequests().get(2).plusPrice(), fakeSkuProducts.get(2).getPlusPrice());
        assertEquals(req.skuProductRequests().get(2).skuProductStatus(), fakeSkuProducts.get(2).getSkuProductStatus());
        assertEquals(productEntity.getId(), fakeSkuProducts.get(2).getProductId());

        // ==== 상품 사이즈 검증 로직 ====
        List<ProductSizeEntity> fakeProductSizes = fakeProductSizeRepository.findAll();
        assertEquals(1, fakeProductSizes.size());
        assertEquals(req.productSizeRequests().get(0).totalLength(), fakeProductSizes.get(0).getTotalLength());
        assertEquals(req.productSizeRequests().get(0).shoulder(), fakeProductSizes.get(0).getShoulder());
        assertEquals(req.productSizeRequests().get(0).chest(), fakeProductSizes.get(0).getChest());
        assertEquals(req.productSizeRequests().get(0).sleeve(), fakeProductSizes.get(0).getSleeve());
        assertEquals(productEntity.getId(), fakeProductSizes.get(0).getProductId());

        // ==== 상품 이미지 검증 로직 ====
        List<ProductImageEntity> fakeProductImages = fakeProductImageRepository.findAll();
        assertEquals(5, fakeProductImages.size());
        assertEquals(req.thumbnailLink(), fakeProductImages.get(0).getImageUrl());
        assertEquals(ImageType.THUMBNAIL, fakeProductImages.get(0).getImageType());
        assertEquals(productEntity.getId(), fakeProductImages.get(0).getProductId());

        assertEquals(req.profileImagesLink().get(0), fakeProductImages.get(1).getImageUrl());
        assertEquals(ImageType.PROFILE, fakeProductImages.get(1).getImageType());
        assertEquals(productEntity.getId(), fakeProductImages.get(1).getProductId());

        assertEquals(req.profileImagesLink().get(1), fakeProductImages.get(2).getImageUrl());
        assertEquals(ImageType.PROFILE, fakeProductImages.get(2).getImageType());
        assertEquals(productEntity.getId(), fakeProductImages.get(2).getProductId());

        assertEquals(req.detailImageLink().get(0), fakeProductImages.get(3).getImageUrl());
        assertEquals(ImageType.DETAIL, fakeProductImages.get(3).getImageType());
        assertEquals(productEntity.getId(), fakeProductImages.get(3).getProductId());

        assertEquals(req.detailImageLink().get(1), fakeProductImages.get(4).getImageUrl());
        assertEquals(ImageType.DETAIL, fakeProductImages.get(4).getImageType());
        assertEquals(productEntity.getId(), fakeProductImages.get(4).getProductId());
    }

}