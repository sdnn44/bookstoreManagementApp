CREATE TABLE IF NOT EXISTS stocks
(
    stock_id            serial PRIMARY KEY,
--     price_total          float,
    quantity      int,
    is_available         boolean
);

CREATE TABLE IF NOT EXISTS publishers
(
    publisher_id            serial PRIMARY KEY,
    publisher_name varchar,
    publish_date varchar, -- ???
    pages      int,
    book_type varchar,
    book_language         varchar
);

CREATE TABLE IF NOT EXISTS books
(
    book_id    serial PRIMARY KEY ,
    stock_id     int,
    publisher_id int,
    book_title        varchar,
    book_author         varchar,
    book_price       float,
    book_category         varchar,
    book_isbn        bigint,
    book_description          varchar,

    CONSTRAINT fk_book_stock FOREIGN KEY (stock_id) REFERENCES stocks (stock_id),
    CONSTRAINT fk_book_publisher FOREIGN KEY (publisher_id) REFERENCES publishers (publisher_id)

    );
