//package me.yangsongi.reviewmate.util;
//
//import lombok.RequiredArgsConstructor;
//import me.yangsongi.reviewmate.domain.Product;
//import me.yangsongi.reviewmate.domain.Review;
//import me.yangsongi.reviewmate.domain.User;
//import me.yangsongi.reviewmate.repository.ProductRepository;
//import me.yangsongi.reviewmate.repository.ReviewRepository;
//import me.yangsongi.reviewmate.repository.UserRepository;
//import me.yangsongi.reviewmate.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Component
//@RequiredArgsConstructor
//public class TestDataRunner implements ApplicationRunner {
//
//    private final ProductRepository productRepository;
//    private final UserRepository userRepository;
//    private final ReviewRepository reviewRepository;
//
//    @Override
//    public void run(ApplicationArguments args) {
//        // 테스트 User 생성
//        User user1 = new User("foo@gmail.com", "foo", "1234");
//        User user2 = new User("bar@gmail.com", "bar", "1234");
//        userRepository.save(user1);
//        userRepository.save(user2);
//
//        Product product1 = new Product(1L, "상품1", "상품1에 대한 설명입니다.", 50000, 0, 0);
//        Product product2 = new Product(2L, "상품2", "상품2에 대한 설명입니다.", 35000, 0, 0);
//        Product product3 = new Product(3L, "상품3", "상품3에 대한 설명입니다.", 120000, 0, 0);
//        productRepository.save(product1);
//        productRepository.save(product2);
//        productRepository.save(product3);
//
//        List<Review> reviews = List.of(
//                new Review(user1, product1, 4, "유저1이 남긴 리뷰1", null),
//                new Review(user1, product2, 4, "유저1이 남긴 리뷰1", null),
//                new Review(user1, product3, 4, "유저1이 남긴 리뷰1", null),
//                new Review(user2, product3, 4, "유저2가 남긴 리뷰2", null)
//        );
//        reviewRepository.saveAll(reviews);
//    }
//
//}
