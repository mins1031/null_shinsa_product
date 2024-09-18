package com.example.nullshinsaproduct.infrastructure.repository;

import com.example.nullshinsaproduct.domain.product.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
