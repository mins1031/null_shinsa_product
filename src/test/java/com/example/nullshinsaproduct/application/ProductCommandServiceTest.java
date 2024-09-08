package com.example.nullshinsaproduct.application;

import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.presentation.dto.request.ProductDetailRequest;
import com.example.nullshinsaproduct.presentation.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.presentation.dto.request.ProductOptionSaveRequest;
import com.example.nullshinsaproduct.infrastructure.repository.SellerRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductCommandServiceTest {
    @Mock
    private ProductRepository productRepository;
    @Mock
    private SellerRepository sellerRepository;

    @InjectMocks
    private ProductCommandService productCommandService;


    @DisplayName("상품을 등록할 수 있다")
    @Test
    void 상품등록() {
        //given
        ProductSaveRequest productSaveRequest = new ProductSaveRequest(
                "신규상품",
                1L,
                50000,
                CouponApplyPossible.POSSIBLE,
                new ProductDetailRequest("fabric", "country", "washCaution", "manufacturingDate", "qualityGuarantee"),
                generateProductOptionSaveRequest()
        );

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
//        //when
//        when(sellerRepository.findById(1L)).thenReturn(Optional.of(requestBrand));
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

    private List<ProductOptionSaveRequest> generateProductOptionSaveRequest() {
        ProductOptionSaveRequest productOptionSaveRequest1 = new ProductOptionSaveRequest(
                "color1", "size1", "length1", "shoulder1", "chest1", "sleeve1", "waist1",
                "crotch1", "hip1", "thigh1", "hem1", 10
        );

        ProductOptionSaveRequest productOptionSaveRequest2 = new ProductOptionSaveRequest(
                "color2", "size2", "length2", "shoulder2", "chest2", "sleeve2", "waist2",
                "crotch2", "hip2", "thigh2", "hem2", 20
        );

        return List.of(productOptionSaveRequest1, productOptionSaveRequest2);
    }

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