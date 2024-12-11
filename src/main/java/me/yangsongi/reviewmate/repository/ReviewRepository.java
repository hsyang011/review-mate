package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
