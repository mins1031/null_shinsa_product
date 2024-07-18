package com.example.nullshinsaproduct.application;

import com.example.nullshinsaproduct.domain.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.domain.dto.response.ProductResponse;
import com.example.nullshinsaproduct.domain.entity.Product;
import com.example.nullshinsaproduct.domain.entity.ProductDetailInfo;
import com.example.nullshinsaproduct.domain.entity.ProductOption;
import com.example.nullshinsaproduct.domain.entity.Seller;
import com.example.nullshinsaproduct.exception.product.ProductException;
import com.example.nullshinsaproduct.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.infrastructure.repository.ProductOptionRepository;
import com.example.nullshinsaproduct.infrastructure.repository.ProductRepository;
import com.example.nullshinsaproduct.exception.seller.SellerException;
import com.example.nullshinsaproduct.exception.seller.SellerExceptionCode;
import com.example.nullshinsaproduct.infrastructure.repository.SellerRepository;
import com.example.nullshinsaproduct.mapper.ProductMapper;
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
    private final ProductOptionRepository productOptionRepository;
    private final SellerRepository sellerRepository;

    @Transactional
    public void saveProduct(final ProductSaveRequest request) {
        final Seller seller = sellerRepository.findById(request.getSellerNum()).orElseThrow(() -> new SellerException(SellerExceptionCode.NOT_EXIST_SELLER));
        final Product savedProduct = productRepository.save(Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .seller(seller)
                .productDetailInfo(ProductDetailInfo.from(request.getProductDetailRequest()))
                .couponApplyPossible(request.getCouponApplyPossible())
                .build());

        request.getProductOptionSaveRequests().forEach((optionRequest) -> {
            ProductOption productOption = ProductOption.builder()
                    .color(optionRequest.getColor())
                    .size(optionRequest.getSize())
                    .length(optionRequest.getLength())
                    .shoulder(optionRequest.getShoulder())
                    .chest(optionRequest.getChest())
                    .sleeve(optionRequest.getSleeve())
                    .waist(optionRequest.getWaist())
                    .crotch(optionRequest.getCrotch())
                    .hip(optionRequest.getHip())
                    .thigh(optionRequest.getThigh())
                    .hem(optionRequest.getHem())
                    .stock(optionRequest.getStock())
                    .productId(savedProduct.getId())
                    .build();

            productOptionRepository.save(productOption);
        });
    }
}
