### Java--集合 Collection
#### （一）背景
1. 什么东西可以容纳多个对象？数组、集合
- 数组中放的对象是固定的（动态的例外），且对象类型单一
- 集合里的对象个数是动态的，且可以放任何类型对象
2. Java 集合框架
- [参考链接](https://www.runoob.com/java/java-collections.html)
3. Collection位于Java.util包中，是一个接口
4. 开发上用的最多的是：List、Set、Map
- 注：Map和Collection没有构成继承关系
- 分为两大类：List、Set 和 Map
#### （二）List
1. add() 向集合里添加对象
  ```java
  List list = new ArrayList();
  list.add(12);
  list.add("hello");
  ```
- List list = new ArrayList();//默认初始容量为10
-  List list = new ArrayList(15);
2. 泛型，指定集合可以放入的对象
- 方便从集合中获取对象
- size()得到集合内对象的实际个数
- List有两种遍历方式
- List是有序列表，可重复
  ```java
  /** 使用泛型 */
  List<String> strList = new ArrayList<String>();
  strList.add(12);//报错
  strList.add("hello");

  /**集合和遍历的第一种方式*/
  for (int i = 0; i < strList.size(); i++) {
      System.out.println(strList.get(i));
  }
  /**集合和遍历的第二种方式*/
  for( String str : strList) {
      System.out.println(str);
  }
  /**集合和遍历的第三种方式:：使用迭代器*/
  Iterator iter = null;
  for (iter = strList.iterator(); iter.hasNext();) {
      String str = (String)iter.next();
      System.out.println(str);
  }
  ```
3. 去掉List中重复对象
- 重写hashCode和equals方法
- 用Set集合包裹List，使用构造方法
- 常用在：Hibernate中
  ```java
  public static void main(String[] args) {
      Student stu1 = new Student("张三",21,"2016");
      Student stu2 = new Student("李四",21,"2015");
      Student stu3 = new Student("张三",21,"2016");

      List<Student> stuList = new ArrayList<Student>();
      stuList.add(stu1);
      stuList.add(stu2);
      stuList.add(stu3);
      System.out.println(stuList.size());

      /** 包装List */
      Set<Student> setList = new HashSet<Student>(stuList);  
      System.out.println(setList.size());
  }
  ```
#### （三）Set
- Set没有索引方法
- Set里的对象是无序且不可重复的
  ```java
  Set<String> set = new HashSet<String>();
  set.add("Hello");
  set.add("world");
  set.add("!");
  set.add("Hello");
  System.out.println(set.size());
  for(String str : set) {
      System.out.println(str);
  }
  /* 结果：
    3
    !
    world
    Hello
  */
  ```
- List和Set的区别
  + List有序可重复，Set无序且不可重复
  + List两种遍历方法，Set一种

#### （四）Map
- Map由键值对构成
- 常用方法
  + put(K,V)
  + size()
  + get(K)
- Map取值：按值取值
  ```java
  Map Map = new HashMap();
  Map.put("学号", "2016");// 键-值对
  Map.put("姓名", "张三");
  Map.put("性别", "男");
  Map.put("性别", "女");
  System.out.println(Map.size());

  /** Map取值：按名取值 */
  System.out.println(Map.get("性别"));
  System.out.println(Map.get("学号"));
  ```
#### （五）LinkedList用法
[参考链接](https://www.cnblogs.com/ysocean/p/8657850.html)
- java的数据结构
- 来自java.util包

#### （六）Stack--(类)
- peek：栈顶指针
- push：进栈
- pop：出栈
- 先进后出

#### （七）Queue--(接口)
- 队列，先进先出
#### 面试题
1. List、Set、Map
2. ArrayList、、、、
- ArrayList
  + 初始容量是10
- Hashtable 和 HashMap区别
  + Hashtable线程安全，K/V不能为空
  + 数组和链表实现
  + 初始容量为11，扩容方式：*2 +1

- HashMap
  + 非线程安全
  + 初始容量为16，扩容方式：*2

- ConcerrentHashMap
  + 线程安全，效率低
- HashSet
  + 非同步，非线程安全
  + 添加的对象可以是
- TreeSet
  + 非同步
  + 有序的
  + 不接受重复元素
  ```java
  public static void main(String[] args) {
      TreeSet<String> treeSet = new TreeSet<String>();
      treeSet.add("hello");
      treeSet.add("world");
      treeSet.add("hello");
      System.out.println(treeSet.size());

      for(String str:treeSet) {
          System.out.println(str);
      }
  }
  /*
      结果：
      2
      hello
      world
  */
  ```
3. Collection和Collections区别
- Collection是接口，代表集合
- Collections是类，集合实用类，提供了一系列方法对集合进行操作
- 类比：Array.sort()
