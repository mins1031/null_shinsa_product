package com.example.nullshinsaproduct;

import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.brand.infrastructure.BrandJpaRepository;
import com.example.nullshinsaproduct.product.domain.ProductSize;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductJpaRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.SkuProductJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("local")
public class ProductInsertTest {

    @Autowired
    private ProductJpaRepository productJpaRepository;
    @Autowired
    private SkuProductJpaRepository skuProductJpaRepository;
    @Autowired
    private BrandJpaRepository brandJpaRepository;

    @Test
    void name() {
        Random random = new Random(700000);
        List<BrandEntity> all = brandJpaRepository.findAll();
        for (BrandEntity brandEntity : all) {
            for (int i = 1; i <= 100000; i++) {
                SecondLayerCategory secondLayerCategory = SecondLayerCategory.OUTER;
                ThirdLayerCategory thirdLayerCategory = ThirdLayerCategory.CARDIGAN;
                if (i > 0 && i <= 25000) {
                    secondLayerCategory = SecondLayerCategory.OUTER;
                    if (i <= 5000) thirdLayerCategory = ThirdLayerCategory.CARDIGAN;
                    if (i > 5000 && i <= 10000) thirdLayerCategory = ThirdLayerCategory.MID_SEASON_COAT;
                    if (i > 10000 && i <= 15000) thirdLayerCategory = ThirdLayerCategory.WINTER_DOUBLE_COAT;
                    if (i > 15000 && i <= 20000) thirdLayerCategory = ThirdLayerCategory.BLOUSON_MA1;
                    if (i > 20000) thirdLayerCategory = ThirdLayerCategory.ETC_OUTER;
                }

                if (i > 25000 && i <= 50000) {
                    secondLayerCategory = SecondLayerCategory.TOP;
                    if (i <= 30000) thirdLayerCategory = ThirdLayerCategory.KNIT;
                    if (i > 30000 && i <= 40000) thirdLayerCategory = ThirdLayerCategory.HOOD_T_SHIRT;
                    if (i > 40000) thirdLayerCategory = ThirdLayerCategory.LONG_SLEEVE;
                }

                if (i > 50000 && i <= 75000) {
                    secondLayerCategory = SecondLayerCategory.BOTTOM;
                    if (i <= 60000) thirdLayerCategory = ThirdLayerCategory.DENIM;
                    if (i > 60000 && i <= 70000) thirdLayerCategory = ThirdLayerCategory.COTTON;
                    if (i > 70000) thirdLayerCategory = ThirdLayerCategory.SUIT_SLACKS;
                }

                if (i > 75000 && i <= 100000) {
                    secondLayerCategory = SecondLayerCategory.BAG;
                    if (i <= 80000) thirdLayerCategory = ThirdLayerCategory.BACK_BAG;
                    if (i > 80000 && i <= 90000) thirdLayerCategory = ThirdLayerCategory.CROSS_BAG;
                    if (i > 90000) thirdLayerCategory = ThirdLayerCategory.SHOULDER_BAG;
                }

                ProductEntity productEntity = ProductEntity.createDefault(
                        brandEntity.getBrandName() + "상품명" + i,
                        random.nextInt(700000),
                        brandEntity.getId(),
                        brandEntity.getBrandName(),
                        brandEntity.getCorporateNumber(),
                        brandEntity.getCommunicationSellingNumber(),
                        brandEntity.getRepresentative(),
                        brandEntity.getLocation(),
                        0,
                        random.nextInt(70),
                        3,
                        DeliveryFee.FREE,
                        DiscountApplyPossible.POSSIBLE,
                        CouponApplyPossible.POSSIBLE,
                        ProductStatus.APPROVE,
                        true,
                        FirstLayerCategory.MEN,
                        secondLayerCategory,
                        thirdLayerCategory,
                        null
                );

                ProductEntity save = productJpaRepository.save(productEntity);

                List<SkuProductEntity> skuProduct = List.of(
                        SkuProductEntity.createSkuProduct(
                                save,
                                save.getName() + "Sku 1",
                                random.nextInt(500),
                                0,
                                SkuProductStatus.APPROVE
                        ),
                        SkuProductEntity.createSkuProduct(
                                save,
                                save.getName() + "Sku 2",
                                random.nextInt(500),
                                0,
                                SkuProductStatus.APPROVE
                        )
                );
                skuProductJpaRepository.saveAll(skuProduct);

                List<ProductSizeEntity> sizeEntities = new ArrayList<>();
                if (secondLayerCategory.equals(SecondLayerCategory.OUTER)) {
                    sizeEntities = List.of(
                            ProductSizeEntity.builder()
                                    .sizeName("M")
                                    .totalLength("총장 - M")
                                    .shoulder("어꺠너비 - M")
                                    .chest("가슴 - M")
                                    .sleeve("소매길이 - M")
                                    .product(save)
                                    .build(),
                            ProductSizeEntity.builder()
                                    .sizeName("L")
                                    .totalLength("총장 - L")
                                    .shoulder("어꺠너비 - L")
                                    .chest("가슴 - L")
                                    .sleeve("소매길이 - L")
                                    .product(save)
                                    .build()
                    );
                }


            }

        }
    }

    @Test
    void name2() {
        Random priceRandom = new Random(700000);
        Random discountRandom = new Random(70);
        System.out.println(priceRandom.nextInt());
        System.out.println(discountRandom.nextInt());
    }
}
