## Oracle第三讲 DDL语句(Data Definition Language —— 数据定义语言:操作表结构)
#### 如何创建数据库
``` SQL
CREAT DATABASE student;
```
#### 如何删除数据库
``` SQL
DROP DATABASE student;
```
#### 如何创建表
```SQL
CREATE TABLE T_STUDENT(
    stu_id VARCHAR2(20),
    stu_name VARCHAR2(20),
    sex VARCHAR2(2),
    birthday DATE,
    score NUMBER，
    mobile VARCHAR2(11)，
    stu_class_id VARCHAR2(10)
);
```
#### 什么是约束?[（点击）](https://www.cnblogs.com/willingtolove/p/9215330.html)
- 列级约束：包含在列定义中，是对某一个特定列的约束，直接跟在列的其它定义之后，用空格分开，不必指定列名
	- 主键、外键、唯一、检查、<u>**缺省、非空**</u>
- 表级约束：与列定义相互独立，不包含在列定义中（通常用于对多个列一起进行约束，必须指出要约束列 的名称）
    - 主键、外键、唯一、检查
1. 主键约束（PRIMARY KEY）：非空且唯一
3. 唯一约束（UNIQUE）：不可重复，可以为空(为空的可重复)
4. 检查约束（CHECK）：对该列数据的范围、格式的限制（如：年龄、性别等）
2. 外键约束（FOREIGN KEY）：需要建立两表间的关系并引用主表的列
5. 非空约束（NOT NULL）：数据不能为空
6. 默认/缺省约束（DEFAULT）:该数据的默认值

```SQL
/*行内约束*/
CREATE TABLE T_STUDENT(
    stu_id VARCHAR2(20) PRIMARY KEY,/*主键约束*/
    stu_name VARCHAR2(20) NOT NULL,/*非空约束*/
    sex VARCHAR2(2) DEFAULT ('男'),/*默认/缺省约束*/
    birthday DATE NOT NULL,/*非空约束*/
    score NUMBER NOT NULL CHECK(core >= 2.0 AND core <= 4.0),/*检查约束*/
    mobile VARCHAR2(11) UNIQUE,/*唯一约束*/
    stu_class_id VARCHAR2(10) REFERENCES T_Class(class_id)/*外键约束*/
);
```
```SQL
/*行外约束*/
CREATE TABLE T_STUDENT(
    stu_id VARCHAR2(20),
    stu_name VARCHAR2(20) NOT NULL,/*非空约束*/
    sex VARCHAR2(2) DEFAULT ('男'),/*默认/缺省约束*/
    birthday DATE NOT NULL,
    score NUMBER NOT NULL,
    mobile VARCHAR2(11),
    stu_class_id VARCHAR2(10),

    CONSTRAINT PK_STUDENT PRIMARY KEY (stu_id),/*主键约束*/
    CONSTRAINT check_score CHECK (score >= 2.0 AND score <= 4.0),/*检查约束*/
    CONSTRAINT unique_mobile UNIQUE (mobile),/*唯一约束*/
    CONSTRAINT FK_STUDENT FOREIGN KEY (stu_class_id) REFERENCES T_Class(class_id)/*外键约束*/
);
```
```SQL
/*增加约束(在表建立后)*/
ALTER TABLE  T_STUDENT ADD CONSTRAINT FK_STUDENT FOREIGN KEY(stu_class_id ) REFERENCES T_Class(class_id);
```
```SQL
/*禁用或启用约束*/
ALTER TABLE 表名  DISABLE|ENABLE  CONSTRAINT 约束名;

ALTER TABLE T_STUDENT DISABLE CONSTRAINT FK_STUDENT;--禁用约束
ALTER TABLE T_STUDENT ENABLE CONSTRAINT FK_STUDENT;--启用约束

```
#### 如何删除表
```SQL
DROP TABLE t_user;/*连表和数据全部删除*/
TRUNCATE TABLE t_user;/*保留表结构，数据全删除，不可回退*/
```

#### 如何修改表（表结构）
```SQL
DESC T_USER; /*显示表结构*/
RENAME T_USER TO T_USER2;/*修改表名-第二种方式*/
ALTER TABLE T_USER2 RENAME TO T_USER;/*修改表名-第二种方式*/

ALTER TABLE T_USER ADD mobile VARCHAR2(11);/*添加字段*/
ALTER TABLE T_USER DROP COLUMN mobile;/*删除字段*/
ALTER TABLE T_USER MODIFY userid VARCHAR(20);/*修改字段类型*/
ALTER TABLE T_USER RENAME COLUMN userid TO user_id;/*修改字段名*/
```

#### 如何修改表内容
```SQL
INSERT INTO T_USER VALUES (1,'zhangsan',22,'男','zhangsan@163.com');-- 默认插入(按照定义顺序依次填写)
INSERT INTO T_USER(id,name,age,sex,email) VALUES (1,'zhangsan',22,'男','zhangsan@163.com');-- 通过给定字段传入
UPDATE T_USER SET name='lisi' WHERE id = 1;-- 表的更新操作，更改指定id的属性值
DELETE FROM T_USER WHERE id = 1;-- 删除id为1的数据
SELECT * FROM T_USER;-- 查看表内容
```
#### 提交数据
```SQL
COMMIT;-- 向数据库提交(INSERT INTO 后要使用COMMIT提交事务，否则数据不会被提交到表里面去)
```

#### 获取
1. 获取表：
```SQL
select table_name from user_tables; /*当前用户的表*/
select table_name from all_tables; /*所有用户的表*/
select table_name from dba_tables; /*包括系统表*/
```
2. 获取表字段：
```SQL
select * from user_tab_columns where Table_Name='用户表';
select * from all_tab_columns where Table_Name='用户表';
```
3. 获取表注释：
```SQL
select * from user_tab_comments;
```
4. 获取字段注释
```SQL
select * from user_col_comments;
```









