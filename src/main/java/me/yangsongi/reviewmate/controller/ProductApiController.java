package me.yangsongi.reviewmate.controller;

import lombok.RequiredArgsConstructor;
import me.yangsongi.reviewmate.dto.AddReviewRequest;
import me.yangsongi.reviewmate.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping(value = "/products/{productId}/reviews")
    public ResponseEntity<Void> addReview(
            @PathVariable Long productId,
//            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestBody AddReviewRequest request) {
        MultipartFile image = null;
        // 로그 출력
        System.out.println("Product ID: " + productId);
        System.out.println("Image: " + (image != null ? image.getOriginalFilename() : "No image"));
        System.out.println("Review Data: " + (request != null ? request.getUserId() : "No User"));

        productService.addReview(productId, image, request);
        return ResponseEntity.ok().build();
    }

}
