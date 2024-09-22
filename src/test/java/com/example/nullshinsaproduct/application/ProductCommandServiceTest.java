package com.example.nullshinsaproduct.application;

import com.example.nullshinsaproduct.application.service.product.service.ProductCommandService;
import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductStatus;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;
import com.example.nullshinsaproduct.domain.product.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.InferiorLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.domain.product.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.infrastructure.repository.BrandRepository;
import com.example.nullshinsaproduct.application.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.application.dto.request.ProductDetailRequest;
import com.example.nullshinsaproduct.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.application.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.application.dto.request.SkuProductRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ProductCommandServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private ProductCommandService productCommandService;


    @DisplayName("상품을 등록할 수 있다")
    @Test
    void 상품등록() {
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
                "브랜드 상품알림내용 입니다. ",
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

        ProductSaveRequest productSaveRequest = new ProductSaveRequest(
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

//        Brand requestBrand = Brand.builder()
//                .name("brand")
//                .brandPhoneNumber("010-1111-2222")
//                .build();




        //when
//        when(brandRepository.findById(1L)).thenReturn(Optional.of(requestBrand));
//        when(productRepository.save(any())).thenReturn(savedProduct);
//        when(productOptionRepository.save(any())).thenReturn(any());
//
//        productCommandService.saveProduct(productSaveRequest);
//
//        //then
//        verify(sellerRepository, atLeast(1)).findById(1L);
//        verify(productRepository, atLeast(1)).save(any());
//        verify(productOptionRepository, atLeast(2)).save(any());
    }

//    private List<ProductSizeRequest> generateProductOptionSaveRequest() {
//        ProductSizeRequest productSizeRequest1 = new ProductSizeRequest(
//                "color1", "size1", "length1", "shoulder1", "chest1", "sleeve1", "waist1",
//                "crotch1", "hip1", "thigh1", "hem1", 10
//        );
//
//        ProductSizeRequest productSizeRequest2 = new ProductSizeRequest(
//                "color2", "size2", "length2", "shoulder2", "chest2", "sleeve2", "waist2",
//                "crotch2", "hip2", "thigh2", "hem2", 20
//        );
//
//        return List.of(productSizeRequest1, productSizeRequest2);
//    }

    @Test
    void 상품매퍼_정상동작_테스트() {
//        ProductSaveRequest productSaveRequest = new ProductSaveRequest(
//                "신규상품",
//                1L,
//                50000,
//                CouponApplyPossible.POSSIBLE,
//                new ProductDetailRequest("fabric", "country", "washCaution", "manufacturingDate", "qualityGuarantee"),
//                generateProductOptionSaveRequest()
//        );
//
//        Brand requestBrand = Brand.builder()
//                .name("seller")
//                .brandPhoneNumber("010-1111-2222")
//                .build();
//
//        Product savedProduct = Product.builder()
//                .name(productSaveRequest.getName())
//                .price(productSaveRequest.getPrice())
//                .brand(requestBrand)
//                .productDetailInfo(ProductDetailInfo.from(productSaveRequest.getProductDetailRequest()))
//                .couponApplyPossible(productSaveRequest.getCouponApplyPossible())
//                .build();
//
//        ProductOption productOption = ProductOption.builder()
//                .productId(1L)
//                .color("color")
//                .size("size")
//                .length("length")
//                .shoulder("shoulder")
//                .chest("chest")
//                .sleeve("sleeve")
//                .waist("waist")
//                .crotch("crotch")
//                .hip("hip")
//                .thigh("thigh")
//                .hem("hem")
//                .stock(2)
//                .build();
//
//        ProductOption productOption2 = ProductOption.builder()
//                .productId(1L)
//                .color("color2")
//                .size("size2")
//                .length("length2")
//                .shoulder("shoulder2")
//                .chest("chest2")
//                .sleeve("sleeve2")
//                .waist("waist2")
//                .crotch("crotch2")
//                .hip("hip2")
//                .thigh("thigh2")
//                .hem("hem2")
//                .stock(4)
//                .build();
//
//        ProductResponse productResponse = ProductMapper.INSTANCE.toResponseDto(savedProduct, List.of(productOption, productOption2));
//
//        Assertions.assertEquals(savedProduct.getName(), productResponse.name());
//        Assertions.assertEquals(savedProduct.getPrice(), productResponse.price());
//        Assertions.assertEquals(savedProduct.getProductDetailInfo().getFabric(), productResponse.fabric());
//        Assertions.assertEquals(savedProduct.getProductDetailInfo().getWashCaution(), productResponse.washCaution());
//        Assertions.assertEquals(savedProduct.getProductDetailInfo().getQualityGuarantee(), productResponse.qualityGuarantee());
//        Assertions.assertEquals(savedProduct.getProductDetailInfo().getManufacturingDate(), productResponse.manufacturingDate());
//        Assertions.assertEquals(savedProduct.getProductDetailInfo().getManufacturingCountry(), productResponse.manufacturingCountry());
//        Assertions.assertEquals(savedProduct.getCouponApplyPossible(), productResponse.couponApplyPossible());
//        Assertions.assertEquals(2, productResponse.productOptionResponseList().size());
//        Assertions.assertEquals(productOption.getStock(), productResponse.productOptionResponseList().get(0).getStock());
//        Assertions.assertEquals(productOption2.getStock(), productResponse.productOptionResponseList().get(1).getStock());
    }
}