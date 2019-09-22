#### 一、DML语言
DML：数据操作语言，操作目标：表中的数据
包含：INSERT,UPDATE,DELETE
1. INSERT INTO
```SQL
INSERT INTO dept VALUES(20,’K’,’L’); -- 给所有字段设置值
INSERT INTO dept(deptno,dname) VALUES(20,’K’); --设置指定字段值
INSERT INTO dept VALUES(60,’MARKET’,DEFAULT); -- 使用默认值
INSERT INTO employee (empno,ename,sal,deptno) SELECT empno,ename,sal,deptno FROM emp WHERE deptno=20; -- 在INSERT中使用子查询
-- 使用多表插入数据（不常用）
INSERT ALL
WHEN deptno=10 THEN INTO dept10
WHEN deptno=20 THEN INTO dept20
WHEN deptno=30 THEN INTO dept30
WHEN job='CLERK' THEN INTO clerk
ELSE INTO other
SELECT * FROM emp;
COMMIT;--提交事务
```
2. UPDATE
```SQL
UPDATE emp SET sal=2560 WHERE ename='SCOTT';
UPDATE emp SET sal=sal*1.5,comm=sal*0.1 WHERE deptno=20;
UPDATE emp SET hiredate=TO_DATE('2007-12-25','yyyy-mm-dd') WHERE empno=7788;
UPDATE emp SET (job,sal,comm)=(SELECT job,sal,comm FROM emp WHERE ename='SMITH') WHERE ename='SCOTT';
UPDATE employee SET deptno=(SELECT deptno FROM emp WHERE empno=7788) WHERE job=(SELECT job FROM emp WHERE empno=7788); --基于一张表修改另一张表
COMMIT;--提交事务
```
3. DELETE
```SQL
DELETE FROM emp WHERE ename='SMITH'; --FROM可以省略
DELETE FROM emp;
DELETE FROM emp WHERE deptno=(SELECT deptno FROM dept WHERE dname='SALES');-- DELETE中使用子查询
COMMIT;--提交事务
```

#### 二、事务 Transaction（面试重点）
1. 事务使用场景
银行转账。从A账户向B账户转账100元，将会执行几个SQL语句？
如果其中一个SQL语句执行失败，最终结果会如何？
```SQL
UPDATE account SET balance=balance-100 WHERE account='A';
UPDATE account SET balance=banlance+100 WHERE account='B';--执行失败，最终结果呢？
```
```SQL
UPDATE account SET balance=balance-100 WHERE account='A';
UPDATE account SET balance=banlance+100 WHERE account='B';--执行失败
ROLLBACK;--回滚事务，回退事务，撤销第一个句子的结果
```
2. 事务是什么？
事务（Transaction）就是一组SQL语句，这组SQL语句是一个逻辑工作单元，也可以认为事务是一组不可分
割的SQL语句。全部SQL执行成功，提交事务；只要其中一个SQL语句执行失败，回退事务，就可认为“这件事情没做”
```SQL
--提交事务 COMMIT；
--回滚或回退事务 ROLLBACK;
```
3. 事务属性有哪些？ 4个
    - 原子性（Atomicity）：事务中的所有SQL语句的执行是不可分割的
    - 一致性（Consistency）：确保数据库的状态是一致的，事务开始时，数据库的状态是一致的；在事务结束时候，数据库的状态也是一致的
    - 隔离性（Isolation）：多个事务可以独立运行，彼此不产生影响
    - 持久性： （Durability）：一旦事务提交，数据库的变化就会永久地保留下来

#### 三、索引 INDEX
[参考链接](https://www.cnblogs.com/wishyouhappy/p/3681771.html)

#### 四、序列
[参考连接](https://www.cnblogs.com/rootq/articles/1089392.html)
1. nextval 写一个序列值
2. currval 序列当前值

#### 五、虚表 dual（常量查询）