### static final （续）
1. 静态方法不能直接调用非静态方法，需要创建对象（实例化）进行调用
2. 非静态方法可以直接调用静态方法。
3. 静态块（游离块）再主方法执行前就被执行，且执行一次，一般用于初始化
4. [ ] java里为什么主函数前面要加static修饰
[参考连接](https://blog.csdn.net/breaker892902/article/details/9331425)
> 这个方法的调用要通过类
5. 静态方法中不能使用super和this(它们实例化的对象)
6. static方法的虚方法的调用有什么特点？
> 虚方法调用对静态方法无效(eg：Student.java)
> 因为static方法不能被重写
7. 完整的对象构造次序(eg：Food.java)
- 父类的静态
- 子类的静态
- 父类的非静态
- 父类的构造
- 子类的非静态
- 子类的构造
#### 类加载机制
- .class字节码文件被JVM（Java虚拟机）加载
- 堆 对象
- 栈 局部变量
- 全局数据区 static
- 代码段

#### 封装类
boolean     Boolean
byte        Byte
short       Short
char        Character
int         Integer
long
float
double
