-- 创建学生表
CREATE TABLE student(
Sno VARCHAR2(20) PRIMARY KEY,
Sname VARCHAR2(20),
Ssex VARCHAR2(3),
Sage NUMBER,
Sdept VARCHAR(20)
);

-- 插入学生的数据
INSERT INTO student(Sno,Sname,Ssex,Sage,Sdept) VALUES('95001','李勇','男',20,'CS');
INSERT INTO student(Sno,Sname,Ssex,Sage,Sdept) VALUES('95002','刘晨','女',19,'IS');
INSERT INTO student(Sno,Sname,Ssex,Sage,Sdept) VALUES('95003','王敏','女',18,'MA');
INSERT INTO student(Sno,Sname,Ssex,Sage,Sdept) VALUES('95004','张立','男',19,'IS');
INSERT INTO student(Sno,Sname,Ssex,Sage,Sdept) VALUES('95005','欧阳锋','男',20,'MA');

-- 拆建课程表
CREATE TABLE Course(
Cno VARCHAR(20) PRIMARY KEY,
Cname VARCHAR(20),
Cpno VARCHAR(20),
Ccredit NUMBER
);
-- 插入数据
INSERT INTO Course(Cno,Cname,Cpno,Ccredit) VALUES('1','DB_Design','1001',3);

-- 创建学生选课表
CREATE TABLE sc(
Sno VARCHAR(20),
Cno VARCHAR(20),
Grade NUMBER
);
-- 插入数据
INSERT INTO sc(Sno,Cno,Grade) VALUES('95001','1',92);
INSERT INTO sc(Sno,Cno,Grade) VALUES('95001','2',85);
INSERT INTO sc(Sno,Cno,Grade) VALUES('95001','3',88);
INSERT INTO sc(Sno,Cno,Grade) VALUES('95002','2',90);
INSERT INTO sc(Sno,Cno,Grade) VALUES('95002','3',80);


-- 1.查询全体学生的学号与姓名
SELECT Sno,Sname FROM student;

-- 2.查询全体学生的姓名、学号、所在系
SELECT Sno,Sname,Sdept FROM student;

-- 3.查询全体学生的详细记录
SELECT * FROM student;

-- 4.查全体学生的姓名及其出生年份
SELECT Sname,TO_CHAR(SYSDATE-SAGE*365,'yyyy') FROM student;
SELECT Sname,TO_CHAR(ADD_MONTHS(SYSDATE,-SAGE*12),'yyyy') FROM student;

-- 5.查全体学生的姓名、出生年份和所在系
SELECT Sname,TO_CHAR(ADD_MONTHS(SYSDATE,-SAGE*12),'yyyy'),Sdept FROM student;

-- 6.查寻所有选修了课程的学生的学号
SELECT DISTINCT Sno FROM sc;

-- 7.查计算机系全体学生的名单
SELECT Sname FROM Student WHERE Sdept = 'CS';

-- 8.查所有年龄在20岁以下的学生姓名及其年龄
SELECT Sname,Sage FROM Student WHERE Sage < 20;

-- 9.查询考试成绩有不及格的学生的学号
SELECT Sno FROM sc WHERE  Grade < 100*0.9;

-- 10.查询年龄在20至23岁之间的学生的姓名、系别、和年龄
SELECT Sname,Sdept,Sage FROM student WHERE Sage>=20 AND Sage<=23;
SELECT Sname,Sdept,Sage FROM student WHERE Sage BETWEEN 20 AND 23;

-- 11.查询年龄不在20至23岁之间的学生姓名、系别和年龄
SELECT Sname,Sdept,Sage FROM student WHERE Sage>23 OR Sage<20;
SELECT Sname,Sdept,Sage FROM student WHERE Sage NOT BETWEEN 20 AND 23;

-- 12.查信息系（IS）、数学系（MA）和计算机科学系（CS）的学生的姓名和性别**************
--SELECT Sname,Ssex FROM student  GROUP BY Sdep;/*错误*/
SELECT Sname,Ssex FROM student WHERE Sdept = 'IS';
SELECT Sname,Ssex FROM student WHERE Sdept = 'MA';
SELECT Sname,Ssex FROM student WHERE Sdept = 'CS';

-- 13.查既不是信息系、数学系，也不是计算机科学系的学生的姓名和性别
SELECT Sname,Ssex FROM student WHERE Sdept NOT IN('IS','MA','CS');

-- 14.查所有姓刘的学生的姓名、学号和性别
SELECT Sname,Sno,Ssex FROM student WHERE Sname LIKE '刘%';

-- 15.查姓“欧阳”且全名为三个汉字的学生的姓名
SELECT Sname FROM student WHERE Sname LIKE '欧阳_';

-- 16.查名字中第二字为“阳”字的学生的姓名和学号
SELECT Sname,Sno FROM student WHERE Sname LIKE '_阳%';

-- 17.查所有不姓刘的学生姓名
SELECT Sname FROM student WHERE Sname NOT LIKE '刘%';

-- 18.查DB_Design课程的课程号和学分
SELECT Cno,Ccredit FROM Course WHERE Cname = 'DB_Design';
SELECT Cno,Ccredit FROM Course WHERE Cname LIKE 'DB\_Design' ESCAPE '\';

-- 19.查以“DB_”开头，且倒数第三个字符为i的课程的详细情况
SELECT * FROM Course WHERE Cname LIKE 'DB\_%i__' ESCAPE '\';

-- 10.查询一下缺少成绩的学生的学号和相应的课程号


-- 21.查询所有成绩记录的学生的学号和课程号


-- 22.查询CS系年龄在20岁以下的学生姓名
SELECT Sname FROM student WHERE Sdept = 'CS' AND Sage<20;

-- 23.查询选修了3号课程的学生的学号及其成绩，查询结果按分数的降序排列
SELECT Sno,Grade FROM sc WHERE Cno = '3' ORDER BY Grade DESC;











