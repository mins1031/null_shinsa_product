package com.example.nullshinsaproduct.regacy.application.facade;

import com.example.nullshinsaproduct.regacy.application.dto.response.ProductQueryResponse;
import com.example.nullshinsaproduct.regacy.application.service.product.service.ClothesProductFindService;
import com.example.nullshinsaproduct.regacy.application.service.product.service.ClothesProductService;
import com.example.nullshinsaproduct.regacy.application.service.product.service.ElectronicProductFindService;
import com.example.nullshinsaproduct.regacy.application.service.product.service.ElectronicProductService;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ElectronicProduct;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductType;
import com.example.nullshinsaproduct.product.application.dto.request.ProductSaveRequest;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.common.exception.product.ProductExceptionCode;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductFacade {
    private final ClothesProductService clothesProductService;
    private final ElectronicProductService electronicProductService;
    private final ClothesProductFindService clothesProductFindService;
    private final ElectronicProductFindService electronicProductFindService;
    private final ProductJpaRepository productJpaRepository;

    public void applySaveProductByType(ProductSaveRequest req) {
        ProductType productType = req.productType();
        switch (productType) {
            case CLOTHES -> clothesProductService.saveClothesProduct(req);
            case ELECTRONICS -> electronicProductService.save(req);
        }
    }

    @Transactional(readOnly = true)
    public ProductQueryResponse switchFindProduct(final long productId) {
        Product product = productJpaRepository.findById(productId).orElseThrow(() -> new ProductException(ProductExceptionCode.NOT_EXIST_PRODUCT));
        return switch (product.getProductType()) {
//            case CLOTHES -> clothesProductFindService.findOneProduct((ProductEntity) product);
            case CLOTHES -> null;
            case ELECTRONICS -> electronicProductFindService.findOneProduct((ElectronicProduct) product);
        };
    }

}
