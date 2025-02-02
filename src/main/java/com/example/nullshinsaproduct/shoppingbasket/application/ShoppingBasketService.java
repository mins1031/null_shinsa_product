package com.example.nullshinsaproduct.shoppingbasket.application;

import com.example.nullshinsaproduct.brand.apllication.output.port.BrandRepository;
import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.output.port.ProductDslRepository;
import com.example.nullshinsaproduct.product.application.output.port.ProductRepository;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductDslRepository;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.dto.FindSkuWithProductDto;
import com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request.ShoppingBasketSaveRequest;
import com.example.nullshinsaproduct.shoppingbasket.domain.ShoppingBasket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ShoppingBasketService {
    private final SkuProductDslRepository skuProductDslRepository;
    private final BrandRepository brandRepository;

    // 1. 일단 저장은 어렵지 않음. 그냥 어떤 상품을 누가 장바구니에 담았는지 알기만 하면됨.
    // 1-1. 저장시에도 그시점 최대 할인률이 계산되서 인입되야함 -> 할인 가능한 부분들 정리해서 코드화 필요
    // 2. 옵션변경도 옵션을 변경하며 함께 변경되야하는 부분만 변경처리되는거라 어렵지 않음.
    // 3. 삭제 역시 쉬움
    // 4. 조회가... 현시점 가격때문에 살짝 애매하긴함.
    // 4-1. 일단 할인가 자체를 계산해야함. -> 저장시에도 그시점 최대 할인률이 계산되서 인입되야함 -> 할인 가능한 부분들 정리해서 코드화 필요
    // 4-2. 저장 구현후 조회 구현 필요

    @Transactional
    public void saveItem(ShoppingBasketSaveRequest req) {
        BrandEntity brandEntity = brandRepository.findById(req.brandId());
        FindSkuWithProductDto productAndSkuDto = skuProductDslRepository.findProductAndSkuByIds(req.productId(), req.skuId());
        if (Objects.isNull(productAndSkuDto)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT);
        }



    }

    public void updateItem() {}

    public void deleteItem() {}

    public List<ShoppingBasket> findAllItemsInUserShoppingBasket() {

        return null;
    }
}
