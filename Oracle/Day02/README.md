### Oracle第二日记录 数据库设计
#### C/S结构（Client/Server）
1. 服务器端
	- SQL Developer 客户端
    - PL/SQL Developer 第三方厂家开发的客户端（付费、商业版）

#### 服务 [Oracle 11g数据库的服务](https://www.jb51.net/article/53649.htm)
1. —>打开服务器：Window+R 输入:`services.msc` 或者：我的电脑->管理->服务和应用程序;
2. 有两个服务必须开启：一个数据库服务`OracleServiceORCL`-Oracle核心服务，一个是监听器服务(OracleOraDb11g_home1TNSListener);
3. 当数据库连接不上的时候，要核实一下两个服务是否打开;
4. 监听服务无法启动，我们需要重建监听:使用Net Configuration Assistant(网络配置助手);
5. 没有ORCL服务或者已有的库不能用了再或者需要新建一个库：使用Database Configuration Assistant(数据库配置助手);


#### 目录结构
1. product
2. oradata->orcl数据库对应目录
 	- ctl:Oracle的控制文件
 	- dbf:Oracle的数据文件
 	- log:Oracle日志文件

#### 默认用户
1. sys:角色-sysdba(管理员)
2. system:角色-sysdba
3. scott:角色(一般用户)


#### sqlplus
1. oracle客户端（Dos窗口）：
	- 进入数据库:`sqlplus`
	- 普通用户:`scott`
	- 管理员登陆:`sys /as sysdba` `system /as sy6sdba`

#### 数据库设计
1. 工具：PowerDesigner、ERWin
2. 安装PD

#### 数据库设计步骤
1. 数据需求分析
2. 逻辑设计(ER图)  CDM:概念数据模型
	- 实体:Entity
	  - 主键：Primary Key(非空且唯一)
	- 属性：Attribute
	- 实体关系:Entity Relationship
		1. 一对一（1:1）
		2. 一对多(1:N)
		3. 多对多(M:N)
		4. 强制关系与非强制关系
	- 逻辑设计步骤
		1. 根据需求确定实体:一定找待开发系统相关实体（实体都是名词）；
        2. 根据实体确定实体属性：属性类型、长度、非空约束、主键约束；
        3. 确定实体之间的关系
    - 属性和实体名字注意事项：
        1. 不要使用Oracle关键字（Oracle不区分大小写） eg:user,uid,usid，order,desc,from,to,level,group都不能取

3. 物理设计 （表结构）PDM：物理数据模型--->关联到某个数据库
	- 表（table）：用于存放数据(ER图中的多对多的关系，再生成物理模型时会被分解两个一对多关系，产生了中间表)。
		- 一行数据-->记录
		- 一列数据（属性）-->字段
		- 五种约束
			1. 非空约束(NOT NULL)：数据不能为空
			2. 唯一约束(UNIQUE)：数据不能重复，Oracle会自动为唯一性约束的字段创建相应的唯一性索引。
			3. 主键约束(PRIMARY KEY):**非空且唯一**，只允许一个主键，主键可以是单个字段或多字段的组合（联合主键），Oracle会自动为主键字段创建对应的唯一性索引。
       		- 联合主键：当两个数据表形成的是多对多的关系，那么需要通过两个数据表的主键来组成联合主键，就可以确定每个数据表的其中一条记录了
           	- 复合主键：在一个数据表中通过多个字段作为主键来确定一条记录，那么，多个字段组成的就是复合主键 
			4. 外键约束(FOREIGN KEY)：建立和其他表的联系，取值可以为空（非强制关系），且外键这一列一定出现在（一对多关系中）多的那一侧。
			5. 检查(CHECK)：
		- VarChar与Char区别：
		  1. 定长与变长
          2. char效率高
4. 优化：规范化与反规范化
	- 范式（共六个）：第一范式（1NF）、第二范式（2NF）、第三范式（3NF）、巴斯-科德范式（BCNF）、第四范式(4NF）和第五范式（5NF，又称完美范式）
	- 什么是范式：用来优化数据数据存储方式的规范；
	- 工程上最高可以达到3NF；
	- 用友软件的面试题：数据库的三范式分别解决什么问题？
	[数据库范式](https://www.cnblogs.com/lca1826/p/6601395.html)
    [详解数据库的第一范式、第二范式、第三范式、BCNF范式](https://blog.csdn.net/gui951753/article/details/79609874)
		1. 第一范式：符合1NF的关系中的每个属性都不可再分
		2. 第二范式：消除非主属性对码的部分函数依赖
		3. 第三范式：消除非主属性对码的传递函数依赖
		4. BCNF范式：消除主属性对于码的部分与传递函数依赖
	- 为什么要规范化？答案：消除冗余数据；
	- Oracle（分为两部分）开发+管理----开发容易管理难；
5. 数据库端的开发



















