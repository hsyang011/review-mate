package me.yangsongi.reviewmate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.yangsongi.reviewmate.domain.Review;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
public class ReviewListResponse {

    @Getter
    @Setter
    public static class ReviewResponse {
        private Long id;
        private Long userId;
        private int score;
        private String content;
        private String photoUrl;
        private LocalDateTime createdAt;

        public ReviewResponse(Review review) {
            this.id = review.getId();
            this.userId = review.getUser().getId();
            this.content = review.getContent();
            this.photoUrl = review.getPhotoUrl();
        }
    }

    private int totalCount;
    private double averageScore;
    private int cursor;
    private List<ReviewResponse> reviews;

    public ReviewListResponse(int totalCount, double averageScore, int cursor, List<Review> reviews) {
        this.totalCount = totalCount;
        this.averageScore = averageScore;
        this.cursor = cursor;
        this.reviews = reviews.stream()
                .map(ReviewResponse::new)
                .collect(Collectors.toList());
    }

}
