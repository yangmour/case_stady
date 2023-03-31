#1、创建数据库day01_test01_market
create database day01_test01_market;
use day01_test01_market;
# 2、创建表格customers
# | 字段名    | 数据类型    |
# | --------- | ----------- |
# | c_num     | int         |
# | c_name    | varchar(50) |
# | c_contact | varchar(50) |
# | c_city    | varchar(50) |
# | c_birth   | date        |
create table customres
(
    c_num     int,
    c_name    varchar(50),
    c_contact varchar(50),
    c_city    varchar(50),
    c_birth   date
);
# 要求3：**将c_contact字段移动到c_birth字段后面
alter table customres
    modify c_contact varchar(50) after c_birth;
# 要求4：**将c_name字段数据类型改为 varchar(70)
alter table customres
    modify c_name varchar(70);
# 要求5：**将c_contact字段改名为c_phone
alter table customres
    change c_contact c_phone varchar(50);
# 要求6：**增加c_gender字段到c_name后面，数据类型为char(1)
alter table customres
    add c_gender char after c_name;
# 要求7：**将表名改为customers_info
alter table customres rename to customers_info;
# 要求8：**删除字段c_city
alter table customers_info
drop c_city;