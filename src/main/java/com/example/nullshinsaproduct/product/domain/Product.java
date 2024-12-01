package com.example.nullshinsaproduct.product.domain;

import com.example.nullshinsaproduct.product.domain.vo.CategoryInfo;
import lombok.Getter;

import java.util.List;

@Getter
public class Product {

    private long id;
    private List<SkuProduct> skuProductList;

    private CategoryInfo categoryInfo;


}
