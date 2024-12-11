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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "name")
    private String name; // 상품명

    @Column(name = "description")
    private String description; // 상품 설명

    @Column(name = "price")
    private double price; // 상품 가격

    @Column(name = "review_count", columnDefinition = "int default 0")
    private int reviewCount; // 상품의 리뷰 개수

    @Column(name = "average_score", columnDefinition = "decimal(3,2) default 0")
    private double averageScore; // 상품의 평균 리뷰 점수

}
