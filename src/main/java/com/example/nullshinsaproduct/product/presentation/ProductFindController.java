package com.example.nullshinsaproduct.product.presentation;

import com.example.nullshinsaproduct.product.application.input.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.product.application.service.ProductFindService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductFindController {
    private final ProductFindService productFindService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products/{id}")
    public ProductQueryResponse findProductById(@NotNull @PathVariable("id") long id) {
        return productFindService.findProductById(id);
    }
}
