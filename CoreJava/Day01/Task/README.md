## HelloWorld程序解析
args 是arguments的缩写，一般默认写为args，是可以修改的
String[] args 这个字符串数组是保存运行main函数时输入的参数的
1. 去掉类前面的修饰符，程序能否编译和执行？
	+ 去掉类前public：编译通过，执行通过！
2. 去掉main前面的修饰符，程序能否编译和执行？
    + 去public：能通过编译，不能执行(找不到main方法)
    + 去static: 能通过编译，不能执行(main 方法不是类 HelloWorld 中的static)
    + 去void: 不能通过编译(方法声明无效，需要返回值类型)
3. main前面的修饰符调换位置，程序能否编译和执行？
    + public与static: 编译通过，执行通过！
    + void与main: 不能通过编译
    + static与void：不能通过编译
    + public与void：不能通过编译
4. 去掉main中形参，程序能否编译和执行？
    + 空：能通过编译，不能执行(找不到main方法)
    + 去String: 不能通过编译(非法类型开始)，不能执行(找不到main方法)
    + 去args: 不能通过编译(需要标识符)，不能执行(找不到main方法)
    + 去[]：能通过编译，不能执行(找不到main方法)
6. 将main形参中的方括号换成...（三个小数点），程序能否编译和执行？
    + 可以通过编译，能正常执行

## 查看Java发展历史
   附上一个链接，写的很全面
   [Java发展历史](https://blog.csdn.net/DJY1992/article/details/56666725)  
   [Java官方文档](https://www.oracle.com/technetwork/cn/java/javase/documentation/index.html)

## JDK、JRE和JVM的关系
1. JRE(Java Runtime Enviroment):
	是Java程序的运行环境，包含JVM和运行时所需的核心类库。
	可以运行Java程序
2. JDK(Java Development Kit):
	是Java程序开发工具包，包含JRE和开发者用的工具。
	可以运行也可以开发Java程序
3. JVM(Java Virtual Machine):
	Java虚拟机，是运行所有Java程序的假想计算机，是Java程序的运行环境。
	Java的虚拟机本身不具有跨平台的性能，每个操作系统下有专属的JVM。
	所有编写的Java程序都运行在JVM上
	
## Java程序的执行过程
1. 编写Java文件，得到.java文件(文本文件)
2. 编译器编译，得到.class文件(字节码文件)
3. 解释器将字节码文件编译为特定平台下的机器码
4. 操作系统运行机器码得到运行结果

## Java平台的划分
1. JavaSE Java Standard Edition Java 标准版
2. JavaME Java Micro Edition Java 微型版
3. JavaEE Java Enterprise Edition Java 企业版

## Java语言有哪些特点？
1. 面向对象，支持继承，封装和多态；除简单的变量类型外，绝大多部分成员都是对象。
2. 可移植，一次编译可在不同平台上解释执行
3. 安全性，无指针，有类装载器，字节码校验器，安全管理器等保证Java的安全
4. 并发性，支持多线程并行机制，分布式应用程序

## C/C++/Java的区别？
1. 语言：C纯面向过程语言；C++可面向过程可面向对象，是一门过渡语言；Java是面向对象的一门语言；
2. 运行：C/C++ 编译成本地机器码, 可以由操作系统直接运行，效率高；Java编译为字节码，由JVM去解释运行，效率低；
3. 指针：C/C++保留指针，程序员可以直接获取使用内存地址，Java出于安全性考虑，去掉指针;
4. 垃圾回收：C/C++程序员自己回收，手动管理；Java有自动回收机制;
5. 用途：C/C++效率高，适合做底层开发，如操作系统；Java安全性好跨平台,适合做大型软件，APP；