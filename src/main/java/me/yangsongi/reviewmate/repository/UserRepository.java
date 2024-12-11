package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
