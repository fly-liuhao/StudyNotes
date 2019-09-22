# 第四章：JDBC
### 一、JDBC背景介绍
#### （一）什么是JDBC？
- JDBC（Java DataBase Connectivity，java数据库连接）是一种用于执行SQL语句的Java API，可以为多种关系数据库提供统一访问，它由一组用[Java语言]编写的类和接口组成。
#### （二）JDBC作用是什么？
- 与数据库建立连接、发送 操作数据库的语句并处理结果
- 架起Java与数据库之间的桥梁
#### （三）主要的JDBC API有哪些？
- 接口
  + [Connection]：close() 、commit()、createStatement() 、getAutoCommit() 、isClosed() 、prepareCall(String sql) 、prepareStatement(String sql) 、rollback() 、setAutoCommit(boolean autoCommit)
  + [PreparedStatement]：addBatch() 、executeQuery() 、executeUpdate() 、setInt(int parameterIndex, int x) 等一些列set方法、
  + [ResultSet]-结果集：absolute(int row) 、afterLast() 、beforeFirst() 、close()
ResultSet释、first() 、一些列get方法、
  + [Statement]：开发基本不用，但要清楚
- 类
  + [DriveManager]（驱动程序管理器）：getConnection(String url) 及重载方法
- 异常
  + [SQLException]：
#### （四）JDBC数据操作的步骤？
1. 注册驱动
2. 获取链接
3. 定义SQL语句
4. 准备SQL语句
5. 占位符赋值（可能没有）
6. 执行SQL语句
7. 处理执行结果
8. 关闭链接


### 二、实践部分
#### （一）启动Oracle
1. 启动服务
2. 开启数据库管理工具：sqldeveloper，连接数据库
3. 建表
#### （二)新建一个动态web项目
- DAO：(Data Access Object) 数据访问对象，数据库操作的代码
- 流程
  + JSP(AJAS) -- Servlet -- Service -- DAO -- DB
  + 显示层/视图层（JSP/HTML）-- 控制层(Servlet) -- 业务处理层(Servicr) -- 数据访问层(Dao) -- 数据源(数据库)
- 需要的外部包
  + Log4j：日志
  + JUnit：单元测试
  + Oracle驱动（D:\Software\app\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar）
#### （三）链接数据库
1. Oracle两种连接数据库方式  oci  和 thin
- **oci**
  ```java
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection con = DriverManager.getConnection("jdbc:oracle:oci:@数据库名","登录名", "密码");
  ```

- **thin**
  ```java
  Class.forName("oracle.jdbc.OracleDriver");// 注册Oracle驱动，
  String url = "jdbc:oracle:thin:@localhost:1521:orcl";
  // jdbc 数据库协议主协议 thin连接方式 @固定语法 localhost为ip地址 1521为端口号   orcl是Oracle数据库驱动的名称
  Connection conn = DriverManager.getConnection(url, "scott", "scott");// 获得数据库连接
  ```
- 区别
  > 1）从使用上来说，oci必须在客户机上安装oracle客户端或才能连接，而thin就不需要，因此从使用上来讲thin还是更加方便，这也是thin比较常见的原因。
  > 2）原理上来看，thin是纯java实现tcp/ip的c/s通讯；而oci方式,客户端通过native java method调用c library访问服务端，而这个c library就是oci(oracle called interface)，因此这个oci总是需要随着oracle客户端安装（从oracle10.1.0开始，单独提供OCI Instant Client，不用再完整的安装client）
  > 3）它们分别是不同的驱动类别，oci是二类驱动， thin是四类驱动，但它们在功能上并无差异。
  > 4) 如果想要高性能，请使用OCI连接，如果不想装Oracle客户端，请使用thin连接。
  > 5) oci不需要写IP thin需要
2. 链接数据库代码
    ```java
    public class DBUtil {
        /**
         * 获取Oracle数据库链接
         *
         * @return 数据库的链接对象
         */
        public static Connection getConnection() {
            /** 定义一个链接对象，Connection是一个接口 */
            Connection conn = null;
            try {
                /** 注册Oracle驱动，参数是Oracle数据库驱动的名称 */
                Class.forName("oracle.jdbc.OracleDriver");
                /** 链接字符串（主协议、子协议、链接方式） */
                //jdbc 数据库协议主协议
                //thin连接方式
                //@固定语法
                //localhost为ip地址
                //1521为端口号   
                //orcl是Oracle数据库驱动的名称
                String url = "jdbc:oracle:thin:@localhost:1521:orcl";
                /** 获得数据库连接 */
                conn = DriverManager.getConnection(url, "scott", "scott");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }

        /**
         * 关闭连接
         *
         * @param conn  链接对象
         * @param pstmt 预编译对象
         * @param rs    结果集对象
         */
        public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        /*
        * 测试是否可以链接到数据库
        */
        public static void main(String[] args) {
            System.out.println(DBUtil.getConnection());
        }
    }
    ```

#### （四）添删改查（CRUD）
- 详细见上传代码

#### （五）额外任务
- JASN
- Log4j 2.x
- JUNIT 5

### 三、链接池
#### （一）什么是连接池
> 实际开发中“获得连接”或“释放资源”是非常消耗系统资源的两个过程，为了解决此类性能问题（并发时），通常情况我们采取连接池技术，来共享连接Connection。在程序开始的时候，可以创建几个连接，将连接放入到连接池中。用户使用连接的时候，可以从连接池中进行获取。用完之后，可以调用 close() 方法将连接[归还]连接池。
1. 概念
- 用池来管理Connection，这样可以重复使用Connection。有了池，我们就不用自己来创建Connection，而是通过池来获取Connection对象。当使用完Connection后，调用Connection的close()方法也不会真的关闭Connection，而是把Connection“归还”给池。池就可以再利用这个Connection对象了。
2. 规范
- Java为数据库连接池提供了公共的接口，javax.sql.DataSource，各个厂商需要让自己的连接池实现这个接口。这样应用程序可以方便地切换不同厂商的连接池。
3. 为什么使用连接池
- 对于一个简单的[数据库](http://lib.csdn.net/base/mysql)应用，由于对于数据库的访问不是很频繁。这时可以简单地在需要访问数据库时，就新创建一个连接，用完后就关闭它，这样做也不会带来什么明显的性能上的开销。但是对于一个复杂的数据库应用，情况就完全不同了。频繁的建立、关闭连接，会极大的减低系统的性能，因为对于连接的使用成了系统性能的瓶颈。
- 连接复用。通过建立一个数据库连接池以及一套连接使用管理策略，使得一个数据库连接可以得到高效、安全的复用，避免了数据库连接频繁建立、关闭的开销。
- 对于共享资源，有一个很著名的设计模式：资源池。该模式正是为了解决资源频繁分配、释放所造成的问题的。把该模式应用到数据库连接管理领域，就是建立一个数据库连接池，提供一套高效的连接分配、使用策略，最终目标是实现连接的高效、安全的复用。

4. 数据库连接池技术带来的优势
- 资源重用
​由于数据库连接得到重用，避免了频繁创建、释放连接引起的大量性能开销。在减少系统消耗的基础上，另一方面也增进了系统运行环境的平稳性（减少内存碎片以及数据库临时进程/线程的数量）。

- 更快的系统响应速度
数据库连接池在初始化过程中，往往已经创建了若干数据库连接置于池中备用。此时连接的初始化工作均已完成。对于业务请求处理而言，直接利用现有可用连接，避免了数据库连接初始化和释放过程的时间开销，从而缩减了系统整体响应时间。

- 新的资源分配手段
​对于多应用共享同一数据库的系统而言，可在应用层通过数据库连接的配置，实现数据库连接池技术，几年钱也许还是个新鲜话题，对于目前的业务系统而言，如果设计中还没有考虑到连接池的应用，那么…….快在设计文档中加上这部分的内容吧。某一应用最大可用数据库连接数的限制，避免某一应用独占所有数据库资源。

- 统一的连接管理，避免数据库连接泄漏
较为完备的数据库连接池实现中，可根据预先的连接占用超时设定，强制收回被占用连接。从而避免了常规数据库连接操作中可能出现的资源泄漏。

#### （二）连接池的种类
[参考链接](https://blog.csdn.net/bjweimengshu/article/details/80212290)
1. [Druid] 第三方组件（阿里）
- Druid是Java语言中最好的数据库连接池，Druid能够提供强大的监控和扩展功能，是一个可用于大数据实时查询和分析的高容错、高性能的开源分布式系统，尤其是当发生代码部署、机器故障以及其他产品系统遇到宕机等情况时，Druid仍能够保持100%正常运行。主要特色：为分析监控设计；快速的交互式查询；高可用；可扩展；Druid是一个开源项目，源码托管在github上。
2. [C3P0] 第三方组件
- 开源的JDBC连接池，实现了数据源和JNDI绑定，支持JDBC3规范和JDBC2的标准扩展。目前使用它的开源项目有Hibernate、Spring等。单线程，性能较差，适用于小型系统，代码600KB左右。
3. [DBCP]
- 官方说法BoneCP是一个高效、免费、开源的Java数据库连接池实现库。设计初衷就是为了提高数据库连接池性能，根据某些测试数据显示，BoneCP的速度是最快的，要比当时第二快速的连接池快25倍左右，完美集成到一些持久化产品如Hibernate和DataNucleus中。BoneCP特色：高度可扩展，快速；连接状态切换的回调机制；允许直接访问连接；自动化重置能力；JMX支持；懒加载能力；支持XML和属性文件配置方式；较好的Java代码组织，100%单元测试分支代码覆盖率；代码40KB左右。
4. [BoneCP]
- 官方说法BoneCP是一个高效、免费、开源的Java数据库连接池实现库。设计初衷就是为了提高数据库连接池性能，根据某些测试数据显示，BoneCP的速度是最快的，要比当时第二快速的连接池快25倍左右，完美集成到一些持久化产品如Hibernate和DataNucleus中。BoneCP特色：高度可扩展，快速；连接状态切换的回调机制；允许直接访问连接；自动化重置能力；JMX支持；懒加载能力；支持XML和属性文件配置方式；较好的Java代码组织，100%单元测试分支代码覆盖率；代码40KB左右。
5. [Tomcat Jdbc Pool]
- Tomcat在7.0以前都是使用common-dbcp做为连接池组件，但是dbcp是单线程，为保证线程安全会锁整个连接池，性能较差，dbcp有超过60个类，也相对复杂。Tomcat从7.0开始引入了新增连接池模块叫做Tomcat jdbc pool，基于Tomcat JULI，使用Tomcat日志框架，完全兼容dbcp，通过异步方式获取连接，支持高并发应用环境，超级简单核心文件只有8个，支持JMX，支持XA Connection。
4. [Poolman]
- 太古老了


#### （三）链接池的实现？
  1. 导入连接池的jia包
  2. 建立连接池配置文件 `.properties` / `.xml`
  3. 代码中使用


- druid.properties
  ```java
  driverClassName=oracle.jdbc.OracleDriver
  url=jdbc:oracle:thin:@localhost:1521:orcl
  username=scott
  password=scott
  # 初始连接池连接数
  initialSize=5
  # 最大连接池数量
  maxActive=10
  # 获取连接时最大等待时间，单位毫秒
  maxWait=3000
  # 最小连接池数量
  minIdle=3
  # 验证连接是否可用
  validationQuery=SELECT 1 FROM dual
  ```
- DBUtil.java
  ```java
  /**
   * 使用Druid连接池获取链接的工具箱
   *
   * @author: liuhao
   * @version 1.0
   */
  public class DBUtilDruid {
      /** 数据源 */
      private static DataSource ds;

      /** 静态代码块，在类加载时候执行 */
      static {
          Properties dbProperties = new Properties();
          try {
              dbProperties.load(DBUtilDruid.class.getResourceAsStream("/druid.properties"));
              ds = DruidDataSourceFactory.createDataSource(dbProperties);
          } catch (IOException e) {
              e.printStackTrace();
          } catch (Exception e) {
              e.printStackTrace();
          }
      }

      /**
       * 获取链接
       *
       * @return 链接对象
       */
      public static Connection getConnection() {
          Connection conn = null;
          try {
              conn = ds.getConnection();
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return conn;
      }

      /**
       * 关闭连接(不是真的关闭，还回操作)
       *
       * @param conn  链接对象
       * @param pstmt 预编译对象
       * @param rs    结果集对象
       */
      public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
          try {
              if (rs != null) {
                  rs.close();
              }
              if (pstmt != null) {
                  pstmt.close();
              }
              if (conn != null) {
                  conn.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      /**
       * 测试是否可以链接成功
       * @param args 主方法参数
       */
      public static void main(String[] args) {
          System.out.println(DBUtilDruid.getConnection());
      }
  }
  ```

- c3p0-config.xml
  ```java
  <?xml version="1.0" encoding="UTF-8"?>
  <c3p0-config>
  	<!-- 这是默认配置信息 -->
  	<default-config>
  		<!-- 连接四大参数配置 -->
  		<property name="jdbcUrl">jdbc:oracle:thin:@localhost:1521:orcl
  		</property>
  		<property name="driverClass">oracle.jdbc.OracleDriver</property>
  		<property name="user">scott</property>
  		<property name="password">scott</property>
  		<!-- 池参数配置 -->
  		<property name="acquireIncrement">3</property>
  		<property name="initialPoolSize">10</property>
  		<property name="minPoolSize">2</property>
  		<property name="maxPoolSize">10</property>
  	</default-config>

  	<!-- Mysql配置信息 -->
  	<named-config name="oracle-config">
  		<property name="jdbcUrl">jdbc:mysql://localhost:3306/mydb1</property>
  		<property name="driverClass">com.mysql.jdbc.Driver</property>
  		<property name="user">root</property>
  		<property name="password">123</property>
  		<property name="acquireIncrement">3</property>
  		<property name="initialPoolSize">10</property>
  		<property name="minPoolSize">2</property>
  		<property name="maxPoolSize">10</property>
  	</named-config>
  </c3p0-config>
  ```
- DBUtilC3P0.java
  ```java
  /**
   * 使用C3P0连接池
   *
   * @author liuhao
   * @version 1.0
   */
  public class DBUtilC3P0 {
      /** 数据源 */
      private static DataSource ds = new ComboPooledDataSource();

      /**
       * 获取数据源（连接池）
       *
       * @return 数据源对象，就是连接池
       */
      public static DataSource getDataSource() {
          return ds;
      }

      /**
       * 获取连接
       *
       * @return 数据库连接对象
       */
      public static Connection getConnection() {
          Connection conn = null;
          try {
              conn = ds.getConnection();
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return conn;
      }

      /**
       * 关闭连接
       *
       * @param rs    结果集
       * @param pstmt 预编译对象
       * @param conn  数据库连接
       */
      public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
          try {
              if (rs != null) {
                  rs.close();
              }
              if (pstmt != null) {
                  pstmt.close();
              }
              if (conn != null) {
                  conn.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

      /**
       * 测试是否可以链接成功
       * @param args 主方法参数
       */
      public static void main(String[] args) {
          System.out.println(DBUtilC3P0.getConnection());
      }
  }
  ```
- Java连接池代码实现

  ```java
  /**
   * 自定义连接池, 管理连接 代码实现：
   * 1. MyPool.java 连接池类
   * 2. 指定全局参数： 初始化数目、最大连接数、当前连接、 连接池集合
   * 3.构造函数：循环创建3个连接
   * 4. 写一个创建连接的方法
   * 5. 获取连接 ------> 判断： 池中有连接， 直接拿 ------> 池中没有连接，------> 判断，是否达到最大连接数；
   *                    达到，抛出异常；没有达到最大连接数， 创建新的连接
   * 6. 释放连接 ------> 连接放回集合中(..)
   *
   */
  public class MyPool {
      private int init_count = 3; // 初始化连接数目
      private int max_count = 6; // 最大连接数
      private int current_count = 0; // 记录当前使用连接数
      // 连接池 （存放所有的初始化连接）
      private LinkedList<Connection> pool = new LinkedList<Connection>();

      // 1. 构造函数中，初始化连接放入连接池
      public MyPool() {
          // 初始化连接
          for (int i = 0; i < init_count; i++) {
              // 记录当前连接数目
              current_count++;
              // 创建原始的连接对象
              Connection con = createConnection();
              // 把连接加入连接池
              pool.addLast(con);
          }
      }

      // 2. 创建一个新的连接的方法
      private Connection createConnection() {
          try {
              Class.forName("com.mysql.jdbc.Driver");
              // 原始的目标对象
              final Connection con = DriverManager.getConnection("jdbc:mysql:///jdbc_demo", "root", "root");

              /********** 对con对象代理 **************/

              // 对con创建其代理对象
              Connection proxy = (Connection) Proxy.newProxyInstance(

                      con.getClass().getClassLoader(), // 类加载器
                      // con.getClass().getInterfaces(), // 当目标对象是一个具体的类的时候,但是这里con是一个接口
                      new Class[] { Connection.class }, // 目标对象实现的接口

                      new InvocationHandler() { // 当调用con对象方法的时候， 自动触发事务处理器
                          @Override
                          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                              // 方法返回值
                              Object result = null;
                              // 当前执行的方法的方法名
                              String methodName = method.getName();

                              // 判断当执行了close方法的时候，把连接放入连接池
                              if ("close".equals(methodName)) {
                                  System.out.println("begin:当前执行close方法开始！");
                                  // 连接放入连接池
                                  pool.addLast(con);
                                  System.out.println("end: 当前连接已经放入连接池了！");
                              } else {
                                  // 调用目标对象方法
                                  result = method.invoke(con, args);
                              }
                              return result;
                          }
                      });
              return proxy;
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }

      // 3. 获取连接
      public Connection getConnection() {

          // 3.1 判断连接池中是否有连接, 如果有连接，就直接从连接池取出
          if (pool.size() > 0) {
              return pool.removeFirst();
          }

          // 3.2 连接池中没有连接： 判断，如果没有达到最大连接数，创建；
          if (current_count < max_count) {
              // 记录当前使用的连接数
              current_count++;
              // 创建连接
              return createConnection();
          }

          // 3.3 如果当前已经达到最大连接数，抛出异常
          throw new RuntimeException("当前连接已经达到最大连接数目 ！");
      }

      // 4. 释放连接
      public void realeaseConnection(Connection con) {
          // 4.1 判断： 池的数目如果小于初始化连接，就放入池中
          if (pool.size() < init_count) {
              pool.addLast(con);
          } else {
              try {
                  // 4.2 关闭
                  current_count--;
                  con.close();
              } catch (SQLException e) {
                  throw new RuntimeException(e);
              }
          }
      }

      /**
       * 测试链接
       */
      public static void main(String[] args) throws SQLException {
          MyPool pool = new MyPool();
          System.out.println("当前连接: " + pool.current_count); // 3

          // 使用连接
          pool.getConnection();
          pool.getConnection();
          Connection con4 = pool.getConnection();
          Connection con3 = pool.getConnection();
          Connection con2 = pool.getConnection();
          Connection con1 = pool.getConnection();

          // 释放连接, 连接放回连接池
  //      pool.realeaseConnection(con1);
          /*
           * 希望：当关闭连接的时候，要把连接放入连接池！【当调用Connection接口的close方法时候，希望触发pool.addLast(con);操作】
           * 把连接放入连接池 解决1：实现Connection接口，重写close方法 解决2：动态代理
           */
          con1.close();

          // 再获取
          pool.getConnection();

          System.out.println("连接池：" + pool.pool.size()); // 0
          System.out.println("当前连接: " + pool.current_count); // 3
      }
  }
  ```

#### （四）实践
1. CRUD
    ```java
    public boolean checkUser(String userName, String userPwd) {
        /** 登陆状态：true--成功，false--失败 */
        boolean result = false;
        /** 连接数据库 */
        Connection conn = null;
        /** 预编译对象 */
        PreparedStatement pstmt = null;
        /** 结果集 */
        ResultSet rs = null;
        /** 使用链接池获取连接 */
        conn = DBUtilDruid.getConnection();
        /** 定义SQL语句 */
        String checkUserSQL = "SELECT * FROM uol_user WHERE username = ? AND userpwd = ?";

        try {
            /** 准备SQL语句/创建一个执行SQL语句的对象 */
            pstmt = conn.prepareStatement(checkUserSQL);
            /** 给参数?赋值 */
            pstmt.setString(1, userName);// 给第一个参数?赋值
            pstmt.setString(2, userPwd);// 给第二个参数?赋值
            /** 执行SQL语句 */
            rs = pstmt.executeQuery();// 执行查询
            // int result = pstmt.executeUpdate();// 执行更新（添加、删除、修改）

            /** 处理执行结果 */
            if (rs.next()) {
                result = true;
            } else {
                result = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 归还连接（不是断掉）
            DBUtilDruid.close(rs, pstmt, conn);
        }
        return result;
    }
    ```
2. 其他SQL语句的执行(DDL等)
    ```java
    String sql = "CREATE TABLE abcdef(id varchar2(10) not null,name varchar(20))";//建表语句
    String sql = "DROP TABLE abcdef";//删表语句
    String sql = "ALTER TABLE abcdef ADD (sex varchar2(1))";//添加类
    String sql = "ALTER TABLE abcdef DROP COLUMN sex";//删除列
    String sql = "ALTER TABLE abcdef MODIFY (sex number(1))";//修改列属性
    String sql = "RENAME abcdef TO ab001";//修改表名
    pstm.execute();//PreparedStatement,返回值boolean类型
    stmt.execute(sql);//Statement
    ```
3. Oracle分页显示：
    ```java
    SELECT *  FROM (SELECT ROWNUM AS rowno, t.*
              FROM emp t
              WHERE   ROWNUM <= 5) table_alias
              WHERE table_alias.rowno >= 1;
    ```
4. 批量删除，批量添加，批量修改
5. 执行DDL语句，创建临时表，通过代码，用完删除
6. 获取元数据
- DatabaseMetaData接口:获取数据库相关信息
  > DatabaseMetaData dbms = conn.getMetaData();//创建
  + getDatabaseProductVersion
  + getDatabaseProductName
  + getDriverName
  + getDriverVersion
  + getUserName
  + getURL
- ResultSetMetaData接口:获取结果集相关信息
  > ResultSetMetaData rsmd = rs.getMetaData();//创建
  + getColumnCount
  + getColumnName(i)
  + getColumnClassName(i)
7. 结果集分页：可滚动的结果集，绝对定位，conn.prepareStrtement(sql, ResultSet.xxx, ResultSet.xxx)，参数一定要写
ORM---双向同步，读（表-内存）改（内存）写（内存-磁盘）

8. 事务：ACID（属性）
- 如果设置了手动提交事务，执行完更新需要提事务

9. 配置：属性文件 Blob和Clob
- CLOB：Character Large Object，大的字符对象
常见场景：保存XML文档
方法：
setAsciiStream(int parameterIndex, InputStream x, long length)
getAsciiStream(String columnLabel)
- BLOB: Binary Large Object,大的二进制对象
常见场景：保存位图
方法：
setBinaryStream(int parameterIndex, InputStream x, int length)
getBinaryStream(String columnLabel)
10. SQL注入攻击（SQL Injection）
    > 简介：
    > 用户输入的字符串中包含了SQL指令，破坏了原SQL语句的原意，从而可以恶意登录
    > 如userName = "1' OR '1'='1"; passWord = "1' OR '1'='1";
    > 防护：
    > 用户输入时，正则验证不允许'='或'出现
    > 接收端判断
- PreparedStatement引入：
  + 继承自Statement接口，stmt能做的pstmt都可以替代
  + SQL中未知内容使用?代替，并使用setString( , )给?设置具体的值，防止了注入的发生
- 预编译的优势：
  + 它会先将SQL语句发送给数据库进行预编译，对于相似的操作语句，他只需要预编译一次，减少编译次数
  + 安全性高，没有SQL注入风险
  + 没有SQL字符串拼接，可读性好
