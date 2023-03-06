# 1、创建数据库day01_test03db
create database if not exists day01_test03db;
use day01_test03db;
# # 2、创建表格employee(数据类型根据数据自己决定),并添加记录
# | **id** | **name** | **sex** | **salary** | **addr** |
# | ------ | -------- | ------- | ---------- | -------- |
# | 10001  | 张一一   | 男      | 1001.58    | 广东韶关 |
# | 10002  | 刘小红   | 女      | 1201.21    | 广东江门 |
# | 10003  | 李四     | 男      | 1004.11    | 广东佛山 |
# | 10004  | 刘小强   | 男      | 1501.23    | 广东深圳 |
# | 10005  | 王艳     | 女      | 1405.16    | 广东广州 |
create table employee
(
    id     int,
    name   varchar(50),
    sex    char,
    salary double,
    addr   varchar(50)
);

insert into employee
    # | 10001  | 张一一   | 男      | 1001.58    | 广东韶关 |
# | 10002  | 刘小红   | 女      | 1201.21    | 广东江门 |
# | 10003  | 李四     | 男      | 1004.11    | 广东佛山 |
# | 10004  | 刘小强   | 男      | 1501.23    | 广东深圳 |
# | 10005  | 王艳     | 女      | 1405.16    | 广东广州 |
values (10001, '张一一', '男 ', 1001.58, '广东韶关'),
       (10002, '刘小红', '女 ', 1201.21, '广东江门'),
       (10003, '李四', '男 ', 1004.11, '广东佛山'),
       (10004, '刘小强', '男 ', 1501.23, '广东深圳'),
       (10005, '王艳', '女 ', 1405.16, '广东广州');

# 要求3：**查询出薪资在1200~1300之间的员工信息。
select *
from employee
where salary between 1200 and 1300;
# 要求4：**查询出姓“刘”的员工的工号，姓名，家庭住址。
select id, name, addr
from employee
where name like '刘%';
# 要求5：**查询出所有人的信息外加每个人的年薪
select *, salary * 12 yearSalary
from employee;
# 要求6：**查询出名字中带“小”的员工
select *
from employee
where name like '%小%';
# 要求7：**查询广东深圳并且工资大于1200的员工信息
select *
from employee
where employee.salary > 1200;
# 要求8：**查询广东深圳或者工资大于1200的员工信息
select *
from employee
where salary > 1200
   or addr = '广州深圳';