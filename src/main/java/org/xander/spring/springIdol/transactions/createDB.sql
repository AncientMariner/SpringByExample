CREATE TABLE BOOK (
ISBN VARCHAR(50) NOT NULL,
BOOK_NAME VARCHAR(100) NOT NULL,
PRICE INT,
PRIMARY KEY (ISBN)
);

CREATE TABLE BOOK_STOCK (
ISBN VARCHAR(50) NOT NULL,
STOCK INT NOT NULL,
PRIMARY KEY (ISBN),
CHECK (STOCK >= 0)
);

CREATE TABLE ACCOUNT (
USERNAME VARCHAR(50) NOT NULL,
BALANCE INT NOT NULL,
PRIMARY KEY (USERNAME),
CHECK (BALANCE >= 0)
);

insert into BOOK (isbn, book_name, price) values (0001, 'The first book', 30);
insert into BOOK_STOCK (isbn, stock) values (0001, 10);
INSERT INTO ACCOUNT (username, balance) VALUES ('user1', 20);