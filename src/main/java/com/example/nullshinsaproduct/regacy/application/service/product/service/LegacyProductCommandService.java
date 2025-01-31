package com.example.nullshinsaproduct.regacy.application.service.product.service;

import com.example.nullshinsaproduct.product.application.input.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductJpaRepository;
import com.example.nullshinsaproduct.brand.infrastructure.BrandJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LegacyProductCommandService {
    private final ProductJpaRepository productJpaRepository;
    private final BrandJpaRepository brandJpaRepository;

    @Transactional
    public void saveProduct(final ProductSaveRequest request) {
//        final Brand brand = sellerRepository.findById(request.getSellerNum()).orElseThrow(() -> new SellerException(SellerExceptionCode.NOT_EXIST_SELLER));
//        final Product savedProduct = productRepository.save(Product.createProduct(
//                request.getName(),
//                request.getPrice(),
//                ProductDetailInfo.from(request.getProductDetailRequest()),
//                request.getCouponApplyPossible(),
//                brand.getId()
//                )
//        );

//        request.getProductOptionSaveRequests().forEach((optionRequest) -> {
//            ProductClothesOption productClothesOption = ProductClothesOption.builder()
//                    .color(optionRequest.getColor())
//                    .size(optionRequest.getSize())
//                    .productTopSize(new ProductTopSize(
//                            optionRequest.getLength(),
//                            optionRequest.getShoulder(),
//                            optionRequest.getChest(),
//                            optionRequest.getSleeve()
//                    ))
//                    .productBottomSize(new ProductBottomSize(
//                            optionRequest.getWaist(),
//                            optionRequest.getCrotch(),
//                            optionRequest.getHip(),
//                            optionRequest.getThigh(),
//                            optionRequest.getHem()
//                    ))
//                    .stock(optionRequest.getStock())
//                    .productId(savedProduct.getId())
//                    .build();
//
//            productOptionRepository.save(productClothesOption);
//        });
    }
}
