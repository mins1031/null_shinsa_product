package com.example.nullshinsaproduct.review.infrestructure.db.enttiy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@Table(
        name = "review"
)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private long reviewerId;
    private long orderId;
    private long productId;
    private String content;
    private double startPoint;
    private boolean isCalculatedStarPoint;
    private String selectSkuOption;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reviewEntity", orphanRemoval = true)
    private List<ReviewImageEntity> reviewImageEntityList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reviewEntity", orphanRemoval = true)
    private List<ReviewHeartEntity> reviewHeartEntityList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "reviewEntity", orphanRemoval = true)
    private List<ReviewReplyEntity> reviewReplyEntityList;

    private ReviewEntity(long reviewerId, long orderId, long productId, String content, double startPoint, String selectSkuOption) {
        this.reviewerId = reviewerId;
        this.orderId = orderId;
        this.productId = productId;
        this.content = content;
        this.startPoint = startPoint;
        this.selectSkuOption = selectSkuOption;
    }

    public static ReviewEntity of(long reviewerId, long orderId, long productId, String content, double startPoint, String selectSkuOption) {
        return new ReviewEntity(
                reviewerId,
                orderId,
                productId,
                content,
                startPoint,
                selectSkuOption
        );
    }

    public void initImages(List<ReviewImageEntity> reviewImageEntityList) {
        this.reviewImageEntityList = reviewImageEntityList;
    }
}
