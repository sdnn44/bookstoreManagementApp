INSERT INTO stocks(quantity, is_available) VALUES (32, true);
INSERT INTO stocks(quantity, is_available) VALUES (7, true);
INSERT INTO stocks(quantity, is_available) VALUES (22, true);
INSERT INTO stocks(quantity, is_available) VALUES (3, true);
INSERT INTO stocks(quantity, is_available) VALUES (0, false);


INSERT INTO publishers(publisher_name, publish_date, pages, book_type, book_language)
VALUES ('John Murray Publishers', 'January 01, 2018', 345, 'Paperback', 'English');

INSERT INTO publishers(publisher_name, publish_date, pages, book_type, book_language)
VALUES ('Independently Published', 'December 09, 2022', 62, 'Paperback', 'English');

INSERT INTO publishers(publisher_name, publish_date, pages, book_type, book_language)
VALUES ('Murdoch Books', 'December 13, 2022', 208, 'Paperback', 'English');

INSERT INTO publishers(publisher_name, publish_date, pages, book_type, book_language)
VALUES ('Mariner Books', 'June 01, 2003', 400, 'Hardcover', 'English');

INSERT INTO publishers(publisher_name, publish_date, pages, book_type, book_language)
VALUES ('Signet Book', 'July 01, 1950', 336, 'Mass Market Paperbound', 'English');

-- 1
INSERT INTO books(stock_id, publisher_id, book_title, book_author, book_price, book_category, book_isbn, book_description)
VALUES (1, 1, 'London Rules', 'Mick Herron', 20.00, 'Thriller', 9781399803083, 'London Rules might not be written down, but everyone knows rule one.

Cover your arse.

Regent’s Park’s First Desk, Claude Whelan, is learning this the hard way. Tasked with protecting a beleaguered prime minister, he’s facing attack from all directions himself: from the showboating MP who orchestrated the Brexit vote, and now has his sights set on Number Ten; from the showboat’s wife, a tabloid columnist, who’s crucifying Whelan in print; and especially from his own deputy, Lady Di Taverner, who’s alert for Claude’s every stumble.');

-- 2
INSERT INTO books(stock_id, publisher_id, book_title, book_author, book_price, book_category, book_isbn, book_description)
VALUES (2, 2, 'The Silent Twins', 'Marjorie Wallace', 55.00, 'Crime', 9780099586418, 'When identical twins June and Jennifer Gibbons were three they began to reject communication with anyone but each other, and so began a childhood bound together in a strange and secret world. As they grew up, love, hate, and genius united to push them to the extreme margins of society and, following a five-week spree of vandalism and arson, the silent twins were sentenced to a grueling twelve-year detention in Broadmoor.');

-- 3
INSERT INTO books(stock_id, publisher_id, book_title, book_author, book_price, book_category, book_isbn, book_description)
VALUES (3, 3, 'The Space Between the Stars', 'Anne Corlett', 45.00, 'Science-Fiction', 9781509833559, 'In a breathtakingly vivid and emotionally gripping debut novel, one woman must confront the emptiness in the universe—and in her own heart—when a devastating virus reduces most of humanity to dust and memories.

All Jamie Allenby ever wanted was space. Even though she wasn’t forced to emigrate from Earth, she willingly left the overpopulated, claustrophobic planet. And when a long relationship devolved into silence and suffocating sadness, she found work on a frontier world on the edges of civilization. Then the virus hit…');

-- 4
INSERT INTO books(stock_id, publisher_id, book_title, book_author, book_price, book_category, book_isbn, book_description)
VALUES (4, 4, 'Animal Farm', 'George Orwell', 15.00, 'Science-Fiction', 9781784876609, 'George Orwell’s fable of revolutionary farm animals – the steadfast horses Boxer and Clover, the opportunistic pigs Snowball and Napoleon, and the deafening choir of sheep – who overthrow their elitist human master only to find themselves subject to a new authority, is one of the most famous warnings ever written.

Rejected by such eminent publishing figures as Victor Gollancz, Jonathan Cape and T.S. Eliot due to its daringly open criticism of Stalin, Animal Farm was published to great acclaim by Martin Secker and Warburg on 17 August 1945. One reviewer wrote ''In a hundred years’ time perhaps Animal Farm … may simply be a fairy story: today it is a fairy story with a good deal of point.’');

-- 5
INSERT INTO books(stock_id, publisher_id, book_title, book_author, book_price, book_category, book_isbn, book_description)
VALUES (5, 5, '1984', 'George Orwell', 14.00, 'Fiction', 9781784876593, 'The year is 1984 and war and revolution have left the world unrecognisable. Great Britain, now known as Airstrip One, is ruled by the Party, led by Big Brother. Mass surveillance is everything and The Thought Police are employed to ensure that no individual thinking is allowed. Winston Smith works at The Ministry of Truth, carefully rewriting history, but he dreams of freedom and of rebellion. It is here that he meets and falls in love with Julia. They start a secret, forbidden affair – but nothing can be kept secret, and they are forced to face consequences more terrifying than either of them could have ever imagined.');

insert into ROLES(ROLE_NAME)
values ('ADMIN'), ('USER');

insert into USERS(USERNAME, PASSWORD, ROLE_ID)
values ('admin', '$2a$10$nkzrCXmW3wi1o6SS/V9mG.OJcD9IqImGZNXXvSjnP.ksDHEUc3V0i', 1),
       ('user', '$2a$10$nkzrCXmW3wi1o6SS/V9mG.OJcD9IqImGZNXXvSjnP.ksDHEUc3V0i', 2);

INSERT INTO reviews(book_id, rating, review_content, review_email, review_login)
VALUES (1, 5, 'Great book', 'login@gmail.com', 'nickname');

INSERT INTO reviews(book_id, rating, review_content, review_email, review_login)
VALUES (1, 1, 'Boring', 'mark@gmail.com', 'markiee');

INSERT INTO reviews(book_id, rating, review_content, review_email, review_login)
VALUES (1, 3, 'Not a big fan', 'jonas@gmail.com', 'jonte');

INSERT INTO reviews(book_id, rating, review_content, review_email, review_login)
VALUES (2, 5, 'Wow', 'mikkel@gmail.com', 'whereisjessicahyde');

INSERT INTO reviews(book_id, rating, review_content, review_email, review_login)
VALUES (3, 5, 'Wow', 'mikkel@gmail.com', 'whereisjessicahyde');

INSERT INTO reviews(book_id, rating, review_content, review_email, review_login)
VALUES (4, 5, 'Wow', 'mikkel@gmail.com', 'whereisjessicahyde');

INSERT INTO reviews(book_id, rating, review_content, review_email, review_login)
VALUES (5, 5, 'Wow', 'mikkel@gmail.com', 'whereisjessicahyde');