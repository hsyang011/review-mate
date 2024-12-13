# 기업 과제 1 : 리뷰 서비스

- **리뷰 작성 및 관리**  
  사용자가 상품 또는 서비스를 리뷰하고, 리뷰를 수정/삭제할 수 있습니다.

- **Docker-compose 기반 배포**  
  프로젝트는 Docker-compose를 이용하여 컨테이너화되어 있으며, MySQL 데이터베이스와 함께 배포됩니다.


## 기술 스택

- **Backend**: Spring Boot 3.x
- **Database**: MySQL 8.0+
- **Authentication**: Spring Security
- **File Storage**: Amazon S3 (더미 통합)
- **Deployment**: Docker, Docker-compose
- **Version Control**: Git


## 테이블 명세

`reviewmate` 프로젝트에서 사용되는 주요 MySQL 테이블은 다음과 같습니다.

### 1. User 테이블

| 컬럼명          | 데이터 타입 | 설명             |
|-----------------|-------------|------------------|
| user_id         | INT         | 사용자 고유 ID    |
| username        | VARCHAR(50) | 사용자 이름      |
| password        | VARCHAR(255)| 비밀번호         |
| email           | VARCHAR(100)| 이메일 주소      |

### 2. Review 테이블

| 컬럼명          | 데이터 타입 | 설명                     |
|-----------------|-------------|--------------------------|
| review_id       | INT         | 리뷰 고유 ID              |
| user_id         | INT         | 사용자 ID (외래키)        |
| product_id      | INT         | 상품 ID (외래키)          |
| content         | VARCHAR(255)| 리뷰 내용                 |
| photourl        | VARCHAR(255)| 사진 URL                  |
| score           | INT         | 평점 (1-5)                |

### 3. Product 테이블

| 컬럼명          | 데이터 타입 | 설명                 |
|-----------------|-------------|----------------------|
| product_id      | INT         | 상품 고유 ID          |
| name            | VARCHAR(255)| 상품명                |
| description     | VARCHAR(255)| 상품 설명             |
| price           | INT         | 상품 가격             |
| review_count    | INT         | 상품의 리뷰 갯수       |
| average_score   | INT         | 상품의 평균 리뷰 점수  |

### 4. ReviewPhoto 테이블 - 리뷰에 등록될 사진이 여러장일 경우, Review테이블과 N:1 관계를 맺습니다.

| 컬럼명          | 데이터 타입 | 설명                 |
|-----------------|-------------|----------------------|
| reviewPhoto_id  | INT         | 리뷰 사진 고유 ID     |
| photourl        | VARCHAR(255)| 사진 URL             |
| review_id       | INT         | 리뷰 ID (외래키)      |


## 데이터 관계 설명

1. **User와 Review**  
   - 1:N 관계입니다. 하나의 사용자는 여러 개의 리뷰를 작성할 수 있습니다.

2. **Product와 Review**  
   - 1:N 관계입니다. 하나의 상품은 여러 리뷰를 가질 수 있습니다.

3. **Review와 ReviewPhoto**  
   - 1:N 관계입니다. 하나의 리뷰는 여러 개의 사진을 가질 수 있으며, 사진은 리뷰의 부가 정보를 제공합니다.
  

## 트러블슈팅

### 파일 업로드와 JSON 요청 동시 처리 문제

**문제 상황**  
리뷰 작성 시 텍스트(JSON 데이터)와 이미지 파일(멀티파트 데이터)을 동시에 처리해야 했습니다. 그러나 Spring Boot에서 `multipart/form-data` 요청 내 JSON 데이터와 파일 데이터를 분리해 처리하는 과정에서 다음과 같은 문제가 발생했습니다:

- JSON 데이터 매핑 실패  
- 파일 처리와 JSON 파싱 간 충돌  

---

**해결 과정**  

1. **요청 형식 설계**  
   클라이언트에서 JSON 데이터를 문자열로 전송하고 파일 데이터를 함께 포함하도록 요청 형식을 지정했습니다.  

2. **DTO와 컨트롤러 구현**  
   - JSON 데이터를 매핑할 DTO 클래스(`ReviewRequestDTO`)를 설계했습니다.  
   - 컨트롤러에서 `@RequestPart`를 사용하여 JSON 데이터와 파일 데이터를 분리해 처리했습니다.  
   ```java
   @PostMapping(value = "/products/{productId}/reviews", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> addReview(
            @PathVariable Long productId,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestPart(value = "request") AddReviewRequest request) {

        productService.addReview(productId, image, request);
        return ResponseEntity.ok().body("Review created successfully.");
    }
