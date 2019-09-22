
## 其它
### Java 网络相关知识
#### 一、Ip
- www.tit.edu.cn -- 180.96.16.231
- .com/.com.cn/.cn
- IPV4与IPV6
- 配置IP:cmd + ncpa.cpl
- 公网访问自己开发的系统
  1. 买个远程主机（服务器），阿里云、腾讯
  2. 把我们开发的软件部署到服务器上
  3. 买一个域名，与IP进行绑定，就是解析
  4. 通过域名访问的自己的系统

#### 二、TCP/IP、UDP
1. TCP：传输控制协议，特点：面向链接的，可靠的
2. UDP：用户数据报协议，特点：无连接、不可靠、快速传输
2. TCP/IP三次握手：[参考链接](https://baijiahao.baidu.com/s?id=1614404084382122793&wfr=spider&for=pc)

#### 三、网络的七层模型
> 七层模型，亦称OSI（Open System Interconnection）。参考模型是国际标准化组织（ISO）制定的一个用于计算机或通信系统间互联的标准体系，一般称为OSI参考模型或七层模型。
- 应用层
网络服务与最终用户的一个接口。
协议有：HTTP FTP TFTP SMTP SNMP DNS TELNET HTTPS POP3 DHCP
- 表示层
数据的表示、安全、压缩。（在五层模型里面已经合并到了应用层）
格式有，JPEG、ASCll、DECOIC、加密格式等
- 会话层
建立、管理、终止会话。（在五层模型里面已经合并到了应用层）
对应主机进程，指本地主机与远程主机正在进行的会话
- 传输层
定义传输数据的协议端口号，以及流控和差错校验。
协议有：TCP UDP，数据包一旦离开网卡即进入网络传输层
- 网络层
进行逻辑地址寻址，实现不同网络之间的路径选择。
协议有：ICMP IGMP IP（IPV4 IPV6） ARP RARP
- 数据链路层
建立逻辑连接、进行硬件地址寻址、差错校验 [2]  等功能。（由底层网络定义协议）
将比特组合成字节进而组合成帧，用MAC地址访问介质，错误发现但不能纠正。
- 物理层
建立、维护、断开物理连接。（由底层网络定义协议）

### Scoket套接字
- 套接字 = IP地址 + 端口号
- 解决客户端的（C/S）结构的软件

### Java注解--Annotation
- 注释和注解的区别？
  + 注解 ：参与代码编译，以@开头的。它是给应用程序看的，单独使用注解毫无意义，一定 要跟工具一起使用,这个所谓的工具实际就是能读懂注解的应用程序 。
  + 注释 ：对代码没有影响。对代码起到解释、说明的作用；
- 用于配置，比如：Servlet配置、Spring MVC 、Spring、Mybatis
- 可自定义注解，一种应用就是为类提供属性值

### 枚举--enum
- [参考链接](https://blog.csdn.net/cauchy6317/article/details/82313088)
- 用来替代常量接口
```java
public enum Color {
  red, green, blue;
}
```

### 内部类
- 局部内部类，成员式内部类
- 主要用于GUI编程
- 如何创建内部类对象？
  ```java
  //非静态
  Outer.Inner inner = new Outer().new Inner();
  //静态
  Outer.Inner2 inner2 = new Outer().Inner();
  ```

### GUI编程--图形用户界面
- GUI---图形用户界面
- java.awt
- java.swing
- 开发：代码书写/使用WindowBuilder插件
