package com.example.nullshinsaproduct.review.infrestructure.db.enttiy;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(
        name = "review_image"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private String urlPath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private ReviewEntity reviewEntity;

    public ReviewImageEntity(String urlPath, ReviewEntity reviewEntity) {
        this.urlPath = urlPath;
        this.reviewEntity = reviewEntity;
    }

    public static ReviewImageEntity of(String urlPath, ReviewEntity reviewEntity) {
        return new ReviewImageEntity(urlPath, reviewEntity);
    }
}
