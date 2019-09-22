#### 多态

1. 什么是多态：对象的多种形态，一个对象被多种称谓
2. 表现方面：
- 引用多态（继承或接口实现）
  ```java
  // 父类的引用可以指向本类的对象；
  Animal obj1 = new Animal();
  // 父类的引用可以指向子类的对象；
  Animal obj2 = new Dog();  
  ```
  >这里我们必须深刻理解引用多态的意义，才能更好记忆这种多态的特性。为什么子类的引用不能用来指向父类的对象呢？通俗的讲：就以上面的例子来说，我们能说“狗是一种动物”，但是不能说“动物是一种狗”，狗和动物是父类和子类的继承关系，它们的从属是不能颠倒的。当父类的引用指向子类的对象时，该对象将只是看成一种特殊的父类（里面有重写的方法和属性），反之，一个子类的引用来指向父类的对象是不可行的！！
- 方法多态
根据上述创建的两个对象：本类对象和子类对象，同样都是父类的引用，当我们指向不同的对象时，它们调用的方法也是多态的。
（1）创建本类对象时，调用的方法为本类方法；
（2）创建子类对象时，调用的方法为子类重写的方法或者继承的方法；
（3）使用多态的时候要注意：如果我们在子类中编写一个独有的方法（没有继承父类的方法），此时就不能通过父类的引用创建的子类对象来调用该方法！！！
**注意： 继承（包括接口的实现）是多态的基础。**

3. 多态中方法调用和执行
- 编译时，方法调用看变量：父类引用指向不同的子类对象，所调用的方法随子类变化而变化。
- 运行时，方法执行看对象：如果一个子类型的对象，向上造型为父类型的变量时，向上造型为不同父类型变量可用的功能也是不一样的。

4. 为什么使用多态？(增强代码的复用能力)
    ```java
    class Person {
        int age;

        public Person(int age) {
            super();
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    public class Student extends Person {

        public Student(int age) {
            super(age);
        }

        public void learn() {
            System.out.println("好好学习,天天向上!");
        }
    }

    class Teacher extends Person {

        public Teacher(int age) {
            super(age);
        }

        public void teach() {
            System.out.println("好好教书！");
        }
    }

    class CalcBirthYear {
        public int CalcYear(Person person) {
            return 2019 - person.getAge();
        }
    }

    class Test {
        public static void main(String[] args) {
            Student student = new Student(20);
            Teacher teacher = new Teacher(30);

            CalcBirthYear calcBirthYear = new CalcBirthYear();
            int syear = calcBirthYear.CalcYear(student);
            int tyear = calcBirthYear.CalcYear(teacher);
            System.out.println("学生出生年：" + syear);
            System.out.println("老师出生年：" + tyear);
        }
    }
    ```

#### 引用类型转换
1. 向上类型转换(隐式/自动类型转换，小类型转换为大类型)
- 父类应用指向子类对象时就是向上类型转换
  ```java
  Dog dog = new Dog();
  Animal animal = dog;// 自动类型提升，向上类型转换
  ```
2. 向下类型转换(强制类型转换，大类型转换为小类型)
- 将上述代码再加上一行，我们再次将父类转换为子类引用，那么会出现错误，编译器不允许我们直接这么做，虽然我们知道这个父类引用指向的就是子类对象，但是编译器认为这种转换是存在风险的。如：
  ```java
  Dog dog = new Dog();
  Animal animal = dog;// 自动类型提升，向上类型转换
  Dog dog2 = animal;// 编译报错
  ```
- 我们可以通过强制类型转换。如：
  ```java
  Dog dog = new Dog();
  Animal animal = dog;// 自动类型提升，向上类型转换
  Dog dog2 = (Dog)animal;// 向下类型转换，强制类型转换
  ```
- 但是如果父类引用没有指向该子类的对象，则不能向下类型转换，虽然编译器不会报错，但是运行的时候程序会出错，如：
  ```java
  Dog dog = (Dog)new Animal();// 编译无错，执行报错！
  // 其实这就是上面所说的子类的引用指向父类的对象，而强制转换类型也不能转换！！
  ```
- 还有一种情况是父类的引用指向其他子类的对象，则不能通过强制转为该子类的对象。如：
  ```java
  Dog dog = new Dog();
  Animal animal = dog;// 自动类型提升，向上类型转换
  Dog dog2 = (Dog)animal;// 向下类型转换，强制类型转换
  Cat cat = (Cat)animal;// 编译无错，执行报错！
  ```
  >这是因为我们在编译的时候进行了强制类型转换，编译时的类型是我们强制转换的类型，所以编译器不会报错，而当我们运行的时候，程序给animal开辟的是Dog类型的内存空间，这与Cat类型内存空间不匹配，所以无法正常转换。这两种情况出错的本质是一样的，所以我们在使用强制类型转换的时候要特别注意这两种错误！！
- 下面有个更安全的方式来实现向下类型转换( instanceof运算符)。
  instanceof是Java的一个二元操作符，和==，>，<是同一类。由于它是由字母组成的，所以也是Java的保留关键字。它的作用是测试它左边的对象是否是它右边的类的实例，返回boolean类型数据。
  ```java
  /*
  1）在强制类型转换中，为了避免出现ClassCastException,可以通过instanceof关键字判断某个引用指向的对象是否为指定类型
  2）语法：对象 instanceof 目标类型
  3）返回值：
    - true:说明对象就是目标类型或者目标类型的小子类型，可以转换；
    - false:说明不满足强制转换前提，不能转换；  
  */

  //利用if语句和instanceof运算符来判断两个对象的类型是否一致。
  if(animal in instanceof Cat) {
    Cat cat = (Cat)animal;
  }
  ```
- 补充说明：在比较一个对象是否和另一个对象属于同一个类实例的时候，我们通常可以采用instanceof和getClass两种方法通过两者是否相等来判断，但是两者在判断上面是有差别的。Instanceof进行类型检查规则是:你属于该类吗？或者你属于该类的派生类吗？而通过getClass获得类型信息采用==来进行检查是否相等的操作是严格的判断,不会存在继承方面的考虑；
>总结：在写程序的时候，如果要进行类型转换，我们最好使用instanceof运算符来判断它左边的对象是否是它右边的类的实例，再进行强制转换。


#### final
- 修饰属性、方法、类
- 修改属性：值不能更改（常量）
- 修饰方法：方法不能重写（继承中子类不能重写父类中被final修饰的成员方法）
- 修饰类：类不能被继承
- 被final修饰的属性：要不显示赋值，要么构造方法赋值
  ```java
  //错误：final修饰的属性/变量不能被修改
  class Test {
    final int PI = 3.1415926;  
    public Test(int pi){
      this.PI = pi;
    }
  }
  ```
- 面试题：
  - 构造方法能不能被final修饰？（不允许）
  - final abstract能不能同时修饰一个类？（不能）

#### static
- 修饰：属性、一般方法、游离块、内部类
- 面试题：能不能修饰外部类和局部变量？（不能）
- 修饰属性：静态属性/类变量
- 修饰方法：静态方法
- static修饰的成员变量不属于对象的数据结构
- static成员变量和类的信息放在一起，仅保留一份，用于共享，而不是在堆中保留在每个对象里的多个副本
- 被static修饰的属性和方法可以用类名字直接调用，可以不创建对象。不过，对象也可以直接调用
- 静态方法里不能使用非静态属性。（eg：main函数不能直接使用本类中的非静态的成员变量）
- static游离块在类加载的就被执行，且只执行一次
- [static参与的程序执行次序](https://my.oschina.net/u/3788721/blog/1628215)
- 面试题
  ```java
  class Test {
      // Test example = new Test();
      static Test example = new Test();

      public Test() {
          System.out.println("lalala");
      }

      public static void main(String[] args) {
          Test test = new Test();
      }
  }
  // 不加static修饰，程序就存在递归
  ```

- [x] 单子模式，设计模式
