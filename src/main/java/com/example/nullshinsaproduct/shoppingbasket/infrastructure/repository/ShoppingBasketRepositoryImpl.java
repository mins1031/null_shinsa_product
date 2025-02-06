package com.example.nullshinsaproduct.shoppingbasket.infrastructure.repository;

import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.shoppingbasket.application.outport.port.ShoppingBasketRepository;
import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;
import com.example.nullshinsaproduct.shoppingbasket.infrastructure.repository.jpa.ShoppingBasketJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class ShoppingBasketRepositoryImpl implements ShoppingBasketRepository {
    private final ShoppingBasketJpaRepository shoppingBasketJpaRepository;

    public ShoppingBasketEntity saveShoppingBasket(final ShoppingBasketEntity entity) {
        if (Objects.isNull(entity)) {
            throw new ProductException(ProductExceptionCode.DONT_SAVE_EMPTY_SHOPPING_BASKET);
        }

        return shoppingBasketJpaRepository.save(entity);
    }

    @Override
    public ShoppingBasketEntity findById(long id) {
        return shoppingBasketJpaRepository.findById(id).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT));
    }

    @Override
    public void update(ShoppingBasketEntity entity) {
        // upsert 느낌
        shoppingBasketJpaRepository.save(entity);
    }

    @Override
    public void delete(long basketId) {
        shoppingBasketJpaRepository.deleteById(basketId);
    }
}
