-- 以管理员方式运行cmd窗口
net start mysql80-- 打开数据库
net stop mysql80-- 关闭数据库

-- 一般cmd窗口
mysql -u root -p-- 进入数据库 密码：root
STATUS;-- 查看数据库信息
CREATE DATABASE mysql_2019;-- 创建数据库
DROP DATABASE mysql_2019;-- 删除数据库
SHOW DATABASES;-- 查看所有数据库
USE mysql_2019;-- 连接数据库


CREATE TABLE t_user2( -- 创建一个表
	id INT PRIMARY KEY AUTO_INCREMENT, -- primary key 表示这一列内容唯一标识（不能为空且不能拿重复） AUTO _INCREMENT:主键自增机制
	name VARCHAR(20) NOT NULL, -- not null 表示name这一列不能为空
	age INT,
	sex VARCHAR(3),
	email VARCHAR(50) UNIQUE-- unipue 表示这一列内容不能有重复
);
SHOW TABLES;-- 查看创建的表
DROP TABLE t_user2;-- 删除创建的表
ALTER TABLE t_user2 ADD address VARCHAR(100);-- 表中添加字段
ALTER table t_user2 MODIFY address VARCHAR(200);-- 修改表中字段类型
ALTER table t_user2 CHANGE address user_address VARCHAR(100);-- 修改表中字段名
ALTER TABLE t_user2 DROP user_address;-- 删除表中字段

DESC t_user2;-- 查看表结构
INSERT INTO t_user2(id,name,age,sex,email) VALUES(1,'zhangsan',22,'男','zhangsan@163.com');-- 插入一条数据
UPDATE t_user2 SET name='lisi' WHERE id = 1;-- 表的更新操作，更改指定id的属性值
DELETE FROM t_user2 WHERE id = 2;-- 删除id为2的数据
SELECT * FROM t_user2;-- 查看表内容


-- 测试非空约束（name不能为空）
INSERT INTO t_user2(id) VALUES(2);-- 插入一条数据
INSERT INTO t_user2(id,name) VALUES(2,NULL);-- 插入一条数据

-- 测试唯一约束（email不能重复）
INSERT INTO t_user2(id,name,email) VALUES(3,'c','zhangsan@163.com');-- 插入一条数据

-- 测试主键约束(id 不能为空且不能重复)
INSERT INTO t_user2(id,name) VALUES(1,'b');-- 插入一条数据
-- 测试主键自增机制（添加数据时不用添加主键约束属性的值）
INSERT INTO t_user2(name,age,sex,email) VALUES('ddd',22,'女','wangwuddd@163.com');-- 插入一条数据

-- 测试主外键约束(开发中不会建立外键约束：无法删除有外键约束相关联的表，一般只会在程序中做控制)
CREATE TABLE t_user( -- 创建一个表
	id INT PRIMARY KEY AUTO_INCREMENT, -- primary key 表示这一列内容唯一标识（不能为空且不能拿重复） AUTO _INCREMENT:主键自增机制
	name VARCHAR(20) NOT NULL-- not null 表示name这一列不能为空
);
INSERT INTO t_user(name) VALUES('zhangsan');-- 插入一条数据
INSERT INTO t_user(name) VALUES('lisi');-- 插入一条数据
INSERT INTO t_user(name) VALUES('wangwu');-- 插入一条数据
SELECT  * FROM t_user;-- 查看表t_user

CREATE TABLE t_order( -- 再创建一个表，添加外键约束
	id INT PRIMARY KEY AUTO_INCREMENT, -- primary key 表示这一列内容唯一标识（不能为空且不能拿重复） AUTO _INCREMENT:主键自增机制
	order_name VARCHAR(20) NOT NULL, -- not null 表示name这一列不能为空
	user_id int,
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES t_user (id)-- ***添加外键约束
);
INSERT INTO t_order(order_name,user_id) VALUES('订单一',1);-- 插入一条数据
INSERT INTO t_order(order_name,user_id) VALUES('订单二',2);-- 插入一条数据
INSERT INTO t_order(order_name,user_id) VALUES('订单四',4);-- 插入一条数据——————外键约束错误，不能添加：因为t_user表中没有id为4的记录
SELECT  * FROM t_order;-- 查看表t_order

DROP TABLE t_user;-- 删除表t_user
DROP TABLE t_order;-- 删除表t_order
SHOW TABLES;


-- 备份数据库（需要在DOS窗口中执行）
mysqldump -u root -p mysql_2019>C:\Users\刘浩\Desktop\mysql_2019.sql-- 备份整个数据库
mysqldump -u root -p mysql_2019 t_user t_order>C:\Users\刘浩\Desktop\mysql_2019_t_user.sql-- 备份数据库中的表

-- 恢复数据库（需进入到数据库中，才能执行操作）
source C:\Users\刘浩\Desktop\mysql_2019_t_user.sql-- 恢复指定路径下的.sql文件到当前所在的数据库中



