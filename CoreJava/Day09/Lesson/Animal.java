/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月25日
 */
package cn.edu.tit.corejava09;

/**
 * 虚方法的调用和instanceof的使用
 * @author liuhao
 * @version: 1.0
 */
public class Animal {
	public void eat() {
		System.out.println("animal 中的eat被调用");
	}
}

class Dog extends Animal{
	public void eat() {
		System.out.println("Dog中的eat被调用");
	}
	
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.eat();
		
		Dog dog = new Dog();
		dog.eat();
		
		Animal animal2 = new Dog();
		animal2.eat();//调用子类方法
		
		//使用instanceof 来判断对象是否为某类的对象
		//使用格式：对象 instanceof 类名		-->返回boolean值
		System.out.println(animal2 instanceof Animal);//true
		System.out.println(dog instanceof Animal);//true
		System.out.println(animal instanceof Dog);//false
	}
}