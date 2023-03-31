#1、创建数据库：day03_test01_company
CREATE DATABASE day03_test01_company;
use day03_test01_company;
#2、在此数据库下创建如下3表，数据类型，宽度，是否为空根据实际情况自己定义。
#A． 部门表（department）：部门编号（depid），部门名称（depname），部门简介（depinfo）；其中部门编号为主键。
CREATE TABLE department(
depid int auto_increment primary KEY,
depname VARCHAR(50),
depinfo VARCHAR(200)
);

-- B． 雇员表（emoloyee）：雇员编号（empid），姓名（name），性别（sex），职称（title），出生日期（birthday），所在部门编号（depid）；其中
-- * ​	雇员编号为主键；
-- * ​	部门编号为外键，外键约束等级为（on update cascade 和on delete set null）；
-- * ​	性别默认为男；
CREATE TABLE employee(
empid int auto_increment PRIMARY KEY,
name VARCHAR(50),
sex CHAR DEFAULT('男'),
title VARCHAR(50),
birthday date,
depid int,
FOREIGN KEY(depid) REFERENCES department(depid) on UPDATE CASCADE ON DELETE SET NULL
);

-- C． 工资表（salary）：雇员编号（empid），基本工资（basesalary），职务工资（titlesalary），扣除（deduction）。
-- 
-- - ​	其中雇员编号为主键。
-- 
-- - ​	给工资表（salary）的雇员编号（empid）增加外键约束，外键约束等级为（on update cascade 和on delete cascade）
CREATE TABLE salary(
empid int auto_increment PRIMARY KEY,
basesalary DOUBLE,
titlesalary DOUBLE,
deduction DOUBLE,
FOREIGN KEY(empid) REFERENCES employee(empid) on UPDATE CASCADE ON DELETE CASCADE
);

-- 3、添加数据如下：
-- 部门表：
-- | 部门编号 | 部门名称 | 部门简介     |
-- | -------- | -------- | ------------ |
-- | 111      | 生产部   | Null         |
-- | 222      | 销售部   | Null         |
-- | 333      | 人事部   | 人力资源管理 |
INSERT INTO department VALUES(111,'生产部',NULL),
(222,'销售部',NULL),
(333,'人事部','人力资源管理');
--  雇员表：
-- 
-- | 雇员编号 | 姓名 | 性别 | 职称       | 出生日期   | 所在部门编号 |
-- | -------- | ---- | ---- | ---------- | ---------- | ------------ |
-- | 1001     | 张三 | 男   | 高级工程师 | 1975-1-1   | 111          |
-- | 1002     | 李四 | 女   | 助工       | 1985-1-1   | 111          |
-- | 1003     | 王五 | 男   | 工程师     | 1978-11-11 | 222          |
-- | 1004     | 张六 | 男   | 工程师     | 1999-1-1   | 222          |
INSERT INTO employee VALUES(1001,'张三','男','高级工程师','1975-1-1',111),
(1002,'李四','女','助工','1985-1-1',111),
(1003,'王五','男','工程师',' 1978-11-11',222),
(1004,'张六','男','工程师','1999-1-1',222);
SELECT * FROM employee;
--  工资表：
-- 
-- | 雇员编号 | 基本工资 | 职务工资 | 扣除 |
-- | -------- | -------- | -------- | ---- |
-- | 1001     | 2200     | 1100     | 200  |
-- | 1002     | 1200     | 200      | NULL |
-- | 1003     | 2900     | 700      | 200  |
-- | 1004     | 1950     | 700      | 150  |
INSERT INTO salary VALUES(1001,2200,1100,200),
(1002,1200,200,NULL),
(1003,2900,700,200),
(1004,1950,700,150);
-- 5、查询出每个雇员的雇员编号，姓名，职称，应发工资（基本工资+职务工资），实发工资（基本工资+职务工资-扣除）。
SELECT e.empid 编号,e.name 姓名,d.depname 职称, s.basesalary+s.titlesalary 应发工资,s.basesalary+s.titlesalary-IFNULL(deduction,0)
FROM employee e LEFT JOIN department d 
ON e.depid = d.depid
LEFT JOIN salary s ON e.empid = s.empid;

#6、查询销售部门的雇员姓名及其基本工资
SELECT e.name,s.basesalary,d.depname 
FROM employee e LEFT JOIN department d 
ON e.depid = d.depid
LEFT JOIN salary s ON e.empid = s.empid
WHERE d.depname = '销售部';
#7、查询姓“赵”且年龄小于40的员工的全部信息和年龄
SELECT *,YEAR(NOW())-YEAR(birthday) age
FROM employee
WHERE YEAR(NOW())-YEAR(birthday)<40 AND name = '赵%';
#8、查询所有男员工的基本工资和职务工资
SELECT e.*,s.basesalary,s.titlesalary 
FROM employee e left JOIN salary s ON e.empid = s.empid 
WHERE e.sex = '男';
#9、查询基本工资低于2000的员工姓名和职称、所在部门名称
SELECT e.name,e.title,d.depname
FROM employee e LEFT JOIN department d 
ON e.depid = d.depid
LEFT JOIN salary s ON e.empid = s.empid
WHERE s.basesalary<2000;
#10、查询员工总数
SELECT count(1) FROM employee;
#11、查询部门总数
SELECT count(1) FROM department;
#12、查询应发工资的平均工资和最高工资、最低工资
SELECT avg(basesalary+titlesalary),max(basesalary+titlesalary),min(basesalary+titlesalary)
FROM salary;

#13、按照部门统计应发工资的平均工资
SELECT avg(s.basesalary+s.titlesalary),d.depname 
FROM employee e LEFT JOIN department d 
ON e.depid = d.depid
LEFT JOIN salary s ON e.empid = s.empid
GROUP BY d.depname;