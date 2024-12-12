package me.yangsongi.reviewmate.controller;

import lombok.RequiredArgsConstructor;
import me.yangsongi.reviewmate.domain.Product;
import me.yangsongi.reviewmate.repository.ProductRepository;
import me.yangsongi.reviewmate.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class ProductViewController {

    private final ProductRepository productRepository;

//    @GetMapping("/products/{productId}/reviews")
//    public String addReview(@RequestParam(required = false) Long id, Model model) {
//        if (id == null) { // id가 없으면 생성입니다.
//
//        } else { // id가 없으면 수정입니다.
////            Review review =
//        }
//
//        return "write";
//    }

    @GetMapping("/products/{productId}")
    public String view(@PathVariable Long productId, Model model) {
        Product product = productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);

        model.addAttribute("product", product);

        return "view";
    }

//    @GetMapping("/products/{productId}/write")
//    public String write(@PathVariable Long productId, Model model) {
//        return "write";
//    }

}
