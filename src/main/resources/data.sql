
INSERT INTO Customer (customer_id, name)
VALUES (1, 'supershopper');

INSERT INTO Customer (customer_id, name)
VALUES (2, 'shopaholic');

INSERT INTO Product (product_id, name, unit_price)
VALUES (1,'levi jeans', 65.99);

INSERT INTO Product (product_id, name, unit_price)
VALUES (2,'microwave', 32.99);

INSERT INTO Product (product_id, name, unit_price)
VALUES (3,'blue jacket', 26.99);

INSERT INTO Product (product_id, name, unit_price)
VALUES (4,'nike shoes', 199.99);

INSERT INTO Product (product_id, name, unit_price)
VALUES (5,'nike shoes', 199.99);

INSERT INTO Product (product_id, name, unit_price)
VALUES (6,'sports car', 21199.99);

INSERT INTO Product (product_id, name, unit_price)
VALUES (7,'leather purse', 329.99);

INSERT INTO Product (product_id, name, unit_price)
VALUES (8,'converse running shoes', 129.99);


INSERT INTO Transaction (transaction_id, customer_id, created)
VALUES (1,1,'2023-09-17');

INSERT INTO Transaction (transaction_id, customer_id, created)
VALUES (2,1,'2023-09-27');

INSERT INTO Transaction (transaction_id, customer_id, created)
VALUES (3,2,'2023-09-17');

INSERT INTO Transaction (transaction_id, customer_id, created)
VALUES (4,2,'2023-09-21');

INSERT INTO Transaction (transaction_id, customer_id, created)
VALUES (5,2,'2023-09-27');

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (1,1);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (1,2);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (1,3);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (2,3);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (2,7);




INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (3,5);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (4,6);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (4,1);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (5,7);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (5,8);

INSERT INTO Trans_Prods (transaction_id, product_id)
VALUES (5,2);