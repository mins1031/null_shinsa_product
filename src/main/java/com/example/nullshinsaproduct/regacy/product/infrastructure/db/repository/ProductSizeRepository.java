package com.example.nullshinsaproduct.regacy.product.infrastructure.db.repository;

import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.Product;
import com.example.nullshinsaproduct.regacy.product.infrastructure.db.entity.ProductSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSizeRepository extends JpaRepository<ProductSize, Long> {

    List<ProductSize> findAllByProduct(Product product);
}
