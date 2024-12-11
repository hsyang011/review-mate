package me.yangsongi.reviewmate.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.yangsongi.reviewmate.dto.AddReviewRequest;
import me.yangsongi.reviewmate.domain.Product;
import me.yangsongi.reviewmate.domain.Review;
import me.yangsongi.reviewmate.domain.User;
import me.yangsongi.reviewmate.repository.ProductRepository;
import me.yangsongi.reviewmate.repository.ReviewRepository;
import me.yangsongi.reviewmate.repository.UserRepository;
import me.yangsongi.reviewmate.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

//    @Transactional
//    public void save(Long productId, AddReviewRequest request) {
//        // 1. 상품 조회
//        Product product = productRepository.findById(productId)
//                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다."));
//
//        // 2. 유저 조회
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));
//
//        // 3. 중복 리뷰 확인
//        boolean alreadyReviewed = reviewRepository.existsByProductAndUser(product, user);
//        if (alreadyReviewed) {
//            throw new IllegalArgumentException("이미 리뷰를 작성하셨습니다.");
//        }
//
//        // 4. 이미지 업로드 처리
//        String photoUrl = null;
//        if (image != null && !image.isEmpty()) {
//            try {
//                photoUrl = FileUtil.upload(image);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        // 5. 리뷰 엔티티 생성 및 저장
//        Review review = new Review();
//        review.setProduct(product);
//        review.setUser(user);
//        review.setScore(request.getScore());
//        review.setContent(request.getContent());
//        review.setPhotoUrl(photoUrl);
//        reviewRepository.save(review);
//
//        // 6. 상품의 리뷰 개수 및 평균 점수 업데이트
//        int updatedReviewCount = product.getReviewCount() + 1;
//        double updatedAverageScore = calculateNewAverage(product.getAverageScore(), product.getReviewCount(), request.getScore());
//
//        product.setReviewCount(updatedReviewCount);
//        product.setAverageScore(updatedAverageScore);
//        productRepository.save(product);
//    }
//
//    private double calculateNewAverage(double currentAverage, int currentCount, int newScore) {
//        return ((currentAverage * currentCount) + newScore) / (currentCount + 1);
//    }

    public void addReview(Long productId, AddReviewRequest request) {
        // 1. 상품 조회
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다."));

        // 2. 유저 조회
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("유저를 찾을 수 없습니다."));

        reviewRepository.save(request.toEntity(user, product));

        // 6. 상품의 리뷰 개수 및 평균 점수 업데이트
//        int updatedReviewCount = product.getReviewCount() + 1;
//        double updatedAverageScore = calculateNewAverage(product.getAverageScore(), product.getReviewCount(), request.getScore());
//
//        product.setReviewCount(updatedReviewCount);
//        product.setAverageScore(updatedAverageScore);
//        productRepository.save(product);
    }

}
