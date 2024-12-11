package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
