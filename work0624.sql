drop database hage;

create database hage character set utf8;

use hage;

create table user (
pkey int primary key auto_increment,
id int(6) zerofill,
pw varchar(32),
salt varchar(6) );

insert into user set id=1, pw=md5('abc'), salt=md5(now(6));
insert into user set id=2, pw=md5('abc'), salt=md5(now(6));
insert into user set id=3, pw=md5('def'), salt=md5(now(6));
insert into user set id=4, pw=md5('def'), salt=md5(now(6));
insert into user set id=5, pw=md5('ghi'), salt=md5(now(6));
insert into user set id=6, pw=md5('ghi'), salt=md5(now(6));
insert into user set id=7, pw=md5('jkl'), salt=md5(now(6));
insert into user set id=8, pw=md5('jkl'), salt=md5(now(6));
insert into user set id=9, pw=md5('mno'), salt=md5(now(6));
insert into user set id=10, pw=md5('mno'), salt=md5(now(6));
