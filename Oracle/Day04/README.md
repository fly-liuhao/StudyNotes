## Oracle第4讲 DQL(数据库查询语言)
 - SQL92、SQL99标准
 - DQL:Data Query Language----数据查询语言
 - SQL:Structured Query Language---结构化查询语言

#### 查询表内容
```SQL
SELECT * FROM classes;-- 查询表所有列（FROM比SELECT先执行）
SELECT class_id FROM classes;-- 查询部分列（投影）
```
面试题：SELECT 和 FROM 谁先执行？（FROM）
#### 使用别名(字段名、表名)
字段名和表名+空格+别名,也可使用AS
```SQL
/*表的别名*/
SELECT  c.class_id,c.class_name FROM classes c;-- 表后直接跟上别名
/*字段的别名*/
SELECT class_id 学生编号, class_name 学生姓名 FROM classes;-- 直接在字段后面加别名
SELECT class_id "学生编号", class_name "学生姓名" FROM classes;-- 别名使用双引号
SELECT class_id AS 学生编号, class_name AS 学生姓名 FROM classes;-- AS 加 别名
SELECT class_id AS "学生编号", class_name AS "学生姓名" FROM classes;-- AS + 引号别名
```

#### 去掉重复行（DISTINCT）
重复：指定的字段要完全相同
```SQL
-- 去除班级名相同的数据并进行显示
SELECT DISTINCT class_name FROM classes;
-- 去除班级名和编号都相同的数据并进行显示
SELECT DISTINCT class_name,class_id FROM classes;
```

#### 连接字段(||或者CONCAT)

```SQL
-- 将学生班级编号和班级名在一列中进行显示
SELECT  class_id||class_name FROM classes;-- 使用“||”
SELECT CONCAT(class_id,class_name) AS "班级信息" FROM classes; -- 使用“CONCAT”
```

#### 排序(ORDER BY)
```SQL
-- 根据班级编号大小进行排序
SELECT  class_id,class_name FROM classes ORDER BY class_id;-- 默认升序
SELECT  class_id,class_name FROM classes ORDER BY class_id ASC;-- 升序(ASC)
SELECT  class_id,class_name FROM classes ORDER BY class_id DESC;-- 降序(DESC)
SELECT  class_id AS cid,class_name FROM classes ORDER BY cid DESC;-- 利用字段别名排序
```
#### 限定查询(WHERE)
1. 比较运算符 =， >，<，<>，>=，<=，!=
```SQL
SELECT * FROM student WHERE sex = '女';
SELECT * FROM student WHERE sex != '女';
SELECT * FROM student WHERE score >= 3.0 ;
SELECT * FROM student WHERE score <= 3.0 ;
SELECT * FROM student WHERE stu_class_id != '10';
-- 查询班号不为"10"的学生信息(<>相当于!=)
SELECT * FROM student WHERE stu_class_id <> '10';
```
2. AND
```SQL
-- 查询学分大于3.0的女学生的信息
SELECT * FROM student WHERE score>3.0 AND sex = '女';
```
3. OR
```SQL
-- 查询班号为"10"或者班号为"30"的学生信息
SELECT * FROM student WHERE stu_class_id = '10' OR stu_class_id = '30';
-- 查询班号为"10"的男学生信息或者学分大于3.0的学生信息
SELECT * FROM student WHERE score>3.0 OR Sex = '男' AND stu_class_id = '10';/*AND优先级比OR高*/
```
4. IN
```SQL
--查询班号是"10"、"20"的学生信息。
SELECT * FROM student WHERE stu_class_id IN('10','30');
--查询班号不是"10"、"20"的学生信息。
SELECT * FROM student WHERE stu_class_id NOT IN('10','30');
```
5. BETWEEN AND(含边界值)
```SQL
-- 查询学分在2.5~3.5之中的学生信息
SELECT * FROM student WHERE score BETWEEN 2.5 AND 3.5;
-- 查询学分不在2.5~3.5之中的学生信息
SELECT * FROM student WHERE Score NOT BETWEEN 2.5 AND 3.5;
```
6. IS NULL
```SQL
-- 查询电话非空的学生信息
SELECT * FROM student WHERE mobile IS NULL;
-- 查询出生日期不为空的学生信息
SELECT * FROM student WHERE birthday IS NOT NULL;
```

6. LIKE(模糊查询)
```SQL
/*LIKE*/
-- 查询所有姓"孙"的学生信息
SELECT * FROM student WHERE stu_name LIKE '孙%';
-- 查询所有名字中含有"辉"的学生信息
SELECT * FROM student WHERE stu_name LIKE '%辉%';
-- 查询所有名字以"五"结尾的学生信息
SELECT * FROM student WHERE stu_name LIKE '%五';
-- 查询所有名字中含有"辉"且前后各只有一个字符的学生信息（"_"：表示单个字符）
SELECT * FROM student WHERE stu_name LIKE '_辉_';
-- 查询所有手机号不为空的学生信息
SELECT * FROM student WHERE mobile LIKE '%%';--任意值（非空）
-- 查询所有名字中含有"_"的学生信息(ESCAPE：自定义转义字符)
SELECT * FROM student WHERE stu_name LIKE '%\_%' ESCAPE '\';
/*NOT LIKE*/
--查询所有不是姓"张"的学生信息
SELECT * FROM student WHERE stu_name NOT LIKE '张%';
```
面试题：
```SQL
-- 表 book（bookname，pub）以下两个SQL语句有何区别？
SELECT * FROM book;
SELECT * FROM book WHERE bookname LIKE '%%' AND pub LIKE '%%'
/*
    1.通过第一种方式会查询所有数据
    2.通过第二种方式查询，结果中不包含空的数据
*/
CREATE TABLE book(
    bookname VARCHAR2(20),
    pub VARCHAR(20)
);
INSERT INTO book VAlUES('操作系统','');-- pub为空
INSERT INTO book VAlUES('编译原理','');
INSERT INTO book VAlUES('','电子工业出版社');-- bookname为空
INSERT INTO book VAlUES('','人民邮电出版社');
INSERT INTO book VAlUES('软件工程','清华大学出版社');--都不为空
INSERT INTO book VAlUES('Java程序设计','东南大学出版社');
SELECT * FROM book;
SELECT * FROM book WHERE bookname LIKE '%%' AND pub LIKE '%%';
```

