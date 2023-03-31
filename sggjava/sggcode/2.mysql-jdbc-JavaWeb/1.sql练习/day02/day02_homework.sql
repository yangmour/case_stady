

#1、创建数据库day01_test02_library
CREATE DATABASE day01_test02_libray;
USE day01_test02_libray;
/*2、创建表格books
| 字段名  | 字段说明 | 数据类型      |
| ------- | -------- | ------------- |
| b_id    | 书编号   | int           |
| b_name  | 书名     | varchar（50） |
| authors | 作者     | varchar(100)  |
| price   | 价格     | float         |
| pubdate | 出版日期 | year          |
| note    | 说明     | varchar(100)  |
| num     | 库存     | int           |
*/
CREATE TABLE books(
	b_id int COMMENT '书编号',
	b_name VARCHAR(50) COMMENT '书名',
	authors VARCHAR(100) COMMENT '作者',
	price FLOAT COMMENT '价格',
	pubdate YEAR COMMENT '出版社',
	note VARCHAR(100) COMMENT '说明',
	num int COMMENT '库存'
);

#3、使用alter语句给books按如下要求增加相应的约束
/*
| 字段名  | 字段说明 | 数据类型      | 主键 | 外键 | 非空 | 唯一 | 自增 |
| ------- | -------- | ------------- | ---- | ---- | ---- | ---- | ---- |
| b_id    | 书编号   | int           | 是   | 否   | 是   | 是   | 是   |
| b_name  | 书名     | varchar（50） | 否   | 否   | 是   | 否   | 否   |
| authors | 作者     | varchar(100)  | 否   | 否   | 是   | 否   | 否   |
| price   | 价格     | float         | 否   | 否   | 是   | 否   | 否   |
| pubdate | 出版日期 | year          | 否   | 否   | 是   | 否   | 否   |
| note    | 说明     | varchar(100)  | 否   | 否   | 否   | 否   | 否   |
| num     | 库存     | int           | 否   | 否   | 是   | 否   | 否   |
*/
DESC books;

ALTER TABLE books MODIFY b_id int auto_increment PRIMARY KEY ;
ALTER TABLE books MODIFY b_name varchar(50) NOT NULL;
ALTER TABLE books MODIFY authors varchar(100) NOT NULL;
ALTER TABLE books MODIFY price float NOT NULL;
ALTER TABLE books MODIFY pubdate year NOT NULL;
ALTER TABLE books MODIFY num int NOT NULL;


/*4、向books表中插入记录
| b_id | b_name        | authors         | price | pubdate | note     | num  |
| ---- | ------------- | --------------- | ----- | ------- | -------- | ---- |
| 1    | Tal of AAA    | Dickes          | 23    | 1995    | novel    | 11   |
| 2    | EmmaT         | Jane lura       | 35    | 1993    | joke     | 22   |
| 3    | Story of Jane | Jane Tim        | 40    | 2001    | novel    | 0    |
| 4    | Lovey Day     | George Byron    | 20    | 2005    | novel    | 30   |
| 5    | Old land      | Honore Blade    | 30    | 2010    | law      | 0    |
| 6    | The Battle    | Upton Sara      | 30    | 1999    | medicine | 40   |
| 7    | Rose Hood     | Richard haggard | 28    | 2008    | cartoon  | 28   |
*/
INSERT INTO books(b_name,authors,price,pubdate,note,num) 	
VALUES('Tal of AAA','Dickes',23,1995,'novel',11),
('EmmaT','Jane lura',35,1993,'joke',22),
('Story of Jane','Jane Tim',40,2001,'novel',0),
('Lovey Day','George Byron',20,2005,'novel',30),
('Old land','Honore Blade',30,2010,'law',0),
('The Battle','Upton Sara',30,1999,'medicine',40),
('Rose Hood','Richard haggard',28,2008,'cartoon',28)


SELECT * from books;

#5、找出“novel”类型的书，按照价格降序排列
SELECT * FROM books WHERE note = 'novel' ORDER BY price DESC;
6、查询图书信息，按照库存量降序排列，如果库存量相同的按照note升序排列
SELECT * FROM books ORDER BY num DESC,note;
7、按照note分类统计书的数量
SELECT note,count(1) count FROM books GROUP BY note;
8、按照note分类统计书的库存量，显示库存量超过30本的
SELECT * FROM books  GROUP BY note HAVING sum(num)>30; 
9、查询所有图书，每页显示5本，显示第二页
SELECT * FROM books LIMIT 5,5;
10、按照note分类统计书的库存量，现在库存量最多的
SELECT note,sum(num) FROM books GROUP BY note ORDER BY sum(num) DESC LIMIT 1;
11、查询书名达到10个字符的书，不包括里面的空格
SELECT * FROM books WHERE LENGTH(REPLACE(b_name,' ','')) >=10;
12、查询书名和类型，其中note值为novel显示小说，law显示法律，medicine显示医药，cartoon显示卡通，joke显示笑话
SELECT b_name,
	CASE note 
		WHEN 'novel' THEN '小说'
		WHEN 'law' THEN '法律'
		WHEN 'medicine' THEN '医药'
		WHEN 'cartoon' THEN '卡通'
		WHEN 'joke' THEN '笑话'
	END
FROM books;

13、查询书名、库存，其中num值超过30本的，显示滞销，大于0并低于10的，显示畅销，为0的显示显示无货，其他的显示正常
SELECT b_name,
	case WHEN num>30 THEN '滞销'
	     WHEN num>0 AND num<10 THEN '畅销'
			 WHEN NUM = 0 THEN '无货'
			 ELSE '正常'
	 END
FROM books;

14、统计库存量前三名的图书
SELECT * FROM books ORDER BY num desc LIMIT 3;

15、找出最早出版的一本书
SELECT * FROM books ORDER BY pubdate LIMIT 1;
16、找出novel中单价最高的一本书
SELECT * FROM books WHERE note = 'novel' ORDER BY price DESC LIMIT 1;
17、找出书名中字数最多的一本书，不含空格
SELECT * FROM books ORDER BY CHAR_LENGTH(REPLACE(b_name,' ','')) DESC LIMIT 1;


