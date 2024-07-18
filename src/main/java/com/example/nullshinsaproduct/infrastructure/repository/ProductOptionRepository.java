package com.example.nullshinsaproduct.infrastructure.repository;

import com.example.nullshinsaproduct.domain.entity.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOptionRepository extends JpaRepository<ProductOption, Long> {
    List<ProductOption> findByProductId(Long productId);
}
