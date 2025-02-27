package com.example.nullshinsaproduct.shoppingbasket.application;

import com.example.nullshinsaproduct.brand.apllication.output.map.BrandOutputMapper;
import com.example.nullshinsaproduct.brand.apllication.output.port.BrandRepository;
import com.example.nullshinsaproduct.brand.domain.Brand;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductDslRepository;
import com.example.nullshinsaproduct.product.application.output.port.SkuProductRepository;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.dto.FindSkuWithProductDto;
import com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request.ShoppingBasketSaveRequest;
import com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request.ShoppingBasketUpdateRequest;
import com.example.nullshinsaproduct.shoppingbasket.application.outport.map.ShoppingBasketOutputMapper;
import com.example.nullshinsaproduct.shoppingbasket.application.outport.port.ShoppingBasketRepository;
import com.example.nullshinsaproduct.shoppingbasket.domain.ShoppingBasket;
import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ShoppingBasketService {
    private final SkuProductDslRepository skuProductDslRepository;
    private final SkuProductRepository skuProductRepository;
    private final BrandRepository brandRepository;
    private final ShoppingBasketRepository shoppingBasketRepository;

    // 1. 일단 저장은 어렵지 않음. 그냥 어떤 상품을 누가 장바구니에 담았는지 알기만 하면됨.
    // 1-1. 저장시에도 그시점 최대 할인률이 계산되서 인입되야함 -> 할인 가능한 부분들 정리해서 코드화 필요 -> 적용되었던 할인률 정도만 인입하자
    // 2. 옵션변경도 옵션을 변경하며 함께 변경되야하는 부분만 변경처리되는거라 어렵지 않음.
    // 3. 삭제 역시 쉬움
    // 4. 조회가... 현시점 가격때문에 살짝 애매하긴함.
    // 4-1. 일단 할인가 자체를 계산해야함. -> 저장시에도 그시점 최대 할인률이 계산되서 인입되야함 -> 할인 가능한 부분들 정리해서 코드화 필요
    // 4-2. 저장 구현후 조회 구현 필요

    @Transactional
    public void saveItem(ShoppingBasketSaveRequest req) {
        Brand brand = BrandOutputMapper.toDomainFromEntity(
                brandRepository.findById(req.brandId())
        );

        FindSkuWithProductDto productAndSkuDto = findSkuWithProductDto(req.productId(), req.skuId());

        shoppingBasketRepository.saveShoppingBasket(
                ShoppingBasketEntity.of(
                        null,
                        productAndSkuDto.getProductId(),
                        productAndSkuDto.getSkuId(),
                        req.customerId(),
                        brand.getId(),
                        brand.getBrandName(),
                        productAndSkuDto.getProductName(),
                        productAndSkuDto.getSkuName(),
                        req.skuCount(),
                        productAndSkuDto.getProductOriginPrice(),
                        req.presentDiscountPricePerSku() // 이거 세일이라는 어그리거트 하나 만들긴 해야할듯..
                )
        );
    }

    private FindSkuWithProductDto findSkuWithProductDto(long productId, long skuId) {
        FindSkuWithProductDto productAndSkuDto = skuProductDslRepository.findProductAndSkuByIds(productId, skuId);
        if (Objects.isNull(productAndSkuDto)) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT);
        }

        boolean isCantSellProduct = ProductStatus.SELLING.getSeq() != productAndSkuDto.getProductStatus().getSeq();
        boolean isCantSellSku = SkuProductStatus.SELLING.getSeq() != productAndSkuDto.getSkuProductStatus().getSeq();
        if (isCantSellProduct || isCantSellSku) {
            throw new ProductException(ProductExceptionCode.DONT_SAVE_SELL_STATUS_PRODUCT_IN_SHOPPING_BASKET);
        }

        return productAndSkuDto;
    }

    @Transactional
    public void updateItem(ShoppingBasketUpdateRequest req) {
        if (req.isNotExistSkuValue()) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        ShoppingBasket shoppingBasket = ShoppingBasketOutputMapper.toDomainFromEntity(
                shoppingBasketRepository.findById(req.basketId())
        );
        SkuProductEntity skuProductEntity = skuProductRepository.findById(req.skuId());

        shoppingBasket.changeProductSku(
                skuProductEntity.getId(),
                skuProductEntity.getName(),
                req.skuCount()
        );

        shoppingBasketRepository.update(
                ShoppingBasketOutputMapper.toEntityFromDomain(shoppingBasket)
        );
    }

    @Transactional
    public void deleteItem(long basketId) {
        if (basketId == 0) {
            throw new ProductException(ProductExceptionCode.NOT_EXIST_REQUEST_PARAMS);
        }

        shoppingBasketRepository.delete(basketId);
    }

    @Transactional(readOnly = true)
    public List<ShoppingBasket> findAllItemsInUserShoppingBasket() {
        //결국 특정기간에 진행되는 세일이 존재하고 이 세일들을 등록해 현재 이 상품에 적용할 수 있는 세일은 무엇이 있는지, 적용 가능한 세일중 가장 할인 폭이 큰 세일은 무엇인지 등등을 판단할 수 있어야함.
        // 나는 상품을 세일하는 방법이 하나의 세일 말고도 여러 세일종류를 중복으로 처리 가능한줄 알고 있었고 이에따라 그 상품의 할인 가능한 종류들을 모두 모아서 가격을 할인해야하는 방식을 생각했었음.
        // 그럼.. 할인개념 등록하는거 부터 처리해야 할듯?

        //음.. 일단 장바구니나 요약 화면 성격상.. 상세한 정보 출력 보다는 대략의 아 이게 할인이라는 개념을 적용하는게 생각보다 빡쌔네
        // 무신사 링크를 참고하되 -> 근데 원래 생각하던 기능이긴 했음 : https://medium.com/musinsa-tech/%EB%AC%B4%EC%A7%84%EC%9E%A5-%EB%B8%94%EB%9E%99-%ED%94%84%EB%9D%BC%EC%9D%B4%EB%8D%B0%EC%9D%B4-%EA%B0%80%EA%B2%A9-%ED%95%A0%EC%9D%B8%EC%9D%80-%EC%96%B4%EB%96%BB%EA%B2%8C-%ED%95%A0%EA%B9%8C-6f8517b5795a
        // 다만 무신사는 내가 생각한 플랫폼 + 상품 할인을 통합해 그냥 "상품할인"이라는 하나의 개념으로 사용하는듯 했음.
        return null;
    }
}
