package me.yangsongi.reviewmate.repository;

import me.yangsongi.reviewmate.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
