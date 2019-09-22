## 第一节：Web应用服务器
### 一、什么是Web应用服务器
- 随着Internet的发展壮大,“主机/终端”或“客户机/服务器”的传统的应用系统模式已经不能适应新的环境,于是就产生了新的分布式应用系统,相应地,新的开发模式也应运而生，即所谓的“浏览器/服务器”结构、“瘦客户机”模式。应用服务器便是一种实现这种模式核心技术。
- Web应用程序驻留在应用服务器(Application Server)上。应用服务器为Web应用程序提供一种简单的和可管理的对系统资源的访问机制。它也提供低级的服务，如HTTP协议的实现和数据库连接管理。Servlet容器仅仅是应用服务器的一部分。除了Servlet容器外，应用服务器还可能提供其他的Java EE(Enterprise Edition)组件，如EJB容器，JNDI服务器以及JMS服务器等。

### 二、常见的Web应用服务器
- Tomcat：来自于Apache组织
- Weblogic：美国的BEA,被Oracle收购，收费
- Websphere：来自IBM,付费的
- JBoss：RedHat（生产Linux厂家之一） 开源免费

### 三、Tomcat
> Apache组织
> Apache软件基金会（也就是Apache Software Foundation，简称为ASF），是专门为运作一个开源软件项目的 Apache 的团体提供支持的非盈利性组织，这个开源软件项目就是 Apache 项目。这个组织把自己作为有着相同目标的开发者与用户的团体，而不是简单的共享在一个服务器上的一组项目的组织团体。在它所支持的 Apache 项目与子项目中，所发行的软件产品都遵循 Apache许可证（Apache License）。
> Tomcat
> Maven
> XML
#### （一）背景介绍
1. 官网：tomcat.apache.org（来自于apache组织，开源的）
2. 是什么？
- 是一个Web**应用**服务器： [参考链接](https://blog.csdn.net/zuochao_2013/article/details/80857333)
- 也是一个Servlet的容器,服务于Servlet(服务器端的小程序)
3. 作用：
    - 部署我们开发好的Web项目，用户通过浏览器访问我们的项目。
    - 把JSP网页编译成HTML,便于浏览器进行显示
4. 调试输出包：com-loging,一种日志信息包，提示信息都为红色
#### （二）Tomcat目录结构：
- apache-tomcat-8.5.43\conf\server.xml中找到8080，更改端口号
- conf：用于配置Tomcat
- lib：Tomcat服务器的jar包
- webapps：放置部署到服务器的项目，Web应用程序
- work目录：JSPA网页被Tomcat编译成.java文件，该目录下放置的就是编出出来的JSP网页。
####（三）web服务器和应用服务器的区别
[参考链接](https://blog.csdn.net/zuochao_2013/article/details/80857333)

#### （四）FAQ
- 端口被占用：
  + eclipse中，双击tomcat，编辑HTTP端口号，四位数字
- 提示超时（time outs）
  + eclipse中，双击tomcat，编辑Timeouts，增大时间
### 四、面试题
1. 什么是 Servlet Container
[参考链接](https://www.cnblogs.com/hustdc/p/8081109.html)
2. Servlet Container的作用是什么？
- web应用服务器
- 接收用户/浏览器的请求，执行JSP网页


## 第二节：JSP
### 一、背景介绍
- 动态网页(JSP,ASP,PHP)
- 静态网页（HTM,HTML）
- JSP：JAVA Server Pages---Java服务端页面
- JSP、Servlet属于Java EE范畴，是Jave EE标准技术（ORACLE维护）
- 主要作用：View层，主要通过图形化的界面显示给用户与用户交互
- `<% %>`：JSP的基本语法，Page指令
- 可以导包，但不推荐使用`<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" imports="java.util.*"%>`
- JSP网页浏览器是不能直接执行的，必须由Tomcat编译成.java文件，然后将一些信息发挥浏览器，Tomcat发给浏览器的内容就是：CSS、JS、HTML
- JSP的动态包含和静态包含
- Jsp的执行过程
  + jsp---java---class---html
  + jsp的本质就是一个Servlet
- JSP文件结构
  ```java
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
  </head>
  <body>

  </body>
  </html>
  ```
### 二、JSP的内置对象
>（直接用，不用创建）【9种】
1. page：代表当前网页，声明周期就是当前页
2. request：请求
3. response：响应
4. sesson---HttpSesson：会话,一个上网者一个，通过sessonid标识
5. application---ServletContext：服务器启动到服务器关闭
6. out：out.print()输出
7. config：配置
8. pageContext：页面上下文，基本不用
9. exception：异常
### 三、使用的技术
#### （一）使用标记/标签来实现（JSTL、EL）
> 用标签替代网页上的Java代码
> https://www.runoob.com/jsp/jsp-jstl.html
1. 导包
- jstl.jar
- standard.jar
2. 使用
- `${}`用来取Servlet转发回到数据
- `<c:forEach>`、`<c:if>` [用法参考](https://www.cnblogs.com/cai170221/p/8035925.html)
- JSTL可能出现的异常：[参考链接](https://blog.csdn.net/qq_25343557/article/details/76727435?tdsourcetag=s_pctim_aiomsg)

#### （二）AJAX
1. Ajax概念
- Ajax全称为“Asynchronous JavaScript and XML” ，异步的JavaScript和XML
- Ajax并不是一门新的语言或技术，它实际上是几项技术按一定的方式组合在一起，在共同的协作中发挥各自的作用。
2. Ajax所使用的技术包括：
- 技术：JavaScript、XML、CSS、XMLHttpRequest、JSON
- 异步：发送请求以后，不等结果，由回调函数处理。
- JavaScript:向服务器发送请求，获得返回结果，更新页面
- XML：用来封装数据
- XMLHttpRequest：进行异步数据读取
3. 使用Ajax优势
- 不需要安装插件支持
- 局部刷新、提高用户的体验度，数据从服务器商加载
- 减轻服务器和带宽的负担
4. 核心对象：XMLHttpRequest
- 通过该对象向服务器发送请求。
- 它是异步请求（无需刷新页面便可向服务器传输或读写数据）的技术，所有现代浏览器都支持（Chrome、IE5+）
7. 如何创建XMLHttpRequest对象
- IE7.0以下是以ActiveXObject的方式引入XMLHttpRequest对象的，创建方式如下：
  ```java
  //IE5.0 IE6.0
  xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
  ```
- 其它浏览器比如 IE7.0+，Firefox、chrome等都支持原生的XMLHttpRequest对象，创建方式如下：
  ```java
  xmlHttpReq = new XMLHttpRequest();
  ```
- 通用的创建方式
  ```java
  var xmlHttp;//声明一个保存XMLHttpRequest的变量
  function createXHR(){
  	if(windows.ActiveObject){
  		xmlHttp = new ActiveObject("Microsoft XMLHTTP");//IE5,IE6
  	}else{
  	xmlHttp = new XMLHttpRequest();//IE7.0+ 以及其它浏览器
  	}
  }
  ```
8. XMLHttpRequest对象的属性与方法
- 方法
  ```java
  // method参数：设置请求类型，主要有get和post请求
  // url参数：请求地址，可以是相对地址，也可以是绝对地址
  // asynchronous参数：默认true为异步请求，false为同步请求
  xhr.open(method,url,asynchronous);用来向服务器建立连接

  // 参数：提交的内容。
  // POST方式:data就是提交的参数，send(username=root&password=abc123);
  // GET方式:send(null)
  send(data):发送请求
  ```
- 属性
  ```java
  // onreadystatechange:设置状态改变时的回调函数，回调函数用来获取服务器数据。
  onreadystatechange=function(){
    // TODO
  }

  // 在收到服务器端响应后，响应的数据会自动填充到XHR对象的属性中
  // 当请求完成加载（readyState值为4）并且响应已经成功（status值为200）时，就可以处理服务端的返回结果了。
  [readyState]:服务器状态响应
    状态码：
  　　0：未初始化
  　　1：正在加载
  　　2：加载完成
  　　3：请求进行中
  　　4：请求完成

  [responseText]:服务器返回的数据(文本格式)

  [responseXML]:服务器返回的数据（XML格式）
  ```
9. 使用XMLHttpRequest的步骤
    ```java
    1)创建XMLHttpRequest对象

    2）设置请求的方法及URL
    xhr.open("GET/POST","url",true/false); //true表示异步请求，false表示同步请求

    3) 设置状态改变时的回调函数
    　　　　xhr.onreadystatechange=function(){
            // TODO
           }
    　　　　0:未初始化
    　　　　1:正在加载
    　　　　2:加载完成
    　　　　3：请求进行中
    　　　　4：请求完成
    4）发送请求
    　　　　xhr.send(data),
    　　　　如果为post提交，则data为提交的数据，如果为get提交，则参数为null即可。
    ```
### 四、CSS前端框架模板
- 饿了吗Element
- MUI
- LayUI
- jQuery
- Easy UI
- 妹子 UI
- H UI


## 第三节：Servlet
### 一、背景介绍
1. 服务器端小程序（service + let（传单））
2. 使用java编写
3. 依赖于Tomcat、和JDK
4. 充当控制层（Controller）,Jsp网页和Service之间的桥梁，处理用户请求。
    ```java
    JSP(HTML-vue)---Servlet(Spring)---Service(Spring MVC)---Dao(MyBatis)---DB
    ```
5. Servlet和JSP有何区别和联系
- 什么是servlet？
  （1）Servlet是一种服务器端的Java应用程序，具有独立于平台和协议的特性，可以生成动态的Web页面。
  （2）它担当客户请求（Web浏览器或其他HTTP客户程序）与服务器响应（HTTP服务器上的数据库或应用程序）的中间层。
- 什么是jsp？
  JSP全名为：Java Server Pages，中文名叫Java服务器页面，其根本是一个简化的Servlet设计，由 Microsystems公司倡导，许多公司参与一起建立的一种动态网页技术标准。
- servlet和jsp的联系？
  + jsp是对servlet的一种高级封装，本质还是servlet。
  + 第一次加载jsp页面的时候，会生成一个java文件，虚拟机编译为.class文件，最后加载并初始化为一个servlet
- servlet和jsp的共同点和不同点：
  （1）servlet在Java代码中通过HttpServletResponse来动态生成一个html页面
  （2）jsp是通过把java代码嵌入到html中去生成一个动态的html页面
  （一个是在java中写html，另一个是在html中写java代码）
- jsp和servlet出现的意义：
  （1）当我们使用servlet来生成动态页面的时候，会非常的复杂。因为需要在out.println()来写入html语句。但是servlet在处理前端和后台数据交互的时候有特别的优秀。
  （2）因此在这个时候我们引入jsp技术来替代servlet生成html的功能。让serlvet只专注前端页面和后台数据的交互。从而也是实现来mvc的思想。


### 二、使用Servlet
####（一）创建Servlet类：
- 继承HttpServlet类
- 重写两个方法：doGet()、doPost()---浏览器向服务器发送的请求常用的两种：get、post
- 使用注解配置Servlet的请求路径,JSP表单的action调用
- Servletd的配置也可以在web.xml里(Servlet3.0版本之后新增了Servlet注解的功能)
`@WebServlet("/AddCourseMemberServlet")`
- get：
    + 在浏览器的地址栏，输入地址，敲回车，属于get方式；
    + 超链接发出的请求也属于get方式
    + 表单method是get
- post：
    + 表单method是post

####（二）查看API
1. HttpServletRequest:
- 获得客户机信息
    ```java
    String requestUrl = request.getRequestURL().toString();// 得到请求的URL地址
    String requestUri = request.getRequestURI();// 得到请求的资源
    String queryString = request.getQueryString();// 得到请求的URL地址中附带的参数
    String remoteAddr = request.getRemoteAddr();// 得到来访者的IP地址
    String remoteHost = request.getRemoteHost();
    int remotePort = request.getRemotePort();
    String remoteUser = request.getRemoteUser();
    String method = request.getMethod();// 得到请求URL地址时使用的方法
    String pathInfo = request.getPathInfo();
    String localAddr = request.getLocalAddr();// 获取WEB服务器的IP地址
    String localName = request.getLocalName();// 获取WEB服务器的主机名
    ```
- 获取查询字符串
  ```java
  request.setAttribute();
  request.getAttribute();
  request.removeAttribute();
  ```
- 转发
  ```java
  request.getRequestDispatcher("publicclass/selectClass.jsp").forward(request, response);
  ```
- Session
  ```java
  HttpSession session = request.getSession();// 获取Sesson
  ```
- Cookies
  ```java
  Cookie[] cookies = request.getCookies();
  ```

2. HttpServletResponse
- 重定向
  ```java
  response.sendRedirect("login.jsp");// 重定向页面
  ```
- 设置编码
  ```java
  response.setContentType("text/html;charset=utf-8");
  response.setCharacterEncoding("UTF-8");
  PrintWriter out = response.getWriter();
  ```
3. HttpSession
- 设置最大的生命周期时间（单位/s）
  ```java
  setMaxInactiveInterval()
  ```
- 让sesson失效
  ```java
   session.invalidate();
  ```
- 删除指定session
  ```java
   session.removeAttribute("userName");
  ```


### 三、使用的技术
#### （一）过滤器：Filter
> 参考：https://blog.csdn.net/yuzhiqiang_1993/article/details/81288912

```java
// new一个过滤器（三个参数：请求，响应，链条）
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
```
-  Jsp和Servlet之间的，用于校验信息、乱码处理（用过滤器filter设置编码格式）
- 请求、相应乱码原因：https://www.jb51.net/article/94408.htm

2.拦截器与Filter的区别
- Spring的拦截器与Servlet的Filter有相似之处，比如二者都是AOP编程思想的体现，都能实现权限检查、日志记录等。
- 不同的是：
  + 使用范围不同：Filter是Servlet规范规定的，只能用于Web程序中。而拦截器既可以用于Web程序，也可以用于Application、Swing程序中。
  + 规范不同：Filter是在Servlet规范中定义的，是Servlet容器支持的。而拦截器是在Spring容器内的，是Spring框架支持的。
  + 使用的资源不同：同其他的代码块一样，拦截器也是一个Spring的组件，归Spring管理，配置在Spring文件中，因此能使用Spring里的任何资源、对象，例如Service对象、数据源、事务管理等，通过IoC注入到拦截器即可；而Filter则不能。

3. 过滤器的执行顺序和url-pattern标签匹配的精确程度（/*，/xxxServlet）无关，只和他们的filter-mapping标签在web.xml文件中的顺序有关,靠上的配置的先执行。

#### （二）监听器：Listener
1. 监听：request的创建、销毁，以及属性变化
2. 启动：服务器启动就同步启动

#### （三）Cookies（会话）
1. 把一些后台信息存储到浏览器端
- 放到缓存里
- 放到硬盘上
2. 具体实现
- 后端：https://blog.csdn.net/w_linux/article/details/79769256
- 前端：https://blog.csdn.net/qq_36834445/article/details/79922821
- cookies详解：https://www.cnblogs.com/wanghuaying/p/9557210.html
- Cookie 的路径以及 Cookie 域：https://blog.csdn.net/czh500/article/details/80220637
3. 使用cookies记住密码
    ```java
    <!-- 从cookies获取用户名以及用户密码 -->
    <%
        // 获取Cookies中的密码用于记住密码
        String username = ""; //用户名
        String userpwd = ""; //密码

        Cookie[] cookies = request.getCookies();
        //保存有cookie对象
        if(cookies != null && cookies.length > 0){
            for(Cookie c: cookies){
                if(c.getName().equals("userName")){
                    username = c.getValue();
                    break;
                }
                if(c.getName().equals("userPwd")){
                    userpwd = c.getValue();
                }
            }
        }
    %>

    <!-- 将获取到的用户名以及用户密码填入 -->
    <li><input name="username"type="text" class="loginuser" style="color: gray" value="<%=username%>" placeholder="请输入用户名" /></li>
    	    <li><input name="userpwd" id="userpwd" type="password" class="loginpwd" style="color: gray" value="<%=userpwd%>" placeholder="请输入密码" /></li>

    ```

4. 使用Ajax实现自动登陆
    ```java
    <!-- 实现自动登陆 -->
    <script type="text/javascript">
        // 获取指定cookie的值
        function getCookie(cname){
            var name = cname + "=";
            var ca = document.cookie.split(';');
            for(var i=0; i<ca.length; i++) {
                var c = ca[i].trim();
                if (c.indexOf(name)==0) {
                    return c.substring(name.length,c.length);
                }
            }
            return "";
        }

        // 获得cookie中存放的密码实现自动登陆
        function checkCookie()
        {  
            var username=getCookie("username");
            var userpwd=getCookie("userpwd");
            $("#username").val(username);
            $("#userpwd").val(userpwd);
            // alert("username："+ username);
            // alert("userpwd："+ userpwd);

        	if (username!="" && userpwd!="") {    	    
                //location.href="AutoLoginServlet?username="+username+"&userpwd="+userpwd;                
            } else {
              //alert("Please login !");
            }
        }
    </script>
    ```
#### （四）web.xml加载次序
- Listener----Filter----Servlet

## 第四节：UOL联合开放实验室开发项目开发
1. Tomcat、jdk、Servlet的版本对应关系

- java Resources  java源文件
- bulid：编译生成的.class

3. MD5加密

Seclect向网页传递参数的一种方式
将集合保存到request,
跳转到指定网页（转发），链式编程



####
1. `request.setAttribute("userlist"，userlist);`
- 把一个对象保存到request中,JSP网页要获取它（和Map练习记忆）
> ServletApi/doc
2.
- 重定向：`response.send`---特点：1.地址栏发生变化 2.浏览器服务器交互两次，request对象无法共享 3.执行重定向代码后的代码还会继续执行
- 转发：`request.getRequestDispatcher("displayUsers.jsp").forward(request, response);`
  + 特点：1.地址栏不发生变化就能跳转，服务器内部完成（内部资源的跳转，共享request对象），转发过程浏览器不知道 2. request对象的生命周期：请求响应结束对象就销毁 3.执行转发代码后的代码不会被继续执行
2. `request.getAttribute("userlist")`
4. 热部署
- 改变程序，无需重启Tomcat服务器，档更改程序后，但是服务器没有侦测到，就需要重启服务器（Tomcat）

#### displayUsers.JSP
1. 如何在jsp中导入包
2. JSP语法
```java
  <%  %> //放Java代码
  <%= %> //输出变量值
  <%! %> //在网页上声明变量
```


#### 用户的删除改和详情
1. 查询所有用户并显示
2. 修改网页(增加删除修改详情链接)
3. 编写删除用户的Servlet
4. 提示用户删除是否成功、或者跳转网页

超链接传参数(属于get传参方式)
```java
<a href="DeleteUserServlet?userid=${user.userid}&userpwd=${user.userpwd}"/>
```

#### 用户的修改功能
#### 用户名是否被占用
1. JSON
2. FastJSON 第三方组件，阿里开源的---fastjson-1.2.7.jar
3. JSON 和 Java对象的转换使用FastJSON
4. 不止有着一种，谷歌也有
5. JQuery：AJAX   

#### JSON
> JSON(JavaScript Object Notation, JS 对象简谱)
```java
var user = {
  'userid' :100,
  'userName': 'zhangsan',
  'sex': '男',
  'address':{
      'homeAddress':'大同',
      'schoolAddress':'太原'
  }
};
// 两种方式
user.userName;
user['userName'];

user.address.homeAddress;

var userArray = {
    {
      'userid' :100,
      'userName': 'zhangsan',
      'sex': '男'
    },
    {
      'userid' :100,
      'userName': 'zhangsan',
      'sex': '男'
    }
}
userArray[1].userName;
```

#### FAQ
1. 经过servlet跳转后jsp页面的样式消失
  > 当在jsp中引入css时，如果其相对路径相对于当前jsp文件的，而在一个和这个jsp的路径不一样的servlet中forward这个jsp时，就会发现这个css样式根本没有起作用。
  > 这是因为在servlet中转发时css的路径就是相对于这个servlet的相对路径而非jsp的路径了。
  > [参考链接](https://blog.csdn.net/zgrgfr/article/details/53067648)
  > [参考链接](https://blog.csdn.net/CodeNoodles/article/details/49515239)
- 解决方法
  (1)引入下列代码
  ```java
  <%
      // getContextPath() 返回当前页面所在的工程的物理路径（项目名称+/）
      String path = request.getContextPath();

      // basePath是拼装得到的当前网页的相对路径的。
      // request.getScheme() 返回当前页面使用的协议，http 或是 https
      // request.getServerName() 返回当前页面所在的服务器的名字，在就是localhost
      // request.getServerPort() 返回当前页面所在的服务器使用的端口
      String basePath = request.getScheme()+"://"
              +request.getServerName()+":"
              +request.getServerPort()+path+"/";
  %>

  <!-- 为页面上的所有链接规定默认地址或默认目标 -->
  <base href="<%=basePath%>">
  ```
  (2)将路径改为根目录下的绝对路径（因为有`<base>`标签所以自动加上定义好的相对路径）
  ```java
  <!-- 更改前 -->
  <link href="../css/style.css" rel="stylesheet" type="text/css" />
  <!-- 更改后 -->
  <link href="css/style.css" rel="stylesheet" type="text/css" />
  ```
  (3)如果没有写<base>标签就需要在所有的css样式、js或者图片引用的路径前加上`<%=basePath%>`
  ```java
  <!-- 更改前 -->
  <link href="../css/style.css" rel="stylesheet" type="text/css" />
  <!-- 更改后 -->
  <link href="<%=basePath%>/css/style.css" rel="stylesheet" type="text/css" />
  ```
