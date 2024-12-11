package me.yangsongi.reviewmate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "photourl")
    private String photoUrl; // 사진 URL

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review; // 해당 리뷰 정보


}
