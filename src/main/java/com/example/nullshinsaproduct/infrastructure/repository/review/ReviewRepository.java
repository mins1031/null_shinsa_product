package com.example.nullshinsaproduct.infrastructure.repository.review;

import com.example.nullshinsaproduct.domain.review.enttiy.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
