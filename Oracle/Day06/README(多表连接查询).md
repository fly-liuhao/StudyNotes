## Oracle第六讲
1. 多表连接查询 (面试题)
2. 视图 (面试题)
3. 子查询 (面试题)
4. CASE表达式
5. 空值函数

#### 一、Oracle 多表连接查询
> 表的三种连接方式：内链接、外连接、交叉连接(两张表关联的载体就是主外键)

1. 内链接
    - 等值连接（在连接条件中使用“=”）
    - 不等值连接（在连接条件中不适用“=”）
    - 自然连接：(Natural join)是一种特殊的等值连接，它要求两个关系中进行比较的分量必须是相同的属性组，并且在结果中把重复的属性列去掉，而等值连接并不去掉重复的属性列。
    - 自连接
```SQL
--<等值连接>
-- 显示学生学号、姓名和班级名称
-- 1.旧写法
SELECT stu_id, stu_name, class_name FROM t_student a, t_class b WHERE a.stu_class_id = b.class_id;
-- 2.新写法 INNER JOIN ...ON (条件);
SELECT stu_id, stu_name, class_name FROM t_student a INNER JOIN t_class b ON a.stu_class_id = b.class_id;
-- 显示学生学号、姓名和班级名称、班号（如果两表相关联字段的字段名相同，字段要指明表名）
SELECT stu_id ,stu_name,class_name，class_id FROM t_student a INNER JOIN t_class b ON A.class_id = b.class_id;
--<非等值连接>
SELECT e.ename,e.sal,s.grade FROM emp e, salgrade s WHERE e.sal BETWEEN s.losal AND s.hisal;
--<自然连接>
SELECT * FROM R INNER JOIN S ON S.b = R.b;-- 不去掉重复的属性列
SELECT * FROM R Natural INNER JOIN S;-- 把重复的属性列去掉
--<自连接>
-- 显示员工姓名以及上级领导姓名
SELECT w.ename, m.ename FROM emp w, emp m WHERE w.mgr = m.empno;
```

2. 外连接（外键列取值有空的场景）
    - 左外连接（left outer join）
    - 右外连接（right outer join）
    - 全连接（full outer join）
```SQL
-- 显示所有学生的学号、姓名和班级名称
-- <1.左连接left outer join> 查询结果除了返回包含连接条件的行，还包含左表（a）中不满足连接条件的行，其中不满足连接条件的行中b表的字段值将被置为空
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a LEFT OUTER JOIN t_class b ON a.stu_class_id = b.class_id; 
-- <2.右连接right outer join> 查询结果除了返回包含连接条件的行，还包含右表（b）中不满足连接条件的行，其中不满足连接条件的行中a表的字段值将被置为空。
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a RIGHT OUTER JOIN t_class b ON a.stu_class_id = b.class_id; 
-- <3.全连接full outer join> 查询结果除了返回包含连接条件的行，还包含左表(a)、右表（b）中不满足连接条件的行，其中不满足连接条件的行中的字段值将被置为空。
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a FULL OUTER JOIN t_class b ON a.stu_class_id = b.class_id;
```

3. 交叉连接
```SQL
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student,t_class ; -- 默认就是交叉连接
SELECT stu_id ,stu_name,class_name，STU_CLASS_ID FROM t_student a CROSS JOIN t_class b;
```

4. 多张表查询
```SQL
-- 旧写法
SELECT stu_id ,stu_name,class_name,major_name FROM t_student a,t_class b,t_major c WHERE a.STU_CLASS_ID = B.CLASS_ID AND b.class_major_id = c.major_id; 
-- 新写法
SELECT stu_id ,stu_name,class_name,major_name FROM t_student a INNER JOIN t_class b ON a.STU_CLASS_ID = b.class_id INNER JOIN t_major c ON b.class_major_id = c.major_id; 
```

#### 二、视图：View

1. 试图是什么？视图（审视数据的窗口）,是一个虚拟表，本质是SELECT语句，基于已有的表（基表）建立，有一张或者多张表构成
> 面试题：视图中是否存储数据？不可以
> 面试题：能否对视图进行增删改操作？一般可以，设置了只读的视图不可以
> 面试题：使用视图的目的是什么？1.可以隐藏一些数据（保护数据）2.可使复杂的查询易于管理和使用（简化操作）
2. 如何创建视图？
```SQL
CREATE [OR REPLACE] VIEW view_name AS
SELECT查询
[WITH READ ONLY] --只读视图
```
```SQL
-- 创建一个视图，仅包含学生学号，姓名，学分绩点，班级名称；从视图中查询学生姓名和班级名称
CREATE VIEW stu_view AS SELECT stu_id ,stu_name,class_name,score FROM t_student INNER JOIN t_class ON STU_CLASS_ID = class_id;
```
3. 如何使用视图
```SQL
-- 和表的使用一样
SELECT * FROM stu_view;
```
4. 如何删除视图
```SQL
DROP VIEW stu_view;
```

#### 三、子查询
1. 什么是子查询？ SELECT语句的嵌套。
2. 何时使用子查询？ 当要显示的数据 在表里并不存在，但可以通过对已有数据的加 工获得，可通过子查询实现。
3. 子查询分类？
    - 单行子查询
    - 多行子查询
    - 多列子查询
```SQL
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
```
> 面试题：何为行内视图？和普通视图有何区别？ 行内视图只可用一次，普通视图存放于Oracle中，可随时使用

4. 子查询可以出现在哪里？ 子查询可以出现在4种地方：WHERE子句、FROM子句、DML语句、DDL语句中
5. 子查询编写思路？
    - 仔细分析题目，确定要查询的表及字段（数据）
    - 分析要查询的字段（数据）哪些在表里直接存在，哪些不存在
    - 考虑如何把要显示的数据造出来（通过查询语句获得）
    - 考虑子查询与表的连接点是什么 (通常是主外键、共有字段)
    - 考虑子查询放在什么位置
    - 组合成完整的SQL语句
**提示：工程上，把复杂的子查询做成视图**

#### 四、CASE
```SQL
--对10号部门员工工资定级,员工工资大于3000的grade是1，大于2000的grade是2，否则grade是3
SELECT ename,sal, CASE WHEN sal>3000 THEN 1
                      WHEN sal>2000 THEN 2
                      ELSE 3 END grade
FROM emp WHERE deptno=10;
```

#### 五、Oracle空值函数 NVL （重要）
```SQL
-- 显示员工姓名和补助（comm）
SELECT ename, comm FROM emp;
-- 显示员工姓名和补助（comm），补助为空NULL的，用0替换
SELECT enamel, NVL(comm,0) FROM emp;
```

#### 六、课后任务（使用到Oracle自带的表：DEPT、EMP、SALGRADE ）
1. 任务：百度搜索“自然连接”并理解之（下次课随机抽取讲解）
2. 任务：显示学生姓名、班级名称、专业名称。使用3张表：学生表，班级表，专业表
3. 任务：显示班级编号为10的学生姓名、班级名称、专业名称。使用3张表：学生表，班级表，专业表
4. 任务：创建一个视图，包含学生姓名、学分绩点、手机、班号、班级名称、专业名称。从该视图中查询班号为10的学生姓名、班级名称。写出创建视图语句和SQL语句。
5. 任务：搜索Oracle集合操作并学之[UNION|UNION ALL|INTERSECT|MINUS]（下次课随机抽取讲解）。
6. 显示所有雇员的平均工资、总工资、最高工资、最低工资
7. 显示每种岗位的雇员总数、平均工资
8. 显示雇员总数，以及获得补助的雇员数
9. 显示管理者总数
10. 显示雇员工资的最大差额
11. 显示每部门每岗位的平均工资、每个部门的平均工资、每岗位的平均工资
12. 显示部门20的部门名称、以及该部门的所有雇员名字、雇员工资和岗位
13. 显示获得补助的所有雇员名字、补助以及所在部门
14. 显示在DALLAS工作的所有雇员名字、雇员工资以及所在部门
15. 显示雇员SCOTT的管理者名字
16. 查询EMP表和SALGRADE表，显示部门20的雇员名字、工资以及其工资级别
17. 显示部门10的所有雇员名字、部门名称、以及其他部门名称
18. 18. 显示部门10的所有雇员名字、部门名称、以及其他雇员名称
19. 显示部门10的所有雇员名字、部门名称、以及其他部门名称和雇员名称

***
选做：
1. 显示BLAKE同部门的所有员工，但不显示BLAKE
2. 显示超过平均工资的所有员工名、工资和部门号
3. 显示超过部门平均工资的所有员工名、工资和部门号
4. 显示高于CLERK岗位所有雇员工资的所有雇员名、工资和岗位
5. 显示工资、补助与SCOTT完全一致的所有雇员名、工资和补助
