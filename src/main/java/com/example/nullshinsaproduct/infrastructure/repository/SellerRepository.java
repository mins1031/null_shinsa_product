package com.example.nullshinsaproduct.infrastructure.repository;

import com.example.nullshinsaproduct.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
