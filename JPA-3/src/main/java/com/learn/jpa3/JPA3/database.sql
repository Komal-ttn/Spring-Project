create table author(auth_id int PRIMARY KEY AUTO_INCREMENT,auth_name VARCHAR(20),street_number int,location VARCHAR(20),state VARCHAR(20));

create table book(id int PRIMARY KEY AUTO_INCREMENT,book_name VARCHAR(20),auth_id int,FOREIGN KEY(auth_id) REFERENCES author(auth_id));

create table authors_book( author_id int, book_id int, FOREIGN KEY(author_id) REFERENCES author(auth_id), FOREIGN KEY(book_id) REFERENCES book(id));
