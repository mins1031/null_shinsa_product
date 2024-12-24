package com.example.nullshinsaproduct.regacy.presentation.product;

import com.example.nullshinsaproduct.regacy.application.facade.ProductFacade;
import com.example.nullshinsaproduct.regacy.application.service.product.service.ClothesProductFindService;
import com.example.nullshinsaproduct.common.dto.ResponseResult;
import com.example.nullshinsaproduct.regacy.application.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaproduct.regacy.application.dto.response.ProductQueryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LegacyProductFindController {
    private final ClothesProductFindService clothesProductFindService;
    private final ProductFacade productFacade;

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/products/{id}")
//    public ResponseResult<ProductQueryResponse> findIntegrationProduct(@PathVariable("id") long productId) {
//        return ResponseResult.success(HttpStatus.OK, productFacade.switchFindProduct(productId));
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/stock")
    public List<ProductOptionStockResponse> findProductOptionStock(@RequestParam(name = "productIds") List<Long> productOptionIdList) {
        return clothesProductFindService.findProductOptionStocks(productOptionIdList);
    }
}
