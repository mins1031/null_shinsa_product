package com.example.nullshinsaproduct.product.infrastructure.db.repository.dsl;

import com.example.nullshinsaproduct.product.application.output.port.SkuProductDslRepository;
import com.example.nullshinsaproduct.product.domain.enumeration.SkuProductStatus;
import com.example.nullshinsaproduct.product.infrastructure.db.entity.QProductEntity;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.dto.FindSkuWithProductDto;
import com.example.nullshinsaproduct.product.infrastructure.db.repository.dto.QFindSkuWithProductDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

import static com.example.nullshinsaproduct.product.infrastructure.db.entity.QProductEntity.productEntity;
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

    @Override
    public FindSkuWithProductDto findProductAndSkuByIds(long productId, long skuId) {
//        FindSkuWithProductDto findSkuWithProductDto = jpaQueryFactory.select(
//                        new QFindSkuWithProductDto(
//                                productEntity.id,
//                                skuProductEntity.id,
//                                productEntity.name,
//                                skuProductEntity.name,
//                                productEntity.price,
//                                skuProductEntity.plusPrice
//                        )
//                ).from(productEntity)
//                .leftJoin(skuProductEntity.product, productEntity)
//                .where(
//                        productEntity.id.eq(productId)
//                                .and(
//                                        skuProductEntity.id.eq(skuId)
//                                )
//                ).fetchOne();

        FindSkuWithProductDto result = jpaQueryFactory.select(
                        new QFindSkuWithProductDto(
                                productEntity.id,
                                skuProductEntity.id,
                                productEntity.name,
                                skuProductEntity.name,
                                productEntity.price,
                                skuProductEntity.plusPrice,
                                productEntity.productStatus,
                                skuProductEntity.skuProductStatus
                        )
                ).from(skuProductEntity)
                .where(
                        skuProductEntity.id.eq(skuId).and(
                                skuProductEntity.product.id.eq(productId)
                        )
                ).fetchOne();

        return result;
    }
}
