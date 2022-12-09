CREATE SEQUENCE "order".ORDER_SEQUENCE
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1;

CREATE TABLE "order".order
(
    id int8 PRIMARY KEY,
    user_id int8 NOT NULL,
    purchase_date TIMESTAMP NOT NULL,
    promotion_id int8,
    price real NOT NULL,
    product_id varchar(255) NOT NULL
);