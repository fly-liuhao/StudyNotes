--1.1字符函数
/*
UPPER(列|字符串):将字符串的内容全部转为大写
LOWER(列|字符串):将字符串的内容全部转为小写
INITCAP(列|字符串):将字符串的首字母转为大写
LENGTH(列|字符串):求出字符串的长度
SUBSTR(列|字符串，起始索引，长度):截取字符串
REPLACE(列|字符串):字符串替换
TRIM(列|字符串):去掉左右空格
INSTR(列|字符串，要查找的字符串 ):查找字符串中某个字符的索引
*/
SELECT * FROM EMP;
SELECT UPPER(ENAME),ENAME FROM EMP;/*转为大写*/
SELECT LOWER(ENAME),ENAME FROM EMP;/*转为小写*/
SELECT INITCAP(ENAME),ENAME FROM EMP;/*首字母大写*/
SELECT LENGTH(ENAME),ENAME FROM EMP;/*获取字符串的长度*/
SELECT SUBSTR(ENAME,1,3),ENAME FROM EMP;/*截取字符串*/
SELECT REPLACE(ENAME,'S','XXX'),ENAME FROM EMP;/*字符串替换*/
SELECT TRIM(ENAME) FROM EMP;/*去除左右空格*/
SELECT INSTR(ENAME,'E'), ENAME FROM EMP;/*查找字符串中某个字符的索引(找到返回索引，找不到返回0)*/


--1.2数值函数
/*
    ROUND(数字，保留位数)：对小数进行四舍五入，可以指定保留的位数，不指定则会将小数点之后的数字全部进行四舍五入
    MOD(数字，数字):取模
*/
CREATE TABLE T_SALARY(/*创建一个工资表*/
    EID NUMBER PRIMARY KEY,
    ENAME VARCHAR2(20),
    ESALARY NUMBER
);
INSERT INTO T_SALARY(EID,ENAME,ESALARY) VALUES(1,'zhangsan',4536.25546);
INSERT INTO T_SALARY(EID,ENAME,ESALARY) VALUES(2,'lisi',3985.65845);
INSERT INTO T_SALARY(EID,ENAME,ESALARY) VALUES(3,'wangwu',4937.35468);
SELECT * FROM T_SALARY;
/*将员工工资保留三位小数*/
SELECT ROUND(s.ESALARY),s.ESALARY FROM T_SALARY s;
SELECT ROUND(s.ESALARY,3),s.ESALARY FROM T_SALARY s;
/*将员工工资对1000取模（余数）*/
SELECT MOD(s.ESALARY,1000),s.ESALARY FROM T_SALARY s;


--1.3日期函数
/*
    ADDDATE(日期，数字)：指定的日起加上指定的天数，求出新的日期(MySQL写法)
    日期+数字：指定的日起加上指定的天数，求出新的日期(Oracle写法)
    ADD_MONTHS(日期，数字)：指定的日起加上指定的约月数，求出新的日期(Oracle写法)
    LAST_DAY(日期)：求出指定日期(当月)的最后一天
*/
-- 1.3.1获得对当前系统时间
/*Oracle 写法*/
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE,'yyyy-MM-dd HH24:mi:ss') FROM DUAL;
/* MySQL写法*/
SELECT NOW() FROM t_user;

--1.32 
SELECT TO_CHAR(e.HIREDATE,'yyyy-mm-dd') FROM EMP e;
/*加一天*/
SELECT adddate(NOW(),1),NOW() FROM t_user;/*MySQL写法*/
SELECT TO_CHAR(SYSDATE + 1,'yyyy-mm-dd hh24-mi-ss') FROM DUAL;
SELECT TO_CHAR(e.HIREDATE + 1,'yyyy-MM-dd HH24:mi:ss'),TO_CHAR(e.HIREDATE,'yyyy-MM-dd HH24:mi:ss') FROM EMP e;
/*加一个月*/
SELECT TO_CHAR(ADD_MONTHS(SYSDATE,1),'yyyy-mm-dd hh24-mi-ss') FROM DUAL;
SELECT TO_CHAR(ADD_MONTHS(e.HIREDATE,1),'yyyy-MM-dd HH24:mi:ss'),TO_CHAR(e.HIREDATE,'yyyy-MM-dd HH24:mi:ss') FROM EMP e;
/*加一年*/
SELECT TO_CHAR(ADD_MONTHS(SYSDATE,12),'yyyy-mm-dd hh24-mi-ss') FROM DUAL;
SELECT TO_CHAR(ADD_MONTHS(e.HIREDATE,12),'yyyy-MM-dd HH24:mi:ss'),TO_CHAR(e.HIREDATE,'yyyy-MM-dd HH24:mi:ss') FROM EMP e;

/*计算当前月的最后一天*/
SELECT TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE,-1)),'yyyy-mm-dd') FROM DUAL;


--1.4通用函数
/*
    IFNULL(字段名，默认值)：如果该字段数据为NULL,就是用默认值（MySQL）
    NVL(col,val):当col为空时取val作为返回值，当col不为空时取col值
    DECODE(字段,判断值1, 返回值1, 判断值2, 返回值2, ... , 默认值):多值判断，如果某一列的数据与判断值相同，则使用指定的显示结果输出，如果没有满足条件，则显示默认值
    CASE 列|数值 WHEN 表达式1 THEN 显示结果1 ... ELSE 表达式2 END:用于实现多条判断，在WHERE之后编写条件，而在THEN之后 编写条件满足的显示操作，如果不满足则使用ELSE中的表达式处理
*/
SELECT * FROM EMP;
SELECT NVL(e.COMM,2333) ,e.COMM FROM EMP e;

CREATE TABLE T_USER(/*创建一个用户表*/
    USER_ID NUMBER PRIMARY KEY,
    USER_NAME VARCHAR2(20),
    SEX VARCHAR2(20)
);
INSERT INTO T_USER(USER_ID,USER_NAME,SEX) VALUES(1,'zhangsan',null);
INSERT INTO T_USER(USER_ID,USER_NAME,SEX) VALUES(2,'lisi','男');
INSERT INTO T_USER(USER_ID,USER_NAME,SEX) VALUES(3,'wangwu','女');
SELECT *FROM T_USER;
/*空值判断*/
SELECT NVL(u.SEX,'中性'),u.SEX FROM T_USER u;
/*CASE判断*/
SELECT CASE WHEN u.SEX = '男' THEN '♂' ELSE '♀' END, u.SEX FROM T_USER u;
/*DECODE多值判断*/
SELECT DECODE(u.SEX,'男','♂','女','♀',null) FROM T_USER u;

--1.5统计函数
/*
    COUNT：求出全部的居记录数(分页的时候会用到）
    SUM：求出总和
    AVG:平均值
    MAX:最大值
    MIN:最小值
*/
SELECT * FROM EMP;
/*查询员工总数*/
SELECT COUNT(1) FROM EMP;
/*求出每个月支出的总和*/
SELECT SUM(SAL)+SUM(COMM) AS SUM FROM EMP; 
/*求出员工最高工资*/
SELECT MAX(SAL) FROM EMP;
/*求出员工最低工资*/
SELECT MIN(SAL) FROM EMP;
/*求出员工平均工资*/
SELECT AVG(SAL) FROM EMP;
/*都显示出来*/
SELECT MAX(SAL) AS "最高工资", MIN(SAL) AS "最低工资", ROUND(AVG(SAL),3) AS "平均工资" FROM EMP;






