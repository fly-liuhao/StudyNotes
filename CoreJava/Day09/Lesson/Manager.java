/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月26日
 */
package cn.edu.tit.corejava09;

/**
 * final演示
 * @author liuhao
 * @version: 1.0
 */
public class Manager {
	final int sal = 20000;//final修饰成员变量,该变量不可被修改
	
	final int age;//final修饰变量时，要么显示赋值，要么构造赋值
	
	final void showSal() {//final修饰成员方法，该方法不可被重写
		final int age = 21;//final修饰局部变量
		System.out.println(sal);
	}
	
	protected Manager(int age) {
		//补充：构造方法对修饰符无要求，但是private修饰的话，不能用来创建对象
		this.age = age;
	}
}
final class A{//final修饰类，该类不可被继承
	
}

//class AA extends A{}//编译异常

class TestFinal{
	public static void main(String[] args) {
		Manager m = new Manager(20);
	}
}