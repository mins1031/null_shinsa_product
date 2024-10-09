package com.example.nullshinsaproduct.infrastructure.repository.product;

import com.example.nullshinsaproduct.domain.product.entity.ClothesProduct;
import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.enumeration.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    Optional<Product> findByIdAndProductType(long productId, ProductType productType);
}
