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
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) values ('user2', 'ROLE_USER');




CREATE TABLE acl_sid(
  ID BIGINT not null AUTO_INCREMENT ,
  SID VARCHAR (100) not null,
  PRINCIPAL SMALLINT not null,
  PRIMARY KEY (ID),
  UNIQUE (SID, PRINCIPAL)
);

CREATE TABLE acl_class(
  ID BIGINT not null default 1,
  CLASS VARCHAR (100) not null,
  PRIMARY KEY (ID),
  UNIQUE (CLASS)
);

CREATE TABLE acl_object_identity(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  OBJECT_ID_CLASS BIGINT NOT NULL,
  OBJECT_ID_IDENTITY BIGINT NOT NULL,
  PARENT_OBJECT BIGINT,
  OWNER_SID BIGINT,
  ENTRIES_INHERITING SMALLINT NOT NULL,
  PRIMARY KEY(ID),
  UNIQUE(OBJECT_ID_CLASS, OBJECT_ID_IDENTITY),
  FOREIGN KEY (PARENT_OBJECT) REFERENCES acl_object_identity(ID),
  FOREIGN KEY (OBJECT_ID_CLASS) REFERENCES acl_class(ID),
  FOREIGN KEY (OWNER_SID) REFERENCES acl_sid(ID)
);

CREATE TABLE acl_entry (
  ID BIGINT NOT NULL AUTO_INCREMENT,
  ACL_OBJECT_IDENTITY BIGINT NOT NULL,
  ACE_ORDER INT NOT NULL,
  SID BIGINT NOT NULL,
  MASK INTEGER NOT NULL,
  GRANTING SMALLINT NOT NULL,
  AUDIT_SUCCESS SMALLINT NOT NULL,
  AUDIT_FAILURE SMALLINT NOT NULL,
  PRIMARY KEY(ID),
  UNIQUE (ACL_OBJECT_IDENTITY, ACE_ORDER),
  FOREIGN KEY (ACL_OBJECT_IDENTITY) references acl_object_identity(ID),
  FOREIGN KEY (SID) references acl_sid(ID)
);
