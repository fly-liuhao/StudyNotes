### Java API应用
#### 一、API
1. 什么是API
-  API(Application Programming Interface)——应用程序编程接口
    > 是一些预先定义的函数，目的是提供应用程序与开发人员基于某软件或硬件得以访问一组例程的能力，而又无需访问源码，或理解内部工作机制的细节。

2. API分类
- JDK带的
- SDK
- 第三方Apache
- 公司自己提供

#### 二、微服务 ***
1. 什么是为服务？
- 给我公开接口，我来调用
- 微：小
- 服务：一个功能或者一个系统
- 微服务：小型系统或功能

2. 微服务相关技术
1. Spring Boot
2. Spring Cloud

例：我开发的教务管理系统：教务管理、学历验证、支付、短信验证、学生户籍信息
- 教务管理：开发人员根据需求开发
- 学历验证：调用【学信网】 的接口
- 支付：调用【微信支付】的接口
- 短信验证码：调用【网易】的接口
- 学生户籍验证：调用【公安户籍管理】的接口

#### 三、String
1. String类考题
- 面试题
列举几个常用的被final修饰的类
eg:String 、Math、System、Integer等
- 提示：String不是关键字；是不是Java的内置类型？不是。
int String = 90;//正确

2. String类的常用方法
> 多查看java jdk文档
- String(char[] value) //将字符数组转换成字符串
- String newName = new String(name.getBytes("ISO-8859-1"),"UTF-8");// 处理中文乱码
- boolean equals(Object anObject)  
- toCharArray();  //将字符串转化成数组
- boolean equals(Object anObject)  //区分大小的比价
- boolean equals(Object anObject)  //忽略大小写的比较
- string.trim();//去掉字符串的空格
- String substring(int beginIndex, int endIndex)  //截取子串
- String substring(int beginIndex)  //截取开始索引后的所有字符
  ```Java
  substring(2);//从索引开始，取到结束
  substring(1,1);//有结果，长度为0
  substring(4,2);//error
  ```
- String replace(char oldChar, char newChar)  //替换单个字符
- String replace(CharSequence target, CharSequence replacement)  //替换多个字符
- char charAt(int index)  //返回 char指定索引处的值
