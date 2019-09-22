-- 创建院系表
CREATE TABLE T_DEPATMENT(
    dept_id VARCHAR2(10) PRIMARY KEY,
    dept_name VARCHAR(20) NOT NULL UNIQUE
);

-- 创建专业表
CREATE TABLE T_MAJOR(
    major_id VARCHAR2(10) PRIMARY KEY,
    major_name VARCHAR2(20) NOT NULL UNIQUE,
    major_dept_id VARCHAR2(10),
    CONSTRAINT FK_Major FOREIGN KEY (major_dept_id) REFERENCES T_DEPATMENT(dept_id)
);

-- 创建班级表
CREATE TABLE T_CLASS(
    class_id VARCHAR2(10) PRIMARY KEY,
    class_name VARCHAR2(20) NOT NULL UNIQUE,
    class_major_id VARCHAR(20),
    CONSTRAINT FK_CLASS FOREIGN KEY (class_major_id) REFERENCES T_MAJOR(major_id)
);

-- 创建学生表
CREATE TABLE T_STUDENT(
    stu_id VARCHAR2(20) PRIMARY KEY,
    stu_name VARCHAR2(20) NOT NULL,
    sex VARCHAR2(2),
    birthday DATE NOT NULL,
    score NUMBER NOT NULL CHECK(score >= 2.0 AND score <= 4.0),
    mobile VARCHAR2(11) UNIQUE,
    stu_class_id VARCHAR2(10),
    CONSTRAINT FK_STUDENT FOREIGN KEY (stu_class_id) REFERENCES T_Class(class_id)
);

-- 创建教师表
CREATE TABLE T_TEACHER(
    teacher_id VARCHAR2(10) PRIMARY KEY,
    teacher_name VARCHAR2(20) NOT NULL,
    teacher_dept_id VARCHAR(20),
    CONSTRAINT FK_TEACHER FOREIGN KEY (teacher_dept_id) REFERENCES T_DEPATMENT(dept_id)
);

-- 创建课程表
CREATE TABLE T_COURSE(
    course_id VARCHAR2(10) PRIMARY KEY,
    course_name VARCHAR2(20) NOT NULL UNIQUE,
    course_credit NUMBER NOT NULL,
    course_teacher_id VARCHAR2(20),
    CONSTRAINT FK_COURSE FOREIGN KEY (course_teacher_id) REFERENCES T_TEACHER(teacher_id)
);

-- 创建学生-课程表
CREATE TABLE T_STUDENT_COURSE(
    sc_stu_id VARCHAR2(10),
    sc_course_id VARCHAR2(10),
    CONSTRAINT PK_STUDENT_COURSE PRIMARY KEY  (sc_stu_id,sc_course_id),
    CONSTRAINT FK_STUDENT_COURSE_C_STUDENT FOREIGN KEY (sc_stu_id) REFERENCES T_STUDENT(stu_id),
    CONSTRAINT FK_STUDENT_COURSE_C_COURSE FOREIGN KEY (sc_course_id) REFERENCES T_COURSE(course_id)
);

INSERT INTO T_DEPATMENT(dept_id,dept_name) VALUES('01','机械工程系');-- 插入一条数据
INSERT INTO T_DEPATMENT(dept_id,dept_name) VALUES('02','电子工程系');
INSERT INTO T_DEPATMENT(dept_id,dept_name) VALUES('03','自动化系');
INSERT INTO T_DEPATMENT(dept_id,dept_name) VALUES('04','化学与化工系');
INSERT INTO T_DEPATMENT(dept_id,dept_name) VALUES('05','计算机工程系');

INSERT INTO T_MAJOR(major_id,major_name,major_dept_id) VALUES('001','计算机科学与技术','05');
INSERT INTO T_MAJOR(major_id,major_name,major_dept_id) VALUES('002','软件工程','05');
INSERT INTO T_MAJOR(major_id,major_name,major_dept_id) VALUES('003','网络工程','05');
INSERT INTO T_MAJOR(major_id,major_name,major_dept_id) VALUES('004','数字媒体技术','05');

INSERT INTO T_CLASS(class_id,class_name,class_major_id) VALUES('0001','软工一','002');
INSERT INTO T_CLASS(class_id,class_name,class_major_id) VALUES('0002','软工二','002');
INSERT INTO T_CLASS(class_id,class_name,class_major_id) VALUES('0003','计科一','001');
INSERT INTO T_CLASS(class_id,class_name,class_major_id) VALUES('0004','数媒一','004');

INSERT INTO T_STUDENT(stu_id,stu_name,sex,birthday,score,mobile,stu_class_id) VALUES('000024','刘浩','男',to_date('19980105','yyyymmdd'),3.27,'15364925795','0002');
INSERT INTO T_STUDENT(stu_id,stu_name,sex,birthday,score,mobile,stu_class_id) VALUES('000025','任云康','男',to_date('1998-05-25','yyyy-mm-dd'),3.69,'15135451575','0003');

SELECT * FROM T_DEPATMENT;-- 查看表内容
SELECT * FROM T_MAJOR;
SELECT * FROM T_CLASS;
SELECT * FROM T_STUDENT;


-- 验证唯一约束是否可以为空，空数据数是否只能有一个（可以多个)
CREATE TABLE T_USER(
    userid NUMBER PRIMARY KEY,
    username VARCHAR2(20) NOT NULL,
    userOrderid NUMBER UNIQUE,
    usersex VARCHAR2(2)
);
INSERT INTO T_USER(userid,username,userOrderid,usersex) VALUES(1,'张三',1001,'男');
INSERT INTO T_USER(userid,username,userOrderid,usersex) VALUES(2,'李四',null,'男');
INSERT INTO T_USER(userid,username,userOrderid,usersex) VALUES(3,'王五',null,'女');
SELECT * FROM T_USER;

-- 验证外键约束
CREATE TABLE T_USER2(
    userid NUMBER PRIMARY KEY,
    username VARCHAR2(20) NOT NULL,
    userOrderid NUMBER UNIQUE,
    usersex VARCHAR2(2) DEFAULT ('男'),
    u2ID NUMBER REFERENCES T_USER(userid)
);
INSERT INTO T_USER2(userid,username，u2ID) VALUES(1,'张三',1);
INSERT INTO T_USER2(userid,username，u2ID) VALUES(2,'李四',3);
SELECT * FROM T_USER2;

-- 删除表
DROP TABLE T_USER;
DROP TABLE T_USER2;

-- 修改表结构
DESC T_USER; /*显示表结构*/
RENAME T_USER TO T_USER2;/*修改表名-第二种方式*/
ALTER TABLE T_USER2 RENAME TO T_USER;/*修改表名-第二种方式*/
ALTER TABLE T_USER MODIFY userid VARCHAR(20);/*修改字段类型*/
ALTER TABLE T_USER RENAME COLUMN userid TO user_id;/*修改字段名*/
ALTER TABLE T_USER ADD homemobile VARCHAR2(11);/*添加字段*/
ALTER TABLE T_USER DROP COLUMN homemobile;/*删除字段*/

-- 修改表内容
CREATE TABLE T_USER( 
	id NUMBER PRIMARY KEY,
	name VARCHAR2(20) NOT NULL,
	age NUMBER,
	sex VARCHAR2(3),
	email VARCHAR2(50) UNIQUE
);
INSERT INTO T_USER(id,name,age,sex,email) VALUES(1,'zhangsan',22,'男','zhangsan@163.com');-- 插入一条数据
UPDATE T_USER SET name='lisi' WHERE id = 1;-- 表的更新操作，更改指定id的属性值
DELETE FROM T_USER WHERE id = 1;-- 删除id为1的数据
SELECT * FROM T_USER;-- 查看表内容

-- 获取表：
select table_name from user_tables; /*当前用户的表*/     
select table_name from all_tables; /*所有用户的表*/   
select table_name from dba_tables; /*包括系统表*/ 
-- 获取表字段： 
select * from user_tab_columns where Table_Name='用户表'; 
select * from all_tab_columns where Table_Name='用户表'; 
-- 获取表注释： 
select * from user_tab_comments;
-- 获取字段注释
select * from user_col_comments;


DROP TABLE T_STUDENT;
