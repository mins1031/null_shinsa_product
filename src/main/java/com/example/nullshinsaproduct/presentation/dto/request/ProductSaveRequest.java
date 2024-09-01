package com.example.nullshinsaproduct.presentation.dto.request;

import com.example.nullshinsaproduct.domain.product.enumeration.CouponApplyPossible;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class ProductSaveRequest {
    @NotBlank(message = "상품생성시 상품명은 필수 입니다.")
    private String name;
    @Min(value = 1, message = "상품생성시 판매자 정보는 필수 입니다.")
    private long sellerNum;
    private int price;
    private CouponApplyPossible couponApplyPossible;
    private ProductDetailRequest productDetailRequest;
    @Size(min = 1, message = "상품 옵션값은 상품당 한개 이상입니다.")
    private List<ProductOptionSaveRequest> productOptionSaveRequests;

    public ProductSaveRequest(
            String name,
            long sellerNum,
            int price,
            CouponApplyPossible couponApplyPossible,
            ProductDetailRequest productDetailRequest,
            List<ProductOptionSaveRequest> productOptionSaveRequests
    ) {
        this.name = name;
        this.sellerNum = sellerNum;
        this.price = price;
        this.couponApplyPossible = couponApplyPossible;
        this.productDetailRequest = productDetailRequest;
        this.productOptionSaveRequests = productOptionSaveRequests;
    }
}
