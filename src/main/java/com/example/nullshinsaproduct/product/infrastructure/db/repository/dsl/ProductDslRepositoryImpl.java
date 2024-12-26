package com.example.nullshinsaproduct.product.infrastructure.db.repository.dsl;

import com.example.nullshinsaproduct.product.application.output.port.ProductDslRepository;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.nullshinsaproduct.product.infrastructure.db.entity.QProductEntity.productEntity;

@Repository
@RequiredArgsConstructor
public class ProductDslRepositoryImpl implements ProductDslRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public void updateStatusById(Long id, ProductStatus productStatus) {
        JPAUpdateClause update = jpaQueryFactory.update(productEntity);
        update
                .set(productEntity.productStatus, productStatus)
                .set(productEntity.isCanView, true)
                .where(productEntity.id.eq(id))
                .execute();
    }

    @Override
    public void updateStatusByIds(List<Long> ids, ProductStatus productStatus) {
        JPAUpdateClause update = jpaQueryFactory.update(productEntity);
        update
                .set(productEntity.productStatus, productStatus)
                .set(productEntity.isCanView, true)
                .where(productEntity.id.in(ids))
                .execute();
    }
}
