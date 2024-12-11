-- Insert_into_Product_table
INSERT INTO product (name, description, price, review_count, average_score)
VALUES
    ('Product 1', 'This is the description for product 1.', 19.99, 10, 4.5),
    ('Product 2', 'This is the description for product 2.', 29.99, 5, 3.8),
    ('Product 3', 'This is the description for product 3.', 15.49, 0, 0),
    ('Product 4', 'This is the description for product 4.', 99.99, 15, 4.2),
    ('Product 5', 'This is the description for product 5.', 49.99, 20, 4.7);

-- Insert_into_User_table
INSERT INTO user (email, username, password)
VALUES
    ('user1@example.com', 'user1', 'password1'),
    ('user2@example.com', 'user2', 'password2'),
    ('user3@example.com', 'user3', 'password3'),
    ('user4@example.com', 'user4', 'password4'),
    ('user5@example.com', 'user5', 'password5');
