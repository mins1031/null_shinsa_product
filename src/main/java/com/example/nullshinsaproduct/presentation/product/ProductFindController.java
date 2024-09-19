package com.example.nullshinsaproduct.presentation.product;

import com.example.nullshinsaproduct.application.service.product.service.ProductFindService;
import com.example.nullshinsaproduct.common.dto.ResponseResult;
import com.example.nullshinsaproduct.domain.dto.response.ProductOptionStockResponse;
import com.example.nullshinsaproduct.domain.dto.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductFindController {
    private final ProductFindService productFindService;

//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping("/products/{id}")
//    public ResponseResult<ProductResponse> findIntegrationProduct(@PathVariable("id") Long productId) {
//        return ResponseResult.success(productFindService.findIntegrationProductById(productId));
//    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/stock")
    public List<ProductOptionStockResponse> findProductOptionStock(@RequestParam(name = "productIds") List<Long> productOptionIdList) {
        return productFindService.findProductOptionStocks(productOptionIdList);
    }
}
