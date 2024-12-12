package me.yangsongi.reviewmate.controller;

import lombok.RequiredArgsConstructor;
import me.yangsongi.reviewmate.dto.AddReviewRequest;
import me.yangsongi.reviewmate.dto.ReviewListResponse;
import me.yangsongi.reviewmate.service.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    @PostMapping(value = "/products/{productId}/reviews", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Void> addReview(
            @PathVariable Long productId,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestPart(value = "request") AddReviewRequest request) {
        // 로그 출력
        System.out.println("Product ID: " + productId);
        System.out.println("Image: " + (image != null ? image.getOriginalFilename() : "No image"));
        System.out.println("Review Data: " + (request != null ? request.getUserId() : "No User"));

        productService.addReview(productId, image, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/products/{productId}/reviews")
    public ResponseEntity<ReviewListResponse> reviewList(
            @PathVariable Long productId,
            @RequestParam(required = false, defaultValue = "0") int cursor,
            @RequestParam(required = false, defaultValue = "10") int size) {
        ReviewListResponse response = productService.reviewList(productId, cursor, size);
        return ResponseEntity.ok().body(response);
    }

}
