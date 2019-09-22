## 课后查询补充

#### 一、JDK、JRE、JVM三者间的关系
参考连接：https://www.cnblogs.com/zhangzongxing01/p/5559126.html
- JDK（Java Development Kit）：是整个Java的核心，包括了Java运行环境JRE、Java工具和Java基础类库。
- JRE（Java Runtime Environment）：Java运行环境，包含JVM标准实现及Java核心类库
- JVM（Java Virtual Machine）：Java虚拟机，可将.class文件解释为机器码（...\jdk\jre\bin\java.exe）
> JDK中包含JRE，在JDK的安装目录下有一个名为jre的目录，里面有两个文件夹bin和lib，在这里可以认为bin里的就是jvm，lib中则是jvm工作所需要的类库，而jvm和 lib和起来就称为jre。
```
疑问：JDK目录下有bin、lib、jre文件夹，而其中的jre文件夹下又有bin、lib----有什么不同？
答：
  1. jdk是开发时环境，jre是运行时环境。就是编写java文件用jdk，运行java文件用jre；
  2. jdk的bin下有各种java程序需要用到的命令，与jre的bin目录最明显的区别就是jdk下才有javac
```

#### 二、Java运行过程
javac编译`.java文件`生成`.class文件`，Java翻译成对应操作系统(OS)机器码，操作系统执行机器码

#### 三、Java的平台划分
参考：
【1】：[官网]()
【2】：https://blog.csdn.net/qq_36243386/article/details/85056070
【3】：https://baijiahao.baidu.com/s?id=1591559918900661165&wfr=spider&for=pc
- JavaME 微型版
- JavaSE 便准版
- JavaEE 企业版

#### 四、C、C++、Java比较

- 应用场景不同：
C：面向过程、主要做硬件编程底层编程
C++：面向对象，C++是C的继续和发展，兼容C eg:图形图像处理、通信软件、控制软件、工具软件、游戏
Java：面向对象的，主要用于：大型管理系统开发、大数据开发、Android开发
