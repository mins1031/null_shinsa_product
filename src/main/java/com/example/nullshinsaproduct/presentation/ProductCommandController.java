package com.example.nullshinsaproduct.presentation;

import com.example.nullshinsaproduct.application.ProductCommandService;
import com.example.nullshinsaproduct.presentation.dto.request.ProductSaveRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductCommandController {
    private final ProductCommandService productCommandService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/products")
    public void saveProduct(@Valid @RequestBody ProductSaveRequest request) {
        productCommandService.saveProduct(request);
    }
}
