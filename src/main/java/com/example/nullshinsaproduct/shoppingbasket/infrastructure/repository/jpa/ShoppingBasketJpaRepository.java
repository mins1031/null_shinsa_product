package com.example.nullshinsaproduct.shoppingbasket.infrastructure.repository.jpa;

import com.example.nullshinsaproduct.shoppingbasket.infrastructure.entity.ShoppingBasketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingBasketJpaRepository extends JpaRepository<ShoppingBasketEntity, Long> {
}
