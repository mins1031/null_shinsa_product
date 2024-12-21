package com.example.nullshinsaproduct.review.infrestructure.db.repository;


import com.example.nullshinsaproduct.review.infrestructure.db.enttiy.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
