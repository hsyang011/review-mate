-- V4__Create_ReviewPhoto_table.sql
CREATE TABLE IF NOT EXISTS review_photo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    photo_url VARCHAR(255) NOT NULL,
    review_id BIGINT NOT NULL,
    FOREIGN KEY (review_id) REFERENCES review(id) ON DELETE CASCADE
);
