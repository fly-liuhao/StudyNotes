/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月25日
 */
package cn.edu.tit.corejava09;

/**
 * 接口实现多态
 * @author liuhao
 * @version: 1.0
 */
public class PersonImpl implements IPerson{

	@Override
	public void sleep() {
		System.out.println("Person实现sleep");
	}

	@Override
	public void speak() {
		System.out.println("Person实现speak");
	}
	
	public void playFootball() {
		System.out.println("play football");
	}
}

class TestPersonImpl{
	public static void main(String[] args) {
		PersonImpl pImpl = new PersonImpl();
		IPerson person = new PersonImpl();//接口实现多态
		person.sleep();
	}
}
