SELECT * FROM emp;

-- 1.ASCII
-- 返回指定的字符饭回来的十进制数
SELECT ascii('A'),ascii('a'),ascii('0'),ascii(' ') FROM dual;

-- 2.CHR 
-- 给出整数返回对应的字符
SELECT chr(65),chr(97),chr(48),chr(32) FROM dual;

-- 3.CONCAT
-- 连接两个字符串;
  SELECT concat('010-','88888888')||'转110'  电话 FROM dual;
  
-- 4.INITCAP
-- 返回字符串并将字符串的第一个字母变为大写;
  SELECT initcap('smith') upp FROM dual;

-- 5.INSTR(C1,C2,I,J)
-- 在一个字符串中搜索指定的字符,返回发现指定的字符的位置;
  SELECT instr('oracle traning','ra',1,2) instring FROM dual;

-- 6.LENGTH *
-- 返回字符串的长度
SELECT  ename, length(ename)  FROM emp;

-- 7.LOWER
-- 返回字符串,并将所有的字符小写
SELECT lower('AaBbCcDd')   AaBbCcDd FROM dual;
SELECT deptno FROM emp WHERE lower(ename)='scott';

-- 8.UPPER
-- 返回字符串,并将所有的字符大写
  SELECT upper('AaBbCcDd') upper FROM dual;

-- 9.RPAD和LPAD
-- RPAD  在列的右边粘贴字符
-- LPAD  在列的左边粘贴字符
-- 不够字符则用*来填满
SELECT rpad('gao',5,'*') FROM dual;
SELECT lpad('gao',5,'*') FROM dual;
SELECT lpad(rpad('gao',10,'*'),17,'*') FROM dual;


-- 10.LTRIM和RTRIM *
-- LTRIM  删除左边出现的字符串
-- RTRIM  删除右边出现的字符串
SELECT ltrim('***gao qian jing****','*') FROM dual;
SELECT rtrim('***gao qian jing****','*') FROM dual;
SELECT ltrim(rtrim('****gao qian jing****','*'),'*') FROM dual;

-- 11.SUBSTR(string,start,count) *
-- 取子字符串,从start开始,取count个    （学号162054225）
SELECT substr('123456789',3,8)  FROM  dual;

-- 12.REPLACE('string','s1','s2')
--   string   希望被替换的字符或变量 
--   s1       被替换的字符串
--   s2       要替换的字符串
SELECT replace('He love you','He','I') FROM dual;
        
-- 13. TRIM('s' FROM 'string') 
--       LEADING   剪掉前面的字符
--       TRAILING  剪掉后面的字符
select trim('a' FROM 'a b 123') FROM dual;

-- 14. ABS
-- 返回指定值的绝对值
SELECT abs(100),abs(-100) FROM dual;                

-- 15. CEIL *
-- 返回大于或等于给出数字的最小整数
SELECT ceil(3.1415927) FROM dual;

-- 16. FLOOR *
-- 对给定的数字取整数
SELECT floor(2345.67) FROM dual;

-- 17. MOD(n1,n2) *
--  返回一个n1除以n2的余数
SELECT mod(10,3),mod(3,3),mod(2,3) FROM dual;

-- 18. ROUND *
-- 按照指定的精度进行舍入(对比20)
SELECT round(55.5),round(-55.4),trunc(55.5),trunc(-55.5) FROM dual;
SELECT round(3.1415926,3),round(-3.1415926,3),trunc(3.1415926,3),trunc(-3.1415926,3) FROM dual;

-- 19.SIGN *
-- 取数字n的符号,大于0返回1,小于0返回-1,等于0返回0
SELECT sign(100),sign(-100),sign(0) FROM dual;
        
-- 20.TRUNC *
-- 按照指定的精度截取一个数
SELECT trunc(124.1666,-2) trunc1,trunc(124.16666,2) FROM dual;

-- 21.ADD_MONTHS *
-- 增加或减去月份
SELECT to_char(add_months(to_date('200712','yyyymm'),2),'yyyymm') FROM dual; 

SELECT to_char(add_months(to_date('200712','yyyymm'),-2),'yyyymm') FROM dual;

-- 22. LAST_DAY
-- 返回日期(当月)的最后一天
SELECT last_day(to_date('2007-05-12','yyyy-mm-dd'))FROM dual;
SELECT to_char(to_date('2007-05-12','yyyy-mm-dd'),'yyyy-mm-dd') FROM dual;
SELECT to_char(last_day(to_date('2007-05-12','yyyy-mm-dd')),'yyyy-mm-dd')FROM dual;
SELECT to_char(SYSDATE,'yyyy-mm-dd hh24-mi-ss day') FROM dual;
SELECT to_char(last_day(SYSDATE),'yyyy-mm-dd') FROM dual;

-- 23.NEXT_DAY(date,'day')
-- 给出日期date和星期x之后计算下一个星期的日期
SELECT next_day('08-8月-2007','星期三') next_day FROM dual;
            
-- 24.SYSDATE  **
-- 用来得到系统的当前日期
SELECT to_char(sysdate,'yyyy-mm-dd day') FROM dual;

-- 25. TO_CHAR(date,'format') **
SELECT to_char(sysdate,'yyyy/mm/dd hh24:mi:ss day') FROM dual;
SELECT to_char(sysdate,'yyyy-mm-dd hh-mi-ss am') FROM dual;

-- 26. TO_DATE(string,'format') **
-- 将字符串转化为ORACLE中的一个日期
SELECT to_date('2003-09-08 18:26:37', 'yyyy-mm-dd hh24:mi:ss') from dual;

-- 27. TO_NUMBER *
-- 将给出的字符转换为数字
SELECT to_number('2019') year FROM dual;

-- 28. GREATEST *
-- 返回一组表达式中的最大值,即比较字符的编码大小.
SELECT greatest('AA','AB','AC') FROM dual;
SELECT greatest('a','b','c') FROM dual;

-- 29. LEAST *
-- 返回一组表达式中的最小值 
SELECT least('啊','安','天') FROM dual;
SELECT least('a','b','c') FROM dual;

-- 30.UID
-- 返回标识当前用户的唯一整数
SELECT uid FROM dual;
SELECT uid FROM emp;

-- 31.USER
-- 返回当前用户的名字
SHOW user;
SELECT user FROM  dual;

-- 32.AVG(DISTINCT|ALL) *
-- all表示对所有的值求平均值,distinct只对不同的值求平均值
SELECT avg(distinct sal) FROM emp;
SELECT avg(all sal) FROM emp;

-- 33.MAX(DISTINCT|ALL) *
-- 求最大值,ALL表示对所有的值求最大值,DISTINCT表示对不同的值求最大值,相同的只取一次
SELECT max(distinct sal) FROM emp;

-- 34.MIN(DISTINCT|ALL) *
-- 求最小值,ALL表示对所有的值求最小值,DISTINCT表示对不同的值求最小值,相同的只取一次
SELECT min(all sal) FROM emp;

-- 35.GROUP BY *
-- 主要用来对一组数进行统计
SELECT deptno,count(*),sum(sal) FROM emp group by deptno;

-- 36.HAVING *
-- 对分组统计再加限制条件
SELECT deptno,count(*),sum(sal) FROM emp group by deptno 
having count(*)>=5;

-- 37. ORDER BY *
-- 用于对查询到的结果进行排序输出
SELECT deptno,ename,sal FROM emp order by deptno,sal desc;

-- 38. Extract(date FROM datetime)
-- 从日期时间中取得特定数据（例如取出月、年等）
SELECT extract(YEAR FROM sysdate)   FROM dual;
SELECT extract(MONTH FROM sysdate) FROM dual;
SELECT extract(DAY FROM sysdate)    FROM dual;
SELECT extract(HOUR FROM localtimestamp) FROM dual;
SELECT extract(MINUTE FROM localtimestamp) FROM dual;
SELECT extract(SECOND FROM localtimestamp) FROM dual;

--39. DECODE(expr,search1,result1[,search2,result2][,default])**
-- 多值判断，如果某一列的数据与判断值相同，则使用指定的显示结果输出，如果没有满足条件，则显示默认值
SELECT deptno,DECODE(deptno,'10','ABC','20','DEF','30','AAA','NO') result FROM dept;

-- 40.NULLIF(expr1,expr2)
-- 如果expr1和expr2的值相等，则返回NULL，否则返回expr1
SELECT NULLIF('abc','abc') result FROM dual;
SELECT NULLIF('abc','abb') result FROM dual;


-- 41.NVL(expr1,expr2)**
-- 如果expr1是null,则返回expr2; 如果expr1不为null,则返回expr1
SELECT empno,ename,comm,NVL(comm,0) FROM emp;


-- 42. NVL2(expr1,expr2,expr3)
-- 如果expr1不是null,则返回expr2;如果expr1是null,则返回expr3;参数expr1可以是任意数据类型，而expr2和expr3可以是除Long之外的任何数据类型
SELECT empno,ename,comm,NVL2(comm,1,0) FROM emp;

-- 43.Translate(x,from_string,to_string) *
-- 从'a1b0c2d3'中找在‘3210’中出现过的字符，找到后用‘pqxy’相应位置的字符替换
-- 实际使用中最好使第二个参数 和 第三个参数的位数一样
-- 0 用 y 代替, 1 用 x 代替, 2 用 q 代替, 3 用 p 代替
SELECT translate('a1b0c2d3','3210','pqxy') from dual;
SELECT translate('32100123','3210','pqxy') from dual;






















