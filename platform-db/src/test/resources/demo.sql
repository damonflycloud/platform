create database if not exists test ;
use test;
create table if not exists user (
	id INTEGER primary key AUTO_INCREMENT,
	height double null ,
	age integer null, 
	money DECIMAL null,
	name VARCHAR(50) null,
	birthDate TIMESTAMP null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user(height,age,money,name,birthDate) values (175.34, 26, 234324.43, 'Mr yang', '2000-03-12 00:00:00');

create table if not exists user_uuid (
	id varchar(35) primary key ,
	height double null ,
	age integer null, 
	money DECIMAL null,
	name VARCHAR(50) null,
	birthDate TIMESTAMP null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user_uuid(id,height,age,money,name,birthDate) values ('1', 175.34, 26, 234324.43, 'Mr yang', '2000-03-12 00:00:00');
