/**
* @项目名称: Javacore
* @文件名称: Student.java
* @Date: 2019年5月25日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava09;

/**
 * 计算学生，教师出生年份（消除代码冗余）
 * @author: liuhao
 * @version 1.0
 */
class Person {
    int age;

    public Person(int age) {
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
    /**
     * 计算person的出生年份
     * @param person
     * @return
     */
    public int CalcYear(Person person) {
        return 2019 - person.getAge();
    }
}

class Test2 {
    public static void main(String[] args) {
        Student s = new Student(20);
        Teacher t = new Teacher(30);

        CalcBirthYear calcBirthYear = new CalcBirthYear();
        int syear = calcBirthYear.CalcYear(s);
        int tyear = calcBirthYear.CalcYear(t);
        System.out.println("学生出生年：" + syear);
        System.out.println("老师出生年：" + tyear);
    }
}