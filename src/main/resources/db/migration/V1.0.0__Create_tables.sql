-- Create_Product_table
CREATE TABLE IF NOT EXISTS product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    review_count INT DEFAULT 0,
    average_score DECIMAL(3, 2) DEFAULT 0
);

-- Create_User_table
CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Create_Review_table
CREATE TABLE IF NOT EXISTS review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    score INT NOT NULL,
    content TEXT,
    photo_url VARCHAR(255),
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);

-- Create_ReviewPhoto_table
CREATE TABLE IF NOT EXISTS review_photo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    photo_url VARCHAR(255) NOT NULL,
    review_id BIGINT NOT NULL,
    FOREIGN KEY (review_id) REFERENCES review(id) ON DELETE CASCADE
);

