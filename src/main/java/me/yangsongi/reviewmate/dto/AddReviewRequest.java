package me.yangsongi.reviewmate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.yangsongi.reviewmate.domain.Product;
import me.yangsongi.reviewmate.domain.Review;
import me.yangsongi.reviewmate.domain.User;

@NoArgsConstructor // 기본 생성자 추가
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddReviewRequest {

    private Long userId;
    private int score;
    private String content;

    public Review toEntity(User user, Product product) {
        return Review.builder()
                .user(user)
                .product(product)
                .score(score)
                .content(content)
                .build();
    }

}
