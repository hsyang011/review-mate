package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.entity.ReviewPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewPhotoRepository extends JpaRepository<ReviewPhoto, Long> {
}
