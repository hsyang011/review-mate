-- V1__Create_Product_table.sql
CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    review_count INT DEFAULT 0,
    average_score DECIMAL(3, 2) DEFAULT 0
);
