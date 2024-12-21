package com.example.nullshinsaproduct.review.infrestructure.db.enttiy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;

    private long writerId;
    private long orderId;
    private long productId;
    private String content;
    private double startPoint;
    private String selectSkuOption;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "review", orphanRemoval = true)
    private List<ReviewImage> reviewImageList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "review", orphanRemoval = true)
    private List<ReviewHeart> reviewHeartList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "review", orphanRemoval = true)
    private List<ReviewReply> reviewReplyList;

    private Review(long writerId, long orderId, long productId, String content, double startPoint, String selectSkuOption) {
        this.writerId = writerId;
        this.orderId = orderId;
        this.productId = productId;
        this.content = content;
        this.startPoint = startPoint;
        this.selectSkuOption = selectSkuOption;
    }

    public static Review of(long writerId, long orderId, long productId, String content, double startPoint, String selectSkuOption) {
        return new Review(
                writerId,
                orderId,
                productId,
                content,
                startPoint,
                selectSkuOption
        );
    }

    public void initImages(List<ReviewImage> reviewImageList) {
        this.reviewImageList = reviewImageList;
    }
}
