package com.example.review.review.entity;

import com.example.review.review.enums.TravelType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "review")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "travel_type", nullable = true)
    private TravelType travelType;

    @Column(name = "content",  nullable = true, length = 1000)
    private String content;

    @Column(name = "like_count", nullable = false)
    private int likeCount; //null 못들어가게 기본형

    @Column(name = "dislike_count", nullable = false)
    private int dislikeCount;

    @Column(name = "created_at", updatable = false, nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "hotel_reaction", nullable = true, columnDefinition = "TEXT")
    private String hotelReaction;

    @Column(name = "hotel_reaction_created_at", nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDateTime hotelReactionCreatedAt;
}
