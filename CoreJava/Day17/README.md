## 多线程
> Java语言内支持多线程
> [【参考学习链接】](https://www.cnblogs.com/snow-flower/p/6114765.html)

#### 一. 创建线程和启动
1. 使用继承方式
- 创建一个Thread子类，继承与Thread类
- 重写父类run()方法
- 创建Thread子类的实例，即创建了线程对象；
- 调用该线程对象的start()方法启动线程。
2. 使用接口方式
- 创建Runnable接口的实现类，实现Runnable接口中的run()方法
- 创建Runnable实现类的实例，并以此实例作为Thread的target对象，即该Thread对象才是真正的线程对象。
3. 通过Callable和Future创建线程
- 创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
- 创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值。
- 使用FutureTask对象作为Thread对象的target创建并启动新线程。
- 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值其中，Callable接口(也只有一个方法)定义如下：
```Java
    public interface Callable   {
      V call() throws Exception;  
     }

  //步骤1：创建实现Callable接口的类SomeCallable(略);   
  //步骤2：创建一个类对象：
      Callable oneCallable = new SomeCallable();
  //步骤3：由Callable创建一个FutureTask对象：   
    FutureTask oneTask = new FutureTask(oneCallable);
  //注释： FutureTask是一个包装器，它通过接受Callable来创建，它同时实现了 Future和Runnable接口。
  //步骤4：由FutureTask创建一个Thread对象：   
    Thread oneThread = new Thread(oneTask);   
  //步骤5：启动线程：  
    oneThread.start();
```

#### 二、线程的生命周期
1. 新建状态
- 用new关键字和Thread类或其子类建立一个线程对象后，该线程对象就处于新生状态。处于新生状态的线程有自己的内存空间，通过调用start方法进入就绪状态（runnable）。
- 注意：不能对已经启动的线程再次调用start()方法，否则会出现Java.lang.IllegalThreadStateException异常。
2. 就绪状态
- 处于就绪状态的线程已经具备了运行条件，但还没有分配到CPU，处于线程就绪队列（尽管是采用队列形式，事实上，把它称为可运行池而不是可运行队列。因为cpu的调度不一定是按照先进先出的顺序来调度的），等待系统为其分配CPU。等待状态并不是执行状态，当系统选定一个等待执行的Thread对象后，它就会从等待执行状态进入执行状态，系统挑选的动作称之为“cpu调度”。一旦获得CPU，线程就进入运行状态并自动调用自己的run方法。
- 提示：如果希望子线程调用start()方法后立即执行，可以使用Thread.sleep()方式使主线程睡眠一会儿，转去执行子线程。
3. 运行状态
- 处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。
- 处于就绪状态的线程，如果获得了cpu的调度，就会从就绪状态变为运行状态，执行run()方法中的任务。如果该线程失去了cpu资源，就会又从运行状态变为就绪状态。重新等待系统分配资源。也可以对在运行状态的线程调用yield()方法，它就会让出cpu资源，再次变为就绪状态。
- 注： 当发生如下情况是，线程会从运行状态变为阻塞状态：
  + 线程调用sleep方法主动放弃所占用的系统资源
  + 线程调用一个阻塞式IO方法，在该方法返回之前，该线程被阻塞
  + 线程试图获得一个同步监视器，但更改同步监视器正被其他线程所持有
  + 线程在等待某个通知（notify）
  + 程序调用了线程的suspend方法将线程挂起。不过该方法容易导致死锁，所以程序应该尽量避免使用该方法，目前以不推荐使用。
- 当线程的run()方法执行完，或者被强制性地终止，例如出现异常，或者调用了stop()、desyory()方法等等，就会从运行状态转变为死亡状态。
4. 阻塞状态
- 处于运行状态的线程在某些情况下，如执行了sleep（睡眠）方法，或等待I/O设备等资源，将让出CPU并暂时停止自己的运行，进入阻塞状态。
- 在阻塞状态的线程不能进入就绪队列。只有当引起阻塞的原因消除时，如睡眠时间已到，或等待的I/O设备空闲下来，线程便转入就绪状态，重新到就绪队列中排队等待，被系统选中后从原来停止的位置开始继续运行。
5. 死亡状态
- 当线程的run()方法执行完，或者被强制性地终止，就认为它死去。这个线程对象也许是活的，但是，它已经不是一个单独执行的线程。线程一旦死亡，就不能复生。 如果在一个死去的线程上调用start()方法，会抛出java.lang.IllegalThreadStateException异常。

#### 三、线程管理
1. 线程睡眠——sleep()
- 如果我们需要让当前正在执行的线程暂停一段时间，并进入阻塞状态，则可以通过调用Thread的sleep方法。
- sleep是静态方法，最好不要用Thread的实例对象调用它,因为它睡眠的始终是当前正在运行的线程，而不是调用它的线程对象，它只对正在运行状态的线程对象有效。如下面的例子：
  ```Java
  public class Test1 {  
      public static void main(String[] args) throws InterruptedException {  
          System.out.println(Thread.currentThread().getName());  
          MyThread myThread=new MyThread();  
          myThread.start();  
          myThread.sleep(1000);//这里sleep的就是main线程，而非myThread线程  
          Thread.sleep(10);  
          for(int i=0;i<100;i++){  
              System.out.println("main"+i);  
          }  
      }  
  }
  ```
- Java线程调度是Java多线程的核心，只有良好的调度，才能充分发挥系统的性能，提高程序的执行效率。但是不管程序员怎么编写调度，只能最大限度的影响线程执行的次序，而不能做到精准控制。因为使用sleep方法之后，线程是进入阻塞状态的，只有当睡眠的时间结束，才会重新进入到就绪状态，而就绪状态进入到运行状态，是由系统控制的，我们不可能精准的去干涉它，所以如果调用Thread.sleep(1000)使得线程睡眠1秒，可能结果会大于1秒。
2. 线程让步——yield()
- yield()方法和sleep()方法有点相似，它也是Thread类提供的一个静态的方法，它也可以让当前正在执行的线程暂停，让出cpu资源给其他的线程。**但是和sleep()方法不同的是，它不会进入到阻塞状态，而是进入到就绪状态。** yield()方法只是让当前线程暂停一下，重新进入就绪的线程池中，让系统的线程调度器重新调度器重新调度一次，完全可能出现这样的情况：当某个线程调用yield()方法之后，线程调度器又将其调度出来重新进入到运行状态执行。
- 实际上，当某个线程调用了yield()方法暂停之后，优先级与当前线程相同，或者优先级比当前线程更高的就绪状态的线程更有可能获得执行的机会，当然，只是有可能，因为我们不可能精确的干涉cpu调度线程。用法如下：
  ```java
  public class Test1 {  
      public static void main(String[] args) throws InterruptedException {  
          new MyThread("低级", 1).start();  
          new MyThread("中级", 5).start();  
          new MyThread("高级", 10).start();  
      }  
  }  

  class MyThread extends Thread {  
      public MyThread(String name, int pro) {  
          super(name);// 设置线程的名称  
          this.setPriority(pro);// 设置优先级  
      }  

      @Override  
      public void run() {  
          for (int i = 0; i < 30; i++) {  
              System.out.println(this.getName() + "线程第" + i + "次执行！");  
              if (i % 5 == 0)  
                  Thread.yield();  
          }  
      }  
  }
  ```
- 关于sleep()方法和yield()方的区别如下：
  + sleep方法暂停当前线程后，会进入阻塞状态，只有当睡眠时间到了，才会转入就绪状态。而yield方法调用后 ，是直接进入就绪状态，所以有可能刚进入就绪状态，又被调度到运行状态。
  + sleep方法声明抛出了InterruptedException，所以调用sleep方法的时候要捕获该异常，或者显示声明抛出该异常。而yield方法则没有声明抛出任务异常。
  + sleep方法比yield方法有更好的可移植性，通常不要依靠yield方法来控制并发线程的执行。
3. 线程合并——join()
- 线程的合并的含义就是将几个并行线程的线程合并为一个单线程执行，应用场景是当一个线程必须等待另一个线程执行完毕才能执行时，Thread类提供了join方法来完成这个功能。**注意:它不是静态方法。**
- 它有3个重载的方法：
  ```java
  void join()      
       //当前线程加入该线程后面，等待该线程终止。    
  void join(long millis)  
       //当前线程等待该线程终止的时间最长为 millis 毫秒。 如果在millis时间内，该线程没有执行完，那么当前线程进入就绪状态，重新等待cpu调度  
  void join(long millis,int nanos)   
       //等待该线程终止的时间最长为 millis 毫秒 + nanos 纳秒。如果在millis时间内，该线程没有执行完，那么当前线程进入就绪状态，重新等待cpu调度  
  ```
4. 设置线程的优先级
- 每个线程执行时都有一个优先级的属性，优先级高的线程可以获得较多的执行机会，而优先级低的线程则获得较少的执行机会。与线程休眠类似，线程的优先级仍然无法保障线程的执行次序。只不过，优先级高的线程获取CPU资源的概率较大，优先级低的也并非没机会执行。
- 每个线程默认的优先级都与创建它的父线程具有相同的优先级，在默认情况下，main线程具有普通优先级。
- 注：Thread类提供了setPriority(int newPriority)和getPriority()方法来设置和返回一个指定线程的优先级，其中setPriority方法的参数是一个整数，范围是1~10之间，也可以使用Thread类提供的三个静态常量：
  ```java
  MAX_PRIORITY  = 10

  MIN_PRIORITY  = 1

  NORM_PRIORITY  = 5
  ```
  > 注：虽然Java提供了10个优先级别，但这些优先级别需要操作系统的支持。不同的操作系统的优先级并不相同，而且也不能很好的和Java的10个优先级别对应。所以我们应该使用MAX_PRIORITY、MIN_PRIORITY和NORM_PRIORITY三个静态常量来设定优先级，这样才能保证程序最好的可移植性。

  ```java
  public class Test1 {  
        public static void main(String[] args) throws InterruptedException {  
            new MyThread("高级", 10).start();  
            new MyThread("低级", 1).start();  
        }  
    }  

    class MyThread extends Thread {  
        public MyThread(String name,int pro) {  
            super(name);//设置线程的名称  
            setPriority(pro);//设置线程的优先级  
        }  
        @Override  
        public void run() {  
            for (int i = 0; i < 100; i++) {  
                System.out.println(this.getName() + "线程第" + i + "次执行！");  
            }  
        }  
    }
  ```
5. 后台（守护）线程
- 守护线程使用的情况较少，但并非无用，举例来说，JVM的垃圾回收、内存管理等线程都是守护线程。还有就是在做数据库应用时候，使用的数据库连接池，连接池本身也包含着很多后台线程，监控连接个数、超时时间、状态等等。调用线程对象的方法setDaemon(true)，则可以将其设置为守护线程。
- 守护线程的用途为：
  - 守护线程通常用于执行一些后台作业，例如在你的应用程序运行时播放背景音乐，在文字编辑器里做自动语法检查、自动保存等功能。

   - Java的垃圾回收也是一个守护线程。守护线程的好处就是你不需要关心它的结束问题。例如你在你的应用程序运行的时候希望播放背景音乐，如果将这个播放背景音乐的线程设定为非守护线程，那么在用户请求退出的时候，不仅要退出主线程，还要通知播放背景音乐的线程退出；如果设定为守护线程则不需要了。
- setDaemon方法的详细说明：
  ```java
  /**
   * 将该线程标记为守护线程或用户线程。当正在运行的线程都是守护线程时，Java 虚拟机退出。
   * 该方法必须在启动线程前调用。 该方法首先调用该线程的 checkAccess 方法，且不带任何参数。这可能抛出 SecurityException（在当前线程中）。  
   * 参数：
   *       on - 如果为 true，则将该线程标记为守护线程。
   * 抛出：     
   *      IllegalThreadStateException - 如果该线程处于活动状态。
   *      SecurityException - 如果当前线程无法修改该线程。
   * @param on
   */
  public final void setDaemon(boolean on)  
  ```
- 注：JRE判断程序是否执行结束的标准是所有的前台执线程行完毕了，而不管后台线程的状态，因此，在使用后台县城时候一定要注意这个问题。
6. 正确结束线程
- Thread.stop()、Thread.suspend、Thread.resume、Runtime.runFinalizersOnExit这些终止线程运行的方法已经被废弃了，使用它们是极端不安全的！
- 想要安全有效的结束一个线程，可以使用下面的方法：
  + 正常执行完run方法，然后结束掉；
  + 控制循环条件和判断条件的标识符来结束掉线程。
  ```java
  class MyThread extends Thread {  
      int i=0;  
      boolean next=true;  

      @Override  
      public void run() {  
          while (next) {  
              if(i==10)  
                  next=false;  
              i++;  
              System.out.println(i);  
          }  
      }  
  }
  ```

#### 四、线程同步、共享数据
>java允许多线程并发控制，当多个线程同时操作一个可共享的资源变量 / 临界资源时（如数据的增删改查），将会导致数据不准确，相互之间产生冲突，因此加入同步锁以避免在该线程没有完成操作之前，被其他线程的调用，从而保证了该变量的唯一性和准确性

1. 什么是同步、异步？
- 同步：线程执行有先后次序，一个线程结束才能执行另一个。同步保障了线程的安全但过多地占用CPU资源使得CPU利用率降低
- 异步：一哄而上

2. 解决线程同步的方法
- 同步方法 ：使用 synchronized 关键字修饰方法
  ```java
  public synchronized void withDraw(double count) {
      System.out.println(Thread.currentThread().getName() + "：进入取款方法...");
      if (count <= this.balance) {
          System.out.println(Thread.currentThread().getName() + "：正在取款...");
          this.balance -= count;
          System.out.println(Thread.currentThread().getName() + "：取款成功！剩余金额：" + this.balance);
      } else {
          System.out.println(Thread.currentThread().getName() + "：余额不足，请及时充值...");
      }
  }
  ```
- 同步代码块：使用 synchronized 关键字修饰语句块
  ```java
  public void withDraw(double count) {
      System.out.println(Thread.currentThread().getName() + "：进入取款方法...");
      synchronized (this) {
          if (count <= this.balance) {
              System.out.println(Thread.currentThread().getName() + "：正在取款...");
              this.balance -= count;
              System.out.println(Thread.currentThread().getName() + "：取款成功！剩余金额：" + this.balance);
          } else {
              System.out.println(Thread.currentThread().getName() + "：余额不足，请及时充值...");
          }
      }
  }
  ```
- 注：同步是一种高开销的操作，因此应该尽量减少同步的内容。通常没有必要同步整个方法，使用synchronized代码块同步关键代码即可。

3. 实例：账户取款问题
    > 一个账户，两人同时取款（两个线程共享同一个账户）

- 实现：参考  `ThreadsSharedata.java`

#### 五、线程通信
1. 借助于Object类的wait()、notify()和notifyAll()实现通信
- wait()：线程执行wait()后，就放弃了运行资格，处于冻结状态；
- notify()：线程运行时，内存中会建立一个线程池，冻结状态的线程都存在于线程池中，notify()执行时唤醒的也是线程池中的线程，线程池中有多个线程时唤醒第一个被冻结的线程。
- notifyall()：唤醒线程池中所有线程。
2. 注：
- wait(), notify(),notifyall()都用在同步里面，因为这3个函数是对持有锁的线程进行操作，而只有同步才有锁，所以要使用在同步中；
- wait(),notify(),notifyall(),  在使用时必须标识它们所操作的线程持有的锁，因为等待和唤醒必须是同一锁下的线程；而锁可以是任意对象，所以这3个方法都是Object类中的方法。
3. 实例：生产者消费者问题
- 问题描述：生产者——消费者问题是指有两组线程共享一个环形的缓冲池，一组称为生产者，一组称为消费者。缓冲池是由若干个大小相等的缓冲区组成，每个缓冲区可以容纳一个产品。生产者线程不断的将产品放入缓冲池中，消费者不断将产品从缓冲池中取出。
- 核心：生产者——消费者问题，既存在着线程程同步问题，也存在着临界区互斥问题。当缓冲区满时，表示供大于求，生产者必须停止生产，进入等待状态，同时唤醒消费者；当所有缓冲区都为空时，表示供不应求，消费者必须停止消费，唤醒生产者。这就是生产者线程和消费者线程的同步关系。对于缓冲池，生产者和消费者都要使用它，显然他是一个临界资源，对于缓冲池的操作必须是互斥的。
- 实现：参考 `ProducerConsumer.java`

#### 六、理解并口述
1. 程序、进程、线程之间的关系
    > [【参考链接】](https://www.cnblogs.com/aquarius-bear/p/3939939.html)

- 程序：程序只是一组指令的有序集合,本身并没有任何运行的含义，它只是一个静态的实体。
- 进程：系统资源分配和调度的基本单位（独占系统资源），它是程序在某个数据集上的执行，有一定的生命周期，反映了一个程序在一定的数据集上运行的全部动态过程。进程之间支持并发执行。
- 线程：线程是进程的一个实体,CPU调度和分派的基本单位，它是比进程更小的能独立运行的基本单位，共享资源，线程之间可以并发执行 eg：迅雷下载
- 一个正在执行的程序至少有一个进程,一个进程至少有一个线程.
2. 实现线程的方式
- 通过继承Thread类
- 通过实现Runnable接口
- 通过 Callable 和 Future 创建线程。
3. 线程的状态
- 创建状态、就绪状态、运行状态、阻塞状态、消亡状态
4. 线程同步机制
- 锁机制/信号量机制
- 如果同步，那个线程获得锁，那个线程才能执行
5. 同步的目的
- 防止多线程共享数据出现问题
6. 线程方法和对象方法
- 线程方法：来自于Thread的方法eg：start()、run()、sleep()、yield()
- 对象方法：来自于Object的方法eg：wait()、notify() 、notifyAll()
7. 结束线程
- 方式一：自然结束，run()运行结束
- 方式二：方法中发生异常
8. 什么时候使用线程同步
- 资源/数据被多个线程共享使用时
9. 什么是并发？
- 一段时间内，允许多个进程/线程同时运行（宏观上讲）
10. 面试题：sleep()和wait()和yield()和join()
- 线程睡眠-sleep()：静态方法，让当前正在执行的线程暂停一段时间，进入到阻塞状态,不释放锁,可以在任何地方使用；
- wait()：释放锁，进入等待队列，待调用notify()/notifyAll()唤醒指定的线程或者所有线程，才会进入锁池,只能在同步方法或同步块中使用；
- 线程让步-yield()：不释放锁，也不会进入到阻塞状态，而是进入到就绪状态。yield()方法只是让当前线程暂停一下，重新进入就绪的线程池中，让系统的线程调度器重新调度器重新调度一次（按照优先级）。
- 线程合并-join() ：线程的合并的含义就是将几个并行线程的线程合并为一个单线程执行，应用场景是当一个线程必须等待另一个线程执行完毕才能执行时，Thread类提供了join方法来完成这个功能，注意，它不是静态方法。
