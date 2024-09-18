package com.example.nullshinsaproduct.domain.product.factory;

import com.example.nullshinsaproduct.domain.dto.request.ProductSizeRequest;
import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.ProductBottomSize;
import com.example.nullshinsaproduct.domain.product.entity.ProductSize;
import com.example.nullshinsaproduct.domain.product.entity.ProductTopSize;
import com.example.nullshinsaproduct.domain.dto.request.CategoryInfoRequest;
import com.example.nullshinsaproduct.domain.dto.request.ProductSaveRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductSizeFactory {

    public List<ProductSize> createProductSizeDetailByCategory(Product product, CategoryInfoRequest categoryReq, List<ProductSizeRequest> sizeReqs) {
        List<ProductSize> productSize;

        switch (categoryReq.thirdLayerCategory()) {
            case OUTER, TOP ->
                    productSize = sizeReqs.stream()
                            .map(sizeReq -> new ProductTopSize(
                                    sizeReq.sizeName(),
                                    product,
                                    sizeReq.length(),
                                    sizeReq.shoulder(),
                                    sizeReq.chest(),
                                    sizeReq.sleeve()
                            )).collect(Collectors.toList());
            case BOTTOM ->
                    productSize = sizeReqs.stream()
                            .map(sizeReq -> new ProductBottomSize(
                                    sizeReq.sizeName(),
                                    product,
                                    sizeReq.length(),
                                    sizeReq.waist(),
                                    sizeReq.crotch(),
                                    sizeReq.hip(),
                                    sizeReq.thigh(),
                                    sizeReq.hem()
                            )).collect(Collectors.toList());

            default ->
                    productSize = new ArrayList<>();
        }

        return productSize;
    }
}
