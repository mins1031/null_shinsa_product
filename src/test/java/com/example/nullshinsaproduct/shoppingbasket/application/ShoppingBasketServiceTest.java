package com.example.nullshinsaproduct.shoppingbasket.application;

import com.example.nullshinsaproduct.brand.infrastructure.BrandEntity;
import com.example.nullshinsaproduct.common.exception.product.ProductException;
import com.example.nullshinsaproduct.product.application.output.port.FakeBrandRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeProductRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeSkuProductDslRepository;
import com.example.nullshinsaproduct.product.application.output.port.FakeSkuProductRepository;
import com.example.nullshinsaproduct.product.common.helper.BrandTestHelper;
import com.example.nullshinsaproduct.product.common.helper.ProductTestHelper;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;
import com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request.ShoppingBasketSaveRequest;
import com.example.nullshinsaproduct.shoppingbasket.application.inport.dto.request.ShoppingBasketUpdateRequest;
import com.example.nullshinsaproduct.shoppingbasket.application.output.FakeShoppingBasketRepository;
import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShoppingBasketServiceTest {
    private FakeBrandRepository fakeBrandRepository;
    private FakeSkuProductDslRepository fakeSkuProductDslRepository;
    private FakeSkuProductRepository fakeSkuProductRepository;
    private FakeShoppingBasketRepository fakeShoppingBasketRepository;
    private FakeProductRepository fakeProductRepository;

    private ShoppingBasketService shoppingBasketService;

    @BeforeEach
    void setUp() {
        this.fakeSkuProductDslRepository = new FakeSkuProductDslRepository();
        this.fakeSkuProductRepository = new FakeSkuProductRepository();
        this.fakeBrandRepository = new FakeBrandRepository();
        this.fakeShoppingBasketRepository = new FakeShoppingBasketRepository();
        this.fakeProductRepository = new FakeProductRepository();

        this.shoppingBasketService = new ShoppingBasketService(
                this.fakeSkuProductDslRepository,
                this.fakeSkuProductRepository,
                this.fakeBrandRepository,
                this.fakeShoppingBasketRepository
        );
    }

    @Test
    void 장바구니에_상품정보를_저장할_수_있다() {
        //given
        ProductEntity productEntity = fakeProductRepository.save(ProductTestHelper.makeProductEntityInSelling());
        SkuProductEntity skuProductEntitiy = fakeSkuProductDslRepository.save(
                ProductTestHelper.makeSkuProductEntityInSelling(productEntity)
        );
        BrandEntity brandEntity = fakeBrandRepository.save(BrandTestHelper.makeBrandEntity());

        ShoppingBasketSaveRequest req = new ShoppingBasketSaveRequest(
                productEntity.getId(),
                skuProductEntitiy.getId(),
                2L,
                brandEntity.getId(),
                brandEntity.getBrandName(),
                productEntity.getName(),
                skuProductEntitiy.getName(),
                skuProductEntitiy.getStock(),
                15
        );

        //when
        shoppingBasketService.saveItem(req);

        //then
        ShoppingBasketEntity result = fakeShoppingBasketRepository.findById(1L);
        assertEquals(1L, result.getId());
        assertEquals(productEntity.getId(), result.getProductId());
        assertEquals(skuProductEntitiy.getId(), result.getSkuId());
        assertEquals(req.customerId(), result.getCustomerId());
        assertEquals(brandEntity.getId(), result.getBrandId());
        assertEquals(brandEntity.getBrandName(), result.getBrandName());
        assertEquals(productEntity.getName(), result.getProductName());
        assertEquals(skuProductEntitiy.getName(), result.getSkuName());
        assertEquals(req.skuCount(), result.getSkuCount());
        assertEquals(productEntity.getPrice(), result.getProductPrice());
        assertEquals(req.presentDiscountPricePerSku(), result.getDiscountPriceWhenSave());
    }

    @Test
    void 장바구니에_저장할_상품_조회결과가_없는경우_예외가_발생한() {
        //given
        ProductEntity productEntity = fakeProductRepository.save(ProductTestHelper.makeProductEntityInSelling());
        SkuProductEntity skuProductEntitiy = ProductTestHelper.makeSkuProductEntityInSelling(productEntity);
        BrandEntity brandEntity = fakeBrandRepository.save(BrandTestHelper.makeBrandEntity());

        ShoppingBasketSaveRequest req = new ShoppingBasketSaveRequest(
                productEntity.getId(),
                1L,
                2L,
                brandEntity.getId(),
                brandEntity.getBrandName(),
                productEntity.getName(),
                skuProductEntitiy.getName(),
                skuProductEntitiy.getStock(),
                15
        );

        //when && then
        assertThrows(ProductException.class, () -> shoppingBasketService.saveItem(req));
    }

    @Test
    void 장바구니에_저장할_상품이_판매가능_상태가_아닌경우_예외가_발생한다() {
        //given
        ProductEntity productEntity = fakeProductRepository.save(ProductTestHelper.makeProductEntityInApprove());
        SkuProductEntity skuProductEntitiy = fakeSkuProductDslRepository.save(
                ProductTestHelper.makeSkuProductEntityInSelling(productEntity)
        );
        BrandEntity brandEntity = fakeBrandRepository.save(BrandTestHelper.makeBrandEntity());

        ShoppingBasketSaveRequest req = new ShoppingBasketSaveRequest(
                productEntity.getId(),
                skuProductEntitiy.getId(),
                2L,
                brandEntity.getId(),
                brandEntity.getBrandName(),
                productEntity.getName(),
                skuProductEntitiy.getName(),
                skuProductEntitiy.getStock(),
                15
        );

        //when && then
        assertThrows(ProductException.class, () -> shoppingBasketService.saveItem(req));
    }

    @Test
    void 장바구니의_SKU_정보를_변경할_수_있다() {
        //given
        ProductEntity productEntity = fakeProductRepository.save(ProductTestHelper.makeProductEntityInApprove());
        SkuProductEntity skuProductEntitiy = fakeSkuProductDslRepository.save(ProductTestHelper.makeSkuProductEntityInSelling(productEntity));
        fakeSkuProductDslRepository.save(ProductTestHelper.makeSkuProductEntities(productEntity).get(0));
        BrandEntity brandEntity = fakeBrandRepository.save(BrandTestHelper.makeBrandEntity());
        fakeShoppingBasketRepository.saveShoppingBasket(
                ShoppingBasketEntity.of(
                        null,
                        productEntity.getId(),
                        skuProductEntitiy.getId(),
                        2L,
                        brandEntity.getId(),
                        brandEntity.getBrandName(),
                        productEntity.getName(),
                        skuProductEntitiy.getName(),
                        skuProductEntitiy.getStock(),
                        15,
                        15
                )
        );

        fakeSkuProductRepository.save(ProductTestHelper.makeSkuProductEntityInSelling(productEntity));
        SkuProductEntity updatedSku = fakeSkuProductRepository.save(ProductTestHelper.makeSkuProductEntities(productEntity).get(0));
        ShoppingBasketUpdateRequest req = new ShoppingBasketUpdateRequest(
                1L,
                productEntity.getId(),
                updatedSku.getId(),
                updatedSku.getName(),
                2
        );

        //when
        shoppingBasketService.updateItem(req);

        //then
        ShoppingBasketEntity result = fakeShoppingBasketRepository.findById(req.basketId());
        assertEquals(req.skuId(), result.getSkuId());
        assertEquals(req.skuName(), result.getSkuName());
        assertEquals(req.skuCount(), result.getSkuCount());
        assertEquals(req.productId(), result.getProductId());
    }

    @Test
    void 장바구니_아이템_PK를_통해_아이템을_장바구니에서_삭제한다() {
        //given
        ProductEntity productEntity = fakeProductRepository.save(ProductTestHelper.makeProductEntityInApprove());
        SkuProductEntity skuProductEntitiy = fakeSkuProductDslRepository.save(
                ProductTestHelper.makeSkuProductEntityInSelling(productEntity)
        );
        BrandEntity brandEntity = fakeBrandRepository.save(BrandTestHelper.makeBrandEntity());
        ShoppingBasketEntity shoppingBasketEntity = fakeShoppingBasketRepository.saveShoppingBasket(
                ShoppingBasketEntity.of(
                        null,
                        productEntity.getId(),
                        skuProductEntitiy.getId(),
                        2L,
                        brandEntity.getId(),
                        brandEntity.getBrandName(),
                        productEntity.getName(),
                        skuProductEntitiy.getName(),
                        1,
                        productEntity.getPrice(),
                        15 // 이거 세일이라는 어그리거트 하나 만들긴 해야할듯..
                )
        );

        //when
        shoppingBasketService.deleteItem(shoppingBasketEntity.getId());

        //then
        ShoppingBasketEntity result = fakeShoppingBasketRepository.findById(shoppingBasketEntity.getId());
        assertNull(result);
    }
}