### 第2题
# 1、创建数据库day01_test02_company
create database if not exists day01_test02_company;
use day01_test02_company;
/*2、创建表格employees
| 字段名     | 数据类型      |
| ---------- | ------------- |
| emp_num    | int           |
| first_name | varchar(50)   |
| last_name  | varchar(50)   |
| mobile     | varchar(25)   |
| code       | int           |
| birth      | date          |
| note       | varchar(255） |
| sex        | varchar（5）  |
*/
create table employees
(
    emp_num    int,
    first_name varchar(50),
    last_name  varchar(50),
    mobile     varchar(25),
    code       int,
    birth      int,
    note       varchar(255),
    sex        varchar(5)
);
# 要求3：**将表employees的mobile字段修改到code字段后面。
alter table employees
    modify mobile varchar(25) after code;
# 要求4：**将表employees的birth字段改名为birthday;
alter table employees
    change birth birthday date;
# 要求5：**修改sex字段，数据类型为char(1)。
alter table employees
    modify sex char;
# 要求6：**删除字段note；
alter table employees
    drop note;
# 要求7：**增加字段名bonus，数据类型为double；
alter table employees
    add bonus double;
# 要求8：**将表employees的名称修改为 employees_info
alter table employees rename to employees_inf;