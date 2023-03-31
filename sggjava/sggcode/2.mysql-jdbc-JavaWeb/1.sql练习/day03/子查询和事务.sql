SELECT * FROM emp04;
/*
# 13. 子查询
## 13.1 SELECT的SELECT中嵌套子查询
子查询：嵌套在另一个SQL语句中的查询。
SELECT语句可以嵌套在另一个SELECT中，UPDATE，DELETE，INSERT，CREATE语句等。
*/

-- (1)SELECT的SELECT中嵌套子查询
#（1）在“t_employee”表中查询每个人薪资和公司平均薪资的差值，
#并显示员工薪资和公司平均薪资相差5000元以上的记录。
SELECT AVG(salary) FROM emp04
SELECT *,salary-(SELECT AVG(salary) FROM emp04) FROM emp04;

SELECT *,salary-(SELECT AVG(salary) FROM emp04) FROM emp04 WHERE ABS(salary-(SELECT AVG(salary) FROM emp04))>5000;

#（2）在“t_employee”表中查询每个性别平均薪资和平均薪资的差值。
SELECT AVG(salary) FROM emp04;

SELECT sex,salary-(SELECT AVG(salary) FROM emp04) FROM emp04 GROUP BY sex

##（1）在“t_employee”表中查询薪资最高的员工姓名（ename）和薪资（salary）。
#SELECT ename,MAX(salary) FROM t_employee;#错误
#取表中第一行员工的姓名和全公司最高的薪资值一起显示。
SELECT `name`,salary FROM emp04 WHERE salary = (SELECT MAX(salary) FROM emp04);

DELETE FROM emp04 WHERE name = (SELECT * FROM (SELECT name FROM emp04 WHERE name = '李四') as a);

#复制表结构
CREATE TABLE emp05 LIKE emp04;
INSERT INTO emp05 (SELECT * FROM emp04);
#复制表结构和数据
CREATE TABLE emp06 AS (SELECT * FROM emp04);

#事务
set autocommit = FALSE;
UPDATE emp06 SET salary = 2000 WHERE id = 1;
UPDATE emp06 SET salary = 6013 WHERE id = 3;

#提交
COMMIT
#回滚
ROLLBACK