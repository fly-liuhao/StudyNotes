-- 创建班级表
CREATE TABLE classes(
    class_id VARCHAR2(10) PRIMARY KEY,
    class_name VARCHAR2(20) 
);
-- 插入数据:INSERT INTO 表名(字段名1,字段名2,...) VALUES(值1,值2,...);
INSERT INTO classes VALUES ('10','软工一班');-- 默认插入(按照定义顺序依次填写)
INSERT INTO classes VALUES ('20','软工二班');
INSERT INTO classes VALUES ('30','网工一班');
INSERT INTO classes (class_id,class_name) VALUES ('40','网工二班');-- 通过给定字段传入
INSERT INTO classes (class_id,class_name) VALUES ('50','数媒一班');
INSERT INTO classes (class_id,class_name) VALUES ('60','软工一班');
-- 提交数据
COMMIT;-- 向数据库提交

-- 查询表内容 
SELECT * FROM classes;-- 查询表所有列（FROM比SELECT先执行）
SELECT class_id FROM classes;-- 查询部分列（投影）

-- 别名
/*表的别名*/
SELECT  c.class_id,c.class_name FROM classes c;-- 表后直接跟上别名
/*字段的别名*/
SELECT class_id 学生编号, class_name 学生姓名 FROM classes;-- 直接在字段后面加别名
SELECT class_id "学生编号", class_name "学生姓名" FROM classes;-- 别名使用双引号
SELECT class_id AS 学生编号, class_name AS 学生姓名 FROM classes;-- AS 加 别名
SELECT class_id AS "学生编号", class_name AS "学生姓名" FROM classes;-- AS + 引号别名

-- 去掉查询结果中某字段重复行 
SELECT DISTINCT class_name FROM classes;
SELECT DISTINCT class_name,class_id FROM classes;

-- 连接字段(||或者CONCAT)
SELECT  class_id||class_name FROM classes;-- 使用“||”
SELECT CONCAT(class_id,class_name) AS "班级信息" FROM classes; -- 使用“CONCAT”

-- 排序(默认升序)
SELECT  class_id,class_name FROM classes ORDER BY class_id;-- 默认升序
SELECT  class_id,class_name FROM classes ORDER BY class_id ASC;-- 升序(ASC)
SELECT  class_id,class_name FROM classes ORDER BY class_id DESC;-- 降序(DESC)
SELECT  class_id AS cid,class_name FROM classes ORDER BY cid DESC;-- 利用字段别名排序


-- 创建学生表
CREATE TABLE student(
    stu_id VARCHAR2(20) PRIMARY KEY,
    stu_name VARCHAR2(20) ,
    sex VARCHAR2(2),
    birthday DATE ,
    score NUMBER ,
    mobile VARCHAR2(11),
    stu_class_id VARCHAR2(10),
    CONSTRAINT FK_STUDENTS FOREIGN KEY (stu_class_id) REFERENCES CLASSES(class_id)
);
INSERT INTO student (stu_class_id,Stu_Id, stu_name, sex, birthday, score, mobile) VALUES ('10','2001', '张三', '男', TO_DATE('2001-04-01 12:07:56', 'YYYY-MM-DD HH24:MI:SS'), '3.23', '13587569541');
INSERT INTO student (stu_class_id,stu_id, stu_name, sex, birthday, score, mobile) VALUES ('10','2002', '李四', '男', TO_DATE('1998-12-24 12:08:22', 'YYYY-MM-DD HH24:MI:SS'), '2.14', null);
INSERT INTO student (stu_class_id,stu_id, Stu_Name, Sex, Birthday, Score, Mobile) VALUES ('20','2003', '王五', '女', TO_DATE('1999-03-12 12:09:22', 'YYYY-MM-DD HH24:MI:SS'), '2.62', '12345678910');
INSERT INTO student (stu_class_id,stu_id, stu_name, sex, birthday, score, mobile) VALUES ('30','2004', '赵六', '男', TO_DATE('1999-06-04 12:09:26', 'YYYY-MM-DD HH24:MI:SS'), '3.47', 'null');
INSERT INTO student (stu_class_id,stu_id, stu_name, sex, birthday, score, mobile) VALUES ('40','2005', '孙_七', '女', TO_DATE('2000-09-04 12:09:26', 'YYYY-MM-DD HH24:MI:SS'), '3.77', '14856987645');
INSERT INTO student (stu_class_id,stu_id, stu_name, sex, birthday, score, mobile) VALUES ('50','2006', '周辉涛', '男', null, '3.77', 14852658458);

--限定查询
/* =， >，<，<>，>=，<=，!= */
SELECT * FROM student WHERE sex = '女';
SELECT * FROM student WHERE sex != '女';
SELECT * FROM student WHERE score >= 3.0 ;
SELECT * FROM student WHERE score <= 3.0 ;
SELECT * FROM student WHERE stu_class_id != '10';
SELECT * FROM student WHERE stu_class_id <> '10';-- 班号不为10的学生（<>相当于!=）
/*AND*/
SELECT * FROM student WHERE SCORE>3.0 AND SEX = '女';-- 学分大于3.0，性别是女的学生
/*OR*/
SELECT * FROM student WHERE stu_class_id = '10' OR stu_class_id = '30';-- 班级为10或者为30的学生
SELECT * FROM student WHERE SCORE>3.0 OR SEX = '男' AND stu_class_id = '10';/*AND优先级比OR高*/
/*IN*/
SELECT * FROM student WHERE stu_class_id IN('10','30');-- 班号是10或者20的学生
/*NOT IN*/
SELECT * FROM student WHERE stu_class_id NOT IN('10','30');-- 班号不是10或者20的学生
/*BETTON AND*/--(包含边界值)
SELECT * FROM student WHERE score BETWEEN 2.5 AND 3.5;-- 学分在2.5~3.5之中的学生
/*NOT BETTON AND*/
SELECT * FROM student WHERE Score NOT BETWEEN 2.5 AND 3.5;-- 学分不在2.5~3.5之中的学生
/*IS NULL*/
SELECT * FROM student WHERE mobile IS NULL;-- 电话非空的的学生
/*IS NOT NULL*/
SELECT * FROM student WHERE birthday IS NOT NULL;-- 出生日期不为空的学生
/*LIKE(模糊查询)*/
SELECT * FROM student WHERE stu_name LIKE '孙%';-- 名字以孙字打头的学生
SELECT * FROM student WHERE stu_name LIKE '%辉%';-- 名字含有辉字的学生
SELECT * FROM student WHERE stu_name LIKE '%五';-- 名字以五结尾的学生
SELECT * FROM student WHERE stu_name LIKE '_辉_';-- 名字中含辉，且前后各一个字符的学生（"_"：表示单个字符）
SELECT * FROM student WHERE stu_name LIKE '%%';--名字为任意值的学生（非空）
SELECT * FROM student WHERE stu_name LIKE '%\_%' ESCAPE '\';-- 名字含有“_”的学生（含有特殊字符，使用ESCAPE自定义转义字符）
/*NOT LIKE*/
SELECT * FROM student WHERE stu_name NOT LIKE '张%';-- 名字不以张打头的学生

-- 面试题：模糊查找LIKE '%%' 和直接查询的区别
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





