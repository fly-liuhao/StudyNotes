## Log4j
- 有两个系列（1.x系列和32.x系列）
- 官网：
  - http://logging.apache.org/log4j/1.2/download.html
  - https://logging.apache.org/log4j/2.x/
- 来自于Apache组织，也是开源的，是一个第三方组件
- 作用：做日志
1. 基础配置
- 复制官网下载的jar包，到工程下，并build path添加到构建路径里
- 复制Log4j.properties配置文件到工程src目录下

2. 使用
- 学习网址：https://blog.csdn.net/sinat_30185177/article/details/73550377
- Log4j由三个重要的组件构成：日志信息的优先级，日志信息的输出目的地，日志信息的输出格式。
- 日志信息的优先级：分为OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者您定义的级别。
- 常用优先级：ERROR、WARN、INFO、DEBUG
- 使用流程：
    - 导入jar包 log4j-1.2.16.jar
    - 将配置文件log4j.properties放置在与**src同级目录**下
    - 在代码中使用
    ```java
       //得到日志对象
       Logger logger = Logger.getLogger(PrintInfo.class);
       try {
          new AccountBank().withDrawMethod();
       } catch (AccountException e) {
          logger.debug(e);// 调试过程中用debug
          logger.error(e);// 程序运行过程中错误用error
          logger.info(e);// 一般提示信息用info
       }
    ```
3. 作业
- 使用Log4j 2.x 做一个工程


#### 问题
1. 异常分类
- 已检查异常（Checked Exception）
- 未检查异常/运行时异常（Unchecked Exception）RuntimeException
- 区别：已检查异常在编译是就能发现，未已检查异常执行时才发现

2. 请列举几个常见的异常
- NullPointException  空指针异常
- ArithmeticException 算术计算异常
- ArrayIndexOutOfBoundsException   数组越界异常
3. Exception和error的区别
- [参考链接](https://blog.csdn.net/weixin_42124070/article/details/80833629)
- 异常：程序员是可以处理的
- 错误：是未预料到的，由外部环境引起的，一般是JVM崩溃，内存泄露等，程序员处理不了
4. 重写时异常如何处理
- 子类可以重写更多的异常，但这些异常类型必须是父类的子类
