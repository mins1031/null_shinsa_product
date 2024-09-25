package com.example.nullshinsaproduct.application.service.brand;

import com.example.nullshinsaproduct.application.dto.request.BrandSaveRequest;
import com.example.nullshinsaproduct.domain.product.entity.Brand;
import com.example.nullshinsaproduct.infrastructure.repository.brand.BrandRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandCommandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandCommandService brandCommandService;

    @DisplayName("브랜드 정상등록 테스트")
    @Test
    void 브랜드_등록() {
        //given
        BrandSaveRequest request = new BrandSaveRequest(
                "브랜드1",
                "한줄 소개 입니다",
                "11-11-22-4",
                "031-242-1111",
                "사업자1",
                "서울특별시 강남구 개쩌는동",
                "titleImage",
                "introImage"
        );

        //when
        when(brandRepository.save(any(Brand.class))).thenReturn(any(Brand.class));

        brandCommandService.saveBrand(request);

        //then
        verify(brandRepository, atLeast(1)).save(any(Brand.class));
    }
}