/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月16日
 */
package cn.edu.tit.corejava08;

/**
 * 抽象类和抽象方法
 * 
 * @author liuhao
 * @version: 1.0
 */
abstract class Person {
    /**
     * 抽象类可以包含一般类具有的，如成员变量，构造方法，普通方法,静态代码块，继承类实现接口等 抽象方法不能被private修饰
     * 抽象类方法在JDK8之后，默认default修饰，JDK8之前默认protected修饰
     */
    int a = 1;
    static {
        int b = 2;
    }

    public Person() {

    }

    public void sleep() {
    }

    abstract void speak();
}