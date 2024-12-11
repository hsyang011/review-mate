package me.yangsongi.reviewmate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "score")
    private int score; // 리뷰 점수

    @Column(name = "content")
    private String content; // 리뷰 내용

    @Column(name = "photo_url")
    private String photoUrl; // 리뷰 사진 URL

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false) // 하나의 상품엔 여러개의 리뷰가 달립니다.
    private Product product; // 상품 정보

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // 한 명의 유저는 여러개의 리뷰를 달 수 있습니다.
    private User user; // 작성한 유저 정보

}
