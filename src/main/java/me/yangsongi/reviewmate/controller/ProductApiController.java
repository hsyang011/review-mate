package me.yangsongi.reviewmate.controller;

import lombok.RequiredArgsConstructor;
import me.yangsongi.reviewmate.dto.AddReviewRequest;
import me.yangsongi.reviewmate.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping("/products/{productId}/reviews")
    public ResponseEntity<Void> addReview(
            @PathVariable Long productId,
//            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestBody AddReviewRequest request) {
        productService.addReview(productId, request);

        return ResponseEntity.ok().build();
    }

}
