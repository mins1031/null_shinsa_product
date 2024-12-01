package com.example.nullshinsaproduct.regacy.brand;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
