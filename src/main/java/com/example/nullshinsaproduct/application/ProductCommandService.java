package com.example.nullshinsaproduct.application;

import com.example.nullshinsaproduct.domain.product.entity.ProductClothesBottomOption;
import com.example.nullshinsaproduct.domain.product.entity.ProductClothesOption;
import com.example.nullshinsaproduct.domain.product.entity.ProductClothesTopOption;
import com.example.nullshinsaproduct.presentation.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.ProductDetailInfo;
import com.example.nullshinsaproduct.domain.product.entity.Brand;
import com.example.nullshinsaproduct.infrastructure.repository.ProductOptionRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.exception.seller.SellerException;
import com.example.nullshinsaproduct.exception.seller.SellerExceptionCode;
import com.example.nullshinsaproduct.infrastructure.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductCommandService {
    private final ProductRepository productRepository;
    private final ProductOptionRepository productOptionRepository;
    private final SellerRepository sellerRepository;

    @Transactional
    public void saveProduct(final ProductSaveRequest request) {
        final Brand brand = sellerRepository.findById(request.getSellerNum()).orElseThrow(() -> new SellerException(SellerExceptionCode.NOT_EXIST_SELLER));
        final Product savedProduct = productRepository.save(Product.createProduct(
                request.getName(),
                request.getPrice(),
                ProductDetailInfo.from(request.getProductDetailRequest()),
                request.getCouponApplyPossible(),
                brand.getId()
                )
        );

        request.getProductOptionSaveRequests().forEach((optionRequest) -> {
            ProductClothesOption productClothesOption = ProductClothesOption.builder()
                    .color(optionRequest.getColor())
                    .size(optionRequest.getSize())
                    .productClothesTopOption(new ProductClothesTopOption(
                            optionRequest.getLength(),
                            optionRequest.getShoulder(),
                            optionRequest.getChest(),
                            optionRequest.getSleeve()
                    ))
                    .productClothesBottomOption(new ProductClothesBottomOption(
                            optionRequest.getWaist(),
                            optionRequest.getCrotch(),
                            optionRequest.getHip(),
                            optionRequest.getThigh(),
                            optionRequest.getHem()
                    ))
                    .stock(optionRequest.getStock())
                    .productId(savedProduct.getId())
                    .build();

            productOptionRepository.save(productClothesOption);
        });
    }
}
