## 第1题
# 1、创建数据库day02_test01db
create database if not exists day02_test01db;
use day02_test01db;
# 2、创建表格pet
# | 字段名  | 字段说明 | 数据类型    |
# | ------- | -------- | ----------- |
# | name    | 宠物名称 | varchar(20) |
# | owner   | 宠物主人 | varchar(20) |
# | species | 种类     | varchar(20) |
# | sex     | 性别     | char(1)     |
# | birth   | 出生日期 | year        |
# | death   | 死亡日期 | year        |
create table pet
(
    name    varchar(20),
    owner   varchar(20),
    species varchar(20),
    sex     char,
    birth   year,
    death   year
);
# 3、添加记录
# | name   | owner  | species | sex  | birth | death |
# | ------ | ------ | ------- | ---- | ----- | ----- |
# | Fluffy | harold | Cat     | f    | 2003  | 2010  |
# | Claws  | gwen   | Cat     | m    | 2004  |       |
# | Buffy  |        | Dog     | f    | 2009  |       |
# | Fang   | benny  | Dog     | m    | 2000  |       |
# | bowser | diane  | Dog     | m    | 2003  | 2009  |
# | Chirpy |        | Bird    | f    | 2008  |       |
insert into pet(name, owner, species, sex, birth, death)
values ('Fluffy', 'harold', 'Cat', 'f', '2003', '2010'),
       ('Claws', 'gwen', 'Cat', 'm', '2004', null),
       ('Buffy', null, 'Dog', 'f', '2009', null),
       ('Fang', 'benny', 'Dog', 'm', '2000', null),
       ('bowser', 'diane', 'Dog', 'm', '2003', '2009'),
       ('Chirpy', null, 'Bird', 'f', '2008', null);
# 4、 添加字段主人的生日owner_birth。
alter table pet
    add owner_birth date;
# 5、 将名称为Claws的猫的主人改为kevin
update pet
set owner='kevin'
where name = 'Claws';
# 6、 将没有死的狗的主人改为duck
update pet
set owner = 'duck'
where death is null
  and species = 'Dog';

select *
from pet;
# 7、 查询没有主人的宠物的名字；
select name
from pet
where owner is null;
# 8、 查询已经死了的cat的姓名，主人，以及去世时间；
select name, owner, death
from pet
where death is not null;
# 9、 删除已经死亡的狗
delete
from pet
where death is not null;
# 10、查询所有宠物信息
select *
from pet;
