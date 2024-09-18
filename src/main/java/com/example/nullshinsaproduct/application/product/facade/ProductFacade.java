package com.example.nullshinsaproduct.application.product.facade;

import com.example.nullshinsaproduct.application.product.service.ClothesProductService;
import com.example.nullshinsaproduct.application.product.service.ElectronicProductService;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;
import com.example.nullshinsaproduct.domain.dto.request.ProductSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductFacade {
    private final ClothesProductService clothesProductService;
    private final ElectronicProductService electronicProductService;

    public void applySaveProductByType(ProductSaveRequest req) {
        ProductType productType = req.productType();
        switch (productType) {
            case CLOTHES -> clothesProductService.saveClothesProduct(req);
            case ELECTRONICS -> electronicProductService.save(req);
        }

    }
}
