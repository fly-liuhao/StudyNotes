# 第一讲 Java开发起步
### 前期准备
- [x] 任务一：下载安装JDK
    [Jdk下载官网](https://www.oracle.com/technetwork/java/javase/downloads/jdk12-downloads-5295953.html)
- [x] 任务二：配置环境变量
    需要配置的两个环境变量：
    1. Path:可执行文件路径(路径指向jdk的bin路径)
    2. CLASSPATH：类路径，值是 .;
    > 分号不能是汉字输入法下的
    - 问题：Path和CLASSPATH大小写区分吗？
    在Windows下不区分，在Linux, Unix, Mac下必须是Path,CLASSPATH
    - 问题：Windows环境下，用户变量和系统变量一样，谁会生效？
    用户变量生效，系统变量会被覆盖
- [x] 任务三：验证环境变量配置是否成功
    1. 验证方式一：javac, java
    - 问题：javac和java从哪里来？
    Path环境变量的值，就是JDK的bin目录
    2. 验证方式二：set命令(可查可改)
    使用set classpath或者 set path，查看显示的是否正确。
    在set设置时，设置结果仅对当前控制台或者命令行窗口有效，控制台关闭，set结果失效。
    > win+r 输入sysdm.cpl 进入高级->环境变量
- [x] 任务四：编写HelloWorld程序，不带包
    编写Java代码的工具：Java文件实际上就是文本文件。
        记事本，Atom,Notepad++,EditPlus(商业)，Sublime, VS Code
    - 注意事项：
        1. 必须加规范的注释(版权注释，JavaDoc注释)
        2. 缩进4个空格
        3. 类名，方法名后加一个空格
        4. Java严格区分大小写
        5. 编译：javac HelloWorld.java 
    > 有GBK中文问题时，这样输入 javac -encoding utf-8 HelloWorld.java
     DOS命令：
                切换到D盘：        D:+enter
                显示当前目录：     dir
                退回到上级目录：   cd ..
                退回至根目录：     cd \
                补全命令           首字母+tab键
- [x] 任务五：编写HelloWorld，带包
    编译方法：javac -d . HelloWorld.java
    > .表示在当前目录下
    执行方法：java cn.edu.tit.corejava.Day01.HelloWorld
- [x] 任务六：在一个Java文件中编写多个类
    ```java
    public class Person {
    	public static void main(String []args) {
    		System.out.println("Person");
    	}
    }

    class Student {
    	public static void main(String []args) {
    		System.out.println("Student");
    	}
    }

    class Teacher {
    	public static void main(String []args) {
    		System.out.println("Teacher");
    	}
    }
    ```
    问题：将Person.java另存为Student.java,为什么编译无法通过？
        如果一个类被public修饰时，保存文件时，文件名和此类名命名一致
    问题：将Student修饰为public，为什么无法通过编译？
        一个Java文件中，最多只能有一个类被public修饰。
        如果所有类都不是public，文件名可以自己命名
    > .class文件叫字节码文件，使用内存地址+16进制编码表示， 以CAFEBABE开头
- [x] 任务七：配置并使用Eclipse
    + 什么是IDE？集成开发环境
    + 主要的IDE有哪些？Eclipse(免费)，IDEA(商业)，NetBeans(免费的，来自sun公司)
    [Eclipse下载官网](https://www.eclipse.org/downloads/packages/)
    从官网上下载后得到一个压缩包，解压即可使用(绿色软件)
    + Eclipse使用先决条件：
        先安装JDK，并配置好环境变量，
        注意：JDK的位数与Eclipse的位数一致
        Eclipse的版本和它匹配的JDK版本要一致，如果Eclipse要求JDK8，那么最好是安装JDK8(软件一般向下兼容)
    + 术语介绍：
        1. 工作空间 Workspace,存放写好的项目
        2. 工程或者项目，在写程序前必须先建立工程
    + 正式使用前必须配置Eclipse
        1. 配置编码，utf-8（处理乱码）
        ![配置编码](https://github.com/lichuangbo/markdown-images/raw/master/CoreJava%20images/utf-8.jpg)
        2. 配置JDK
        ![JDK](https://github.com/lichuangbo/markdown-images/raw/master/CoreJava%20images/JDK.jpg)
        3. 配置自动提示
        ![自动提示](https://github.com/lichuangbo/markdown-images/raw/master/CoreJava%20images/%E8%87%AA%E5%8A%A8%E6%8F%90%E7%A4%BA.jpg)
    + Eclipse如何使用？
        1. 如何建立工程或者项目？
        2. 如何编写HelloWorld程序？
            执行HelloWorld方式：鼠标点击
            ctrl + F11 或者 ALT + SHIFT + X,J
        3. Eclipse常用的快捷键
            > 任务：搜索Eclipse快捷键
            Ctrl + M:   放大或者还原代码编辑窗口
            Ctrl + W:   关闭当前编辑的窗口 
            Ctrl + Shift + W: 关闭所有编辑窗口
            Ctrl + E:     结合上下键，切换编辑窗口
            Ctrl + D:     删除光标所在行
            Shift + Enter:在光标所在行后，另起一行
            Ctrl + Shift + Enter:在光标所在行前，另起一行
            Alt + 上下键： 移动代码行的位置
            Alt + 左键：     回到前一编辑页面
            Alt + 右键：     回到后移编辑页面
            Ctrl + /:单行注释
            Ctrl + Shift + /:多行注释
            Ctrl + Shift + \:取消多行注释
            Ctrl + L:      快速定位行
            Ctrl + Q:      回到上次操作行
            Ctrl + Shift + F:格式化代码(代码无error,搜狗输入法关闭)
            Alt + Shift + S: 自动补充代码
            Ctrl + Alt + 下键： 复制当前行到下一行
            Ctrl + Alt + 上键： 复制当前行到上一行
            Ctrl + Shift + P:定位到下一匹配符(括号的匹配)
        4. 如何安装Eclipse插件(plugin)？
            - 打开文件路径的插件 OpenExplorer
            复制插件的jar包，放置到Eclipse的plugins目录中；
            重启Eclipse，如果不生效，删除Eclipse目录下的configuration的org.eclipse.update，重启若还是不生效可能是版本不匹配
            - 安装阿里巴巴的代码审查工具
            Help->Install New Software-> 将"https://p3c.alibaba.com/plugin/eclipse/update"这段网址复制在Work with目录下
            ->点击Add(为工具命名)->next->select all勾选上->一路next安装完毕
            使用：
                右键->选择"阿里编码规范检查"->如有不规范代码会显示出来
