package com.example.nullshinsaproduct.product.infrastructure.db.repository.jpa;

import com.example.nullshinsaproduct.product.infrastructure.db.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
//    Optional<Product> findByIdAndProductType(long productId, ProductType productType);

    @Query("select COUNT(p) FROM ProductEntity p")
    int findByCount();
}
