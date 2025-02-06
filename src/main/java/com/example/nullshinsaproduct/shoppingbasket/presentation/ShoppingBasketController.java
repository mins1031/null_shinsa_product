package com.example.nullshinsaproduct.shoppingbasket.presentation;

import com.example.nullshinsaproduct.common.dto.ResponseResult;
import com.example.nullshinsaproduct.review.application.dto.request.ReviewSaveRequest;
import com.example.nullshinsaproduct.shoppingbasket.application.ShoppingBasketService;
import com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request.ShoppingBasketSaveRequest;
import com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request.ShoppingBasketUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShoppingBasketController {
    private final ShoppingBasketService shoppingBasketService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/shopping-basket")
    public ResponseResult<Boolean> saveShoppingBasketItem(@Valid @RequestBody ShoppingBasketSaveRequest request) {
        log.info("장바구니 상품 등록 req : {}", request);
        shoppingBasketService.saveItem(request);
        return ResponseResult.success(HttpStatus.CREATED, true);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/shopping-basket")
    public ResponseResult<Boolean> updateShoppingBasketItem(@Valid @RequestBody ShoppingBasketUpdateRequest request) {
        log.info("장바구니 sku 수정 req : {}", request);
        shoppingBasketService.updateItem(request);
        return ResponseResult.success(HttpStatus.OK, true);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/shopping-basket/{basketId}")
    public ResponseResult<Boolean> deleteShoppingBasketItem(@PathVariable("basketId") Long basketId) {
        log.info("장바구니 sku 삭제 basketId : {}", basketId);
        shoppingBasketService.deleteItem(basketId);
        return ResponseResult.success(HttpStatus.OK, true);
    }

}
