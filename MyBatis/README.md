## MyBatis
### 一、背景介绍
> 在2010年6月16日，iBATIS团队决定从apache迁出并迁移到Google Code，并更名为MyBatis。目前iBATIS 2.x和MyBatis 3不是100%兼容的，如配置文件的DTD变更，SqlMapClient直接由SqlSessionFactory代替了，包名也有com.ibatis变成org.ibatis等等。

1. MyBatis是一个框架，是一个第三方组件，开源的
2. 作用：用于持久化操作（数据库），是一个ORM工具。
3. 负责数据库操作的事情，MyBatis 底层依赖于JDBC
4. MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案。
5. 相关网站：
- 官网：http://www.mybatis.org
- 中文开发文档：http://www.mybatis.org/mybatis-3/zh/index.html
- 中文官网（国人）：http://www.mybatis.cn/
- MyBatis源码、jar包下载：[参考链接](https://blog.csdn.net/brave_monkey/article/details/79612174)

### 二、ORM是什么
1. 全称：Object Relational Mapping  对象关系映射
2. 理解：Object--Java对象  Relational--Java和数据库  Mapping--映射
2.  类--表   对象--一条记录  属性--字段  内存--硬盘
3. 常见ORM框架：MyBatis、Hibernate、JPA
- [x] MyBatis： 半自动的ORM工具，轻量级ORM工具，需要自己写SQL语句
- [x] Hibernate（冬眠）：全自动，重量级，可以不写SQL语句，灵活性较低，性能较低
- [x] JPA：Java Persistence API的简称,是JDK 5.0注解或XML描述对象－关系表的映射关系，将运行期的实体对象持久化到数据库中
4. 术语：POJO、JavaBean
- [x] POJO：简单的Java对象，实际就是普通JavaBeans是。例如Users类--简单属性和简单方法（com.ychs.uol.vo.User、com.ychs.uol.model.User、com.ychs.uol.do.User）
- [x] Java Bean 命名规则(属性)：
  - 第一个单词的首字母必须小写，且单词长度大于1
  - 第二个单词首字母大写其余小写

### 三、为什么使用MyBatis？
1. 将SQL语句从Java代码中分离出，独立存放，做到解耦的效果，便于维护
2. 减少了代码量

### 四、使用MyBatis
- [x] mybatis 3.5.2 API : [参考链接](http://www.mybatis.org/mybatis-3/zh/apidocs/index.html?tdsourcetag=s_pctim_aiomsg)
> XML:可扩展标记语言

#### 实践步骤
1. 导包(MyBatis的jar包)
2. 两个配置文件
  - jdbc.properties
  - mybatis-config.xml
3. 数据库建表
4. 准备POJO/JavaBean---实体类
5. 写Mapper接口
6. 写配置文件：xxx.xml
  - 注意链接的<类名>--使用全限定的类名（包名+类名）
  - 注意链接的<方法名>还有<方法参数类型>
  - <SQL语句>的书写以及<参数>的获取：#{属性名}
7. Dao实用类
  - 获取工厂
  - 定义接口对象（动态代理模式）
  - 调用接口中的方法
8. Test测试类
  - JUnit的使用
  - Log4j使用
#### 准备
1.xml添删改查`<insert>`、`<delete>`、`<update>`、`<select>`标签属性
  - id="xxxx" ——表示此段sql执行语句的唯一标识，也是接口的方法名称【必须一致才能找到】
  - parameterType="xxxx" ——表示该sql语句中需要传入的参数， 类型要与对应的接口方法的类型一致【可选】
  - resultMap="xxx"—— 定义出参，调用已定义的<resultMap>映射管理器的id值
  - resultType="xxxx"——定义出参，匹配普通Java类型或自定义的pojo【出参类型若不指定，将为语句类型默认类型，如<insert>语句返回值为int】
2. 注意： 至于为何<insert><delete><update> 语句的返回值类型为什么是int，有过JDBC操作经验的朋友可能会有印象，增删改操作实际上返回的是操作的条数（受影响的条数）。而Mybatis框架本身是基于JDBC的，所以此处也沿袭这种返回值类型。

#### （一）添加用户
```java
<!-- 添加用户 -->
<!-- id中的insertUser就是UserMapper接口中的方法名；parameterType的值指的是insertUser方法带的参数类型，使用全限定的类名 -->
<insert id="insertUser" parameterType="com.ychs.uol.model.User">
  INSERT INTO uol_user(userid, username, userpwd, realname, sex, job,
  remark, status)
  VALUES(sys_guid(),#{userName},#{userPwd},#{realName},#{sex},#{job},#{remark},#{status})
  <!-- 特别注意：SQL语句后绝对不能加分号 -->
</insert>
```

#### （二）删除用户
```java
<!-- 删除用户 -->
<delete id="deleteUserByUserid" parameterType="String">
  DELETE FROM users
  WHERE userid=#{userid}
</delete>
```

#### （三）修改用户
```java
<!-- 修改用户 -->
<update id="modifyUser" parameterType="com.ychs.uol.model.User">
  UPDATE uol_user SET
  username = #{userName}, userpwd = #{userPwd},realname =
  #{realName},sex = #{sex},job = #{job},remark = #{remark}, status =
  #{status} WHERE userid = #{userId}
</update>
```

#### （四）查询用户
- 查询所有用户
```java
<!-- 查询所有用户 -->
<select id="selectAllUser" resultMap="userMap">
  SELECT * FROM uol_user
</select>

<!-- 自定义返回结果集类型，命名为：userMap，建立uol_user表字段和User类属性之间的映射关系 -->
<resultMap id="userMap" type="com.ychs.uol.model.User">
    <!-- 主键 -->
    <id property="userId" column="userid" />
    <!-- 非主键 -->
    <result property="userName" column="username" />
    <result property="userPwd" column="userpsw" />
    <result property="realName" column="realname" />
    <result property="sex" column="sex" />
    <result property="job" column="job" />
    <result property="remark" column="remark" />
    <result property="status" column="status" />
</resultMap>
```
#### （五）传参（多个参数）
1. 方式一：#{0}、#{1}、#{2}
    > 注意：不同版本之间使用方式不同，在3.4版本之后使用：#{arg0}、#{arg1}、#{arg2}
    > [参考链接](https://blog.csdn.net/mrliar17/article/details/76079450?tdsourcetag=s_pctim_aiomsg)

- MyBatis3.4版本之前
    ```Java
    <!-- 方式1: 使用序号传参 -->
    <select id="selectBook" resultType="com.ychs.uol.vo.Book">
      SELECT * FROM book WHERE bookname=#{0} AND publisher=#{1}
    </select>
    ```
- MyBatis3.4.4版本之后
    ```Java
    <!-- 方式1: 使用序号传参 -->
    <select id="selectBook" resultType="com.ychs.uol.vo.Book">
      SELECT * FROM book WHERE bookname=#{arg0} AND publisher=#{arg1}
    </select>
    ```
2. 方式二：使用MyBise注解
    ```Java
    //xml
      <!-- 方式2: 使用参数注解@Param -->
      <select id="selectBookByAnnotation"
        resultType="com.ychs.uol.vo.Book">
        SELECT * FROM book WHERE bookname=#{bname} AND publisher=#{pubname}
      </select>

    //dao
      public Book selectBookByAnnotation(@Param("bname") String bookname, @Param("pubname") String publisher) {
          SqlSession sqlSession =DBUtil.getSession();
          Book book = null;
          try {
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            book = bookMapper.selectBookByAnnotation(bookname, publisher);
          } catch (Exception e) {
            e.printStackTrace();
          } finally {
            sqlSession.close();
          }
          return book;
      }
    ```
3. 方式三：使用Map(常用)
    ```Java
    <!-- 方式3: 使用Map传参 -->
    <select id="selectBookByMap" parameterType="java.util.Map"
      resultType="com.ychs.uol.vo.Book">
      SELECT * FROM book WHERE bookname=#{bname} AND publisher=#{pubname}
    </select>
    ```
4. 方式四：传对象(常用)
    ```Java
    <!-- 方式4: 使用JavaBean传参 -->
    <select id="selectBookByBean"
      parameterType="com.ychs.uol.vo.Book" resultType="com.ychs.uol.vo.Book">
      SELECT * FROM book WHERE bookname=#{bookname} AND publisher=#{publisher}
    </select>
    ```

#### （六）多表链接查询
```java
<resultMap id="infoMap" type="com.ychs.uol.model.Info">
  <result property="schoolName" column="schoolname" />
  <result property="deptName" column="deptname" />
  <result property="majorName" column="majorname" />
</resultMap>

<select id="seleteMajorInfo" resultMap="infoMap"
  parameterType="String">
  SELECT s.schoolname, d.deptname, m.majorname FROM
  uol_major m INNER JOIN
  uol_department d ON m.deptid = d.deptid INNER
  JOIN uol_school s ON
  d.schoolid = s.schoolid
  WHERE m.majorname=#{majorName}
</select>
```

#### （七）多条件组合查询
1. 方式一（SQL中写WHERE1=1）
    ```java
    <!-- 多条件组合查询 -->
    <select id="selectLabMember" parameterType="java.util.Map" resultMap="labMemberMap">
        SELECT * FROM uol_labmember WHERE 1=1
        <if test="memberName != null">
        	AND membername LIKE #{memberName}
        </if>
        <if test="grade != null">
        	AND grade = #{grade}
        </if>
        <if test="school != null">
        	AND school = #{school}
        </if>
    </select>
    ```
2. 方式二（使用`<where>`标签）
    ```java
    <!-- 多条件组合查询 -->
    <select id="selectLabMember" parameterType="java.util.Map" resultMap="labMemberMap">
        SELECT * FROM uol_labmember
        <where>
            <if test="memberName != null">
              AND membername LIKE #{memberName}
            </if>
            <if test="grade != null">
              AND grade = #{grade}
            </if>
            <if test="school != null">
              AND school = #{school}
            </if>
        </where>
    </select>
    ```
#### （八）分页显示
1. 方式一：使用MyBatis自带的类

    ```java
    //xml
      <!-- 分页显示，方式一：使用MyBaits自带的类 -->
      <select id="selectUserPage" resultMap="userMap">
        SELECT * FROM uol_user
      </select>

    //dao
      public List<User> selectUserPage(int currPage, int pageSize) {
          List<User> userList = new ArrayList<User>();
          SqlSession sqlSession = DBUtil.getSession();
          // 偏移量，当前页第一条记录的序号（从0开始）
          int offset = (currPage - 1) * pageSize;
          try {
              UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
              userList = userMapper.selectUserPage(new RowBounds(offset, pageSize));
              sqlSession.commit();
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              DBUtil.closeSession(sqlSession);
          }
          return userList;
      }

    ```
2. 方式二：自己写sql(使用伪列)
    ```java
    //xml
      <!-- 分页显示，方式二：自己写SQL语句，通过参数控制 -->
      <select id="selectUserPageSql" resultMap="userMap">
        SELECT * FROM (SELECT
        ROWNUM AS rowno, u.* FROM uol_user u WHERE ROWNUM &lt;= #{arg1})
        WHERE rowno   &gt;= #{arg0}
      </select>

    //dao
      public List<User> selectUserPageSql(int currPage, int pageSize) {
          List<User> userList = new ArrayList<User>();
          SqlSession sqlSession = DBUtil.getSession();
          // 当前页第一条记录的序号（从1开始）
          int begin = (currPage - 1) * pageSize + 1;
          // 当前页最后一条记录的序号
          int end = begin + (pageSize - 1);
          try {
              UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
              userList = userMapper.selectUserPageSql(begin, end);
              sqlSession.commit();
          } catch (Exception e) {
              e.printStackTrace();
          } finally {
              DBUtil.closeSession(sqlSession);
          }
          return userList;
      }
    ```


### 五、使用MyBatis（二）

#### （一）自增主键
- [参考链接](https://blog.csdn.net/xu1916659422/article/details/77921912)
- 主键分类
  - 自然主键：没有实际意义，只是一种唯一标识
    + Oracle :使用序列
    + MySQL：自增
    + 随机数生成主键（随机数生成的种子）
    + UUID：32位的序列
  - 业务主键：带有实际意义，学号，身份证

-  `<selectKey>`标签
    属性|描述
    |:--:|:--|
    |keyProperty|selectKey 语句结果应该被设置的目标属性。如果希望得到多个生成的列，也可以是逗号分隔的属性名称列表。对应实体类中的主键的属性|
    |keyColumn|匹配属性的返回结果集中的列名称。如果希望得到多个生成的列，也可以是逗号分隔的属性名称列表。|
    |resultType|结果的类型。MyBatis 通常可以推算出来，但是为了更加确定写上也不会有什么问题。MyBatis 允许任何简单类型用作主键的类型，包括字符串。如果希望作用于多个生成的列，则可以使用一个包含期望属性的 Object 或一个 Map。|
    |order|这可以被设置为 BEFORE 或 AFTER。如果设置为 BEFORE，那么它会首先选择主键，设置 keyProperty 然后执行插入语句。如果设置为 AFTER，那么先执行插入语句，然后是 selectKey 元素|
    |statementType|与前面相同，MyBatis 支持 STATEMENT（直接操作sql，不进行预编译，获取数据---${xxx}），PREPARED（预处理，参数，进行预编译，获取数据---#{xxx}） 和 CALLABLE（执行存储过程） 语句的映射类型，分别代表 PreparedStatement 和 CallableStatement 类型。|
- 代码：
  ```java
  <!-- 添加用户，主键自增 -->
  <insert id="insertUserKeyAutoInc"
    parameterType="com.ychs.uol.model.User">
    <selectKey keyProperty="userId" resultType="String"
      keyColumn="userNo" order="BEFORE">
      SELECT myseq.nextval as userNo FROM dual
      <!-- SELECT MAX(userid)+1 AS userNo FROM uol_user -->
    </selectKey>
    INSERT INTO uol_user(userid, username, userpwd, realname, sex, job,
    remark, status)
    VALUES(#{userId},#{userName},#{userPwd},#{realName},#{sex},#{job},#{remark},#{status})
  </insert>
  ```

#### （二）批量删除
- `<foreach>`标签

  |属性|描述|
  |:--:|:--:|
  |collection|指定输入对象中集合属性<br>|
  |item|每次遍历生成的对象|
  |open|开始遍历时拼接的串|
  |close|结束遍历时两个对象需要拼接的串|
  |separator|表示隔离符号|
  |index|集合迭代位置|
- collection属性详解
  - 如果传入的是单参数且参数类型是一个List的时候，collection属性值为list
  - 如果传入的是单参数且参数类型是一个array数组的时候，collection的属性值为array
  - 如果传入的参数是多个的时候，我们就需要把它们封装成一个Map了，当然单参数也可以封装成map，实际上如果你在传入参数的时候，在breast里面也是会把它封装成一个Map的，map的key就是参数名，所以这个时候collection属性值就是传入的List或array对象在自己封装的map里面的key
- 代码：
  ```java
  <!-- 批量删除用户 -->
  <delete id="deleteUserBatch" parameterType="java.util.List">
      DELETE FROM uol_user WHERE userid IN
      <foreach collection="list" item="item" open="(" separator="," close=")">
          #{item}
      </foreach>
  </delete>
  ```

#### （三）选择一个条件进行查询
- 使用`<choose>`、`<when>`、`<otherwise>`标签
  ```java
  <!-- 多条件查询用户（只能使用一个条件） -->
  <select id="selectUserMulCondition"
      parameterType="java.util.Map" resultMap="userMap">
      SELECT * FROM uol_user WHERE 1 =1
      <choose>
          <when test="userName != null">
              AND username = #{userName}
          </when>
          <when test="realName != null">
              AND realname = #{realName}
          </when>
          <when test="sex != null">
              AND sex = #{sex}
          </when>
          <otherwise>
              AND sex = '女'
          </otherwise>
      </choose>
  </select>
  ```
####（四）更新时sql动态拼装
- 使用`<set>`、`<if>`标签
  ```java
  <!-- 动态SQL: set，动态包含需要更新的列，舍去其它的 -->
  <update id="updateUserIfNecessary"
      parameterType="com.ychs.uol.model.User">
      UPDATE uol_user
      <set>
          <if test="userName != null">username=#{userName},</if>
          <if test="userPwd != null">userpsw=#{userPwd},</if>
          <if test="realName != null">realname=#{realName},</if>
          <if test="sex != null">sex=#{sex},</if>
          <if test="job != null">job=#{job},</if>
          <if test="remark != null">remark=#{remark},</if>
          <if test="status != null">status=#{status}</if>
      </set>
      WHERE userid=#{userId}
  </update>
  ```

#### （四）模糊查询
1. 使用`${}`直接获取，不经过预编译
    ```java
      <!-- 模糊查询，第一种写法 realname LIKE '%xxx%' 用$——不预编译 -->
      <select id="selectUserLike" parameterType="String" resultMap="userMap">
        SELECT * FROM uol_user WHERE username LIKE '%${words}%'
      </select>
    ```

2. 使用`||`链接
    ```java
    <!-- 模糊查询，第二种写法,使用Oracle字符串连接符|| -->
    <select id="selectUserLike" parameterType="String" resultMap="userMap">
      SELECT * FROM uol_user WHERE username LIKE '%'||#{words}||'%'
    </select>
    ```

3. 使用`CONCAT()`数据库函数链接
    ```java
    <!-- 模糊查询，第三种写法 -->
    <select id="selectUserLike" parameterType="String" resultMap="userMap">
      SELECT * FROM uol_user WHERE username LIKE CONCAT(CONCAT('%',#{words}),'%')
    </select>
    ```

#### （五）级联删除
1. 调用接口中方法方式
    ```java
    public int deleteSchool(String schoolName) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            // 定义三个Mapper
            SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
            // 删除专业
            majorMapper.deleteMajor(schoolName);
            // 删除系部
            departmentMapper.deleteDepartment(schoolName);
            // 删除学校
            result = schoolMapper.deleteSchool(schoolName);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return result;
    }
    ```
2. 使用触发器
- 使用一个触发器
  ```sql
  create or replace TRIGGER DELETE_SCHOOL
  BEFORE DELETE ON uol_school
  FOR EACH ROW
  DECLARE
  pragma autonomous_transaction;-- 加入一个自治事务
  BEGIN
      DELETE uol_major WHERE deptid IN (SELECT deptid FROM uol_department WHERE schoolid IN (SELECT schoolid FROM uol_school WHERE schoolname = :old.schoolname));
      DELETE uol_department WHERE schoolid IN (SELECT schoolid FROM uol_school WHERE schoolname = :old.schoolname);
      commit;
  END;
  ```
- 使用两个触发器
  ```sql
  create or replace TRIGGER DELETE_SCHOOL
  BEFORE DELETE ON uol_school
  FOR EACH ROW
  BEGIN
      DELETE uol_department WHERE schoolid = :old.schoolid;
  END;
  ```
  ```sql
  create or replace TRIGGER DELETE_DEPARTMENT
  BEFORE DELETE ON uol_department
  FOR EACH ROW
  BEGIN
      DELETE uol_major WHERE deptid = :old.deptid;
  END;
  ```


### 六、FAQ：
#### （一）uuid是什么
- UUID 是 通用唯一识别码（Universally Unique Identifier）的缩写
- UUID是由一组32位数的16进制数字所构成，所以UUID理论上的总数为16^32=2^128，约等于3.4 x 10^38。也就是说若每纳秒产生1兆个UUID，要花100亿年才会将所有UUID用完。
- 目前最广泛应用的UUID，是微软公司的全局唯一标识符（GUID）
#### （二）xml文件里如何使用‘>’‘<’ ？
- [参考链接](https://blog.csdn.net/qq_26599807/article/details/52126377)
- 使用转义字符‘>’---`&gt;`,  ‘<’---`&lt;`
#### （三）Mybatis常用的xml标签
- [参考链接](https://blog.csdn.net/qq_41426442/article/details/79663467)
#### （四）ssh和ssm的区别
- [参考链接](https://blog.csdn.net/xxk666/article/details/83446702)
- ssh通常使用 Struts2为控制器(controller) ，spring 为事务层(service)， hibernate 负责持久层（dao）
- ssm通常使用 springMVC为控制器(controller) ，spring 为事务层(service)， MyBatis 负责持久层（dao）
