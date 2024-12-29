package com.example.nullshinsaproduct.review.infrestructure.db.repository;


import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
