package com.example.nullshinsaproduct.infrastructure.repository;

import com.example.nullshinsaproduct.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
