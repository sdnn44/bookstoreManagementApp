drop table if exists stocks cascade;
drop table if exists publishers cascade;
drop table if exists books cascade;
drop table if exists ROLES cascade;
drop table if exists USERS cascade;
drop table if exists reviews cascade;
drop table if exists FAVOURITE cascade;

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
    book_id    serial PRIMARY KEY,
    stock_id     int,
    publisher_id int,
    book_title        varchar,
    book_author         varchar,
    book_price       numeric,
    book_category         varchar,
    book_isbn        varchar,
    book_description          varchar,

    CONSTRAINT fk_book_stock FOREIGN KEY (stock_id) REFERENCES stocks (stock_id),
    CONSTRAINT fk_book_publisher FOREIGN KEY (publisher_id) REFERENCES publishers (publisher_id)

);

CREATE TABLE IF NOT EXISTS reviews
(
    review_id serial PRIMARY KEY,
    book_id int,
    rating int,
    review_content varchar,
    review_email varchar,
    review_login varchar,
    CONSTRAINT fk_review_book FOREIGN KEY (book_id) REFERENCES books (book_id)
);
create table if not exists ROLES
(
    ID serial primary key,
    ROLE_NAME varchar
);

create table if not exists USERS(
    ID serial primary key,
    USERNAME varchar,
    PASSWORD varchar not null,
    ROLE_ID integer,
    constraint roles_fk foreign key (ROLE_ID) references ROLES(ID)
);

create table if not exists FAVOURITE_BOOKS(
    user_id serial,
    book_id serial,
    constraint user_id_fav_fk foreign key(user_id) references USERS(ID),
    constraint book_id_fav_fk foreign key(book_id) references books(book_id)
);