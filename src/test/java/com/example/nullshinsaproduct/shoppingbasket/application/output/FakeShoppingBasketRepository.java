package com.example.nullshinsaproduct.shoppingbasket.application.output;

import com.example.nullshinsaproduct.common.CommonTestHelper;
import com.example.nullshinsaproduct.shoppingbasket.application.outport.port.ShoppingBasketRepository;
import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FakeShoppingBasketRepository implements ShoppingBasketRepository {
    private long idCountIncrement = 0;
    private Map<Long, ShoppingBasketEntity> fakeShoppingBasketContext = Collections.synchronizedMap(new HashMap<>());

    @Override
    public ShoppingBasketEntity saveShoppingBasket(ShoppingBasketEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[장바구니 상품저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeShoppingBasketContext.put(idCountIncrement, entity);
        CommonTestHelper.injectIdInEntity(entity, "id", idCountIncrement);

        return fakeShoppingBasketContext.get(idCountIncrement);
    }

    @Override
    public ShoppingBasketEntity findById(long id) {
        return fakeShoppingBasketContext.get(id);
    }

    @Override
    public void update(ShoppingBasketEntity entity) {
        ShoppingBasketEntity shoppingBasketEntity = fakeShoppingBasketContext.get(entity.getId());

    }

    @Override
    public void delete(long basketId) {
        fakeShoppingBasketContext.remove(basketId);
    }
}
