## 第三单元  数据类型和变量
[Oracle-java官网](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

#### 一、数据类型有哪些？ （11种）
1. 基本数据类型/（简单数据类型）  8种
2. 引用数据类型/（复合数据类型）  3种

##### 基本数据类型（8种）
1. byte（1字节，8位，-128~127）
```java
  byte age = 200;//error：超出范围
```
2. short（2字节，16位，-32768~32767）

3. int（4字节，32位，-2^31 ~ 2^31-1）
4. long（8字节，64位，-2^63 ~ 2^63-1）
```java
  //笔试题：long类型数L、l可有可无（错）
  long salary = 2147483647;
  long salary = 2147483648;//error
  long salary = 2147483648L;//超过int表示的范围后必须要加"L"

  /*
  注：
    当值小于等于int类型最大值，可不加L,否则必须
    不建议使用小写"l"
  */
```



5. char (2字节，16位，0~65565)
```java
  char sex = '男';//right
  char sex = "男";//error
  char sex = 97;//right
  char sex = '\u0097'//right:Unicode编码

  /*
  注：
    字符型数据本质就是数字
    字符型用单引号
    Java语言采用Unicode编码，一个字符就是两个字节
  */
```
- [ ] 不同类型编码：ASCII ,ISO8859-1,GB2312,GBK,Unicode,UTF-8（*详细见Task/README.md*）
    链接：https://blog.csdn.net/Fly_1213/article/details/85249201
- [ ] 转义字符：转义就是失去特殊含义
      （  所有的ASCII码都可用"\\"加数字（一般是8进制数字）来表示。而C语言中定义了一些字母前加"\\"来表示常见的那些不能显示的ASCII字符如\0,\t,\n等，就称为转义字符，因为后面的字符，都不是它本来的ASCII字符意思了。）


 |转义字符|意义|ASCII码值（十进制）
 | :--:| :--:|:--:|
 |\n| 换行(LF) ，将当前位置移到下一行开头|010
 |\t| 水平制表(HT) （跳到下一个TAB位置）| 009
 |\r| 回车(CR) ，将当前位置移到本行开头| 013
 |\ \\| 代表一个反斜线字符'\\' |092
 |\\"|代表一个双引号字符|034
 |\\?|	代表一个问号|	063
 |\0|空字符(NUL)|000
 |\a|响铃(BEL)|007
 |\b|退格(BS) ，将当前位置移到前一列|008
 |\f|换页(FF)，将当前位置移到下页开头|012

```java
  //打印双引号
  System.out.println("\"\"");
  //打印两个反斜杠"\\"
```
6. float（4字节，32位，……）
```java
  flout height = 1.75;//error:必须加f/F
  flout height = 1.75F;//right
  float height = .8;//right:0.8
  float height = 8.;//right:8.0
  /*
    注：
      float类型数据"F"/"f"不能省去
  */
```
7. double (8字节，64位，……）
8. boolean 取值：true和false。长度不明确
```java
  boolean a = 1;//error:只能是True或False
```
***
- 整数默认int,小数默认double
- Java长度由小变大
```java
  byte---short---int---long---float---double
  //长度不会随平台变化
```
- 数据类型可以转换（从低级类型到高级类型）
```java
/*
  规则：低级给高级自动转换，高级给低级强制转换
	排序：byte---short---int---long---float---double
	补充：char可直接转换int,boolean不参加转换
*/
  int num1 = 1;
  double num2 = 2;
  //从低级类型到高级类型
  num2 = num1;//right：自动转换
  //从高级类型转到低级类型
  num1 = num2;//error:需要强制转换
  uum1 = (int)num2;//right
  /*
  注：
    char与short都是16bit，在Java中，char是16bit长的无符号整数，因此范围是：0～65535，而short则是16bit长的带符号整数，范围是-32768～32767。 所以，两者虽然字长相同，但意义却不一样（表示范围并不完全重合或包含），因此不管是char转换成short，还是short转换成char，都属于数值的“窄化转换”（Narrowing Primitive Conversion）。 窄化转化都可能“丢失精度”，因此必须强制转换。
  */
```
##### 复合数据类型（引用数据类型）
- 复合(引用)类型（3种）：
类、数组、接口
- 引用类型就是类或接口类型
`String name;  Address addr;`
- 每个类就是一种类型，因此java中的类型可以引申为无限多种类型
`Person p;`
- java中每个变量都有确定的类型
`int age;   Student s;`

#### 二、Java值传递
- 方法调用时，实参传给形参
- 传递的参数可以是：基本类型、引用类型
- Java中只有值传递
- 注意堆区和栈区的数据变化（画图）
- 可通过DeBug调试查看变量值

>Eclipse之DeBug调试
>1. 设置断点
>2. 进入子方法（Step Into/F5）
>3. 单步执行（Step Over/F6）
>4. 从子方法跳出（Step Return F7）---结合F5使用
>5. 结束调试---点击红色按钮
>6. 回到编辑模式---点击eclipse右上角图标（java）

#### 三、面试问题
1. 什么是标识符？命名规则是什么？
- 标识符(identifier)就是名字
- 以"_"、"\$”、字母开头，后面加字母、数字、下划线、$
```java
  //以下哪些是合法的标识符？BCDE
  A. Hello World   B.True   C.String   D.学生  E._  F.*P  G.12abc  J.A@B
```
2. 什么是关键字（保留字）？有什么特点？
- [关键字-官网](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html)
- 被Java语言保留，有特殊含义，标识符不能用
- 关键字全小写
- true、false、null 不是关键字（参考官网）
- goto、const是关键字，但不能使用
- system不是关键字
```java
  //面试题： 以下哪些是Java语言关键字？ab de(官方文档不在关键字列表中)
  A. goto  B. const C. NULL D. true E. false F. System
```
3. 局部变量和成员变量的区别
- 成员变量就是属性
- 局部变量在方法内部定义
- 局部变量没有默认值，使用前必须先赋值
- 区别方法：看定义的位置
- 开发中成员变量和局部变量名字不要相同
4. 内存逻辑的划分
  - 栈：先进后出,存放所有局部变量，由操作系统管理，用于数据交换
  - 堆：存放new关键字创建的对象
  - 全局数据区：存放全局变量
  - 方法区：存放程序代码
5. 什么是Java中的垃圾回收机制？（*详细见Task/README.md*）
- [图解Java 垃圾回收机制](https://blog.csdn.net/justloveyou_/article/details/71216049)
- 垃圾：废弃/无用的对象
- Java中采取自动的垃圾回收机制(garbage collection，GC)---有延时
- 内存泄漏：指废弃的对象没有被及时的回收
- 垃圾回收机制是JVM自带的一个线程（伴随主程序运行着的程序），用于回收废弃的对象
- 目的：减轻程序员的负担，减少了内存泄漏
- 我们能不能通过调用System.gc()强制回收？（不能，仅仅是建议JVM马上调用GC进行垃圾回收）
- [ ] finalize()方法有什么用？----【tip:搜索】（*详细见Task/README.md*）

> 内存泄漏：（Memory Leak）是指程序中己动态分配的堆内存由
于某种原因程序未释放或无法释放，造成系统内存的浪费，导致程
序运行速度减慢甚至系统崩溃等严重后果。

6. Java中是否有可能存在代码泄露？
- 不可避免
- 当长生命周期的对象持有短生命周期对象的引用就很可能发生内存泄露，尽管短生命周期对象已经不再需要，但是因为长生命周期对象持有它的引用而导致不能被回收，这就是java中内存泄露的发生场景。
7. String 是不是内置的数据类型？
- 不是，是Java API中的一个类
