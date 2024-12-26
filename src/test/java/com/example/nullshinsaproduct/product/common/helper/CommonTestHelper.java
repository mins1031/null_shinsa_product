package com.example.nullshinsaproduct.product.common.helper;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;

import java.lang.reflect.Field;

public class CommonTestHelper {

    public static <T> void injectIdInEntity(T entity, String fieldName, long idCountIncrement) {
        try {
            Field id = entity.getClass().getDeclaredField(fieldName);
            id.setAccessible(true);
            id.set(entity, idCountIncrement);
        } catch (Exception e) {
            throw new IllegalArgumentException("특정 필드값 조회 및 값 세팅 실패");
        }
    }
}
