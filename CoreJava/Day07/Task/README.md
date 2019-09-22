## Java 功底测试（五）
1.
- 答案：[1,3,100,6,7]
- 考点分析：考察数组的使用
- 原因：数组是引用类型，“=”传递、参数传递的时候传递的是首地址，主方法中的a、b、形参中的a都指向相同的数组内存，且只有一块内存存放数组元素

``` java
//1. 以下程序的输出结果是什么？
import java.util.Arrays;
class Change {
    public void ex(int[] a) {
        a[2] = 100;
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 4, 6, 7 };
        int[] b = a;
        Change c = new Change();
        c.ex(a);
        System.out.println(Arrays.toString(b));
    }
}
```
2.
- 答案：E
- 考点分析：考察数组的初始化
- 原因：A—缺少"[ ]"；B—只有在定义的时候才可一起赋值；C—数组定义且赋值的时候不能指定大小

```java
// 2.以下数组的使用，正确是哪些？
A. int a = new int[3];
B. int m[ ] = new int[3];
    m = {1,3,4};
C. int n[ ] = new int[3]{2,4,8};
D. int [3] x = {4,5,6};
E. int [ ] x = new int[ ] {4,5,6};
```

3.
- 答案：A、F
- 考点分析：考察二维数组的定义
- 原因：

```java
//3.以下数组的使用，正确是哪些？
A. int [ ][ ] a = new int[3][4];
B. int [3 ][4 ] a = new int[3][4];
C. int [3 ][ ] a = new int[3][4];
D. int [ ][ 4] a = new int[3][4];
E. int [ ][ ] a = new int[ ][4];
F. int [ ][ ] a = new int[3][ ];
```

4.
- 答案：编译错误，无法运行
- 考点分析：length和length()的区别
- 原因：length()是String类的成员方法,数组对象无法调用

```java
//4.以下代码片段的输出结果是什么？
public static void main(String[] args) {
    char[] x = { 'a', 'b', 'c' };
    for (int i = 0; i < x.length(); i++) {
        System.out.println(x[i] + 1);
    }
}
```

5.
- 答案：编译错误
- 考点分析：char[]转换int[]
- 原因：类型不匹配:不能将char[]转换为int[]

```java
//5.以下代码片段的输出结果是什么？
public static void main(String[] args) {
    char[] x = { 'a', 'b', 'c' };
    int[] y = x;
    for (int i = 0; i < y.length; i++) {
        System.out.println(y[i]);
    }
}
```

6. 问答题：配置环境变量时，环境变量的名称和值区分大小写吗？
- 答案：Windows环境变量不区分大小写，Linux、Unix下不同，区分大小写

7. 问答题：在控制台下生成API文档的命令是什么？
- 答案：
javadoc + .java文件
或者  
javadoc -author -version + .java文件（生成待作者和版本信息Javadoc文档）

8. 问答题：Java中的关键字共有多少个？goto与const是否能在编程中使用？
- 答案：（50个），goto和const都是关键字，不能用作标识符。
>true，false和，null看起来像关键字，但它们实际上是文字; 您不能在程序中将它们用作标识符。

[参考](https://blog.csdn.net/u014493693/article/details/73320735)

9.
- 答案：
  ```
  setShort  
  setByte   
  setInt  
  setLong  
  setDouble
  ```
- 考点分析：考察函数的重载（调用结果取决于参数---基本类型）

```java
//9.以下代码的输出结果是什么？
public class TestChar {
    public void set(short x) {
        System.out.println("setShort");
    }

    public void set(byte x) {
        System.out.println("setByte");
    }

    public void set(int x) {
        System.out.println("setInt");
    }

    public void set(long x) {
        System.out.println("setLong");
    }

    public void set(float x) {
        System.out.println("setFloat");
    }

    public void set(double x) {
        System.out.println("setDouble");
    }

    public void setChar(char x) {
        System.out.println("setChar");
    }

    public static void main(String[] args) {
        TestChar ts = new TestChar();
        short x = 9;
        byte y = 90;
        int m = 100;
        long n = 101;
        double p = 1.4;
        ts.set(x);
        ts.set(y);
        ts.set(m);
        ts.set(n);
        ts.set(p);
    }
}
```

10. 问答题：全局变量与局部变量的区别？它们的默认值是什么？
- 答案：
1）存储区域：全局变量(全局静态变量)存放在方法区，局部变量则存放于栈中
2）生命周期：全局变量在类加载的时候，就被创建，随着类的消失而消失，生存时间较长；局部变量当方法被调用时而存在，当方法调用结束而消失，生存时间短
3）作用域：全局变量作用整个类中，而局部变量作用在一个局部区域，例如一个方法中
4）全局变量有初值，而局部变量没有初值，赋值后才能使用
[参考](https://blog.csdn.net/demo_gsl/article/details/81123918)

```java

```

11.
- 答案：
  ```
  Object
  String
  ```
- 考点分析：考察函数的重载（调用结果取决于参数---引用类型）

```java
//11.以下程序的输出结果是什么？
public class Test {
    public void test(String x) {
        System.out.println("String");
    }

    public void test(Object x) {
        System.out.println("Object");
    }

    public static void main(String[] args) {
        Test t = new Test();
        Object str = "Hello";
        t.test(str);
        String str1 = "IT";
        t.test(str1);
    }
}
```

12.问答题：Override的规则是什么？构造方法能否重载？调用重载的方法时，如何确定调用哪个方法？
- 答案：
1）重写的规则是：子类中重写父类的方法，要与父类的方法：方法名、参数列表、返回值类型相同，访问控制符相同或者大于父类访问控制范围
2）构造方法可以能被重载
3）确定调用哪个方法取决于参数列表，根据参数列表调用与之对应的方法

13.
- 答案：编译错误，无法运行
- 考点分析：考察函数的重载
- 原因：函数重载要求同名方法参数列表一定不同，返回值和访问控制符不限，题目中的第一个方法和第二个方法，方法名想同且参数列表相同，因此存在语法错误

```java
//13.以下程序的输出结果是什么？
public class Test {
    public void test(String x, int y) {
        System.out.println("1");
    }

    public int test(String str1, int s) {
        System.out.println("2");
        return 23;
    }

    private void test(int a, String name) {
        System.out.println("3");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test("a", 20);
        t.test(30, "b");
    }
}
```

14.
- 答案：A/B, C/D, E, F
- 考点分析：考察函数的重载
- 原因：函数重载要求同名方法参数列表一定不同，返回值和访问控制符不限

```java
14.以下哪些可以构成重载？
A. public int test();
B. public void test();
C. public void test(int x);
D. public int test(int y);
E. public void test(float x, int y);
F. public void test(int y, float x);
```

15. 问答题：数组元素在不赋值的情况下能否使用？
- 答案：
  ```java
  int[] a ;
  int[] b = new int[5];

  //a数组不可使用，b数组可以使用
  ```
- 考点分析：考察数组的使用
- 原因：使用new后给数组分配了内存，有默认值所以可以使用

16.
- 答案：编译错误，无法运行
  ```java
  //Analyze：
  short x = 10;//right
  x = x -2;//error:x-2是一个int型，不能直接转换成short型
  x = x++;//right
  char c = 'A' + 1;//right:c = B
  char y = d + 63;//error
  byte m = 97;//right:byte一个字节-128~127
  char n = m;//error:不能将byte型直接转换成chars
  ```
- 考点分析：考察基本类型的相互转换
- 原因：低级给高级自动转换，高级给低级需要强制转换

```java
//16.以下代码片段的输出结果是什么？
public static void main(String[] args) {
    short x = 10;
    x = x -2;
    x = x++;
    System.out.println(x);
    char c = ‘A’ + 1;
    System.out.println(c);
    byte d = 2;
    char y = d + 63;
    System.out.println(y);
    byte m = 97;
    char n = m;
    System.out.println(n);
}
```

17.
- 答案：true
- 考点分析：
- 原因：

```java
//17.以下代码片段的输出结果是什么？
public class Person {
    public static void main(String[] args) {
        int x = 0;
        double y = 0.0;
        System.out.println(x == y);
    }
}
```

18.问答题：switch语句中的default能省略吗？break能省略吗？switch能够接受参数类型有哪些？
- 答案：
1）default能省略
2）break在特殊使用情况下可省略
3）switch能够接受参数类型有：部分整形（byte、short、int），字符类型char，String类型，枚举类型；不能识别：整形中long、浮点型（float、double），布尔型（boolean）
- 考点分析：考察switch语句

19.
- 答案：编译错误
- 考点分析：考察switch语句的使用
- 原因：case中判断的x,y并不是字符

```java
//19.请写出以下代码片段的输出结果：
public static void main(String[] args) {
    char x = 'a';
    char y = 'a';
    char z = 'b';
    switch (x) {
    case y:
        System.out.println("a");
    case z:
        System.out.println("b");
        break;
    }
}
```

20.
- 答案：
  ```
  青年
  中年
  ```
- 考点分析：考察if语句
- 原因：if语句后面如果是定义语句需要大括号，跟输出语句`System.out.println(...)`就不需要大括号，但作用区域只有一行（有效代码行）

```java
//20.以下程序片段的输出结果是什么？
public static void main(String[] args) {
    int age = 35;
    if (age < 18)
        System.out.println("未成年");
    if (age > 18 && age < 40)
        ;
    System.out.println("青年");
    if (age > 40 && age < 55)
        ;
    System.out.println("中年");
}
```
