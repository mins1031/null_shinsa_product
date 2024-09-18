package com.example.nullshinsaproduct.application.product.service;

import com.example.nullshinsaproduct.application.combine.ProductDataCombine;
import com.example.nullshinsaproduct.domain.product.entity.Brand;
import com.example.nullshinsaproduct.domain.product.entity.ClothesProduct;
import com.example.nullshinsaproduct.domain.product.entity.ProductImage;
import com.example.nullshinsaproduct.domain.product.entity.ProductSize;
import com.example.nullshinsaproduct.domain.product.entity.ProductTopSize;
import com.example.nullshinsaproduct.domain.product.entity.SkuProduct;
import com.example.nullshinsaproduct.domain.product.entity.embaded.CategoryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.DiscountDetail;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductBrandInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDeliveryInfo;
import com.example.nullshinsaproduct.domain.product.entity.embaded.ProductDetail;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.ImageType;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;
import com.example.nullshinsaproduct.domain.product.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.domain.product.factory.ProductSizeFactory;
import com.example.nullshinsaproduct.infrastructure.repository.BrandRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductDetailRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductImageRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductSizeRepository;
import com.example.nullshinsaproduct.domain.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.domain.dto.request.ProductDetailRequest;
import com.example.nullshinsaproduct.domain.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.domain.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.domain.dto.request.SkuProductRequest;
import com.example.nullshinsaproduct.infrastructure.repository.SkuProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ClothesProductServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private ProductDataCombine productDataCombine;
    @Mock
    private BrandRepository brandRepository;

    @Mock
    private ProductSizeFactory productSizeFactory;

    @InjectMocks
    private ClothesProductService clothesProductService;

    @Test
    @DisplayName("의류 상품을 등록할 수 있다")
    void 의류상품_등록() {
        //given
        CategoryInfoRequest categories = new CategoryInfoRequest(
                FirstLayerCategory.MEN,
                SecondLayerCategory.CLOTHES,
                ThirdLayerCategory.KNIT_WEAR,
                InferiorLayerCategory.TOP
        );

        ProductDetailRequest detail = new ProductDetailRequest(
                "manufacturingCountry",
                "manufacturingCompany",
                "manufacturingDate",
                "qualityGuarantee",
                "fabric",
                "measurement",
                "washCaution",
                "productInnerItems",
                "asOfficerAndTel",
                "detailContent",
                "브랜드 상품알림내용 입니다.",
                "adminDetailContent"
        );

        List<ProductSizeRequest> sizes = List.of(
                new ProductSizeRequest("sizeName", "length", "shoulder",
                        "chest", "sleeve", null, null, null, null, null)
        );

        List<SkuProductRequest> skus = List.of(
                new SkuProductRequest("블루", "M", 0, 0, ProductStatus.TEMP),
                new SkuProductRequest("블루", "L", 0, 0, ProductStatus.TEMP),
                new SkuProductRequest("레드", "M", 0, 0, ProductStatus.TEMP),
                new SkuProductRequest("레드", "L", 0, 0, ProductStatus.TEMP)
        );

        ProductSaveRequest req = new ProductSaveRequest(
                "신규상품",
                1L,
                50000,
                categories,
                CouponApplyPossible.POSSIBLE,
                DiscountApplyPossible.POSSIBLE,
                3,
                15,
                detail,
                sizes,
                "https://thunbnailList.com",
                List.of("https://profileImageLinks"),
                List.of("https://detailImageLinks"),
                skus,
                ProductType.CLOTHES
        );

        Brand requestBrand = Brand.builder()
                .brandName("min-brand")
                .communicationSellingNumber("selling-num")
                .communicationSellingNumber("010-1111-2222")
                .representative("repre")
                .location("토론토")
                .build();

        ProductBrandInfo productBrandInfo = new ProductBrandInfo(
                req.brandId(),
                "min-brand",
                "010-1111-2222",
                "selling-num",
                "repre",
                "토론토"
        );

        CategoryInfo categoryInfo = new CategoryInfo(
                categories.firstLayerCategory(),
                categories.secondLayerCategory(),
                categories.thirdLayerCategory(),
                categories.inferiorLayerCategory()
        );


        ClothesProduct clothesProduct = ClothesProduct.createBasicClothesProduct(
                req.name(),
                req.price(),
                productBrandInfo,
                categoryInfo,
                new DiscountDetail(req.discountApplyPossible(), req.discountMinRate(), req.discountMaxRate()),
                req.couponApplyPossible(),
                ProductDeliveryInfo.createFreeDelivery()
        );

        List<SkuProduct> skuProducts = skus.stream()
                .map(sku -> SkuProduct.createSkuProduct(
                        sku.color(),
                        sku.size(),
                        sku.stock(),
                        sku.discountRate(),
                        sku.productStatus(),
                        clothesProduct
                ))
                .collect(Collectors.toList());

        ProductDetail productDetail = new ProductDetail(
                detail.manufacturingCountry(),
                detail.manufacturingCompany(),
                detail.manufacturingDate(),
                detail.qualityGuarantee(),
                detail.fabric(),
                detail.measurement(),
                detail.washCaution(),
                detail.productInnerItems(),
                detail.asOfficerAndTel(),
                detail.detailContent(),
                detail.brandDetailContent(),
                detail.adminDetailContent(),
                clothesProduct
        );

        List<ProductImage> images = new ArrayList<>();
        images.add(new ProductImage(req.thumbnailLink(), ImageType.THUMBNAIL, clothesProduct));
        images.addAll(
                req.profileImagesLink().stream()
                        .map(link -> new ProductImage(link, ImageType.TITLE, clothesProduct))
                        .collect(Collectors.toList())
        );
        images.addAll(
                req.detailImageLink().stream()
                        .map(link -> new ProductImage(link, ImageType.DETAIL, clothesProduct))
                        .collect(Collectors.toList())
        );

        List<ProductSize> productTopSizes = req.productSizeRequests().stream()
                .map(sizeReq -> new ProductTopSize(
                        sizeReq.sizeName(),
                        clothesProduct,
                        sizeReq.length(),
                        sizeReq.shoulder(),
                        sizeReq.chest(),
                        sizeReq.sleeve()
                )).collect(Collectors.toList());

        //when
        when(brandRepository.findById(req.brandId())).thenReturn(Optional.of(requestBrand));
        when(productSizeFactory.createProductSizeDetailByCategory(any(), any(), anyList())).thenReturn(productTopSizes);
        when(productRepository.save(any())).thenReturn(clothesProduct);
        doNothing().when(productDataCombine).saveProductSubEntities(
                any(),
                anyList(),
                anyList(),
                anyList()
        );

        clothesProductService.saveClothesProduct(req);

        //then
        verify(brandRepository, atLeast(1)).findById(1L);
        verify(productRepository, atLeast(1)).save(any());
        verify(productSizeFactory, atLeast(1))
                .createProductSizeDetailByCategory(any(), any(), anyList());
        verify(productDataCombine, atLeast(1)).saveProductSubEntities(
                any(),
                anyList(),
                anyList(),
                anyList()
        );
    }
}