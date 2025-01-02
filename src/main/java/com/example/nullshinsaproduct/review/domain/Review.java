package com.example.nullshinsaproduct.review.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Review {
    private Long id;
    private long reviewerId;
    private long orderId;
    private long productId;
    private String content;
    private double startPoint;
    private String selectSkuOption;
    private List<ReviewImage> reviewImages;
    private List<ReviewHeart> reviewHearts;
    private List<ReviewReply> reviewReplies;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    private Review(
            Long id,
            long reviewerId,
            long orderId,
            long productId,
            String content,
            double startPoint,
            String selectSkuOption,
            List<ReviewImage> reviewImages,
            List<ReviewHeart> reviewHearts,
            List<ReviewReply> reviewReplies,
            LocalDateTime createdDate,
            LocalDateTime updatedDate
    ) {
        this.id = id;
        this.reviewerId = reviewerId;
        this.orderId = orderId;
        this.productId = productId;
        this.content = content;
        this.startPoint = startPoint;
        this.selectSkuOption = selectSkuOption;
        this.reviewImages = reviewImages;
        this.reviewHearts = reviewHearts;
        this.reviewReplies = reviewReplies;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public static Review createDefault(
            Long id,
            long reviewerId,
            long orderId,
            long productId,
            String content,
            double startPoint,
            String selectSkuOption,
            LocalDateTime createdDate,
            LocalDateTime updatedDate
    ) {
        return new Review(
                id,
                reviewerId,
                orderId,
                productId,
                content,
                startPoint,
                selectSkuOption,
                new ArrayList<>(),
                new ArrayList<>(),
                new ArrayList<>(),
                createdDate,
                updatedDate
        );
    }
}
