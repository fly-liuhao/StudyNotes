/***********************************DML语句***************************************************/
-- DML语句：INSERT，UPDATE，DELETE

-- 1. INSERT INTO
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


-- 2. UPDATE
UPDATE emp SET sal=2560 WHERE ename='SCOTT';
UPDATE emp SET sal=sal*1.5,comm=sal*0.1 WHERE deptno=20;
UPDATE emp SET hiredate=TO_DATE('2007-12-25','yyyy-mm-dd') WHERE empno=7788;

UPDATE emp SET (job,sal,comm)=(SELECT job,sal,comm FROM emp WHERE ename='SMITH') WHERE ename='SCOTT';
UPDATE employee SET deptno=(SELECT deptno FROM emp WHERE empno=7788) WHERE job=(SELECT job FROM emp WHERE empno=7788); --基于一张表修改另一张表

COMMIT;--提交事务


-- 3. DELETE
DELETE FROM emp WHERE ename='SMITH'; --FROM可以省略
DELETE FROM emp;
DELETE FROM emp WHERE deptno=(SELECT deptno FROM dept WHERE dname='SALES');-- DELETE中使用子查询

COMMIT;--提交事务

/***********************************事务***************************************************/
--提交事务 COMMIT;(DML语句之后要提交事务 内存->硬盘)
--回滚或回退事务 ROLLBACK;

UPDATE account SET balance=balance-100 WHERE account='A';
UPDATE account SET balance=banlance+100 WHERE account='B';--执行失败，最终结果呢？

UPDATE account SET balance=balance-100 WHERE account='A';
UPDATE account SET balance=banlance+100 WHERE account='B';--执行失败，最终结果呢？
ROLLBACK;--回滚事务，回退事务，撤销第一个句子的结果

















