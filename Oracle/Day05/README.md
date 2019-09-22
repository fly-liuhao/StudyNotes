## Oracle第5讲 DQL补充

1. 对查询结果分组 GROUP BY 和 HAVING
  -  分组函数（Oracle内置函数）
    - max 求一列数据的最大值，适用任何数据类型
    - min 求一列数据的最小值，适用任何数据类型
    - sum 求一列数据的总和，只能用于数字
    - avg 求一列数据的品平均值，只能用于数字
    - count 统计表数据总行数
```sql
    面试题:COUNT(字段)和COUNT(*)区别
    COUNT(字段)：不统计空数据
    COUNT(*):统计所有的数据
```
```SQL
-- SELECT完整语法
SELECT column, group_function
FROM table  WHERE condition
GROUP BY group_by_expression -- 按什么字段分组
HAVING group_condition -- 对分组后的结果进行限制
ORDER BY column;   -- 总是在最后
```
```SQL
/*单列分组*/
--任务：显示每个部门的平均工资
SELECT deptno, AVG(sal) avgsal FROM emp GROUP BY deptno;--按 deptno分组
/*多列分组*/
SELECT deptno,job,AVG(sal) avgsal,MAX(sal) maxsal FROM emp GROUP BY deptno,job; --按deptno和job一起分组
/*使用HAVING*/
-- 任务：显示平均工资小于2500的各部门号、平均工资、最低工资
SELECT empno,AVG(sal),MIN(sal) FROM emp GROUP BY empno HAVING AVG(sal)<2500;
-- 任务：显示各部门部门编号,平均工资，按平均工资排序。对分组结果排序
SELECT deptno,ROUND(AVG(sal),3) FROM emp GROUP BY deptno ORDER BY AVG(sal);--ASC,DESC
```
```SQL
面试题：SELECT各子句执行次序
执行先后次序： from -> where -> group by -> having -> select -> order by
eg:SELECT ename,sal salary FROM emp WHERE salary < 2000; --该语句返回0条记录还是可能有多条？答案：报错，不返回值。
```

2. 伪列rownum、rowid
```SQL
任务：查询学生表的前3行数据。
SELECT * FROM emp WHERE rownum < 3;
任务：查询学生表的第2至第4行数据(使用 minus)
SELECT * FROM emp WHERE rownum <= 4 MINUS SELECT * FROM emp WHERE rownum  <= 1;
select * from（select t.*，rownum rn from emp t）where rn >= 2 AND rn <= 4;-- 使用子查询
SELECT * FROM( SELECT e.*, ROWNUM rn FROM (SELECT * FROM emp) e WHERE ROWNUM <= 5) WHERE rn >= 2;
任务：理解rownum、rowid
SELECT rownum,rowid FROM student;
```
- ROWID：ROWID是ORACLE中的一个重要的概念。用于定位数据库中一条记录的一个相对唯一地址值。通常情况下，该值在该行数据插入到数据库表时即被确定且唯一。ROWID它是一个伪列，它并不实际存在于表中。它是ORACLE在读取表中数据行时，根据每一行数据的物理地址信息编码而成的一个伪列。所以根据一行数据的ROWID能找到一行数据的物理地址信息。从而快速地定位到数据行。数据库的大多数操作都是通过ROWID来完成的，而且使用ROWID来进行单记录定位速度是最快的。

- rowid是数据的详细地址，利用rowid可以帮助oracle快速定位某行数据的具体位置。rowid可以分为两种，普通表中的rowid是物理rowid，索引组织表中的rowid是逻辑rowid。

- 使用describle(或简写为desc)命令查看表结构时，输出结果中是不能看到rowid这里一列的，这是因为这一列只在数据库内部使用。

