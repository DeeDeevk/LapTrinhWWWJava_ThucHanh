INSERT INTO customers (name, customer_since) VALUES
                                                 ('Nguyen Van A', '2021-05-10'),
                                                 ('Tran Thi B', '2022-03-22'),
                                                 ('Le Hoang C', '2023-01-15');

INSERT INTO categories (name) VALUES
                                  ('Electronics'),
                                  ('Clothing'),
                                  ('Books');

-- PRODUCT
INSERT INTO products (name, price, in_stock, category_id) VALUES
                                                              ('Laptop Lenovo', 15000000, TRUE, 1),
                                                              ('Smartphone Samsung', 10000000, TRUE, 1),
                                                              ('T-shirt Polo', 350000, TRUE, 2),
                                                              ('Novel - The Alchemist', 120000, TRUE, 3),
                                                              ('Jeans Blue', 450000, TRUE, 2);

-- COMMENT
INSERT INTO comments (text, product_id) VALUES
                                            ('Very good laptop, fast and reliable!', 1),
                                            ('Battery drains a bit fast.', 1),
                                            ('Keyboard feels smooth and comfortable.', 1),
                                            ('Nice shirt, fits perfectly.', 3),
                                            ('Color is slightly different than in the photo.', 3),
                                            ('Amazing book! Totally worth it.', 4),
                                            ('Storyline was engaging from start to finish.', 4),
                                            ('Shipping was quick and packaging was safe.', 2),
                                            ('Price is reasonable for the quality.', 2),
                                            ('Customer support was very helpful.', 5),
                                            ('Would buy again, highly recommend!', 1),
                                            ('Fabric quality is top-notch!', 3),
                                            ('Pages are thick and easy to read.', 4),
                                            ('Got a small scratch, but overall good.', 2),
                                            ('Arrived earlier than expected.', 5);

-- ORDER
INSERT INTO orders (date, customer_id) VALUES
                                           ('2023-08-15', 1),
                                           ('2023-09-20', 2),
                                           ('2023-09-25', 1);

-- ORDERLINE
INSERT INTO OrderLines (order_id, product_id, amount, purchase_price) VALUES
                                                                          (1, 1, 1, 14500000),
                                                                          (1, 3, 2, 330000),
                                                                          (2, 2, 1, 9800000),
                                                                          (2, 4, 1, 110000),
                                                                          (3, 5, 1, 430000);