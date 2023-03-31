
/*
非空约束
*/

CREATE TABLE emp01(
	id int NOT NULL, #非空约束
	name VARCHAR(50) NOT NULL #非空约束
);

INSERT INTO emp01 VALUES(1,'张三');


CREATE TABLE emp02(
	id int auto_increment primary KEY, #主键约束
	name VARCHAR(50) DEFAULT '张三', #默认值
	phone VARCHAR(50) UNIQUE KEY DEFAULT '李四' #唯一约束和默认值
);

INSERT INTO emp02(id) VALUES(null);

#在最后指定主键和唯一
CREATE TABLE emp03(
	id int auto_increment, #自增
	name VARCHAR(50) DEFAULT '张三', #默认值
	phone VARCHAR(50) UNIQUE KEY DEFAULT '李四', #唯一约束和默认值
	email VARCHAR(50), 
	PRIMARY KEY(id), #设置主键
	UNIQUE KEY(name) #设置唯一约束
);

INSERT INTO emp03 VALUES(null,"王五","1231342523","123123@123124.com");


#联合主键和联合唯一和检查约束测试
CREATE TABLE emp04(
	id int auto_increment,#自增
	name VARCHAR(50) DEFAULT '张三', #默认
	age int CHECK (age >0 && age <80), #检查约束
	phone VARCHAR(50) UNIQUE KEY DEFAULT '李四', #唯一约束和默认值
	email VARCHAR(50), 
	PRIMARY KEY(id,name), # 联合主键 （两次加入，只要有一个值不同就可以，两次加入的值都是一样就错误）
	UNIQUE KEY(phone,email)#联合唯一 (两个加入，只要有一个值不同就可以，两次加入的值都是一样就错误)
);

#测试表结构和数据
CREATE TABLE `emp04`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '张三',
  `age` int NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '李四',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `salary` double NULL DEFAULT NULL,
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `name`) USING BTREE,
  UNIQUE INDEX `phone`(`phone` ASC) USING BTREE,
  UNIQUE INDEX `phone_2`(`phone` ASC, `email` ASC) USING BTREE,
  CONSTRAINT `emp04_chk_1` CHECK ((`age` > 0) and (`age` < 80))
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `atguigudb`.`emp04` (`id`, `name`, `age`, `phone`, `email`, `salary`, `sex`) VALUES (1, '王五', 2, '1231342523', '123123@123124.com', 3000.23425, '男');
INSERT INTO `atguigudb`.`emp04` (`id`, `name`, `age`, `phone`, `email`, `salary`, `sex`) VALUES (2, '张三', 32, '李四', '123123@123124.com', 34535.809, '女');
INSERT INTO `atguigudb`.`emp04` (`id`, `name`, `age`, `phone`, `email`, `salary`, `sex`) VALUES (3, '李四', 25, '123144', 'DDDFAFSA@312324.com', 1241213.1212, '男');
INSERT INTO `atguigudb`.`emp04` (`id`, `name`, `age`, `phone`, `email`, `salary`, `sex`) VALUES (3, '赵六', 20, '5431234', '22342@323412324.com', 5013.1212, '女');



SELECT * FROM emp04;

/**
分组函数
**常用分组函数类型**

* **AVG(x)** ：求平均值
* **SUM(x)**：求总和
* **MAX(x)** ：求最大值
* **MIN(x)** ：求最小值
* **COUNT(x) **：统计记录数
也可以联合group by分组函数使用
*/
SELECT AVG(age) ageAvG,SUM(salary) sumSalary,MAX(salary) max,MIN(salary),COUNT(1)
FROM emp04;

SELECT COUNT(1),sex 
FROM emp04 GROUP BY sex;

/*
数学函数
| 函数          | 用法                                 |
| ------------- | ------------------------------------ |
| ABS(x)        | 返回x的绝对值                        |
| CEIL(x)       | 返回大于x的最小整数值                |
| FLOOR(x)      | 返回小于x的最大整数值                |
| MOD(x,y)      | 返回x/y的模                          |
| RAND()        | 返回0~1的随机值                      |
| ROUND(x,y)    | 返回参数x的四舍五入的有y位的小数的值 |
| TRUNCATE(x,y) | 返回数字x截断为y位小数的结果         |
| SQRT(x)       | 返回x的平方根                        |
| POW(x,y)      | 返回x的y次方                         |
*/

SELECT ABS(-1),CEIL(salary), FLOOR(salary),ROUND(salary,2),TRUNCATE(salary,2)
FROM emp04;

/*
字符串常用
| 函数                        | 功能描述                                               |
| --------------------------- | ------------------------------------------------------ |
| CONCAT(S1,S2,……Sn)          | 连接S1,S2,……Sn为一个字符串                             |
| CONCAT_WS(s,S1,S2,……Sn)     | 同CONCAT(S1,S2,…)函数，但每个字符串之间要加上s         |
| CHAR_LENGTH(s)              | 返回字符串s的字符数                                    |
| LENGTH(s)                   | 返回字符串s的字节数，和字符集有关                      |
| INSTR(str,str1)             | 返回子字符串str1在str中的开始位置                      |
| UPPER(s)或UCASE(s)          | 将字符串s的所有字母转成大写字母                        |
| LOWER(s)或LCASE(s)          | 将字符串s的所有字母转成小写字母                        |
| LEFT(s,n)                   | 返回字符串s最左边的n个字符                             |
| RIGHT(s,n)                  | 返回字符串s最右边的n个字符                             |
| LPAD(str,len,pad)           | 用字符串pad对str最左边进行填充直到str的长度达到len     |
| RPAD(str,len,pad)           | 用字符串pad对str最右边进行填充直到str的长度达到len     |
| LTRIM(s)                    | 去掉字符串s左侧的空格                                  |
| RTRIM(s)                    | 去掉字符串s右侧的空格                                  |
| TRIM(s)                     | 去掉字符串s开始与结尾的空格                            |
| TRIM([BOTH] s1 FROM s)      | 去掉字符串s开始与结尾的s1                              |
| TRIM([LEADING] s1 FROM s)   | 去掉字符串s开始处的s1                                  |
| TRIM([TRAILING]s1 FROM s)   | 去掉字符串s结尾处的s1                                  |
| INSERT(str,index,len,instr) | 将字符串str从index位置开始len个字符的替换为字符串instr |
| REPLACE(str,a,b)            | 用字符串b替换字符串str中所有出现的字符串a              |
| REPEAT(str,n)               | 返回str重复n次的结果                                   |
| REVERSE(s)                  | 将字符串反转                                           |
| SUBSTRING(s,index,len)      | 返回从字符串s的index位置截取len个字符                  |
*/
SELECT CONCAT(`name`,age,sex)
FROM emp04;

/*
日期时间
| 函数                                                         | 功能描述                                            |
| ------------------------------------------------------------ | --------------------------------------------------- |
| CURDATE()或CURRENT_DATE()                                    | 返回当前系统日期                                    |
| CURTIME()或CURRENT_TIME()                                    | 返回当前系统时间                                    |
| NOW()/SYSDATE()/CURRENT_TIMESTAMP()/  LOCALTIME()/LOCALTIMESTAMP() | 返回当前系统日期时间                                |
| YEAR(date)/MONTH(date)/DAY(date)/  HOUR(time)/MINUTE(time)/SECOND(time) | 返回具体的时间值                                    |
| DAYOFMONTH(date)/DAYOFYEAR(date)                             | 返回一月/年中第几天                                 |
| WEEK(date)/WEEKOFYEAR(date)                                  | 返回一年中的第几周                                  |
| DAYOFWEEK()                                                  | 返回周几，注意，周日是1，周一是2，…周六是7          |
| WEEKDAY(date)                                                | 返回周几，注意，周一是0，周二是1，…周日是6          |
| DAYNAME(date)                                                | 返回星期，MONDAY,TUESDAY,…SUNDAY                    |
| MONTHNAME(date)                                              | 返回月份，January,…                                 |
| DATEDIFF(date1,date2)/TIMEDIFF(time1,time2)                  | 返回date1-date2的日期间隔/返回time1-time2的时间间隔 |
| DATE_ADD(date,INTERVAL expr type)或ADDDATE/DATE_SUB/SUBDATE  | 返回与给定日期相差INTERVAL时间段的日期              |
| ADDTIME(time,expr)/SUBTIME(time,expr)                        | 返回给定时间加上/减去expr的时间值                   |
| DATE_FORMAT(datetime,fmt)/  TIME_FORMAT(time,fmt)            | 按照字符串fmt格式化日期datetime值/时间time值        |
| STR_TO_DATE(str,fmt)                                         | 按照字符串fmt对str进行解析，解析为一个日期          |
*/

SELECT NOW(),CURDATE(),DATE_FORMAT(NOW(),'%Y/%m/%d %H:%i:%s'),
STR_TO_DATE(DATE_FORMAT(NOW(),'%Y/%m/%d %H:%i:%s'),'%Y/%m/%d %H:%i:%s');


/*
4、加密函数
| 函数                  | 用法                                                         |
| --------------------- | ------------------------------------------------------------ |
| password(str)         | 返回字符串str的加密版本，41位长的字符串<font color='red'>（mysql8不再支持）</font> |
| md5(str)              | 返回字符串str的md5值，也是一种加密方式                       |
| SHA(str)              | 返回字符串str的sha算法加密字符串，40位十六进制值的密码字符串 |
| SHA2(str,hash_length) | 返回字符串str的sha算法加密字符串，密码字符串的长度是hash_length/4。hash_length可以是224、256、384、512、0，其中0等同于256。 |
*/

SELECT MD5("hhh");
