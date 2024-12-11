package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.domain.Product;
import me.yangsongi.reviewmate.domain.Review;
import me.yangsongi.reviewmate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    boolean existsByProductAndUser(Product product, User user);
}
