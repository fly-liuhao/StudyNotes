-- 查询EMP表中的向所有数据
SELECT *FROM EMP;

-- 显示表中部分字段（投影）
SELECT EMPNO,ENAME FROM EMP; 

--使用别名
SELECT e.EMPNO,e.ENAME,e.JOB FROM EMP e; 
-- 别名的另一种操作
SELECT
    e.EMPNO AS "员工编号",
    e.ENAME AS "员工姓名",
    e.JOB AS "员工职位" 
FROM EMP e; 

-- 去掉重复内容(DISTINCT)
SELECT DISTINCT e.JOB FROM EMP e; 

-- 连接显示，把多列合并成一列进行显示
SELECT CONCAT(e.EMPNO,e.ENAME) AS "员工信息" FROM EMP e; 

--限定查询
SELECT e.* FROM EMP e WHERE e.EMPNO = 7369;
SELECT e.* FROM EMP e WHERE e.SAL > 2000;
SELECT e.* FROM EMP e WHERE e.SAL >= 2000 AND e.SAL <= 3000;/*(查询工资在2500到3000范围内的员工信息)*/
-- Oracle专有查询(BETWEEN)
SELECT * FROM EMP WHERE SAL BETWEEN 2500 AND 3000;/*BETWEEN 最小值 AND 最大值*/
SELECT * FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;/*查询或者关系的信息(查询10部门或20部门的所有员工信息)*/
SELECT e.* FROM EMP e WHERE e.DEPTNO = 10 OR e.DEPTNO = 20;
-- 通过IN关键字  (IN意思是包含)
SELECT e.* FROM EMP e WHERE e.DEPTNO IN(10,20);
SELECT e.* FROM EMP e WHERE e.DEPTNO NOT IN(10,20);

-- 判断是否为空（IS NOT NULL：代表字段不为空    IS NULL：表示字段为空）
SELECT e.* FROM EMP e WHERE e.COMM IS NOT NULL;/*查询奖金为空的员工信息*/ 
SELECT e.* FROM EMP e WHERE e.COMM!=0;/*会过滤掉空值*/
SELECT e.* FROM EMP e WHERE e.COMM IS NULL;

-- 模糊查询(LIKE %代表匹配)
SELECT * FROM EMP e WHERE e.ENAME LIKE 'S%';/*查询员工姓名以S开头的所有员工信息*/
SELECT * FROM EMP e WHERE e.ENAME LIKE '%S%';/*查询员工姓名含S的所有员工信息*/
SELECT * FROM EMP e WHERE e.ENAME NOT LIKE '%S%';/*查询员工姓名不含S的所有员工信息*/

-- 排序（ORDER BY  ASC:升序 DESC:降序 默认升序排列）
SELECT e.* FROM EMP e ORDER BY e.SAL;/*查询所有员工信息，并且按照员工工资由低到高排列*/
SELECT e.* FROM EMP e ORDER BY e.SAL ASC;
SELECT e.* FROM EMP e ORDER BY e.SAL DESC;

-- 查询除了ALLEN 以外的所有员工
SELECT e.* FROM EMP e WHERE e.ENAME = 'ALLEN';
SELECT e.* FROM EMP e WHERE e.ENAME <> 'ALLEN';-- <>:不等于的效果



-- 多表查询
SELECT * FROM EMP;/*14条数据*/
SELECT * FROM DEPT;/*4条数据*/
SELECT * FROM EMP,DEPT;/*惊奇的有56条数据-----笛卡儿积效应（没有加关联字段）*/
SELECT e.* FROM EMP e,DEPT d WHERE e.DEPTNO = d.DEPTNO;/*添加关联字段，消除笛卡儿积*/
/*面试题：笛卡儿积产生的原因都是什么？*/
/*答：表之间没有添加关联字段*/ 
-- 查询所有员工，要求显示员工编号，员工姓名，部门编号，部门姓名
SELECT e.EMPNO, e.ENAME, d.DEPTNO,d.DNAME FROM EMP e, DEPT d WHERE e.DEPTNO = d.DEPTNO;


--连接查询 
SELECT e.EMPNO, e.ENAME, e.MGR, m.ENAME FROM EMP e, EMP m WHERE e.MGR = m.EMPNO; /*查询出每个员工的员工编号，员工姓名，领导编号，领导姓名*/
--第二种方式 左连接：以左表为主（全部展示）， 右链接：以右表为主（全部展示）（没有匹配到就显示null代替）
SELECT e.EMPNO, e.ENAME, e.MGR, m.ENAME FROM EMP e LEFT JOIN EMP m on (e.MGR = m.EMPNO);/*左连接*/
SELECT e.EMPNO, e.ENAME, e.MGR, m.ENAME FROM EMP e RIGHT JOIN EMP m on (e.MGR = m.EMPNO);/*右连接*/
SELECT e.EMPNO, e.ENAME, e.DEPTNO, d.DNAME FROM EMP e RIGHT JOIN DEPT d on (e.DEPTNO = d.DEPTNO);/*右连接: 查询出每个员工的员工编号，员工姓名，部门编号，部门姓名*/


-- 结果集的合并（UNION  UNION ALL）
/*
UNION:返回查询结果的全部内容，重复数据不显示
UNION ALL :返回查询结果的全部内容，重复内容也会显示
*/
SELECT * FROM DEPT
UNION
SELECT * FROM DEPT;

SELECT * FROM DEPT
UNION ALL 
SELECT * FROM DEPT;











