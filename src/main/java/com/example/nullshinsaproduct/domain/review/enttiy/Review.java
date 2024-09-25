package com.example.nullshinsaproduct.domain.review.enttiy;

import com.example.nullshinsaproduct.domain.product.entity.Product;
import com.example.nullshinsaproduct.domain.product.entity.ProductImage;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private String selectOption;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "review", orphanRemoval = true)
    private List<ReviewImage> reviewImageList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "review", orphanRemoval = true)
    private List<ReviewHeart> reviewHeartList;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "review", orphanRemoval = true)
    private List<ReviewReply> reviewReplyList;

    public Review(long writerId, long orderId, long productId, String content, double startPoint, String selectOption) {
        this.writerId = writerId;
        this.orderId = orderId;
        this.productId = productId;
        this.content = content;
        this.startPoint = startPoint;
        this.selectOption = selectOption;
    }
}
