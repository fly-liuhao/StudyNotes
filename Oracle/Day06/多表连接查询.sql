-- 1.from 表1，表2 返回所有满足where条件的行
SELECT a.empno AS 员工编号, a.ename AS 员工名称, b.dname as 部门 FROM emp a, dept b WHERE a.deptno = b.deptno;
-- 2.inner join 内链接
SELECT a.empno As 员工编号, a.ename AS 员工名称, b.dname as 部门 FROM emp a JOIN dept b ON a.deptno = b.deptno ; 
-- 3.left outer join 查询结果除了返回包含连接条件的行，还包含左表（a）中不满足连接条件的行，其中不满足连接条件的行中b表的字段值将被置为空
SELECT a.empno As 员工编号, a.ename AS 员工名称, b.dname as 部门 FROM emp a LEFT OUTER JOIN dept b ON a.deptno = b.deptno;
-- 4.right outer join 查询结果除了返回包含连接条件的行，还包含右表（b）中不满足连接条件的行，其中不满足连接条件的行中a表的字段值将被置为空。
SELECT a.empno As 员工编号, a.ename AS 员工名称, b.dname as 部门 FROM emp a RIGHT OUTER JOIN dept b ON a.deptno = b.deptno;
-- 5.full outer join
SELECT a.empno As 员工编号, a.ename AS 员工名称, b.dname as 部门 FROM emp a FULL OUTER JOIN dept b ON a.deptno = b.deptno;
-- 6.cross  join
/***********************************多表查询***************************************************/
-- 一、内链接
-- <1.等值连接>
-- 显示学生学号、姓名和班级名称
-- 1.旧写法from 表1，表2 返回所有满足where条件的行
SELECT stu_id ,stu_name,class_name FROM t_student a,t_class b WHERE a.STU_CLASS_ID = B.CLASS_ID; 
-- 2.新写法 INNER JOIN ...ON (条件)；
SELECT stu_id ,stu_name,class_name FROM t_student a INNER JOIN t_class b ON A.STU_CLASS_ID = b.CLASS_ID; 
-- 显示学生学号、姓名和班级名称、班号（指明表名）
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a INNER JOIN t_class b ON A.STU_CLASS_ID = b.CLASS_ID; 
-- 显示学分绩点大于1.9的学生学号、姓名和班级名称（多条件查询）
SELECT stu_id ,stu_name,class_name FROM t_student a INNER JOIN t_class b ON A.STU_CLASS_ID = b.CLASS_ID AND a.SCORE>1.9;
-- 显示学分绩点在1.9到2.2之间的学生学号、姓名和班级名称（多条件查询）
SELECT stu_id ,stu_name,class_name FROM t_student a INNER JOIN t_class b ON A.STU_CLASS_ID = b.CLASS_ID AND SCORE BETWEEN  1.9  AND 2.2;

-- <2.非等值连接>
SELECT * FROM emp;
SELECT * FROM salgrade;
SELECT e.ename,e.sal,s.grade FROM emp e, salgrade s WHERE e.sal BETWEEN s.losal AND s.hisal;

-- <3.自连接>（用一个表中）
-- 显示员工姓名以及上级领导姓名
SELECT * FROM emp;
SELECT w.ename, m.ename FROM emp w, emp m WHERE w.mgr = m.empno;

-- <4.自然连接>
-- 自然连接(Natural join)是一种特殊的等值连接，它要求两个关系中进行比较的分量必须是相同的属性组，并且在结果中把重复的属性列去掉，而等值连接并不去掉重复的属性列。
CREATE TABLE R(
 A NUMBER,
 B VARCHAR2(1),
 C NUMBER
);
INSERT INTO R(A,B,C) VALUES(1,'a',3);
INSERT INTO R(A,B,C) VALUES(2,'b',6);
INSERT INTO R(A,B,C) VALUES(3,'c',7);
CREATE TABLE S(
 D NUMBER,
 B VARCHAR2(1),
 E NUMBER
);
INSERT INTO S(D,B,E) VALUES(2,'c',7);
INSERT INTO S(D,B,E) VALUES(3,'d',5);
INSERT INTO S(D,B,E) VALUES(1,'a',3);
SELECT * FROM R INNER JOIN S ON S.b = R.b;-- 不去掉重复的属性列
SELECT * FROM R Natural INNER JOIN S;-- 把重复的属性列去掉

-- 二、外连接
-- 显示所有学生的学号、姓名和班级名称
-- <1.左连接left outer join> 查询结果除了返回包含连接条件的行，还包含左表（a）中不满足连接条件的行，其中不满足连接条件的行中b表的字段值将被置为空
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a LEFT OUTER JOIN t_class b ON a.stu_class_id = b.class_id; 

-- <2.右连接right outer join> 查询结果除了返回包含连接条件的行，还包含右表（b）中不满足连接条件的行，其中不满足连接条件的行中a表的字段值将被置为空。
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a RIGHT OUTER JOIN t_class b ON a.stu_class_id = b.class_id; 

-- <3.全连接full outer join> 查询结果除了返回包含连接条件的行，还包含左表(a)、右表（b）中不满足连接条件的行，其中不满足连接条件的行中的字段值将被置为空。
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a FULL OUTER JOIN t_class b ON a.stu_class_id = b.class_id; 

-- 三、交叉连接
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student,t_class ; -- 默认就是交叉连接
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a CROSS JOIN t_class b ; 

-- 多张表查询
-- 旧写法
SELECT stu_id ,stu_name,class_name,major_name FROM t_student a,t_class b,t_major c WHERE a.STU_CLASS_ID = B.CLASS_ID AND b.class_major_id = c.major_id; 
-- 新写法
SELECT stu_id ,stu_name,class_name,major_name FROM t_student a INNER JOIN t_class b ON a.STU_CLASS_ID = b.class_id INNER JOIN t_major c ON b.class_major_id = c.major_id; 


/***********************************视图***************************************************/
-- 创建视图
CREATE VIEW stu_view AS SELECT stu_id ,stu_name,class_name,score FROM t_student INNER JOIN t_class ON STU_CLASS_ID = class_id;
-- 查看视图
SELECT * FROM stu_view;
-- 删除视图
DROP VIEW stu_view;

/***********************************子查询***************************************************/
-- 子查询（SELECT语句的嵌套）
-- <1.单行子查询>
-- 查询与SCOTT同一部门的员工信息
SELECT ename,sal,deptno FROM emp WHERE deptno=(SELECT deptno FROM emp WHERE ename='SCOTT');
-- <2.多行子查询>
-- 查询与10号部门员工职位相同的员工信息。
SELECT ename,job,sal,deptno FROM emp WHERE job IN (SELECT DISTINCT job FROM emp WHERE deptno=10);
SELECT ename,sal,deptno FROM emp WHERE sal> ALL (SELECT sal FROM emp WHERE deptno=30);-- ALL
SELECT ename,sal,deptno FROM emp WHERE sal> ANY (SELECT sal FROM emp WHERE deptno=30); -- ANY
-- <3.多列子查询>
-- 查询与SMITH所在部门和职务相同的员工信息
SELECT ename,job,sal,deptno FROM emp WHERE (deptno,job)=(SELECT deptno,job FROM emp WHERE ename='SMITH');
-- 高于部门平均工资的雇员信息
SELECT ename,job,sal FROM emp INNER JOIN (SELECT deptno,avg(sal) avgsal FROM emp GROUP BY deptno) dept ON emp.deptno=dept.deptno AND sal>dept.avgsal;


/***********************************CASE***************************************************/
-- CASE表达式（只存在于Oracle中）
--操作员工表EMP,对10号部门员工工资定级,员工工资大于3000的grade是1，大于2000的grade是2，否则grade是3。
SELECT ename,sal, CASE WHEN sal>3000 THEN 1
                      WHEN sal>2000 THEN 2
                      ELSE 3 END grade
FROM emp WHERE deptno=10;

-- NVL()--空值函数
-- 显示员工姓名和补助（comm）
SELECT ename, comm FROM emp;
-- 显示员工姓名和补助（comm），补助为空NULL的，用0替换
SELECT enamel, NVL(comm,0) FROM emp;




-- 课后作业
-- 1. 任务：百度搜索“自然连接”并理解之（下次课随机抽取讲解）
-- 答：自然连接(Natural join)是一种特殊的等值连接，它要求两个关系中进行比较的分量必须是相同的属性组，并且在结果中把重复的属性列去掉，而等值连接并不去掉重复的属性列。
CREATE TABLE R(
 A NUMBER,
 B VARCHAR2(1),
 C NUMBER
);
INSERT INTO R(A,B,C) VALUES(1,'a',3);
INSERT INTO R(A,B,C) VALUES(2,'b',6);
INSERT INTO R(A,B,C) VALUES(3,'c',7);

CREATE TABLE S(
 D NUMBER,
 B VARCHAR2(1),
 E NUMBER
);
INSERT INTO S(D,B,E) VALUES(2,'c',7);
INSERT INTO S(D,B,E) VALUES(3,'d',5);
INSERT INTO S(D,B,E) VALUES(1,'a',3);

SELECT * FROM R INNER JOIN S ON S.b = R.b;-- 不去掉重复的属性列
SELECT * FROM R Natural INNER JOIN S;-- 把重复的属性列去掉

SELECT * FROM t_student a INNER JOIN t_class b ON A.STU_CLASS_ID = b.CLASS_ID; /*等值连接去掉了比较的列*/
SELECT * FROM t_student a Natural INNER JOIN t_class b; /*等值连接去掉了比较的列*/

-- 2. 任务：显示学生姓名、班级名称、专业名称。使用3张表：学生表，班级表，专业表
SELECT stu_name AS 学生姓名, class_name AS 班级名称, major_name AS 专业名称 FROM t_student INNER JOIN t_class ON stu_class_id = class_id INNER JOIN t_major ON class_major_id = major_id;

-- 3. 任务：显示班级编号为10的学生姓名、班级名称、专业名称。使用3张表：学生表，班级表，专业表
SELECT stu_name AS 学生姓名, class_name AS 班级名称, major_name AS 专业名称 FROM t_student INNER JOIN t_class ON stu_class_id = class_id INNER JOIN t_major ON class_major_id = major_id AND class_id = 10;

-- 4. 任务：创建一个视图，包含学生姓名、学分绩点、手机、班号、班级名称、专业名称。从该视图中查询班号为10的学生姓名、班级名称。写出创建视图语句和SQL语句。
CREATE VIEW stu_class_major AS SELECT stu_name, score, mobile, class_id, class_name, major_name FROM t_student INNER JOIN t_class ON stu_class_id = class_id INNER JOIN t_major ON class_major_id = major_id;
SELECT * FROM stu_class_major;

-- 5. 任务：搜索Oracle集合操作并学之[UNION|UNION ALL|INTERSECT|MINUS]（下次课随机抽取讲解）。
-- UNION (无重并集)：当执行UNION 时，自动去掉结果集中的重复行，并以第一列的结果进行升序排序。
SELECT * FROM emp WHERE sal >= 2000 AND sal <=3000
UNION
SELECT * FROM emp WHERE sal >= 2000;
-- UNION ALL (有重并集)：不去掉重复行，并且不对结果集进行排序。
SELECT * FROM emp WHERE sal >= 2000 AND sal <=3000
UNION ALL
SELECT * FROM emp WHERE sal >= 2000;
-- INTERSECT  (交集)：取两个结果集的交集，并且以第一列的结果进行升序排列。
SELECT * FROM emp WHERE sal >= 2000 AND sal <=3000
INTERSECT
SELECT * FROM emp WHERE sal >= 2000;
-- MINUS  (差集)：只显示在第一个集合中存在，在第二个集合中不存在的数据。并且以第一列的结果进行升序排序。
SELECT * FROM emp WHERE sal >= 2000
MINUS
SELECT * FROM emp WHERE sal >= 2000 AND sal <=3000;

-- 另一个例子
SELECT deptno FROM emp 
UNION 
SELECT deptno FROM emp ;

SELECT deptno FROM emp 
UNION ALL
SELECT deptno FROM emp ;

SELECT deptno FROM emp 
INTERSECT
SELECT deptno FROM emp ;

SELECT deptno FROM emp 
MINUS
SELECT deptno FROM emp ;


-- 6. 显示所有雇员的平均工资、总工资、最高工资、最低工资
SELECT AVG(sal), SUM(sal), MAX(sal), MIN(sal)  FROM emp;

-- 7. 显示每种岗位的雇员总数、平均工资
SELECT COUNT(e.empno), AVG(sal) FROM emp e GROUP BY e.job;

-- 8. 显示雇员总数，以及获得补助的雇员数
SELECT COUNT(e.empno), COUNT(e.comm) FROM emp e;

-- 9. 显示管理者总数
SELECT COUNT( DISTINCT mgr) FROM emp;

-- 10. 显示雇员工资的最大差额
SELECT MAX(sal)- MIN(sal) FROM emp;

-- 11. 显示每部门每岗位的平均工资、每个部门的平均工资、每岗位的平均工资
SELECT deptno,job, AVG(sal) FROM emp GROUP BY deptno,job;
SELECT deptno, AVG(sal) FROM emp GROUP BY deptno;
SELECT job, AVG(sal) FROM emp GROUP BY job;

-- 12. 显示部门20的部门名称、以及该部门的所有雇员名字、雇员工资和岗位
SELECT dname, ename, sal, job FROM emp INNER JOIN dept ON emp.deptno = dept.deptno  AND emp.deptno = 20;

-- 13. 显示获得补助的所有雇员名字、补助以及所在部门
SELECT ename, comm, deptno FROM emp WHERE comm IS NOT NULL AND comm != 0;
SELECT ename, comm, deptno FROM emp WHERE comm IS NOT NULL AND comm <> 0;
SELECT ename, comm, deptno FROM emp WHERE empno NOT IN (SELECT empno FROM emp WHERE comm IS NULL OR comm = 0);-- 子查询

-- 14. 显示在DALLAS工作的所有雇员名字、雇员工资以及所在部门
SELECT ename, sal, d.dname FROM emp e INNER JOIN dept d ON e.deptno = d.deptno AND d.loc = 'DALLAS'; 

-- 15. 显示雇员SCOTT的管理者名字
SELECT b.ename FROM emp a ,emp b WHERE a.mgr = b.empno AND a.ename = 'SCOTT';
SELECT b.ename FROM emp a INNER JOIN emp b ON a.mgr = b.empno AND a.ename = 'SCOTT';
SELECT ename FROM emp WHERE empno = (SELECT mgr FROM emp WHERE ename = 'SCOTT');-- 自查询

-- 16. 查询EMP表和SALGRADE表，显示部门20的雇员名字、工资以及其工资级别
SELECT ename, sal, CASE WHEN sal >= 700 AND sal <= 1200 THEN 1
                        WHEN sal >= 1201  AND sal <= 1400 THEN 2
                        WHEN sal >= 1401  AND sal <= 2000 THEN 3
                        WHEN sal >= 2001  AND sal <= 3000 THEN 4
                        WHEN sal >= 3001  AND sal <= 9999 THEN 5 
                        END grade
FROM emp WHERE deptno = 20;

-- 17. 显示部门10的所有雇员名字、部门名称、以及其他部门名称
SELECT ename, dname FROM emp e RIGHT OUTER JOIN dept d ON e.deptno = d.deptno AND e.deptno = 10;

-- 18. 显示部门10的所有雇员名字、部门名称、以及其他雇员名称
SELECT ename ,dname FROM emp e LEFT OUTER JOIN dept d ON e.deptno = d.deptno AND e.deptno = 10;

-- 19. 显示部门10的所有雇员名字、部门名称、以及其他部门名称和雇员名称
SELECT ename ,dname FROM emp e FULL OUTER JOIN dept d ON e.deptno = d.deptno AND e.deptno = 10;


-- 选做：
-- 1. 显示BLAKE同部门的所有员工，但不显示BLAKE
SELECT ename FROM emp WHERE deptno = (SELECT deptno FROM emp WHERE ename = 'BLAKE') AND ename <> 'BLAKE';

-- 2. 显示超过平均工资的所有员工名、工资和部门号
SELECT ename, sal, deptno FROM emp WHERE sal > (SELECT AVG(sal) FROM emp);

-- 3. 显示超过部门平均工资的所有员工名、工资和部门号
SELECT ename, sal, e.deptno, avg_sal 
FROM emp e 
INNER JOIN (SELECT deptno, avg(sal) avg_sal FROM emp GROUP BY deptno) temp 
ON e.deptno = temp.deptno AND e.sal > temp.avg_sal;

-- 4. 显示高于CLERK岗位所有雇员工资的所有雇员名、工资和岗位
SELECT ename, sal, job FROM emp WHERE sal > (SELECT MAX(sal) FROM emp WHERE job = 'CLERK');
SELECT ename, sal, job FROM emp WHERE sal > ALL(SELECT sal FROM emp WHERE job = 'CLERK');

-- 5. 显示工资、补助与SCOTT完全一致的所有雇员名、工资和补助
SELECT ename, sal, comm FROM emp WHERE (sal,NVL(comm,0)) = (SELECT sal, NVL(comm,0) FROM emp WHERE ename = 'SCOTT');







