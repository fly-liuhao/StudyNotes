## Java API的应用(续)
#### StringBuilder类和StringBuffer类
- String和StringBuilder、StringBuffer区别是什么？
String是不可变字符串类（字符串值/内容不可变，字符串指向可以改变，貌似是一个常量），后者是可变字符串类
  ```Java
    String str = "chana";
    str.toUpperCase();//str还是小写
    String str2 = str.toUpperCase();//str2是大写
    //str2是大写，str没有改变，还是小写
  ```
- StringBuilder、StringBuffer是可变字符串类
 区别：StringBuffer线程安全的，StringBuilder线程是不安全的(但是效率高)
  ```java

  ```
- 开发中常用在SQl组合查询上，动态拼接SELECT语句；
- 常用函数
  ```java
    append();//追加
    delete();//删除
    insert();//插入
    reverse();//字符串按转
    replace();//字符串替换
    length();//字符串长度
    charAt();//指定索引的字符提取
    subString()//专辑顶索引范围字符提取
  ```

- 面试题:字符串的创建方式有哪些？有什么不同？--- 两种

    ```java
    String str1  = "china";
    String str2 = new String("china");//创建了几个对象？---2个第一个是:"china",第二个是str2指向的对象（也就是new出来的对象）
    String str3 = "china";
    ```
  - String存储机制---字符串池
#### System类
- System.currentTimeMillis()//输出程序的执行时间（毫秒）
- System.nanoTime()//输出程序的执行时间（纳秒）
- arraycopy()//两数组内容替换
- exit()//终止JVM
- gc()//提醒JVM回收垃圾（无用的对象等）

#### Math类
- Math.ceil()//相上取整
- Math.floor//向下取整
- Math.random()//产生一个随机[0,1)
- Math.round()//把一个数字舍入为最接近的整数
  ```java
    // 结果分析：负数-如果绝对值大于大于0.5，原数+0.5，结果向下取整（变小）
    System.out.println(Math.round(-11.2));//-11
    System.out.println(Math.round(-11.5));//-11 -11.5+0.5=11
    System.out.println(Math.round(-11.6));//-12
    System.out.println(Math.round(11.2));//11
    System.out.println(Math.round(11.5));//12
    System.out.println(Math.round(-0.5));//0
  ```

#### Random类
java.util.Random 是Java随机数类
- 生成0`1000的随机数
  ```Java
  Random ran = new Random();
  int x = ran.next(1000);
  ```



#### Date和Calendar类
```java
/**
 * 使用Date类获取当前日期时间
 *
 * @return 当前日期时间
 */
public static String getCurrentDate() {
    Date date = new Date();
    return date.toLocaleString();
}

/**
 * 使用Calendar类获取当前日期时间
 *
 * @return 当前日期时间
 */
public static String getCurrentDateByCalendar() {
    Calendar date = Calendar.getInstance();
    return "" + date.get(Calendar.YEAR) + "-" + (date.get(Calendar.MONTH) + 1) + "-"
            + date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.HOUR_OF_DAY) + ":"
            + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
}
```


#### 自定义jar包使用
- 导出包
  ```Java
  示例 1: 将两个类文件归档到一个名为 classes.jar 的档案中:
         jar cvf classes.jar Foo.class Bar.class
  示例 2: 使用现有的清单文件 'mymanifest' 并
             将 foo/ 目录中的所有文件归档到 'classes.jar' 中:
         jar cvfm classes.jar mymanifest -C foo/ .
  ```
- 导入jar包（Bulid Path）
- 调用jar包中函数

#### Object类（顶级父类）
- 位于核心包里
- clone();
- equals();
- toString();
- finalize();

#### 封装类的使用
- Wrapper class
- 什么是封装类？
  8种基本数据类型对应的类，类型，就是封装类，由Jdk提供，位于Java.long中
  boolean---     Boolean
  byte---        Byte
  short---       Short
  char---        Character
  int---         Integer
  long---        Long
  float---       Float
  double---      Double


#### BigDecimal类
- 实现1-0.9的精确计算
  ```java
      System.out.println(1-0.9);//0.099999999999
  ```
- 如何实现精确计算么？---使用java.math.BigDecimal
- 代码示例
  ```java
  public class Calc {

      /**
       * 使用BigDecimal实现时间精确计算（但是依然无法计算出）
       *
       * @param num1 计算数字一
       * @param num2 计算数字二
       * @return 不精确计算结果
       */
      public double sub(double num1, double num2) {
          BigDecimal number1 = new BigDecimal(num1);// API参数为double类型
          BigDecimal number2 = new BigDecimal(num2);
          return number1.subtract(number2).doubleValue();
      }

      /**
       * 使用BigDecimal实现时间精确计算（结果正确）
       *
       * @param num1 计算数字一
       * @param num2 计算数字二
       * @return 精确计算结果
       */
      public double sub2(double num1, double num2) {
          BigDecimal number1 = new BigDecimal(num1 + "");// API参数为String类型
          BigDecimal number2 = new BigDecimal(num2 + "");
          return number1.subtract(number2).doubleValue();
      }

      /**
       * 主方法测试
       * @param args
       */
      public static void main(String[] args) {
          Calc calc = new Calc();
          double num1 = 1;
          double num2 = 0.9;
          // 参数为doule类型
          System.out.println(calc.sub(num1, num2));
          // 参数为String类型
          System.out.println(calc.sub2(num1, num2));
      }
  }
  ```
