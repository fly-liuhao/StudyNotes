## MyBatis面试题

#### （一）什么是MyBatis?
1. Mybatis是一个半ORM（对象关系映射）框架，它内部封装了JDBC，开发时只需要关注SQL语句本身，不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程。程序员直接编写原生态sql，可以严格控制sql执行性能，灵活度高。

2. MyBatis 可以使用 XML 或注解来配置和映射原生信息，将 POJO映射成数据库中的记录，避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。

3. 通过xml 文件或注解的方式将要执行的各种 statement 配置起来，并通过java对象和 statement中sql的动态参数进行映射生成最终执行的sql语句，最后由mybatis框架执行sql并将结果映射为java对象并返回。（从执行sql到返回result的过程）。

#### （二）Mybatis的优点
1. 把sql语句从数据库中独立出来，解除sql与程序代码之间耦合，便于代码的维护和管理。
2. 编写原生SQL语句，更加的灵活。
3. 提供XML标签（where、set、if、choose、when、otherwise、foreach、trim、bind），支持编写动态SQL语句，并可重用。
4. 封装了底层的JDBC，API调用，很好的与各种数据库兼容，并且能将结果自动的转化成JavaBean对象（结果集与java对象自动映射），简化了数据库编程的重复工作。
5. 能够与Spring很好的集成。

#### （三）Mybatis的缺点
1. SQL语句的编写工作量较大，尤其当字段多、关联表多时，对开发人员编写SQL语句的功底有一定要求。
2. SQL语句依赖于数据库，导致数据库移植性差，不能随意更换数据库。

#### （四）MyBatis适用场合
1. MyBatis专注于SQL本身，是一个足够灵活的DAO层解决方案。
2. 对性能的要求很高，或者需求变化较多的项目，如互联网项目，MyBatis将是不错的选择。

#### （五）MyBatis核心类的作用?
> [参考链接](https://www.cnblogs.com/WHL5/p/8675281.html)
> 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。

| 类名 | 作用 |
| :-------------: | :------------- |
| SqlSessionFactoryBuilder | 读取全局配置文件，得到数据源信息，创建连接工厂SqlSessionFactory。它的特点是，当创建了SqlSessionFactory对象之后，这个类就不需要了。因此，它的最佳范围是存在于方法体内，也就是局部变量。 |
| SqlSessionFactory | 连接工厂；创建SqlSession实例的工厂。它的特点是，SqlSessionFactory对象一旦被创建，就无法销毁或者再创建，是单例的。因此，它存在于应用程序的整个运行生命周期 |
| SqlSession | 会话对象类，是一个接口，SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。SqlSession对应着一次数据库会话，所以每次访问数据库时都需要在SqlSessionFactory实例的openSession()方法中创建它。但一个SqlSession会话也可以执行多次SQL语句。注意：一个连接不能让多个线程同时使用,因为是非线程安全的，每个线程都应该有一个SqlSession的实例来完成对数据库的操作 |
| Mapper      | 1.映射类，跟映射关系对应，是从SqlSession中获取的。<br/>2.作为接口的代理类 <br/>3.将传入的接口类型与映射的XML文件关联起来，接口的实现是基于XML配置文件中的SQL实现，生成代理类对象 <br/>4.函数：session.getMapper(接口 class 实例) |

#### （六）MyBatis 的工作流程或运行原理?
1. 通过SqlSessionFactoryBuilder从mybatis-config.xml配置文件中构建出SqlSessionFactory。
2. SqlSessionFactory开启一个SqlSession，通过SqlSession实例获得Mapper对象并且运行Mapper映射的Sql语句。
3. 完成数据库的CRUD操作和事务提交，关闭SqlSession。


#### （七）MyBatis跟Hibernate的比较
1. MyBatis 是半自动化的,需要我们手动的编写sql。
2. Hibernate是全自动化的,只要配置映射文件,可以为我们动态的生成sql。

#### （八）`#{}`和`${}`的区别是什么？
1. `${}`：简单字符串替换（属于静态文本替换），把${}直接替换成变量的值，不做任何转换，这种是取值以后再去编译SQL语句（非预编译）。一种使用情况：用于传入数据库对象，比如表名。
2. `#{}`：预编译处理，sql中的#{}替换成 ‘?’ （占位符），补全预编译语句，有效的防止Sql语句注入，这种取值是编译好sql语句再取值。

#### （九）Mybatis是如何进行分页的？分页插件的原理是什么？
1. 使用 MyBatis 提供的 RowBounds 对象进行分页。
2. 自己写分页 sql 语句实现分页。
3. 使用分页插件：分页插件的基本原理是使用Mybatis提供的插件接口，实现自定义插件，在插件的拦截方法内拦截待执行的sql，然后重写sql，根据dialect方言，添加对应的物理分页语句和物理分页参数。eg：`select * from student，拦截sql后重写为：select t.* from （select * from student）t limit 0，10`

#### （十）什么是MyBatis的接口绑定,有什么好处
- 答：接口映射就是在IBatis中任意定义接口,然后把接口里面的方法和SQL语句绑定，我们直接调用接口方法就可以,这样比起原来了SqlSession提供的方法我们可以有更加灵活的选择和设置。

#### （十一）接口绑定有几种实现方式,分别是怎么实现的?
1. 接口绑定有两种实现方式：
- 一种是通过注解绑定，就是在接口的方法上面加上@Select@Update等注解里面包含Sql语句来绑定。
- 另外一种就是通过xml里面写SQL来绑定，在这种情况下，要指定xml映射文件里面的namespace必须为接口的全路径名。

#### （十二）什么情况下用注解绑定,什么情况下用xml绑定
答：
- 当Sql语句比较简单时候,用注解绑定。
- 当SQL语句比较复杂时候，用xml绑定，一般用xml绑定的比较多。

#### （十三）MyBatis里面的动态Sql是怎么设定的?用什么语法?
答：MyBatis里面的动态Sql一般是通过if节点来实现，通过OGNL语法来实现，但是如果要写的完整，必须配合where、trim节点，where节点是判断包含节点有内容就插入where，否则不插入，trim节点是用来判断如果动态语句是以and 或or开始，那么会自动把这个and或者or取掉 。

#### （十四）Xml映射文件中，除了常见的select|insert|updae|delete标签之外，还有哪些标签？
- 答：还有很多其他的标签，<resultMap>、<parameterMap>、<sql>、<include>、<selectKey>，加上动态sql的9个标签，trim | where | set | foreach | if | choose | when | otherwise | bind 等，其中<sql>为sql片段标签，通过<include>标签引入sql片段，<selectKey>为不支持自增的主键生成策略标签。

#### （十五）Mybatis动态sql是做什么的？都有哪些动态sql？能简述一下动态sql的执行原理不？
答：
- Mybatis动态sql可以让我们在Xml映射文件内，以标签的形式编写动态sql，完成逻辑判断和动态拼接sql的功能，Mybatis提供了9种动态sql标签trim|where|set|foreach|if|choose|when|otherwise|bind。
- 其执行原理为，使用OGNL从sql参数对象中计算表达式的值，根据表达式的值动态拼接sql，以此来完成动态sql的功能。

#### （十六）Mybatis是如何将sql执行结果封装为目标对象并返回的？都有哪些映射形式？
答：
- 第一种是使用标签，逐一定义列名和对象属性名之间的映射关系。
- 第二种是使用sql列的别名功能，将列别名书写为对象属性名，比如T_NAME AS NAME，对象属性名一般是name，小写，但是列名不区分大小写，Mybatis会忽略列名大小写，智能找到与之对应对象属性名，你甚至可以写成T_NAME AS NaMe，Mybatis一样可以正常工作。有了列名与属性名的映射关系后，Mybatis通过**反射**创建对象，同时使用反射给对象的属性逐一赋值并返回，那些找不到映射关系的属性，是无法完成赋值的。

#### （十七）Mybatis的Xml映射文件中，不同的Xml映射文件，id是否可以重复？
答：
- 不同的Xml映射文件，如果配置了namespace，那么id可以重复；如果没有配置namespace，那么id不能重复；毕竟namespace不是必须的，只是最佳实践而已。

- 原因就是namespace+id是作为Map<String, MappedStatement>的key使用的，如果没有namespace，就剩下id，那么，id重复会导致数据互相覆盖。有了namespace，自然id就可以重复，namespace不同，namespace+id自然也就不同。

#### （十八）Mybatis映射文件中，如果A标签通过include引用了B标签的内容，请问，B标签能否定义在A标签的后面，还是说必须定义在A标签的前面？
答：虽然Mybatis解析Xml映射文件是按照顺序解析的，但是，被引用的B标签依然可以定义在任何地方，Mybatis都可以正确识别。
原理是，Mybatis解析A标签，发现A标签引用了B标签，但是B标签尚未解析到，尚不存在，此时，Mybatis会将A标签标记为未解析状态，然后继续解析余下的标签，包含B标签，待所有标签解析完毕，Mybatis会重新解析那些被标记为未解析的标签，此时再解析A标签时，B标签已经存在，A标签也就可以正常解析完成了。



3. ORM 思想是什么，有什么好处？
	- 将数据库代码和Java代码分离，实现解耦，便于维护
	- [参考文章](https://blog.csdn.net/orecle_littleboy/article/details/82458956)
4. 常见的ORM框架有哪些？
	- MyBatis：流行，在SSM中使用
	- Hibernate：sql固定生成，不够灵活。
	- JPA：java持久化API
	- [SSH和SSM区别](https://blog.csdn.net/xxk666/article/details/83446702)

5. MyBatis中使用到哪些设计模式？
- 工厂模式
- 代理模式（动态代理）

两种调用sql方式
  1.直接通过sqlSesson调用添删改查方法，带有侵入性，不能面向接口编程
  2. 使用接口来进行
  3. 使用注解：没有xml，零配置，但是改动需要编译

### 进阶面试题
#### （一）MyBatis比IBatis比较大的几个改进是什么
1. 有接口绑定,包括注解绑定sql和xml绑定Sql ,
2. 动态sql由原来的节点配置变成OGNL表达式,
3. 在一对一，一对多的时候引进了association,在一对多的时候引入了collection节点,不过都是在resultMap里面配置

#### （二）MyBatis实现一对一有几种方式?具体怎么操作的
答：有联合查询和嵌套查询，分别如下
- 联合查询是几个表联合查询,只查询一次，通过在resultMap里面配置association节点配置一对一的类就可以完成。
- 嵌套查询是先查一个表,根据这个表里面的结果的外键id,去再另外一个表里面查询数据,也是通过association配置,但另外一个表的查询通过select属性配置。

#### （三）IBatis和MyBatis在核心处理类分别叫什么
答：
- IBatis里面的核心处理类交SqlMapClient
- MyBatis里面的核心处理类叫做SqlSession

#### （四）讲下MyBatis的缓存
答：MyBatis的缓存分为一级缓存和二级缓存，分别如下：

- 一级缓存放在session里面，默认就有。
- 二级缓存放在它的命名空间里，默认是打开的。使用二级缓存属性类需要实现Serializable序列化接口(可用来保存对象的状态),可在它的映射文件中配置

#### （五）最佳实践中，通常一个Xml映射文件，都会写一个Dao接口与之对应，请问，这个Dao接口的工作原理是什么？Dao接口里的方法，参数不同时，方法能重载吗？
答：
- Dao接口，就是人们常说的 Mapper 接口，接口的全限名，就是映射文件中的namespace的值，接口的方法名，就是映射文件中 MappedStatement 的id值，接口方法内的参数，就是传递给sql的参数。Mapper接口是没有实现类的，当调用接口方法时，接口全限名+方法名拼接字符串作为key值，可唯一定位一个MappedStatement，举例：com.mybatis3.mappers.StudentDao.findStudentById，可以唯一找到namespace为com.mybatis3.mappers.StudentDao下面id = findStudentById的MappedStatement。在Mybatis中，每一个`<select>、<insert>、<update>、<delete>`标签，都会被解析为一个MappedStatement对象。
- Dao接口里的方法，是不能重载的，因为是全限名+方法名的保存和寻找策略。
- Dao接口的工作原理是JDK动态代理，Mybatis运行时会使用JDK动态代理为Dao接口生成代理proxy对象，代理对象proxy会拦截接口方法，转而执行MappedStatement所代表的sql，然后将sql执行结果返回。

#### （六）简述Mybatis的插件运行原理，以及如何编写一个插件。
答：
- Mybatis仅可以编写针对ParameterHandler、ResultSetHandler、StatementHandler、Executor这4种接口的插件，Mybatis使用JDK的动态代理，为需要拦截的接口生成代理对象以实现接口方法拦截功能，每当执行这4种接口对象的方法时，就会进入拦截方法，具体就是InvocationHandler的invoke()方法，当然，只会拦截那些你指定需要拦截的方法。
- 实现Mybatis的Interceptor接口并复写intercept()方法，然后在给插件编写注解，指定要拦截哪一个接口的哪些方法即可，记住，别忘了在配置文件中配置你编写的插件。

#### （七）Mybatis执行批量插入，能返回数据库主键列表吗？
- 答：能，JDBC都能，Mybatis当然也能。

#### （八）Mybatis是否支持延迟加载？如果支持，它的实现原理是什么？
答：
- Mybatis仅支持association关联对象和collection关联集合对象的延迟加载，association指的就是一对一，collection指的就是一对多查询。在Mybatis配置文件中，可以配置是否启用延迟加载lazyLoadingEnabled=true|false。

- 它的原理是，使用CGLIB创建目标对象的代理对象，当调用目标方法时，进入拦截器方法，比如调用a.getB().getName()，拦截器invoke()方法发现a.getB()是null值，那么就会单独发送事先保存好的查询关联B对象的sql，把B查询上来，然后调用a.setB(b)，于是a的对象b属性就有值了，接着完成a.getB().getName()方法的调用。这就是延迟加载的基本原理。

#### （九）Mybatis中如何执行批处理？
- 答：使用BatchExecutor完成批处理。

#### （十）Mybatis都有哪些Executor执行器？它们之间的区别是什么？
答：
- Mybatis有三种基本的Executor执行器，SimpleExecutor、ReuseExecutor、BatchExecutor。
- SimpleExecutor：每执行一次update或select，就开启一个Statement对象，用完立刻关闭Statement对象。
- ReuseExecutor：执行update或select，以sql作为key查找Statement对象，存在就使用，不存在就创建，用完后，不关闭Statement对象，而是放置于Map<String, Statement>内，供下一次使用。简言之，就是重复使用Statement对象。
- BatchExecutor：执行update（没有select，JDBC批处理不支持select），将所有sql都添加到批处理中（addBatch()），等待统一执行（executeBatch()），它缓存了多个Statement对象，每个Statement对象都是addBatch()完毕后，等待逐一执行executeBatch()批处理。与JDBC批处理相同。
- 作用范围：Executor的这些特点，都严格限制在SqlSession生命周期范围内。

#### （十一）Mybatis中如何指定使用哪一种Executor执行器？
答：
- 在Mybatis配置文件中，可以指定默认的ExecutorType执行器类型，也可以手动给DefaultSqlSessionFactory的创建SqlSession的方法传递ExecutorType类型参数。

#### （十二）Mybatis是否可以映射Enum枚举类？
答：
- Mybatis可以映射枚举类，不单可以映射枚举类，Mybatis可以映射任何对象到表的一列上。映射方式为自定义一个TypeHandler，实现TypeHandler的setParameter()和getResult()接口方法。TypeHandler有两个作用，一是完成从javaType至jdbcType的转换，二是完成jdbcType至javaType的转换，体现为setParameter()和getResult()两个方法，分别代表设置sql问号占位符参数和获取列查询结果。

#### （十三）简述Mybatis的Xml映射文件和Mybatis内部数据结构之间的映射关系？
- 答：Mybatis将所有Xml配置信息都封装到All-In-One重量级对象Configuration内部。在Xml映射文件中，<parameterMap>标签会被解析为ParameterMap对象，其每个子元素会被解析为ParameterMapping对象。<resultMap>标签会被解析为ResultMap对象，其每个子元素会被解析为ResultMapping对象。每一个`<select>、<insert>、<update>、<delete>`标签均会被解析为MappedStatement对象，标签内的sql会被解析为BoundSql对象。
