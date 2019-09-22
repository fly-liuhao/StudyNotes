/**
 * CopyRight © 2019All rights reserved.
 * 
 * @date: 2019年5月25日
 */
package cn.edu.tit.corejava09;

/**
 * 一般方法计算学生，教师出生年份（冗杂）
 * @author liuhao
 * @version: 1.0
 */
public class Student {
	int age;
	
	public Student(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void learn() {
		System.out.println("student learn");
	}
}

class Teacher{
	int age;
	
	public Teacher(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void teach() {
		System.out.println("teacher teach");
	}
}

class CalcBirthYear{
	/**
	 * 计算学生的出生年份
	 * @param s 学生对象
	 * @return 学生出生年份
	 * @return: int
	 */
	public int calcStudent(Student s) {
		return 2019 - s.getAge();
	}
	
	/**
	 * 计算老师的出生年份
	 * @param t
	 * @return
	 * @return: int
	 */
	public int calcTeacher(Teacher t) {
		return 2019 - t.getAge();
	}
	
	public static void main(String[] args) {
		Teacher t = new Teacher(35);
		Student s = new Student(20);
		CalcBirthYear calc = new CalcBirthYear();
		//两个方法都是计算对象年龄，定义了两个方法去实现，功能上是实现了，但是存在冗余代码
		//可以使用多态，让传过来的对象参数去匹配方法
		int sYear = calc.calcStudent(s);
		int tYear = calc.calcTeacher(t);
		
		System.out.println("学生年龄：" + sYear);
		System.out.println("老师年龄： " + tYear);
	}
}

