CREATE TABLE "order".payment_details
(
    order_id int8 PRIMARY KEY,
    credit_number int8 not null,
    expiration_month varchar(2) not null,
    expiration_year varchar(4) not null,
    cvv varchar(3) not null
);