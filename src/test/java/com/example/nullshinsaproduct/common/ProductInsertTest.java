package com.example.nullshinsaproduct.common;

import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.brand.infrastructure.BrandJpaRepository;
import com.example.nullshinsaproduct.product.domain.enumeration.CouponApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.DeliveryFee;
import com.example.nullshinsaproduct.product.domain.enumeration.DiscountApplyPossible;
import com.example.nullshinsaproduct.product.domain.enumeration.ImageType;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.domain.enumeration.category.FirstLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.SecondLayerCategory;
import com.example.nullshinsaproduct.product.domain.enumeration.category.ThirdLayerCategory;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductImageJpaRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductJpaRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.ProductSizeJpaRepository;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa.SkuProductJpaRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa.ReviewImageJpaRepository;
import com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa.ReviewJpaRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
@ActiveProfiles("local")
@Disabled
@Transactional
public class ProductInsertTest {

    @Autowired
    private BrandJpaRepository brandJpaRepository;
    @Autowired
    private ProductJpaRepository productJpaRepository;
    @Autowired
    private SkuProductJpaRepository skuProductJpaRepository;
    @Autowired
    private ProductSizeJpaRepository productSizeJpaRepository;
    @Autowired
    private ProductImageJpaRepository productImageJpaRepository;
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;
    @Autowired
    private ReviewImageJpaRepository reviewImageJpaRepository;


    @Test
    @Disabled
    void 상품_및_상품_연관관계_데이터_INSERT() {
        Random random = new Random(700000);
        List< BrandEntity> all = brandJpaRepository.findAll();
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
                        10,
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

                List<ProductSizeEntity> sizeEntities;
                if (secondLayerCategory.equals(SecondLayerCategory.OUTER)
                        || secondLayerCategory.equals(SecondLayerCategory.TOP)
                ) {
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
                } else if (secondLayerCategory.equals(SecondLayerCategory.BOTTOM)) {
                    sizeEntities = List.of(
                            ProductSizeEntity.builder()
                                    .sizeName("M")
                                    .totalLength("총장 - M")
                                    .waist("허리 - M")
                                    .crotch("밑위 - M")
                                    .hip("엉덩이 단면 - M")
                                    .thigh("허벅지 단면 - M")
                                    .hem("밑단 - M")
                                    .product(save)
                                    .build(),
                            ProductSizeEntity.builder()
                                    .sizeName("L")
                                    .totalLength("총장 - L")
                                    .waist("허리 - L")
                                    .crotch("밑위 - L")
                                    .hip("엉덩이 단면 - L")
                                    .thigh("허벅지 단면 - L")
                                    .hem("밑단 - L")
                                    .product(save)
                                    .build()
                    );
                } else {
                    sizeEntities = List.of(
                            ProductSizeEntity.builder()
                                    .sizeName("M")
                                    .width("100")
                                    .height("140")
                                    .depth("200")
                                    .product(save)
                                    .build(),
                            ProductSizeEntity.builder()
                                    .sizeName("L")
                                    .width("110")
                                    .height("150")
                                    .depth("210")
                                    .product(save)
                                    .build()
                    );
                }
                productSizeJpaRepository.saveAll(sizeEntities);

                List<ProductImageEntity> imageEntities = new ArrayList<>();
                if (secondLayerCategory.equals(SecondLayerCategory.OUTER)) {
                    imageEntities = List.of(
                            ProductImageEntity.of(
                                    "THUMBNAIL url 1",
                                    ImageType.THUMBNAIL,
                                    save
                            ),
                            ProductImageEntity.of(
                                    "PROFILE url 1",
                                    ImageType.PROFILE,
                                    save
                            ),
                            ProductImageEntity.of(
                                    "DETAIL image url 1",
                                    ImageType.DETAIL,
                                    save
                            )
                    );
                }
                productImageJpaRepository.saveAll(imageEntities);
            }
        }
    }

    @Test
    @Disabled
    void 리뷰_및_리뷰_연관관계_데이터_INSERT() {
        int chunk = 2000;
        Random pointRandom = new Random(5);
        Random idRandom = new Random(20);
        int count = productJpaRepository.findByCount();
        for (int i = 0; i < count / chunk; i++) {
            int offset = i * chunk;
            PageRequest pageRequest = PageRequest.of(offset, chunk);
            Page<ProductEntity> products = productJpaRepository.findAll(pageRequest);
            for (ProductEntity productEntity : products) {
                List<ReviewEntity> of = List.of(
                        ReviewEntity.of(
                                idRandom.nextLong(),
                                idRandom.nextLong(),
                                productEntity.getId(),
                                productEntity.getName() + "리뷰1",
                                pointRandom.nextDouble(),
                                "SKU NAME " + (i + 1)
                        ),
                        ReviewEntity.of(
                                idRandom.nextLong(),
                                idRandom.nextLong(),
                                productEntity.getId(),
                                productEntity.getName() + "리뷰2",
                                pointRandom.nextDouble(),
                                "SKU NAME " + (i + 1)
                        )
                );

                reviewJpaRepository.saveAll(of);
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
