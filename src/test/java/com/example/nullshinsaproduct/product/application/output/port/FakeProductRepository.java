package com.example.nullshinsaproduct.product.application.output.port;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductImageEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductSizeEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.SkuProductEntity;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FakeProductRepository implements ProductRepository {
    private long idCountIncrement = 0;
    private Map<Long, ProductEntity> fakeProductContext = Collections.synchronizedMap(new HashMap<>());


    @Override
    public ProductEntity save(ProductEntity entity) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[상품저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeProductContext.put(idCountIncrement, entity);
        injectIdInEntity(entity);

        return fakeProductContext.get(idCountIncrement);
    }

    public ProductEntity saveWithAssociations(
            ProductEntity entity,
            List<SkuProductEntity> skuProductEntities,
            List<ProductSizeEntity> productSizeEntities,
            List<ProductImageEntity> productImageEntities
    ) {
        if (Objects.isNull(entity)) {
            throw new IllegalArgumentException("[상품저장] - 엔티티 파리미터 NULL");
        }

        idCountIncrement++;
        fakeProductContext.put(idCountIncrement, entity);
        injectIdInEntity(entity);
        injectSkuListInEntity(entity, skuProductEntities);
        injectSizeListInEntity(entity, productSizeEntities);
        injectImageListInEntity(entity, productImageEntities);

        return fakeProductContext.get(idCountIncrement);
    }

    @Override
    public ProductEntity findById(long id) {
        return this.fakeProductContext.get(id);
    }


    private void injectIdInEntity(ProductEntity entity) {
        try {
            Field id = entity.getClass().getDeclaredField("id");
            id.setAccessible(true);
            id.set(entity, idCountIncrement);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }

    private void injectSkuListInEntity(ProductEntity entity, List<SkuProductEntity> skus) {
        try {
            Field skuProductEntityList = entity.getClass().getDeclaredField("skuProductEntityList");
            skuProductEntityList.setAccessible(true);
            skuProductEntityList.set(entity, skus);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }

    private void injectSizeListInEntity(ProductEntity entity, List<ProductSizeEntity> sizes) {
        try {
            Field productSizeEntityList = entity.getClass().getDeclaredField("productSizeEntityList");
            productSizeEntityList.setAccessible(true);
            productSizeEntityList.set(entity, sizes);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }

    private void injectImageListInEntity(ProductEntity entity, List<ProductImageEntity> sizes) {
        try {
            Field productImageEntityList = entity.getClass().getDeclaredField("productImageEntityList");
            productImageEntityList.setAccessible(true);
            productImageEntityList.set(entity, sizes);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }

}