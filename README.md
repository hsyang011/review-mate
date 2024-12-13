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

### 4. ReviewPhoto 테이블

| 컬럼명          | 데이터 타입 | 설명                 |
|-----------------|-------------|----------------------|
| reviewPhoto_id  | INT         | 리뷰 사진 고유 ID     |
| photourl        | VARCHAR(255)| 사진 URL             |
| review_id       | INT         | 리뷰 ID (외래키)      |
