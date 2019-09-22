## 第四单元

#### 口述和面试题
1. if语句后面如果是定义语句，必须加花括号
    ```java
    //right
    if (5 > 0)
      System.out.println("hello");

    //error
    if (5 > 0)
      int a = 5;

    //right
    if (5 > 0) {
      int a = 5;
    }
    ```
2. 结束整个循环有几种方式
    ```java
      break;//只能跳出循环
      return;//程序不在向下执行
      system.exit();//直接退出程序
    ```
3. 双重循环效率问题
    ```java
    for (size_t i = 0; i < 5; i++)
    {
      for (int j = 0; j < 3; j++)
      {

      }
    }
    //比上面效率高
    for (size_t i = 0; i < 3; i++)
    {
      for (int j = 0; j < 5; j++)
      {

      }
    }
    ```
4. 扩展的赋值运算符号特点
    ```java
    //byte、char、shorrt类型在运算的时候自动变成int或者说JVM把他们以int考虑，只要不超范围就可以；
    short s = 20;//reght
    byte x = 100;//right
    s = s + 10;//error右侧是高级类型，赋值给低级类型需要强制转换
    s += 10;//right，
    ```

5. 1-0.9的结果？
- 不是0.1，接近0.1
- 十进制和二进制转化在浮点数运算上存在精度丢失
  ```java
  System.out.println("1-0.9 = "+(1-0.9));
  System.out.println("1-0.8 = "+(1-0.8));
  System.out.println("1-0.7 = "+(1-0.7));
  System.out.println("1-0.6 = "+(1-0.6));
  System.out.println("1-0.5 = "+(1-0.5));
  System.out.println("1-0.4 = "+(1-0.4));
  System.out.println("1-0.3 = "+(1-0.3));
  System.out.println("1-0.2 = "+(1-0.2));
  System.out.println("1-0.1 = "+(1-0.1));
  ```
6. switch语句
    ```java
    switch(n)
    {
    case 1:
      执行代码块 1
      break;
    case 2:
      执行代码块 2
      break;
    default:
      n 与 case 1 和 case 2 不同时执行的代码
    }
    ```
  - switch语句中可以检测的类型：int、short、char、String、enum
  - 不能检测的数据类型为：long、boolean、浮点型（double、float）
  - default可有可无，且位置在哪不受影响。

#### 包复习
1. 那个包无需导入？
2. 包支持嵌套导入吗？---不支持
3. 导包的次序？
    - 基础包
    - 扩展包
    - 第三包包
    - 自定义包
4. 包的定义
    - 包名全小写
    - 域名倒写+系统名+模块名+层次名。

***

## 第五单元 数组
#### 任务
1. 普通创建
- 注意事项：只有在创建的时候才能进行赋值操作（数组各元素一起赋值）
    ```java
    int[] intArray = {1,2,3,4}; //数组声明
    ```
2. new创建数组
- 使用new,指定长度
- 使用new创建数组，元素有默认初值
  ```java
  int [] score = new int[4];
  //整数默认：0
  //浮点数默认：0
  //char:0
  //String:null
  ```
3. 如何给数组元素赋值
- 静态初始化
  ```java
  //创建并赋值
  int [] salary = new int[] {1,2,3,4};
  ```

- 动态初始化
  ```java
    for(int i = 0; i < salary.length; i++){
      salary[i] = 0;
    }
  ```
4. 面试：length和length()有什么区别？
- length数数组的属性，代表数组长度
- length()是String类的成员方法

5. 数组是不是引用类型
- 是，引用类型有三种：类，数组，接口
- 引用类型以对象的形式存在，存放在堆区域

6. 输出数组
- 一个一个取
- for循环
- for-eath循环
  ```java
  for(int x : salary){
    system.out.println(x)
  }
  ```
7. 数组排序---查询种类及特点
- [ ] 排序方式：https://blog.csdn.net/weixin_42014942/article/details/80674225

- 冒泡排序
  ```java
  public void sortUp(int [] beforArray) {
      for (int i = 0; i < beforArray.length-1; i++) {
          for (int j = 0; j < beforArray.length-i-1; j++) {
              if(beforArray[j] > beforArray[j+1]) {
                  int temp = beforArray[j];
                  beforArray[j] = beforArray[j+1];
                  beforArray[j+1] = temp;
              }
          }
      }    
  }
  ```
- 自带排序
  ```java
  import java.util.Arrays;
  Arrays.sort(array1);
  ```


> 总结： 数组是一种线性数据结构，能不能在一个的数组里放不同类型的数据？
不能（线性：类型单一）
数组长度再new时已经指定，不能越界取值。有默认值0/null
