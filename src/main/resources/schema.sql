CREATE TABLE STORY (
  ID      INT IDENTITY,
  CONTENT VARCHAR(144)
);
create table users(
	username varchar(50) not null primary key,
	password varchar(250) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

-- create user
INSERT INTO users VALUES('a','$2a$10$bT.U.ZEJOBhQ1.dAnifAk.wSTPbTjLnBpt5Q5zXN2qZlw85InW.Fu',true);
INSERT INTO authorities VALUES('a','ADMIN');