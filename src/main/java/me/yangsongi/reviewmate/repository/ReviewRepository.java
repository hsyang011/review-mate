package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.domain.Product;
import me.yangsongi.reviewmate.domain.Review;
import me.yangsongi.reviewmate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//    boolean existsByProductAndUser(Product product, User user);
    @Query("SELECT r FROM Review r WHERE r.product.id = :productId AND r.id < :cursor ORDER BY r.id DESC")
    List<Review> findReviewsByProductIdWithPaging(Long productId, int cursor, int size);

    @Query("SELECT COUNT(r) FROM Review r WHERE r.product.id = :productId")
    int countByProductId(Long productId);
    @Query("SELECT AVG(r.score) FROM Review r WHERE r.product.id = :productId")
    double calculateAverageScore(Long productId);

}
