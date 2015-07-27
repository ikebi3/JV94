drop database sales;

create database sales character set utf8;

use sales;

-- show create table users;

create table users (
pkey int primary key auto_increment not null,
id int(6) zerofill unique not null,
pw varchar(32) not null,
salt varchar(6) not null,
c_time datetime default current_timestamp not null,
u_time timestamp default current_timestamp on update current_timestamp not null
);

insert into users set id=1, pw=md5('abc'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=2, pw=md5('cba'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=3, pw=md5('def'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=4, pw=md5('fed'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=5, pw=md5('ihg'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=6, pw=md5(concat(pw,md5(now(6)))), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=7, pw=md5('jkl'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=8, pw=md5('lkj'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=9, pw=md5('mno'), salt=md5(now(6)), c_time=now(), u_time=now();
insert into users set id=10, pw=md5('onm'), salt=md5(now(6)), c_time=now(), u_time=now();


-- create user user01@localhost identified by 'password';

-- GRANT FILE ON  *.* TO user01;
-- GRANT SELECT ON sales.* TO user01;
-- GRANT
--		INSERT(id,pw,salt),
--		UPDATE(pw),
--		DELETE ON
--				user TO user01;
-- FLUSH PRIVILEGES;