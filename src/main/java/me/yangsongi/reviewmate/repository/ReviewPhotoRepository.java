package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.domain.ReviewPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewPhotoRepository extends JpaRepository<ReviewPhoto, Long> {
}
