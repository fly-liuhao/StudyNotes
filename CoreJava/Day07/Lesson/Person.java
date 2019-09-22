/**
* @项目名称: Javacore
* @文件名称: Person.java
* @Date: 2019年5月12日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tit.corejava07;

/**
 * OOP-封装、继承
 * 
 * @author: liuhao
 * @version 1.0
 */
public class Person {

    public int ageplus = 10;
    private String name;
    public int age = ageplus;
    private String sex;

    /**
     * 父类默认构造函数
     */
    public Person() {
        System.out.println("这里是父类的默认构造方法");
    }

    /**
     * 父类带参构造函数
     * 
     * @param name
     * @param age
     * @param sex
     */
    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("这里是父类的带参构造方法");
    }

    /**
     * 父类说话方法
     */
    public void speak() {
        System.out.println("哈喽~");
    }

}

class Student extends Person {
    int score;

    public Student() {
        // super();
        System.out.println("这里是子类Student的构造方法！");
    }

    /**
     * 子类Student重写父类的speak()方法
     */
    public void speak() {
        System.out.println("我是一名学生...");
    }

    /**
     * 子类Student独有的写作业方法
     */
    public void doHomeWork() {
        System.out.println("我正在写作业！");
    }

}

class Teacher extends Person {
    int workAge;

    public Teacher() {
        System.out.println("这里是子类Teacher的构造方法！");
    }

    /**
     * 子类Teacher重写父类的speak()方法
     */
    public void speak() {
        System.out.println("我是一名老师...");
    }

    /**
     * 子类Teacher独有的批改作业方法
     */
    public void checkHomeWork() {
        System.out.println("我正在批改作业！");
    }

}

class Test extends Person {

    public static void main(String[] args) {
        // 创建子类对象
        Student student = new Student();
        Teacher teacher = new Teacher();

        // 调用子类重写方法以及子类特有方法
        student.speak();
        student.doHomeWork();
        teacher.speak();
        teacher.checkHomeWork();

    }
}