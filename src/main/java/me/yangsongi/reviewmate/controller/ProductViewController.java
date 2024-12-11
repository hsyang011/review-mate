package me.yangsongi.reviewmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductViewController {

    @GetMapping("/products/{productId}/reviews")
    public String newReview(@RequestParam(required = false) Long id, Model model) {
        if (id == null) { // id가 없으면 생성입니다.

        } else { // id가 없으면 수정입니다.
//            Review review =
        }

        return "newReview";
    }

}
