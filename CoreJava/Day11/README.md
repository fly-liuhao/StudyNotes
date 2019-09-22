## Java OOP—设计模式
### 一、问题

1. 什么是设计模式
  一种通用方法和手段  
2. ：Java中有多少种模式（23种）
  - 共23种设计模式。
  - 参考资源：《Java与模式》、《Head First设计模式》、菜鸟教程
3. 问题三：设计模式什么场合会用？
  一般在框架里用，eg：spring框架
4. 列举几个Java设计模式
- 工厂模式 ***
- 单例模式 ***
- 适配器模式
- 装饰模式
- 模板方法模式
- 观察者模式
- MVC模式
> 单例模式和工厂模式一定能手写，脱离IDE。
> 方法：先画类图，再写代码。

### 二、OOP设计原则[（参考链接）](https://www.cnblogs.com/princessd8251/articles/3784949.html)
- OCP（Open-Closed Principle），开放封闭原则：软件实体应该扩展开放、修改封闭。
- DIP(Dependency Inversion Principle)，依赖倒置原则：摆脱面向过程编程思想中高层模块依赖于低层实现，抽象依赖于具体细节。OOP中要做到的是，高层模块不依赖于低层模块实现，二者都依赖于抽象；抽象不依赖于具体实现细节，细节依赖于抽象。。
- LSP(Liskov Substitution Principle)，Liskov替换原则：继承思想的基础。“只有当衍生类可以替换掉基类，软件单位的功能不会受到影响时，基类才真正被复用，而衍生类也才能够在基类的基础上增加新的行为。”
- ISP（Interface Insolation Principle），接口隔离原则：接口功能单一，避免接口污染。
实现：一个类对另外一个类的依赖性应当是建立在最小的接口上的。使用多个专门的接口比使用单一的总接口要好。
- SRP(Single Resposibility Principle)，单一职责原则：就一个类而言，应该仅有一个引起它变化的原因。 如果一个类的职责过多，就等于把这些职责耦合在一起，一个职责的变化可能会抑止这个类完成其他职责的能力。
- CARP（Composite/Aggregate Reuse Principle），合成/聚合复用原则：设计模式告诉我们对象委托优于类继承，从UML的角度讲，就是关联关系优于继承关系。尽量使用合成/聚合、尽量不使用继承。
实现：在一个新的对象里面使用一些已有的对象，使之成为新对象的一部分，以整合其功能。
- LoD(Law Of Demeter or Principle of Least Knowledge)，迪米特原则或最少知识原则：就是说一个对象应当对其他对象尽可能少的了解。即只直接与朋友通信，或者通过朋友与陌生人通信。


### 三、常考设计模式

#### 模板方法模式
 代码实现
- 写一个抽象类（模板类），有具体的方法
- 创建子类，重写父类的抽象方法

- [ ] 面向对象的设计原则
eg：开闭原则

#### 单例/单子模式（非常重要）
1.解决什么问题？
  一个类只能创建一个对象
2. 什么时候用？
  只需要单一对象的时候，比如一个宿舍只需要一个饮水机
3. 实现模式
- 饿汉式
（1）属性：private、static属性，当前类类型，立即初始化
（2）构造方法必须私有,private修饰
（3）创建get方法，public、static修饰，通过get方法获得当前类的对象（实例）
（4）特点：线程安全，效率高
  ```java
  public class Person {
      /**属性：private、static修饰，类型为当前类类型，且立即初始化 */
      private static Person person = new Person();

      /**
       * 构造方法必须私有
       */
      private Person() {
          System.out.println(" 这里是饿汉式的私有构造方法！");
      }

      /**
       * public、通过get当前类的对象
       * @return
       */
      public static Person getPerson() {
          return person;
      }
  }

  //测试类
  class TestPerson {
      public static void main(String[] args) {
          //static方法，直接通过类调用进行对象初始化
          Person person1 = Person.getPerson();
          Person person2 = Person.getPerson();

          //属于同一个对象
          System.out.println(person1 == person2);
      }

  ```
- 懒汉式
（1）属性：private、static修饰，类型为当前类类型，不初始化
（2）构造方法必须私有,private修饰
（3）创建get方法，public、static修饰，通过get方法获得当前类的对象（实例），首次获取需要实例化创建对象
（4）特点：线程不安全，效率低
（5）两者区别：对象创建的时间点不同，饿汉式早，懒汉式晚。饿汉是在属性上直接创建对象，懒汉式则是在方法调用的时候再创建对象。
  ```Java
  public class Student {
      /**属性：private、static修饰，类型为当前类类型，不先初始化，只先声明 */
      private static Student student;

      /**
       * 构造方法必须私有
       */
      private  Student() {
          System.out.println("这里是懒汉模式的私有构造方法！");
      }

       /**
       * public、通过get当前类的对象(首次使用需要实例化)
       * @return student
       */
      public static Student getStudentInstence() {
          if(student == null)
              student = new Student();
          return student;
      }  
  }

  //测试类
  class TestStudent {
      public static void main(String[] args) {
     		//static方法，直接通过类调用进行对象初始化
          Student stu1 = Student.getStudentInstence();
          Student stu2 = Student.getStudentInstence();

          //属于同一个对象
          System.out.println(stu1 == stu2);
      }
  }
  ```

#### 工厂模式
1. 什么是工厂模式？
  向用户屏蔽创建对象的细节，直接取对象即可。比如：我们取手机店买手机，不需要了解手机是如何生产的？

2. 最终目的：
  创建者和调用者的分离

3. 分类
- 简单工厂模式
- 工厂方法模式： 定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法是一个类的实例化延迟到其子类。
- 抽象工厂模式：提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

4. 使用示例：
- Calendar的getInstance方法：Calendar.getInstance();
- JDBC中Connection对象的获取getConnection方  法:DriverManager.getConnection();

- spring中的IOC容器创建、管理bean对象的时候
- 反射中Class对象的newInstance方法
5. 代码实现
- 简单工厂模式（参见代码部分）
- 工厂方法模式（参见代码部分）
