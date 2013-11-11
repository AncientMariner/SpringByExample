
CREATE TABLE USERS (
  USERNAME VARCHAR(10) NOT NULL,
  PASSWORD VARCHAR(32) NOT NULL,
  ENABLED SMALLINT,
  PRIMARY KEY (USERNAME)
);
CREATE TABLE AUTHORITIES (
  USERNAME VARCHAR(10) NOT NULL,
  AUTHORITY VARCHAR(10) NOT NULL,
  FOREIGN KEY FK_USERS (USERNAME) REFERENCES USERS(USERNAME)
);

INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) values ('admin', 'secret', 1);
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) values ('user1', '1111', 1);
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) values ('user2', '2222', 0);


INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) values ('admin', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) values ('admin', 'ROLE_USER');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) values ('user1', 'ROLE_USER');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) values ('user2', 'ROLE_USER')