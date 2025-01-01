package com.example.nullshinsaproduct.review.infrestructure.db.repository.jpa;


import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepository extends JpaRepository<ReviewEntity, Long> {
}
