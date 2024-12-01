//package com.example.nullshinsaproduct.regacy.product.domain.factory;
//
//import com.example.nullshinsaproduct.regacy.application.dto.request.ProductSizeRequest;
//import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Product;
//import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductBottomSizeEntity;
//import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
//import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductTopSizeEntity;
//import com.example.nullshinsaproduct.regacy.application.dto.request.CategoryInfoRequest;
//import com.example.nullshinsaproduct.product.domain.enumeration.ProductSizeType;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Slf4j
//@Service
//public class ProductSizeFactory {
//
//    public List<ProductSizeEntity> createProductSizeDetailByCategory(Product product, CategoryInfoRequest categoryReq, List<ProductSizeRequest> sizeReqs) {
//        List<ProductSizeEntity> productSizeEntity;
//
//        switch (categoryReq.thirdLayerCategory()) {
//            case OUTER, TOP, KNIT_WEAR ->
//                    productSizeEntity = sizeReqs.stream()
//                            .map(sizeReq -> new ProductTopSizeEntity(
//                                    sizeReq.sizeName(),
//                                    product,
//                                    ProductSizeType.TOP,
//                                    sizeReq.length(),
//                                    sizeReq.shoulder(),
//                                    sizeReq.chest(),
//                                    sizeReq.sleeve()
//                            )).collect(Collectors.toList());
//            case BOTTOM ->
//                    productSizeEntity = sizeReqs.stream()
//                            .map(sizeReq -> new ProductBottomSizeEntity(
//                                    sizeReq.sizeName(),
//                                    product,
//                                    ProductSizeType.BOTTOM,
//                                    sizeReq.length(),
//                                    sizeReq.waist(),
//                                    sizeReq.crotch(),
//                                    sizeReq.hip(),
//                                    sizeReq.thigh(),
//                                    sizeReq.hem()
//                            )).collect(Collectors.toList());
//
//            default ->
//                    productSizeEntity = new ArrayList<>();
//        }
//
//        return productSizeEntity;
//    }
//}
