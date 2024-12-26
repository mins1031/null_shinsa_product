package com.example.nullshinsaproduct.product.infrastructure.db.repository.dsl;

import com.example.nullshinsaproduct.product.application.output.port.ProductDslRepository;
import com.example.nullshinsaproduct.product.domain.enumeration.ProductStatus;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.QProductEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
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
        jpaQueryFactory
                .update(productEntity)
                .set(productEntity.productStatus, productStatus)
                .set(productEntity.isCanView, true)
                .where(productEntity.id.eq(id));
    }

    @Override
    public void updateStatusByIds(List<Long> ids, ProductStatus productStatus) {
        jpaQueryFactory
                .update(productEntity)
                .set(productEntity.productStatus, productStatus)
                .where(productEntity.id.in(ids))
                .execute();
    }
}
