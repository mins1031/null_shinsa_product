package com.example.nullshinsaproduct.shoppingbasket.domain;

import lombok.Getter;

@Getter
public class ShoppingBasket {

    // 상품의 재고만으로 품절여부를 판단할지
    // 당연히 1번임. 이 재고 데이터 조회 주체가 레디스든 리얼 디비데이터든. 실시간성 데이터가 필요하기에 무조건 1번임 고민 x
    // 여기 도메인 객체에는 실시간성 데이터가 아닌것에 대한 저장이 필요

    //TODO 장바구니 도메인 기능 명세
    // 1. 품절처리를 위한 상품id 정보 및 품절처리
    // 2. 현재 판매 상태를 적용하는 기능
    // 3. insert 당시 가격 vs 현재 가격 -> 원가에서 할인율 계산한거 차이 출력
    // 4.

    private Long basketId;
    private long productId;
    private long skuId;
    private long customerId;
    private long brandId;
    private String brandName;
    private String productName;
    private String skuName;
    private int skuCount;
    private int productPrice;
    private int discountPriceWhenSave;
    private boolean isSoldOut;

    public ShoppingBasket(
            Long basketId,
            long productId,
            long skuId,
            long customerId,
            long brandId,
            String brandName,
            String productName,
            String skuName,
            int skuCount,
            int productPrice,
            int discountPriceWhenSave,
            boolean isSoldOut
    ) {
        this.basketId = basketId;
        this.productId = productId;
        this.skuId = skuId;
        this.customerId = customerId;
        this.brandId = brandId;
        this.brandName = brandName;
        this.productName = productName;
        this.skuName = skuName;
        this.skuCount = skuCount;
        this.productPrice = productPrice;
        this.discountPriceWhenSave = discountPriceWhenSave;
        this.isSoldOut = isSoldOut;
    }

    public static ShoppingBasket ofDefault(
            long productId,
            long skuId,
            long customerId,
            long brandId,
            String brandName,
            String productName,
            String skuName,
            int skuCount,
            int productPrice,
            int discountPriceWhenSave
    ) {
        return new ShoppingBasket(
                null,
                productId,
                skuId,
                customerId,
                brandId,
                brandName,
                productName,
                skuName,
                skuCount,
                productPrice,
                discountPriceWhenSave,
                false
        );
    }

    public void changeProductSku(
            String productName,
            String skuName,
            int skuCount
    ) {
        this.productName = productName;
        this.skuName = skuName;
        this.skuCount = skuCount;
    }

    public void switchSoldOut() {
        this.isSoldOut = true;
    }

    public int calculateDiscountGapWithPresent(
            int productOriginPrice,
            int presentDiscountPercent,
            int presentDiscountPrice
    ) {
        return 0;
    }

    // 쿠폰 적용 -> 일단 쿠폰기능 주문쪽인데 재대로 개발 안됐으니 스킵
//    public void applyCoupon(
//            //쿠폰 정보
//    ) {}


}
