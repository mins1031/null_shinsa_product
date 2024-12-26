package com.example.nullshinsaproduct.product.infrastructure.db.repository.dsl;

import com.example.nullshinsaproduct.product.application.output.port.SkuProductDslRepository;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.nullshinsaproduct.product.infrastructure.db.entity.QSkuProductEntity.skuProductEntity;

@Repository
@RequiredArgsConstructor
public class SkuProductDslRepositoryImpl implements SkuProductDslRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void updateStatusById(Long productId, SkuProductStatus skuProductStatus) {
        jpaQueryFactory
                .update(skuProductEntity)
                .set(skuProductEntity.skuProductStatus, skuProductStatus)
                .where(skuProductEntity.product.id.eq(productId));
    }

    @Override
    public void updateStatusByIds(List<Long> productIds, SkuProductStatus skuProductStatus) {
        jpaQueryFactory
                .update(skuProductEntity)
                .set(skuProductEntity.skuProductStatus, skuProductStatus)
                .where(skuProductEntity.product.id.in(productIds))
                .execute();
    }
}
